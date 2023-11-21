package ua.com.rmarinsky;

import com.microsoft.playwright.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class Scene {

    private static final ConcurrentHashMap<Long, Scene> drama = new ConcurrentHashMap<>();

    @Getter
    @Setter
    private BrowserContext context;

    @Getter
    @Setter
    private Page page;

    @Getter
    private Playwright playwright;

    @Getter
    private Browser browser;

    private Scene(Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    static Scene play() {
        return drama.computeIfAbsent(Thread.currentThread().getId(), k -> {
            var playwright = Playwright.create();
            var browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(Configuration.headless)
                            .setTimeout(Configuration.browserToStartTimeout)
                            .setDevtools(Configuration.devTools)
                            .setSlowMo(Configuration.poolingInterval)
                            .setTracesDir(Paths.get(Configuration.tracesPath))
            );
            return new Scene(playwright, browser);
        });
    }

    public static void initTestContext(boolean traces, String testName) {
        var newContextOptions = new Browser.NewContextOptions();
        newContextOptions.baseURL = Configuration.baseUrl;

        var scene = play();
        var browserContext = scene.getBrowser().newContext(newContextOptions);
        if (traces) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setTitle(testName)
                    .setName(testName + ".zip")
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true)
            );
        }
        var targetPage = browserContext.newPage();

        scene.setContext(browserContext);
        scene.setPage(targetPage);
    }

    public static void closeContext(boolean traces, String testName) {
        var scene = play();
        scene.getPage().close();
        var targetContext = scene.getContext();
        if (traces) {
            targetContext.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get(Configuration.tracesPath, testName + ".zip"))
            );
        }

        targetContext.close();
    }

    static void close() {
        var scene = drama.remove(Thread.currentThread().getId());
        if (scene != null) {
            scene.getPage().close();
            scene.getContext().close();
            scene.getBrowser().close();
            scene.getPlaywright().close();
        }
    }

}

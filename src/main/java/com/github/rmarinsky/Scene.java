package com.github.rmarinsky;

import com.microsoft.playwright.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
public class Scene {

    private static final ConcurrentHashMap<Long, Scene> drama = new ConcurrentHashMap<>();

    @Getter
    private Playwright playwright;

    @Getter
    private Browser browser;

    @Getter
    @Setter
    private BrowserContext context;

    @Getter
    @Setter
    private Page page;

    private Scene(Playwright playwright, Browser browser) {
        this.playwright = playwright;
        this.browser = browser;
    }

    private static Playwright createPlaywright() {
        return Playwright.create();
    }

    private static Browser createBrowser(Playwright playwright) {
        return playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(Configuration.headless)
                        .setTimeout(Configuration.browserToStartTimeout)
                        .setDevtools(Configuration.devTools)
                        .setSlowMo(Configuration.poolingInterval)
                        .setTracesDir(Paths.get(Configuration.tracesPath))
        );
    }

    private static BrowserContext initBrowserContext(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions().setBaseURL(Configuration.baseUrl));
    }

    static Scene play() {
        return drama.computeIfAbsent(Thread.currentThread().getId(), k -> {
            var playwright = createPlaywright();
            var browser = createBrowser(playwright);
            var scene = new Scene(playwright, browser);
            if (!Configuration.saveTraces) {
                var browserContext = initBrowserContext(browser);
                var page = browserContext.newPage();
                scene.context(browserContext);
                scene.page(page);
            }
            return scene;
        });
    }

    public static void initTestContext(boolean traces, String testName) {
        var scene = play();
        var browserContext = initBrowserContext(scene.browser());
        if (traces) {
            browserContext.tracing().start(new Tracing.StartOptions()
                    .setTitle(testName)
                    .setName(testName + ".zip")
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        var tarpage = browserContext.newPage();
        scene.context(browserContext);
        scene.page(tarpage);
    }

    public static void closeContext(boolean traces, String testName) {
        var scene = play();
        scene.page().close();
        var targetContext = scene.context();
        if (traces) {
            targetContext.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get(Configuration.tracesPath, testName + ".zip")));
        }
        targetContext.close();
        scene.context(null);
        scene.page(null);
    }

    static void close() {
        var scene = drama.remove(Thread.currentThread().getId());
        if (scene != null) {
            closeContext(false, null);
            scene.browser().close();
            scene.playwright().close();
        }
    }

}

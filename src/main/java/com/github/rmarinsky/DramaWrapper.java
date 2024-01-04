package com.github.rmarinsky;

import com.microsoft.playwright.*;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.Paths;

public class DramaWrapper {

    private static final ThreadLocal<DramaWrapper> drama = new ThreadLocal<>();

    @Getter
    private final Playwright playwright;

    @Getter
    private final Browser browser;

    @Getter
    @Setter
    private BrowserContext context;

    @Getter
    @Setter
    private Page page;

    private DramaWrapper() {
        this.playwright = Playwright.create();
        this.browser = launchBrowser(this.playwright);
        this.context = initBrowserContext(this.browser);
        this.page = this.context.newPage();
    }

    private static Browser launchBrowser(Playwright playwright) {
        return playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(Configuration.headless)
                        .setTimeout(Configuration.browserToStartTimeout)
                        .setDevtools(Configuration.devTools)
                        .setSlowMo(Configuration.poolingInterval)
                        .setTracesDir(Paths.get(Configuration.tracesPath))
                        .setArgs(Configuration.additionalArgs)
        );
    }

    private static BrowserContext initBrowserContext(Browser browser) {
        return browser.newContext(new Browser.NewContextOptions()
                .setBaseURL(Configuration.baseUrl));
    }

    public static DramaWrapper drama() {
        if (drama.get() == null) {
            drama.set(new DramaWrapper());
        }
        return drama.get();
    }

    public void startTracing(String testName) {
        this.context.tracing().start(new Tracing.StartOptions()
                .setTitle(testName)
                .setName(testTraceZip(testName))
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
    }

    public void stopTracing(String testName) {
        this.context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get(Configuration.tracesPath, testTraceZip(testName))));
    }

    private String testTraceZip(String testName) {
        return testName + ".zip";
    }

    public void close() {
        this.stopTracing(null);
        this.page.close();
        this.context.close();
        this.browser.close();
        this.playwright.close();
        drama.remove();
    }

}

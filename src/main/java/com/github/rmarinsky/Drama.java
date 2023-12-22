package com.github.rmarinsky;

import com.microsoft.playwright.Page;

/**
 * The Drama class provides methods for interacting with web pages in a browser.
 */
public class Drama {


    /**
     * Opens the specified URL in the web browser but with using baseUrl from Configuration
     * Example:
     * Configuration.baseUrl = "https://facebook.com";
     * open("/login");
     *
     * @param url the URL or path to open
     */
    public static void open(String url) {
        Scene.play()
                .page()
                .navigate(url);
    }

    /**
     * Pause execution of test and open recorder in browser
     */
    public static void pause() {
        Scene.play().page().pause();
    }

    /**
     * finds all elements specified by the given selector and returns an instance of LocatorActions
     * Example:
     * findAll("#username").shouldHave(texts("ololo", "trololo"));
     *
     * @param selector the CSS selector or XPath expression to locate the element
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions findAll(String selector) {
        return new LocatorActions(Scene.play().page().locator(selector));
    }

    /**
     * Finds the element specified by the given selector and returns an instance of LocatorActions
     * that can be used to interact with the element.
     * Example:
     * find("#username").click();
     *
     * <p> <a href="https://playwright.dev/java/docs/other-locators#css-pick-n-th-match-from-the-query-result">find first</a></p>
     *
     * @param selector the CSS selector or XPath expression to locate the element
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions find(String selector) {
        return new LocatorActions(Scene.play().page().locator(":nth-match(" + selector + ", 1)"));
    }

    /**
     * Finds the element specified by the given selector and filter all elements with the specified text,
     * and returns an instance of LocatorActions that can be used to interact with the element.
     * Example:
     * find("#username", "John Doe").click();
     *
     * @param selector the CSS selector or XPath expression to locate the element
     * @param withText the text that the element should have
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions find(String selector, String withText) {
        return new LocatorActions(Scene.play().page().locator(selector, new Page.LocatorOptions().setHasText(withText)).first());
    }

    /**
     * Alias for the {@link #findAll(String)} method.
     *
     * @param selector the CSS selector or XPath expression to locate the elements
     * @return an instance of LocatorActions that represents the found all elements
     */
    public static LocatorActions $$(String selector) {
        return findAll(selector);
    }

    /**
     * Alias for the {@link #find(String)} method.
     *
     * @param selector the CSS selector or XPath expression to locate the element
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions $(String selector) {
        return find(selector);
    }

    /**
     * Alias for the {@link #find(String, String)} method.
     *
     * @param selector       the CSS selector or XPath expression to locate the element
     * @param filterWithText the text that the element should contain
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    /**
     * Alias for the {@link #find(String)} method.
     *
     * @param selector the CSS selector or XPath expression to locate the element
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions f(String selector) {
        return find(selector);
    }

    /**
     * Alias for the {@link #findAll(String)} method.
     *
     * @param selector the CSS selector or XPath expression to locate the elements
     * @return an instance of LocatorActions that represents the found all elements
     */
    public static LocatorActions ff(String selector) {
        return findAll(selector);
    }

    /**
     * Waits for the current page URL to match the expected URL.
     * This method blocks execution until the URL matches or the timeout expires.
     * Example:
     * Drama.waitForUrl("**login") - end with login
     *
     * @param expectedUrl the expected URL to wait for
     */
    public static void waitForUrl(String expectedUrl) {
        Scene.play().page().waitForURL(expectedUrl);
    }

    /**
     * Clears all cookies from the current browser context.
     * Example:
     * Drama.clearCookies();
     */
    public static void clearCookies() {
        Scene.play().context().clearCookies();
    }

    /**
     * Opens a new tab in the current browser context and returns the Drama object.
     *
     * @return The Drama object representing the new tab.
     * <p>
     * Example:
     * Drama newDrama = new Drama();
     * drama.newTab();
     */
    public Drama newTab() {
        Scene.play().context().newPage();
        return this;
    }

    /**
     * Make an get screenshot of the current page.
     *
     * @return bytes
     */
    public byte[] getScreenshot() {
        return Scene.play().page().screenshot();
    }

    /**
     * Make an get screenshot of the current page.
     *
     * @return bytes
     */
    public byte[] getScreenshot(Page.ScreenshotOptions options) {
        return Scene.play().page().screenshot(options);
    }

}

package com.github.rmarinsky;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitUntilState;

import java.util.List;

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
        DramaWrapper.drama()
                .page()
                .navigate(url, new Page.NavigateOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
    }

    /**
     * Pause execution of test and open recorder in browser
     */
    public static void pause() {
        DramaWrapper.drama().page().pause();
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
        return new LocatorActions(DramaWrapper.drama().page().locator(selector));
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
        return new LocatorActions(DramaWrapper.drama().page().locator(":nth-match(" + selector + ", 1)"));
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
        return new LocatorActions(DramaWrapper.drama().page().locator(selector, new Page.LocatorOptions().setHasText(withText)).first());
    }

    /**
     * Finds the element specified by the aria accessibility attributes
     * The same as getByRole() but allows you to specify the role of the element simpler
     *
     * @param role
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions role(AriaRole role) {
        return new LocatorActions(DramaWrapper.drama().page().getByRole(role));
    }

    /**
     * Finds the element specified by the aria accessibility attributes
     * The same as getByRole() but allows you to specify the role and accessibility attributes of the element simpler
     *
     * @param role
     * @param withAccessibilityName
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions role(AriaRole role, String withAccessibilityName) {
        return new LocatorActions(DramaWrapper.drama().page().getByRole(role, new Page.GetByRoleOptions().setName(withAccessibilityName)));
    }

    /**
     * Finds the element specified by the data-testId data attribute value
     * The same as getByTestId() but allows you to specify the value of the element simpler
     *
     * @param testIdValue
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions testId(String testIdValue) {
        return new LocatorActions(DramaWrapper.drama().page().getByTestId(testIdValue));
    }

    /**
     * Finds the element specified by the text
     * The same as getByText() but allows you to specify the text of the element simpler
     *
     * @param textInElement
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions byText(String textInElement) {
        return new LocatorActions(DramaWrapper.drama().page().getByText(textInElement));
    }

    /**
     * Finds the element specified by the text
     * The same as getByText() but allows you to specify the text of the element simpler and case sensitive option
     *
     * @param text          for the element
     * @param caseSensitive option true|false
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions text(String text, boolean caseSensitive) {
        return new LocatorActions(DramaWrapper.drama().page().getByText(text, new Page.GetByTextOptions().setExact(caseSensitive)));
    }

    /**
     * Finds the element specified by the label
     * The same as getByLabel() but allows you to specify the label of the element simpler
     *
     * @param labelValue
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions label(String labelValue) {
        return new LocatorActions(DramaWrapper.drama().page().getByLabel(labelValue));
    }

    /**
     * Finds the element specified by the placeholder
     * The same as getByPlaceholder() but allows you to specify the label of the element simpler and case sensitive option
     *
     * @param placeholderValue option true|false
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions placeholder(String placeholderValue) {
        return new LocatorActions(DramaWrapper.drama().page().getByPlaceholder(placeholderValue));
    }

    /**
     * Finds the element specified by the title
     * The same as getByTitle() but allows you to specify the title of the element simpler
     *
     * @param titleValue
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions title(String titleValue) {
        return new LocatorActions(DramaWrapper.drama().page().getByTitle(titleValue));
    }

    /**
     * Finds the element specified by the alt text
     * The same as getByAltText() but allows you to specify the alt text of the element simpler
     *
     * @param altTextValue
     * @return an instance of LocatorActions that represents the found element
     */
    public static LocatorActions altText(String altTextValue) {
        return new LocatorActions(DramaWrapper.drama().page().getByAltText(altTextValue));
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
        try {
            DramaWrapper.drama().page().waitForURL(expectedUrl);
        } catch (PlaywrightException e) {
            throw new PlaywrightException("Expected page to have: '" + expectedUrl + "' but was:\n" + DramaWrapper.drama().page().url());
        }
    }

    /**
     * Clears all cookies from the current browser context.
     * Example:
     * Drama.clearCookies();
     */
    public static void clearCookies() {
        DramaWrapper.drama().context().clearCookies();
    }

    /**
     * Opens a new tab in the current browser context and returns the Drama object.
     *
     * <p>
     * Example:
     * Drama newDrama = new Drama();
     * drama.newTab();
     * </p>
     */
    public static void newTab() {
        Page newPage = DramaWrapper.drama().context().newPage();
        DramaWrapper.drama().page(newPage);
    }

    /**
     * Make an get screenshot of the current page.
     *
     * @return bytes
     */
    public static byte[] getScreenshot() {
        return DramaWrapper.drama().page().screenshot();
    }

    /**
     * Make an get screenshot of the current page.
     *
     * @return bytes
     */
    public static byte[] getScreenshot(Page.ScreenshotOptions options) {
        return DramaWrapper.drama().page().screenshot(options);
    }

    public static List<Page> getActiveTabs() {
        return DramaWrapper.drama().context().pages();
    }

    public static void switchToTab(int index) {
        DramaWrapper.drama().page(DramaWrapper.drama().context().pages().get(index));
    }

    /**
     * Closes the current tab and switch to the previous tab.
     */
    public static void closeActiveTab() {
        DramaWrapper.drama().page().close();
        switchToTab(getActiveTabs().size() - 1);
    }

}

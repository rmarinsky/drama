package com.github.rmarinsky;

import com.github.rmarinsky.conditions.Condition;
import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LocatorActions {

    private final Locator locator;

    /**
     * Chaining find of element
     * <p>
     * Usage:
     * <pre>{@code
     * find("#parentElement").find("#childElement").fill("ololo");
     * }</pre>
     *
     * @param locator the locator of the element to be found CSS or XPath
     * @return the child locator
     */
    public LocatorActions find(String locator) {
        return Drama.find(locator);
    }

    /**
     * Chaining find of element with filtering by text
     * <p>
     * Usage:
     * <pre>{@code
     * find("#parentElement").find("#childElement", "with text").click();
     * }</pre>
     *
     * @param locator        the locator of the element to be found CSS or XPath
     * @param filterWithText the text used for filtering
     * @return an instance of LocatorActions representing the found element
     */
    public LocatorActions find(String locator, String filterWithText) {
        return Drama.find(locator, filterWithText);
    }

    /**
     * Shortcut method for finding an element using CSS or XPath selector
     * <p>
     * Usage:
     * <pre>{@code
     * find("#parentElement").$("#childElement").fill("ololo")
     * }</pre>
     *
     * @param selector the CSS or XPath selector of the element to be found
     * @return an instance of LocatorActions representing the found element
     */
    public LocatorActions $(String selector) {
        return find(selector);
    }

    /**
     * Shortcut method for finding an element using CSS or XPath selector and filter with text
     * <p>
     * Usage:
     * <pre>{@code
     * find("#parentElement").$("#childElement", "with text").click();
     * }</pre>
     *
     * @param selector       the CSS or XPath selector of the element to be found
     * @param filterWithText the text to filter the element with
     * @return an instance of LocatorActions representing the found element
     */
    public LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    /**
     * Shortcut method for finding an element using a CSS or XPath selector
     * <p>
     * Usage:
     * <pre>{@code
     * find("#parentElement").f("#childElement").click();
     * }</pre>
     *
     * @param selector the CSS or XPath selector of the element to be found
     * @return an instance of LocatorActions representing the found element
     */
    public LocatorActions f(String selector) {
        return find(selector);
    }

    /**
     * Clears the value of the input field or the selected text in the textarea element.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").clear();
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions clear() {
        locator.clear();
        return this;
    }

    /**
     * Fills the value of the input field or the textarea element with the specified text.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").fill("Hello, World!");
     * }</pre>
     *
     * @param text the text to be filled in the input field or textarea element
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    /**
     * Navigates to the parent element of the current element.
     * <p>
     * Usage:
     * <pre>{@code
     * find("$child").parent().find("#parent button").click();
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions parent() {
        locator.locator("..");
        return this;
    }

    /**
     * Finds the closest ancestor element that matches the given XPath expression.
     * <p>
     * Usage:
     * <pre>{@code
     * find("$child").closest("ancestor").find("button").click();
     * }</pre>
     *
     * @param ancestor the XPath expression representing the ancestor element to search for
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions closest(String ancestor) {
        locator.locator("//ancestor::" + ancestor);
        return this;
    }

    /**
     * Presses a key on the keyboard.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").press("Tab");
     * }</pre>
     *
     * @param key the key to be pressed
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    /**
     * Presses the Enter key on the keyboard.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").pressEnter();
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions pressEnter() {
        locator.press("Enter");
        return this;
    }

    /**
     * Clicks on the element represented by the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").click().shouldBe(Condition.hidden);
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions click() {
        locator.click();
        return this;
    }

    /**
     * Clicks on the element represented by the locator
     * Waiting and initializing the new page
     * Waits for the new page to be loaded.
     * <p>
     * Usage:
     * <pre>{@code
     * find("a").clickWithNewPage();
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions clickWithNewPage() {
        var newPage = DramaWrapper.drama().context().waitForPage(locator::click);
        DramaWrapper.drama().page(newPage);
        return this;
    }

    /**
     * Open link in the same tab represented by the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("a").clickOnLink();
     * }</pre>
     *
     * @return an instance of LocatorActions for method chaining
     */
    public LocatorActions clickOnLink() {
        Drama.open(locator.getAttribute("href"));
        return this;
    }

    /**
     * Returns the text content of the element represented by the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * var actualText = find("h1").textContent();
     * }</pre>
     *
     * @return the text content of the element
     */
    public String textContent() {
        return locator.textContent();
    }

    /**
     * Returns the inner text of the element represented by the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * var actualText = find("h1").innerText();
     * }</pre>
     *
     * @return the inner text of the element
     */
    public String innerText() {
        return locator.innerText();
    }

    /**
     * Returns the inner HTML of the element for the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * var actualHtml = find("h1").innerHTML();
     * }</pre>
     *
     * @return the inner HTML of the element
     */
    public String innerHTML() {
        return locator.innerHTML();
    }

    /**
     * Returns the value of the attribute for the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * var actualProductId = find("input").getAttribute("product-id");
     * }</pre>
     *
     * @return the value of the attribute
     */
    public String getAttribute(String attributeName) {
        return locator.getAttribute(attributeName);
    }

    /**
     * Returns the value of the element represented by the locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").shouldBe(Condition.visible);
     * }</pre>
     *
     * @return the LocatorActions object for method chaining
     */
    public LocatorActions shouldBe(Condition condition) {
        condition.verify(locator);
        return this;
    }

    /**
     * Verifies that the element represented by the locator satisfies the specified condition.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").shouldHave(Condition.texts("Hello", "World")));
     * }</pre>
     *
     * @param condition the condition to be satisfied by the element
     * @return the LocatorActions object for method chaining
     */
    public LocatorActions shouldHave(Condition condition) {
        condition.verify(locator);
        return this;
    }

    /**
     * Verifies that the element represented by the locator satisfy the specified condition.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").shouldHas(Condition.value("Login@email.com")));
     * }</pre>
     *
     * @param condition the condition to be satisfied by the element
     * @return the LocatorActions object for method chaining
     */
    public LocatorActions shouldHas(Condition condition) {
        condition.verify(locator);
        return this;
    }

    /**
     * Returns the first element matching the given locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").first();
     * }</pre>
     *
     * @return the first element matching the locator
     */
    public LocatorActions first() {
        locator.first();
        return this;
    }

    /**
     * Returns the last element matching the given locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").last();
     * }</pre>
     *
     * @return the last element matching the locator
     */
    public LocatorActions last() {
        locator.last();
        return this;
    }

    /**
     * Returns specific element from collection of elements based on index.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").nth(3);
     * }</pre>
     *
     * @param index the index of the element to be returned
     * @return the nth element matching the locator
     */
    public LocatorActions nth(int index) {
        locator.nth(index);
        return this;
    }

    /**
     * Returns all elements matching the given locator.
     * <p>
     * Usage:
     * <pre>{@code
     * find("input").all();
     * }</pre>
     *
     * @return all elements matching the locator
     */
    public LocatorActions all() {
        locator.all();
        return this;
    }

}

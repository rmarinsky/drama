package com.github.rmarinsky;

import com.github.rmarinsky.conditions.Condition;
import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LocatorActions {

    private final Locator locator;

    public LocatorActions find(String locator) {
        return Drama.find(locator);
    }

    public LocatorActions find(String locator, String filterWithText) {
        return Drama.find(locator, filterWithText);
    }

    public LocatorActions $(String selector) {
        return find(selector);
    }

    public LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public LocatorActions f(String selector) {
        return find(selector);
    }

    public LocatorActions clear() {
        locator.clear();
        return this;
    }

    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    public LocatorActions parent() {
        locator.locator("..");
        return this;
    }

    public LocatorActions closest(String ancestor) {
        locator.locator("//ancestor::" + ancestor);
        return this;
    }

    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    public LocatorActions pressEnter() {
        locator.press("Enter");
        return this;
    }

    public LocatorActions click() {
        locator.click();
        return this;
    }

    public String textContent() {
        return locator.textContent();
    }

    public String innerText() {
        return locator.innerText();
    }

    public String innerHTML() {
        return locator.innerHTML();
    }

    public String getAttribute(String attributeName) {
        return locator.getAttribute(attributeName);
    }

    public LocatorActions shouldBe(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions should(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions shouldHave(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions shouldHas(Condition condition) {
        condition.verify(locator);
        return this;
    }

    public LocatorActions first() {
        locator.first();
        return this;
    }

    public LocatorActions last() {
        locator.last();
        return this;
    }

    public LocatorActions nth(int index) {
        locator.nth(index);
        return this;
    }

    public LocatorActions all() {
        locator.all();
        return this;
    }

}

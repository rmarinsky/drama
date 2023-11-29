package com.github.rmarinsky;

import com.microsoft.playwright.Locator;

public class Drama {

    public static void open(String url) {
        Scene.play().getPage().navigate(url);
    }

    public static LocatorActions find(String selector) {
        return new LocatorActions(Scene.play().getPage().locator(selector).first());
    }

    public static LocatorActions find(String selector, String withText) {
        return new LocatorActions(Scene.play().getPage().locator(selector).filter(
                new Locator.FilterOptions().setHasText(withText)
        ).first());
    }

    public static LocatorActions $(String selector) {
        return find(selector);
    }

    public static LocatorActions $(String selector, String filterWithText) {
        return find(selector, filterWithText);
    }

    public LocatorActions f(String selector) {
        return find(selector);
    }

    public void clearCookies() {
        Scene.play().getContext().clearCookies();
    }

    public Drama newTab() {
        Scene.play().getContext().newPage();
        return this;
    }

}

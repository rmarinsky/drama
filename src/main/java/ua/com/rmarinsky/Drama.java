package ua.com.rmarinsky;

import com.microsoft.playwright.Locator;
import lombok.experimental.UtilityClass;

public class Drama {

    public static void open(String url) {
//        var targetUrl = url.startsWith("http") ? url : Configuration.baseUrl + url;
        Scene.play().getPage().navigate(url);
    }

    public static LocatorActions find(String selector) {
        return new LocatorActions(Scene.play().getPage().locator(selector).first());
    }

    public static LocatorActions find(String selector, String filterWithText) {
        return new LocatorActions(Scene.play().getPage().locator(selector).filter(
                new Locator.FilterOptions().setHasText(filterWithText)
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

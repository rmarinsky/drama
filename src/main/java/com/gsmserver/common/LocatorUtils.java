package com.gsmserver.common;

import com.microsoft.playwright.Locator;

public class LocatorUtils {

    private LocatorUtils() {
    }

    public static void clickZPlyaskamy(Locator locator) {
        locator.click();
        System.out.println("Click Z plyaskamy");

    }

    public static void checkTooltip(Locator ologin) {

    }
}

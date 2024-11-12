package com.gsmserver.common;

import com.microsoft.playwright.Locator;

public class LocatorDecorator {

    private final Locator locator;

    public LocatorDecorator(Locator locator) {
        this.locator = locator;
    }

    public LocatorDecorator clickZPlyaskamy() {
        locator.click();
        System.out.println("Click Z plyaskamy");
        return this;
    }

    public void checkTooltip() {


    }
}

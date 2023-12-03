package com.github.rmarinsky.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HiddenUntil implements Condition {
    private final Integer maxTimeout;

    public HiddenUntil(Integer maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    @Override
    public void verify(Locator locator) {
        PlaywrightAssertions.assertThat(locator).isHidden(new LocatorAssertions.IsHiddenOptions().setTimeout(maxTimeout));
    }
}

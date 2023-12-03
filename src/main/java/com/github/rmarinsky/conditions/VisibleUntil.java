package com.github.rmarinsky.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VisibleUntil implements Condition {
    private final Integer maxTimeout;

    public VisibleUntil(Integer maxTimeout) {
        this.maxTimeout = maxTimeout;
    }

    @Override
    public void verify(Locator locator) {
        PlaywrightAssertions.assertThat(locator).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(maxTimeout));
    }
}

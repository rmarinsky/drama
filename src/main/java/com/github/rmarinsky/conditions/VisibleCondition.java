package com.github.rmarinsky.conditions;

import com.github.rmarinsky.Configuration;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VisibleCondition implements Condition {

    @Override
    public void verify(Locator locator) {
        assertThat(locator).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

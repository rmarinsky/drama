package com.github.rmarinsky.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ValueCondition implements Condition {
    private final String expectedValue;

    public ValueCondition(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public void verify(Locator locator) {
        PlaywrightAssertions.assertThat(locator).hasValue(
                expectedValue
        );
    }
}

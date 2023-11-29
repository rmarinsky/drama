package com.github.rmarinsky.conditions;

import com.github.rmarinsky.LocatorActions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ValueCondition implements Condition {
    private final String expectedValue;

    public ValueCondition(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    @Override
    public void verify(LocatorActions locatorActions) {
        PlaywrightAssertions.assertThat(locatorActions.getLocator()).hasValue(
                expectedValue
        );
    }
}

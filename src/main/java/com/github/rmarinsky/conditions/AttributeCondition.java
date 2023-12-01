package com.github.rmarinsky.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class AttributeCondition implements Condition {
    private final String attributeName;
    private final String expectedValue;

    public AttributeCondition(String attributeName, String expectedValue) {
        this.attributeName = attributeName;
        this.expectedValue = expectedValue;
    }

    @Override
    public void verify(Locator locator) {
        PlaywrightAssertions.assertThat(locator).hasAttribute(attributeName, expectedValue);
    }
}

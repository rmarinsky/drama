package com.github.rmarinsky.conditions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TextsCondition implements Condition {
    private final String[] expectedTexts;

    public TextsCondition(String[] expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public void verify(Locator locator) {
        PlaywrightAssertions.assertThat(locator).containsText(expectedTexts);
    }
}

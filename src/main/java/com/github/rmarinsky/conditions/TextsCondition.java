package com.github.rmarinsky.conditions;

import com.github.rmarinsky.LocatorActions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TextsCondition implements Condition {
    private final String[] expectedTexts;

    public TextsCondition(String[] expectedTexts) {
        this.expectedTexts = expectedTexts;
    }

    @Override
    public void verify(LocatorActions locatorActions) {
        PlaywrightAssertions.assertThat(locatorActions.getLocator()).containsText(expectedTexts);
    }
}

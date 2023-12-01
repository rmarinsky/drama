package com.github.rmarinsky.conditions;

import com.github.rmarinsky.Configuration;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import lombok.AllArgsConstructor;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class TextCondition implements Condition {

    private final String expectedText;

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasText(
                expectedText,
                new LocatorAssertions.HasTextOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

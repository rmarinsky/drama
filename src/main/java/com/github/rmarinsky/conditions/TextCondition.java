package com.github.rmarinsky.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import lombok.AllArgsConstructor;
import com.github.rmarinsky.Configuration;
import com.github.rmarinsky.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class TextCondition implements Condition {

    private final String expectedText;

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).hasText(
                expectedText,
                new LocatorAssertions.HasTextOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

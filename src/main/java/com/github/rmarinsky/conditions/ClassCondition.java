package com.github.rmarinsky.conditions;

import com.github.rmarinsky.Configuration;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import lombok.AllArgsConstructor;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@AllArgsConstructor
public class ClassCondition implements Condition {

    private final String expectedClassName;

    @Override
    public void verify(Locator locator) {
        assertThat(locator).hasClass(
                expectedClassName,
                new LocatorAssertions.HasClassOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

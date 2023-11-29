package com.github.rmarinsky.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.github.rmarinsky.Configuration;
import com.github.rmarinsky.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VisibleCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isVisible(
                new LocatorAssertions.IsVisibleOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

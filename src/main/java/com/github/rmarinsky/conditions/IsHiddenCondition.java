package com.github.rmarinsky.conditions;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.github.rmarinsky.Configuration;
import com.github.rmarinsky.LocatorActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(LocatorActions locatorActions) {
        assertThat(locatorActions.getLocator()).isHidden(
                new LocatorAssertions.IsHiddenOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

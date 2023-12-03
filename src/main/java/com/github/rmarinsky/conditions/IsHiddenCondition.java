package com.github.rmarinsky.conditions;

import com.github.rmarinsky.Configuration;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class IsHiddenCondition implements Condition {

    @Override
    public void verify(Locator locatorActions) {
        PlaywrightAssertions.assertThat(locatorActions).isHidden(
                new LocatorAssertions.IsHiddenOptions().setTimeout(Configuration.defaultTimeout)
        );
    }

}

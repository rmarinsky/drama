package com.github.rmarinsky.conditions;


import com.microsoft.playwright.Locator;

public interface Condition {

    Condition visible = new VisibleCondition();
    Condition hidden = new IsHiddenCondition();

    static Condition text(String expectedText) {
        return new TextCondition(expectedText);
    }

    static Condition texts(String... expectedText) {
        return new TextsCondition(expectedText);
    }

    static Condition value(String expectedValue) {
        return new ValueCondition(expectedValue);
    }

    static Condition attribute(String attributeName, String expectedValue) {
        return new AttributeCondition(attributeName, expectedValue);
    }

    static Condition className(String expectedClassName) {
        return new ClassCondition(expectedClassName);
    }

    void verify(Locator locator);

}

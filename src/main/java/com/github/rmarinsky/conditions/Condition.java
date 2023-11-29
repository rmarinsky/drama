package com.github.rmarinsky.conditions;


import com.github.rmarinsky.LocatorActions;

public interface Condition {

    Condition visible = new VisibleCondition();
    Condition hidden = new IsHiddenCondition();

    static Condition text(String expectedText) {
        return new TextCondition(expectedText);
    }

    void verify(LocatorActions locatorActions);

}

package ua.com.rmarinsky;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ua.com.rmarinsky.conditions.Condition;

@AllArgsConstructor
@Getter
public class LocatorActions {

    private final Locator locator;

    public LocatorActions fill(String text) {
        locator.fill(text);
        return this;
    }

    public LocatorActions parent() {
        locator.locator("..");
        return this;
    }

    public LocatorActions closest(String ancestor) {
        locator.locator("//ancestor::" + ancestor);
        return this;
    }

    public LocatorActions press(String key) {
        locator.press(key);
        return this;
    }

    public LocatorActions click() {
        locator.click();
        return this;
    }

    public LocatorActions shouldBe(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions should(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions shouldHave(Condition condition) {
        condition.verify(this);
        return this;
    }

    public LocatorActions shouldHas(Condition condition) {
        condition.verify(this);
        return this;
    }

}

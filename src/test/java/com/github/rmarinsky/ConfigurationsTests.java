package com.github.rmarinsky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.rmarinsky.conditions.Condition.text;
import static org.junit.jupiter.api.Assertions.fail;

public class ConfigurationsTests {

    static {
        Configuration.baseUrl = "https://github.com";
    }


    @Test
    @DisplayName("check opening the page")
    void checkOpeningThePage() {
        Drama.open("/rmarinsky/drama");
        Drama.find(".application-main a[href='/rmarinsky/drama']").shouldHave(text("drama"));
    }

}

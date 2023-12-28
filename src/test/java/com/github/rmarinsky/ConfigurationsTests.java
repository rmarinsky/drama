package com.github.rmarinsky;

import com.github.rmarinsky.testRunners.DramaExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.github.rmarinsky.Drama.find;
import static com.github.rmarinsky.Drama.open;
import static com.github.rmarinsky.conditions.Condition.text;

@ExtendWith(DramaExtension.class)
public class ConfigurationsTests {

    static {
        Configuration.baseUrl = "https://github.com";
        Configuration.saveTraces = true;
    }


    @RepeatedTest(5)
    @DisplayName("check opening the page of drama repository")
    void checkOpeningThePage() {
        open("/rmarinsky/drama");
        find("#repository-container-header strong a").shouldHave(text("drama"));
    }

}

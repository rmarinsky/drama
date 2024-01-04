package com.github.rmarinsky;

import com.github.rmarinsky.testRunners.TracesExtensionPerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.github.rmarinsky.Drama.find;
import static com.github.rmarinsky.Drama.open;
import static com.github.rmarinsky.conditions.Condition.text;

@ExtendWith(TracesExtensionPerTest.class)
public class BeforeEachTestExtension {

    static {
        Configuration.baseUrl = "https://github.com";
    }

    @BeforeEach
    void beforeEach() {
        open("/rmarinsky");
    }

    @Test
    @DisplayName("Test name")
    void testName() {
        open("/rmarinsky/drama");
        find("#repository-container-header strong a").shouldHave(text("drama"));
    }
}

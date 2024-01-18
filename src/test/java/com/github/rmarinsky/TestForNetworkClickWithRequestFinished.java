package com.github.rmarinsky;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.rmarinsky.Drama.find;
import static com.github.rmarinsky.Drama.open;
import static com.github.rmarinsky.networkWaits.ClickConditions.withWaitForRequestFinished;
import static com.github.rmarinsky.networkWaits.ClickConditions.withWaitForResponse;

public class TestForNetworkClickWithRequestFinished {

    @SneakyThrows
    @Test
    @DisplayName("Wait for request after click")
    void waitForRequestAfterClick() {
        Configuration.headless = false;
        Configuration.baseUrl = "https://www.imdb.com";
        open("/title/tt0111161/");
        String selector = ".ipc-shoveler__arrow--right [class*=right]";

        find(selector).click(withWaitForRequestFinished("/tr"));
        find(selector).click(withWaitForResponse("/tr", 1000));
    }

}

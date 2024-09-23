package com.github.rmarinsky;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.rmarinsky.Drama.*;
import static com.github.rmarinsky.networkConditions.NetworkCondition.withWaitForRequestFinished;
import static com.github.rmarinsky.networkConditions.NetworkCondition.withWaitForResponse;

public class TestForNetworkClickWithRequestFinished {

    @Test
    @DisplayName("Wait for request after click and fill")
    void waitForRequestAfterClick() {
        Configuration.headless = false;
        Configuration.baseUrl = "https://www.imdb.com";
        open("/title/tt0111161/");
        String selector = ".ipc-shoveler__arrow--right [class*=right]";

        $(selector).click(withWaitForRequestFinished("/tr"));
        find(selector).click(withWaitForResponse("/tr", 1000));

        find("#suggestion-search").fill("Shawshank", withWaitForResponse("Shawshank"));
    }

}

package com.github.rmarinsky.networkConditions;

import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

import static com.github.rmarinsky.DramaWrapper.drama;

@AllArgsConstructor
public class RequestFinished implements NetworkCondition {

    private final String waitForUrlRegex;
    private final Integer timeoutToWait;

    @Override
    public void wait(Runnable locatorActionToWrap) {
        var options = new Page.WaitForRequestFinishedOptions();
        drama().page()
                .waitForRequestFinished(
                        options
                                .setTimeout(timeoutToWait)
                                .setPredicate(request -> request.url().contains(waitForUrlRegex)),
                        locatorActionToWrap
                );
    }

}

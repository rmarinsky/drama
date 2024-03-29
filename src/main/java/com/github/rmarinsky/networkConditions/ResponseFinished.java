package com.github.rmarinsky.networkConditions;

import com.microsoft.playwright.Page;
import lombok.AllArgsConstructor;

import static com.github.rmarinsky.DramaWrapper.drama;

@AllArgsConstructor
public class ResponseFinished implements NetworkCondition {

    private final String waitForUrl;
    private final Integer timeoutToWait;

    @Override
    public void wait(Runnable locatorActionToWrapWithNetworkWaiter) {
        var responseOptions = new Page.WaitForResponseOptions();
        drama().page()
                .waitForResponse(response -> response.url().contains(waitForUrl),
                        responseOptions.setTimeout(timeoutToWait),
                        locatorActionToWrapWithNetworkWaiter
                );
    }

}

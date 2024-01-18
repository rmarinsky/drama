package com.github.rmarinsky.networkWaits;

public interface ClickConditions {

    static ClickConditions withWaitForRequestFinished(String waitForUrl) {
        return withWaitForRequestFinished(waitForUrl, 5000);
    }

    static ClickConditions withWaitForRequestFinished(String waitForUrl, Integer timeoutToWait) {
        return new RequestFinished(waitForUrl, timeoutToWait);
    }

    static ClickConditions withWaitForResponse(String waitForUrl, Integer timeoutToWait) {
        return new ResponseFinished(waitForUrl, timeoutToWait);
    }

    static ClickConditions withWaitForResponse(String waitForUrl) {
        return withWaitForResponse(waitForUrl, 5000);
    }

    void wait(Runnable locatorActionToWrapWithNetworkWaiter);

}

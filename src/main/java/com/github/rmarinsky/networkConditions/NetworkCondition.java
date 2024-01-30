package com.github.rmarinsky.networkConditions;

public interface NetworkCondition {

    static NetworkCondition withWaitForRequestFinished(String waitForUrl) {
        return withWaitForRequestFinished(waitForUrl, 5000);
    }

    static NetworkCondition withWaitForRequestFinished(String waitForUrl, Integer timeoutToWait) {
        return new RequestFinished(waitForUrl, timeoutToWait);
    }

    static NetworkCondition withWaitForResponse(String waitForUrl, Integer timeoutToWait) {
        return new ResponseFinished(waitForUrl, timeoutToWait);
    }

    static NetworkCondition withWaitForResponse(String waitForUrl) {
        return withWaitForResponse(waitForUrl, 5000);
    }

    void wait(Runnable locatorActionToWrap);

}

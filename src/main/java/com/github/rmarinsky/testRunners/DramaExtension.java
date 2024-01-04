package com.github.rmarinsky.testRunners;

import com.github.rmarinsky.DramaWrapper;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DramaExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        DramaWrapper.initTestContext(true, getTestName(context));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        DramaWrapper.closeContext(true, getTestName(context));
    }

    private String getTestName(ExtensionContext context) {
        return context.getRequiredTestClass().getName() + " " + context.getDisplayName();
    }

}

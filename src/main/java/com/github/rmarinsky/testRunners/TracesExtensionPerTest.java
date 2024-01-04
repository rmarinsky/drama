package com.github.rmarinsky.testRunners;

import com.github.rmarinsky.DramaWrapper;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TracesExtensionPerTest implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        DramaWrapper.drama().startTracing(getTestName(context));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        DramaWrapper.drama().stopTracing(getTestName(context));
    }

    private String getTestName(ExtensionContext context) {
        return context.getRequiredTestClass().getCanonicalName() + " " + context.getDisplayName().replace(" ", "_");
    }

}

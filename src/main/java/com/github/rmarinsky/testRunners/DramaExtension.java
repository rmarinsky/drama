package com.github.rmarinsky.testRunners;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import com.github.rmarinsky.Configuration;
import com.github.rmarinsky.Scene;

public class DramaExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Scene.initTestContext(Configuration.saveTraces, getTestName(context));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        Scene.closeContext(Configuration.saveTraces, getTestName(context));
    }

    private String getTestName(ExtensionContext context) {
        return context.getRequiredTestClass().getName() + " " + context.getDisplayName();
    }

}

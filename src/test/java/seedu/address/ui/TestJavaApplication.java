package seedu.address.ui;

import javafx.application.Platform;

public class TestJavaApplication {

    public static class TestApp {
        private static TestApp instance;

        /**
         * Initializes Platform for testing.
         */
        public static void initialize() {
            if (instance == null) {
                instance = new TestApp();
                Platform.startup(() -> {});
            }
        }
    }
}

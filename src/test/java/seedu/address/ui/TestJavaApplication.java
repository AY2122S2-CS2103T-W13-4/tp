package seedu.address.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestJavaApplication {

    public static class TestApp {
        private static TestApp instance;

        public static void initialize(){
            if(instance == null){
                instance = new TestApp();
                Platform.startup(() -> {});
            }
        }
    }
}

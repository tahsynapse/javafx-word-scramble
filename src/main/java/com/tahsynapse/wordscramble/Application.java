package com.tahsynapse.wordscramble;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        // attach app stylesheet that defines hover border for letter buttons
        if (Application.class.getResource("styles.css") != null) {
            scene.getStylesheets().add(Application.class.getResource("styles.css").toExternalForm());
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

package org.example.serialgenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.serialgenerator.views.HomeController;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/serialgenerator/views/Home.fxml"));
        Parent root = fxmlLoader.load();

        HomeController homeController = fxmlLoader.getController();
        homeController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);

        scene.getRoot().requestFocus();

        stage.show();
    }

    public static void main(String[] args) {launch(args);}
}

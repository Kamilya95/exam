package com.example.exam;

import com.example.exam.Models.SceneModel;
import com.example.exam.Models.StageModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        StageModel.setMyStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("auth.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        SceneModel.setMyScene(scene);
        stage.setTitle("Главное меню");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
    public void openNewScene(AnchorPane rootPane, String window, String title) {
        try{
            AnchorPane anchorPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(window)));
            rootPane.getChildren().setAll(anchorPane);
            StageModel.getMyStage().setTitle(title);
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }
}
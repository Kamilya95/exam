package com.example.exam.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class MainController {
    @FXML
    private Button btn1,btn2;
    @FXML
    private GridPane grid1, grid2;
    @FXML
    private ImageView logOut;
    @FXML
    void onClick(ActionEvent event) {
        if (event.getSource() == btn1){
            grid1.toFront();
        } else if (event.getSource() == btn2) {
            grid2.toFront();
        }}
    @FXML
    void initialize() {
    }
    public void logOutClick(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) logOut.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/exam/auth.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Главное меню");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}

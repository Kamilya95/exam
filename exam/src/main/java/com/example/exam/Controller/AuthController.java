package com.example.exam.Controller;

import com.example.exam.DbFunctions.DbFunctions;
import com.example.exam.DbFunctions.Variables;
import com.example.exam.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthController {
    @FXML
    private Button btnSignIn;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label registrateLbl;
    @FXML
    private AnchorPane pane;
    private DbFunctions dbFunctions = new DbFunctions();
    private Alert alert;

    @FXML
    void initialize() {
        registrateLbl.setOnMouseClicked(e -> {
            new HelloApplication().openNewScene(pane, "/com/example/exam/registrate.fxml", "Регистрация");
        });

        btnSignIn.setOnAction(e -> {
            try {
                validation_auth();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    private void validation_auth() throws IOException {
        String f_login = loginField.getText();
        String f_password = passwordField.getText();
        int codeError = dbFunctions.signIn(f_login, f_password);
        if (f_login.isEmpty() || f_password.isEmpty()) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Пустые поля!");
            alert.showAndWait();
        } else if (codeError == 404) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Какая то ошибка");
            alert.showAndWait();
        } else if (codeError == 0) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Не найден аккаунт");
            alert.showAndWait();
        } else {
            if (Variables.ROLE_USER.equals("админ")) {

                Stage stage = (Stage) btnSignIn.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/exam/main.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Администратор");
                stage.setScene(new Scene(root1));
                stage.show();
            } else {
                Stage stage = (Stage) btnSignIn.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/exam/main2.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Клиент");
                stage.setScene(new Scene(root1));
                stage.show();
            }
        }



    }


}

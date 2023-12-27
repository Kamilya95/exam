package com.example.exam.Controller;

import com.example.exam.DbFunctions.DbFunctions;
import com.example.exam.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class RegistrateController {
    @FXML
    private TextField surname, lastname, login, name, password;

    @FXML
    private Button registrate;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label signIn;
    private DbFunctions dbFunctions = new DbFunctions();
    private Alert alert;

    @FXML
    void initialize() {
        registrate.setOnAction(e -> validation_create());
        signIn.setOnMouseClicked(e -> {
            new HelloApplication().openNewScene(pane, "/com/example/exam/auth.fxml", "Авторизация");
        });
    }


    private void validation_create() {
        String s_name = surname.getText();
        String name_s = name.getText();
        String l_name = lastname.getText();
        String s_login = login.getText();
        String s_password = password.getText();
        String role = "админ";
        int codeError = dbFunctions.check_login(s_login);
        if (s_name.isEmpty() || name_s.isEmpty() || l_name.isEmpty() || s_login.isEmpty() ||
                s_password.isEmpty()) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Пустые поля!");
            alert.showAndWait();
        } else if (codeError == 0) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Такой логин уже существует");
            alert.showAndWait();
        } else if (codeError == 404) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Какая то ошибка");
            alert.showAndWait();
        } else {
            dbFunctions.createUser(s_name, name_s, l_name, s_login, s_password, role);
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Вы успешно зарегистрировались!");
            alert.showAndWait();
            surname.setText("");
            name.setText("");
            lastname.setText("");
            login.setText("");
            password.setText("");



        }
    }
}

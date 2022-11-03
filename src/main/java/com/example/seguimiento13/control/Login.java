package com.example.seguimiento13.control;

import com.example.seguimiento13.HelloApplication;
import com.example.seguimiento13.model.FileOpenerData;
import com.example.seguimiento13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private HBox boxes;
    @FXML
    private PasswordField passF1;

    @FXML
    private PasswordField passF2;

    @FXML
    private PasswordField passF3;

    @FXML
    private PasswordField passF4;

    @FXML
    private PasswordField passF5;

    @FXML
    private PasswordField passF6;

    @FXML
    void verifyPassword(ActionEvent event) {
        String realPassword = FileOpenerData.getInstance().getUser().getPassword();
        StringBuilder enteredPassword = new StringBuilder();
        for (Node node: boxes.getChildren()) {
            TextField tf = (TextField) node;
            enteredPassword.append(tf.getText());

        }
        if(realPassword.replaceAll("\\s+","").equals(enteredPassword.toString().replaceAll("\\s+",""))) {
            HelloApplication.showWindow("Home.fxml");
            Stage currentStage = (Stage) passF1.getScene().getWindow();
            currentStage.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseña incorrecta");
            alert.setHeaderText("Contraseña incorrecta");
            alert.setContentText("Ingresaste la contraseña incorrecta");
            alert.showAndWait();
        }
    }
    @FXML
    void onKey(KeyEvent event) {
        if(event.getSource().equals(passF1)) {
        } else if(event.getSource().equals(passF2)) {
        } else if(event.getSource().equals(passF3)) {
        } else if(event.getSource().equals(passF4)) {
        } else if(event.getSource().equals(passF5)) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String password = FileUtils.readFile("safePassword.txt");
        FileOpenerData.getInstance().getUser().setPassword(password);
    }
}
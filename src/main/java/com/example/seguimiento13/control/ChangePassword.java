package com.example.seguimiento13.control;

import com.example.seguimiento13.HelloApplication;
import com.example.seguimiento13.model.FileOpenerData;
import com.example.seguimiento13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ChangePassword {

    @FXML
    private HBox boxes;

    @FXML
    private HBox boxes1;

    @FXML
    private Button changePasswordBT;

    @FXML
    private Button closeSafeBT;

    @FXML
    private PasswordField passwordField1;

    @FXML
    private PasswordField passwordField2;

    @FXML
    private PasswordField passwordField3;

    @FXML
    private PasswordField passwordField4;

    @FXML
    private PasswordField passwordField5;

    @FXML
    private PasswordField passwordField6;

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
    void closeSafe(ActionEvent event) {
        Stage stage = (Stage) boxes1.getScene().getWindow();
        stage.hide();
        HelloApplication.showWindow("Login.fxml");
    }

    @FXML
    void onKey(KeyEvent event) {
        if(event.getSource().equals(passF1)) {
            passF2.requestFocus();
        } else if(event.getSource().equals(passF2)) {
            passF3.requestFocus();
        } else if(event.getSource().equals(passF3)) {
            passF4.requestFocus();
        } else if(event.getSource().equals(passF4)) {
            passF5.requestFocus();
        } else if(event.getSource().equals(passF5)) {
            passF6.requestFocus();
        }
    }

    @FXML
    void onKeyNewPassword(KeyEvent event) {
        if(event.getSource().equals(passwordField1)) {
            passwordField2.requestFocus();
        } else if(event.getSource().equals(passwordField2)) {
            passwordField3.requestFocus();
        } else if(event.getSource().equals(passwordField3)) {
            passwordField4.requestFocus();
        } else if(event.getSource().equals(passwordField4)) {
            passwordField5.requestFocus();
        } else if(event.getSource().equals(passwordField5)) {
            passwordField6.requestFocus();
        }
    }

    @FXML
    void verifyPassword(ActionEvent event) {
        String realPassword = FileOpenerData.getInstance().getUser().getPassword();
        StringBuilder enteredPassword = new StringBuilder();
        for (Node node: boxes.getChildren()) {
            TextField tf = (TextField) node;
            enteredPassword.append(tf.getText());
        }
        StringBuilder newPassword = new StringBuilder();
        for (Node node: boxes1.getChildren()) {
            TextField tf = (TextField) node;
            newPassword.append(tf.getText());
        }
        if(realPassword.replaceAll("\\s+","").equals(enteredPassword.toString().replaceAll("\\s+",""))) {
            FileOpenerData.getInstance().getUser().setPassword(newPassword.toString());
            FileUtils.writeFile("safePassword.txt", newPassword.toString());
            Stage stage = (Stage) boxes1.getScene().getWindow();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Constraseña correcta");
            alert.setHeaderText("Informacion incorrecta");
            alert.setContentText("La contraseña ha sido cambiada correctamente :)");
            alert.showAndWait();
            stage.hide();
            HelloApplication.showWindow("Login.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Contraseña incorrecta");
            alert.setHeaderText("Contraseña incorrecta");
            alert.setContentText("Ingresaste la contraseña incorrecta" +
                    "\nNo se puede cambiar la contraseña");
            alert.showAndWait();
        }
    }

}

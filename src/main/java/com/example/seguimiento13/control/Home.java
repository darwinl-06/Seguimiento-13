package com.example.seguimiento13.control;

import com.example.seguimiento13.HelloApplication;
import com.example.seguimiento13.model.FileOpenerData;
import com.example.seguimiento13.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private Button changePass;

    @FXML
    private TextArea content;

    @FXML
    private Button exitHome;


    @FXML
    void changePassword(ActionEvent event) {
        String s = content.getText();
        FileUtils.writeFile("safeContent.txt", s);
        FileOpenerData.getInstance().getUser().setContent(s);
        Stage stage = (Stage) content.getScene().getWindow();
        stage.hide();
        HelloApplication.showWindow("ChangePassword.fxml");
    }

    @FXML
    void exitWindow(ActionEvent event) {
        String s = content.getText();
        FileUtils.writeFile("safeContent.txt", s);
        FileOpenerData.getInstance().getUser().setContent(s);
        Stage stage = (Stage) content.getScene().getWindow();
        stage.hide();
        HelloApplication.showWindow("login.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String content = FileUtils.readFile("safeContent.txt");
        FileOpenerData.getInstance().getUser().setContent(content);
        this.content.setText(content);
    }
}
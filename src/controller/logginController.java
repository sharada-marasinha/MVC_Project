package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class logginController {
    public JFXTextField txtusername;
    public JFXPasswordField txtpasword;
    public Label errorLable;
    @FXML
    private AnchorPane root;

    public void logingOnaction(ActionEvent actionEvent) throws IOException {
        String user = "A";
        String password = "1234";
        if (this.txtusername.getText().equals(user) && this.txtpasword.getText().equals(password)) {
            Stage window = (Stage)this.root.getScene().getWindow();
            window.setScene(new Scene((Parent)FXMLLoader.load(this.getClass().getResource("../view/dashBord.fxml"))));
        } else if (this.txtusername.getText().isEmpty() && this.txtpasword.getText().isEmpty()) {
            this.errorLable.setText("Your User Name Or Password IS Empty...!");
            this.txtusername.clear();
            this.txtpasword.clear();
        } else if (!this.txtusername.getText().equals(user)) {
            this.errorLable.setText("Your User Name is incorrect..!");
            this.txtusername.clear();
            this.txtpasword.clear();
            txtpasword.requestFocus();
        } else if (!this.txtpasword.getText().equals(password)) {
            this.errorLable.setText("Your Password is incorrect..!");
            this.txtusername.clear();
            this.txtpasword.clear();
        }



        }

    public void hiperFacebook(ActionEvent actionEvent) throws URISyntaxException, IOException {
        System.out.println("Face book Link Clicked!");
        Desktop.getDesktop().browse(new URI("https://www.facebook.com/Sharada.Marasinha/"));

    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author apple
 */
public class ResetPasswordFormController implements Initializable {

    @FXML
    private AnchorPane resetPasswordFrame;
    @FXML
    private Pane resetPasswordPanel;
    @FXML
    private TextField oldPasswordField;
    @FXML
    private TextField newPasswordField;
    @FXML
    private TextField confirmationPasswordField;
    @FXML
    private Button saveResetPassword;
    @FXML
    private Button exitResetPassword;
    @FXML
    private Label resetPasswordMessageLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void displaySettings(ActionEvent e) throws IOException {
        //go the settings screen of the logged in user
         System.out.println("Settings Button Clicked");
        
        Parent mainFrameParent = FXMLLoader.load(getClass().getResource("/view/Settings.fxml"));
        Scene scene = new Scene(mainFrameParent);
       
        // Get the stage information by casting the stage to a node
        Stage mfWindow = (Stage)((Node)e.getSource()).getScene().getWindow();
        
        mfWindow.setScene(scene);
        mfWindow.show();  
        //TODO
        
    }
    
    @FXML
    private void resetPassword(ActionEvent e) throws IOException {
       
        if(newPasswordField.getText().equals(confirmationPasswordField.getText())
              /*  && oldPasswordField.getText().equals(acc.getPassword())*/ ){
            resetPasswordMessageLabel.setText("Password has been changed");
        }
        else {
            resetPasswordMessageLabel.setText("Passwords do not match");
        }
        
    }
    
}

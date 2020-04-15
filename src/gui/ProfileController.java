/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application1.Application1;
import application1.fos_user;
import application1.fos_userService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;



/**
 * FXML Controller class
 *
 * @author ouertani
 */
public class ProfileController implements Initializable {

    @FXML
    private AnchorPane profilecontent;
    @FXML
    private Text txtusername;
    @FXML
    private Text txtemail;
    @FXML
    private Button gochangeEmail;
    @FXML
    private Button gochangeUsername;
    @FXML
    private Button gochangemdp;
    @FXML
    private AnchorPane profilecontent1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fos_user user=new fos_user();
        fos_userService us=new fos_userService();
        try {
            user=us.getUserById(   Application1.user_id);
            txtusername.setText(user.getUsername());
            txtemail.setText(user.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    @FXML
    private void gochangeEmail(ActionEvent event) {
    }

    @FXML
    private void gochangeUsername(ActionEvent event) {
    }

    @FXML
    private void gochangemdp(ActionEvent event) {
    }
    
}

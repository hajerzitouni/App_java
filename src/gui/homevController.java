/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class homevController implements Initializable {
   
    
    @FXML
    private Button vente;
    @FXML
    private Button locationB;
    @FXML
    private Button rep;
    @FXML
    private ImageView background;
    @FXML
    private Button event;
    @FXML
    private Button course;
    @FXML
    private Button stat;
    @FXML
    private Button recl;
    @FXML
    private AnchorPane content;
    @FXML
    private ImageView image;
 
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
    }
    

    @FXML
    private void vente(ActionEvent event) {
    }

    @FXML
    private void location(ActionEvent event) throws IOException {
        
       content.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/Afficherlocation.fxml"));
        content.getChildren().add(parent);
        content.toFront();
    }

    @FXML
    private void reparation(ActionEvent event) {
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void cours(ActionEvent event) throws IOException {
        

       content.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/AfficherCours.fxml"));
        content.getChildren().add(parent);
        content.toFront();
    }

    

    @FXML
    private void statistiques(ActionEvent event) {
    }

    @FXML
    private void reclamations(ActionEvent event) throws IOException {
         content.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/showreclamation.fxml"));
        content.getChildren().add(parent);
        content.toFront();
    }
    
}

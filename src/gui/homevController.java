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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author user
 */
public class homevController implements Initializable {
   
    
    @FXML
    private Button vente;
    @FXML
    private MenuItem locationB;
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
    @FXML
    private Button notif;
    @FXML
    private MenuItem velo;
    @FXML
    private MenuItem assurance;
 
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

    @FXML
    private void notif(ActionEvent event) {
        Image img = new Image ("/gui/stick.png");
     Notifications notificationBuilder = Notifications.create()
             .title("Notifications")
             .text("vous avez des nouvelles reclamations ..!")
             .graphic(new ImageView(img))
             .hideAfter(Duration.seconds(5))
             .position(Pos.TOP_RIGHT)
             .onAction(new EventHandler<ActionEvent>() {
               
                 public void hanle (ActionEvent event){
               System.out.println("Clicked on");
                 
                  }

         @Override
         public void handle(ActionEvent event) {
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
             });
     notificationBuilder.darkStyle();
     
     notificationBuilder.show();
             }

    @FXML
    private void velo(ActionEvent event) throws IOException {
         content.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/affichervelo_1.fxml"));
        content.getChildren().add(parent);
        content.toFront();
    }

    @FXML
    private void assurance(ActionEvent event) throws IOException {
         content.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/showassurance.fxml"));
        content.getChildren().add(parent);
        content.toFront();
    }
             
             
            
        
    }
    


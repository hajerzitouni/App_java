/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application1.asurance;
import application1.assuranceService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class AddassuranceController implements Initializable {

    @FXML
    private TextArea montant;
    @FXML
    private TextArea velo;
    @FXML
    private Button ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        
        
        
         try {

    
    assuranceService as = new assuranceService ();
      
        int nbrcomp = (Integer) Integer.parseInt(velo.getText()) + 0;
        int nbr = (Integer) Integer.parseInt(montant.getText()) + 0;
        
       
   
         asurance a = new asurance(nbr,nbrcomp);
         as.ajouter(a);
                
        System.out.println("assurance ajouté"); 
           
            
            
        
           
          }catch (SQLException ex) {
            Logger.getLogger(assuranceService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}

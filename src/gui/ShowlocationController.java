/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import application1.locationn;
import application1.locationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hajer
 */
public class ShowlocationController implements Initializable {

    @FXML
    private TableView<locationn> table;
    locationService ls = new locationService ();
    @FXML
    private TableColumn<?, ?> namecomp;
    @FXML
    private TableColumn<?, ?> start;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> end;
    @FXML
    private TableColumn<?, ?> velo_id;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private Button delete;
    @FXML
    private Button edit;
    @FXML
    private TextArea assurance;
    @FXML
    private Button calculprix;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) throws SQLException {
    
   ArrayList<String> assurancel= new ArrayList<>();
        if(!table.getSelectionModel().getSelectedItems().isEmpty()){
               locationService ls = new locationService ();
           assurancel= ls.afficherassurance(table.getSelectionModel().getSelectedItems().get(0).getId());
            
   // assurance.setText("100");
         for(String a : assurancel){
            assurance.setText(a + "\n");
            // output += s.toString() + "\n";
             
                              // }//
                 
                 
               

       
        }}
       else{
           
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("aucun élément 'a ètè séléctionné");
        alert.showAndWait();

           
        
       
    }
    }

    @FXML
    private void edit(ActionEvent event) {
    }
    
     public void load(Integer id) throws SQLException {
         ObservableList<locationn> location = FXCollections.observableArrayList();
     
         
        
          location.add(ls.FindById(id));
             
         namecomp.setCellValueFactory(new PropertyValueFactory<>("nomlocation"));
         start.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         end.setCellValueFactory(new PropertyValueFactory<>("date_fin"));

        velo_id.setCellValueFactory(new PropertyValueFactory<>("velo_id"));
         prix.setCellValueFactory(new PropertyValueFactory<>("prixloc")); 
       
     
   
       
        table.setItems(location);
        
    
    }  
     
    
    public void load() throws SQLException {
         ObservableList<locationn> location = FXCollections.observableArrayList();
     
         
        
          location.add(ls.FindById(table.getSelectionModel().getSelectedItems().get(0).getId()));
             
         namecomp.setCellValueFactory(new PropertyValueFactory<>("nomlocation"));
         start.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         end.setCellValueFactory(new PropertyValueFactory<>("date_fin"));

        velo_id.setCellValueFactory(new PropertyValueFactory<>("velo_id"));
         prix.setCellValueFactory(new PropertyValueFactory<>("prixloc")); 
       
     
   
       
        table.setItems(location);
        
    
    }  
     
     @FXML
    private void calculprix(ActionEvent event) throws SQLException, IOException, IOException, IOException {
   if(!table.getSelectionModel().getSelectedItems().isEmpty()){
               locationService ls = new locationService ();
           ls.calculPrix(table.getSelectionModel().getSelectedItems().get(0).getId());
         load ();
        }
       else{
           
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("aucun élément 'a ètè séléctionné");
        alert.showAndWait();

           
        
       
    }
  
    }
    
}

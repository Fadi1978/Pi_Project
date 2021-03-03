/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import entities.Message;
import entities.Sujet;
import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.SujetCRUD;
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author windows 10
 */
public class AddSujetController implements Initializable {

    @FXML
    private TextField sujettext;
    @FXML
    private Button ajoutersuj;
    @FXML
    private TableView<Sujet> tabsuj;
    @FXML
    private TableColumn<Sujet, Integer> idsujettab;
    @FXML
    private TableColumn<Sujet, String> idcreateurtab;
    @FXML
    private TableColumn<Sujet, String> sujettab;
    @FXML
    private TableColumn<Sujet, String> dateposttab;
    int ID;
    SujetCRUD pcr = new SujetCRUD();
    @FXML
    private Button supprimer;
    @FXML
    private JFXButton moidifer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showSujet();
     

        
    }    

    @FXML
    private void AjouterSujet(ActionEvent event)  {
          try
        {
        //save Msg in DATA BASE
       String rsuj = sujettext.getText();
        Sujet suj= new Sujet(rsuj);
        SujetCRUD sujj= new SujetCRUD();
        sujj.addSujet(suj);
        // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Sujet!");
              a.setHeaderText(null);
              a.setContentText("Sujet ajouté !!!");
              a.showAndWait();
            
            //*********
            
        
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             //showSujet();
                       showSujet();

    }
       public void showSujet() {
        System.out.println("DEBUGG!!!!");
        ObservableList<Sujet> list =pcr.getSujet();
        //ObservableList<Product> list = FXCollections.observableList(pcd.getProductList());
        idsujettab.setCellValueFactory(new PropertyValueFactory<Sujet, Integer>("id_suj"));
        idcreateurtab.setCellValueFactory(new PropertyValueFactory<Sujet, String>("id_createur"));
        sujettab.setCellValueFactory(new PropertyValueFactory<Sujet, String>("sujet"));
        dateposttab.setCellValueFactory(new PropertyValueFactory<Sujet, String>("date_heure_creation_"));


   
        
        tabsuj.setItems(list);
      
    }

    @FXML
    private void SetValue(MouseEvent event) {
         Sujet selected = tabsuj.getSelectionModel().getSelectedItem();
        if (selected != null) {
         
          //  String idsujettab = String.valueOf(selected.getId_suj());
            
           // tfprixP.setText(Sprix);
            
            sujettext.setText(selected.getSujet());
            ID = selected.getId_suj();
        }
    }

    @FXML
    private void SupprimerSujet(ActionEvent event) {
                 try {
            String requete = "DELETE FROM sujet WHERE id_suj="+ID+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            pst.executeUpdate();
            // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Sujet!");
              a.setHeaderText(null);
              a.setContentText("Sujet supprimé !!!");
              a.showAndWait();
            
            //*********
            
            System.out.println("Sujet supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(SujetCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showSujet(); 
    }

    @FXML
    private void ModifierSujet(ActionEvent event) {
          try {
            String requete = "UPDATE sujet SET sujet=? WHERE id_suj="+ID+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            
            pst.setString(1, sujettext.getText());
           
            pst.executeUpdate();
            // Alert 
            Alert 
              a = new Alert(Alert.AlertType.WARNING); 
              a.setTitle(" Sujet!");
              a.setHeaderText(null);
              a.setContentText("Sujet Modifié !!!");
              a.showAndWait();
            
            //*********
            
            System.out.println("Message modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(SujetCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showSujet();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Message;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.MessageCRUD;
import tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author Samar
 */
public class AddMessageController implements Initializable {

    @FXML
    private TextField idposteur;
    @FXML
    private Button ajouter;
    @FXML
    private TableView<Message> tab;
    @FXML
    private TableColumn<Message, String> nomtab;
    @FXML
    private TableColumn<Message, String> msgtab;
        MessageCRUD pcr=new MessageCRUD();
    @FXML
    private TextField message;
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Message,Integer> idmsg;
        private int ID;
    @FXML
    private Button modifier;
    @FXML
    private ComboBox<String> listesujet;

    ObservableList<String> SujetList;
    ResultSet rs = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            showMessage();
        } catch (SQLException ex) {
            Logger.getLogger(AddMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }    

    @FXML
    private void AjouterMessage(ActionEvent event) throws SQLException {
             try
        {
        //save Msg in DATA BASE
        String rmessage = message.getText();
        String rId_posteur = idposteur.getText();
        Message msg= new Message(rmessage,rId_posteur);
        MessageCRUD msgg= new MessageCRUD();
        msgg.addMessage(msg);
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             showMessage();
    }
       public void showMessage() throws SQLException {
        System.out.println("DEBUGG!!!!");
        ObservableList<Message> list =pcr.getMessage();
        //ObservableList<Product> list = FXCollections.observableList(pcd.getProductList());
        nomtab.setCellValueFactory(new PropertyValueFactory<Message, String>("id_posteur"));
        msgtab.setCellValueFactory(new PropertyValueFactory<Message, String>("message"));
        idmsg.setCellValueFactory(new PropertyValueFactory<Message, Integer>("id_msg"));
                tab.setItems(list);
/*

String requete = "SELECT sujet FROM sujet ";
        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
               //Statement st;
            ResultSet rs = null;
                ObservableList<String> SujetList = FXCollections.observableArrayList(rs.getString("sujet"));
        } catch (SQLException ex) {
            Logger.getLogger(AddSujetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        listesujet.setItems(SujetList);
      
      */
String requete = "SELECT sujet FROM sujet ";
PreparedStatement pst
           = new MyConnection().cn.prepareStatement(requete);
        rs = pst.executeQuery();
          // System.out.println(rs.getString("sujet"));
          while (rs.next())
          {
                ObservableList<String> SujetList = FXCollections.observableArrayList(rs.getString("sujet"));
          
                        listesujet.setItems(SujetList);
          }

    }
 
   
    @FXML
    private void SupprimerComm(ActionEvent event) throws SQLException {
         try {
            String requete = "DELETE FROM message WHERE id_msg="+ID+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            pst.executeUpdate();
            System.out.println("Message supprimé!");
        } catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showMessage(); 
    }

    @FXML
    private void SetValue(MouseEvent event) {
         Message selected = tab.getSelectionModel().getSelectedItem();
        if (selected != null) {
            idposteur.setText(selected.getId_posteur());
            message.setText(selected.getMessage());
            ID = selected.getId_msg();
        }
    }

    @FXML
    private void ModifierMsg(ActionEvent event) throws SQLException {
          try {
            String requete = "UPDATE message SET message=?,id_posteur=? WHERE id_msg="+ID+"";
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            
            pst.setString(1, message.getText());
            pst.setString(2, idposteur.getText());
           
            pst.executeUpdate();
            System.out.println("Message modifié!");
        } catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
          showMessage();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Message;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tools.MyConnection;

/**
 *
 * @author Samar
 */
public class MessageCRUD {
     public void addMessage (Message m) throws SQLException{
    try{
        String requete = "INSERT INTO message (message,id_posteur)"
                + "VALUES(?,?)" ;
           PreparedStatement pst =
            new MyConnection().cn.prepareStatement(requete);
    pst.setString(1,m.getMessage());
    pst.setString(2,m.getId_posteur());
  
    pst.executeUpdate();
    System.out.println("Message ajoutée!");




    }
    catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
     public ObservableList<Message> getMessage() {

        ObservableList<Message> ProductList = FXCollections.observableArrayList();
        String requete = "SELECT id_msg,message,id_posteur FROM message";
        try {
            PreparedStatement pst
                    = new MyConnection().cn.prepareStatement(requete);
            //Statement st;
            ResultSet rs;
            try {
                //System.out.println("AHAYYYAA!!!!");
                //st=conn.createStatement();
                //System.out.println("AHAYYYAA222!!!!");
                rs = pst.executeQuery(requete);
                Message p;

                while (rs.next()) {
                    Message msg = new Message(rs.getInt("id_msg"),rs.getString("message"), rs.getString("id_posteur"));
                    ProductList.add(msg);
                }

            } catch (Exception ex) {
                //System.out.println("AHAYYYAA L7KEEEYAAAAA!!!!");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ProductList;
    }


}

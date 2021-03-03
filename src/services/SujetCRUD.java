/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Sujet;
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
 * @author windows 10
 */
public class SujetCRUD {
    public void addSujet (Sujet suj) throws SQLException{
    try{
        String requete = "INSERT INTO sujet (sujet)"
                + "VALUES(?)" ;
           PreparedStatement pst =
            new MyConnection().cn.prepareStatement(requete);
    pst.setString(1,suj.getSujet());
  
    pst.executeUpdate();
    System.out.println("Sujet ajoutée!");




    }
    catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public ObservableList<Sujet> getSujet() {

        ObservableList<Sujet> SujetList = FXCollections.observableArrayList();
        String requete = "SELECT * FROM sujet ";
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
                Sujet p;

                while (rs.next()) {
                    Sujet suj = new Sujet(rs.getInt("id_suj"),rs.getString("id_createur"), rs.getString("sujet"), rs.getString("date_heure_creation"));
                    SujetList.add(suj);
                }

            } catch (Exception ex) {
                //System.out.println("AHAYYYAA L7KEEEYAAAAA!!!!");
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return SujetList;
    }
}

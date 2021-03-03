/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author windows 10
 */
public class Sujet {
    int id_suj;
    String id_createur;
    String sujet;
    String date_heure_createur;

    public Sujet() {
    }

    public Sujet(int id_suj, String id_createur, String sujet, String date_heure_createur) {
        this.id_suj = id_suj;
        this.id_createur = id_createur;
        this.sujet = sujet;
        this.date_heure_createur = date_heure_createur;
    }
       public Sujet( String sujet) {
        
        this.sujet = sujet;
        
    }

    public String getDate_heure_createur() {
        return date_heure_createur;
    }

    public String getId_createur() {
        return id_createur;
    }

    public int getId_suj() {
        return id_suj;
    }

    public String getSujet() {
        return sujet;
    }

    public void setDate_heure_createur(String date_heure_createur) {
        this.date_heure_createur = date_heure_createur;
    }

    public void setId_createur(String id_createur) {
        this.id_createur = id_createur;
    }

    public void setId_suj(int id_suj) {
        this.id_suj = id_suj;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
    
   
            
            
    
}

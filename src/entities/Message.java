/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javafx.scene.control.Button;

/**
 *
 * @author Samar
 */
public class Message {
     private Integer id_msg;
   private String message;
   private String id_posteur;
   private String date_heure_post;
   private String date_heure_edition;
   private Button button;

    public Message() {
    }

    public Message(Integer id_msg, String message, String id_posteur, String date_heure_post, String date_heure_edition) {
        this.id_msg = id_msg;
        this.message = message;
        this.id_posteur = id_posteur;
        this.date_heure_post = date_heure_post;
        this.date_heure_edition = date_heure_edition;
    }
 
    public Message(String message, String id_posteur) {
        this.message = message;
        this.id_posteur = id_posteur;

       
    }
  public Message(Integer id_msg,String message, String id_posteur) {
        this.id_msg = id_msg;
        this.message = message;
        this.id_posteur = id_posteur;

       
    }
   
    public String getDate_heure_edition() {
        return date_heure_edition;
    }

    public String getDate_heure_post() {
        return date_heure_post;
    }

    public Integer getId_msg() {
        return id_msg;
    }

    public String getId_posteur() {
        return id_posteur;
    }

    public String getMessage() {
        return message;
    }

    public void setDate_heure_edition(String date_heure_edition) {
        this.date_heure_edition = date_heure_edition;
    }

    public void setDate_heure_post(String date_heure_post) {
        this.date_heure_post = date_heure_post;
    }

    public void setId_msg(Integer id_msg) {
        this.id_msg = id_msg;
    }

    public void setId_posteur(String id_posteur) {
        this.id_posteur = id_posteur;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" + "id_msg=" + id_msg + ", message=" + message + ", id_posteur=" + id_posteur + ", date_heure_post=" + date_heure_post + ", date_heure_edition=" + date_heure_edition + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.Message;
import java.sql.SQLException;
import services.MessageCRUD;
import tools.MyConnection;

/**
 *
 * @author Samar
 */
public class MainTest {
       public static void main(String[] args) throws SQLException {
      try {
        MyConnection mc = new MyConnection();
        MessageCRUD msg= new MessageCRUD();
        Message msg1 = new Message(100,"110","20","10/02/2021","10/02/2021");
        
       msg.addMessage(msg1);
    }
    
    catch(SQLException ex)  {
            System.out.println( ex);   
}
}
    
}

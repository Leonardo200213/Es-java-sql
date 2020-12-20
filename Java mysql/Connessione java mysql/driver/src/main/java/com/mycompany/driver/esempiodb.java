/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.driver;

/**
 *
 * @author miste
 */
import static java.lang.System.out;
import java.sql.*;

public class esempiodb {
    
    
    
    public static void main(String[] args){
        persona p = new persona();
        String DRIVER = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(DRIVER);
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver non trovato");
            System.exit(1);
        }
        
        String URL_miodb = "jdbc:mysql://localhost:3306/provejava";
        String query = "SELECT cognome, nome FROM esempiodb";
        
     System.out.println("Connessione con: " + URL_miodb);
     Connection connessione = null;
     try{
         connessione = DriverManager.getConnection(URL_miodb, "root", "");
     }catch(Exception e){
         System.out.println("Errore nella connessione: " + e);
         System.exit(1);
     }
     
     try{
         Statement state = connessione.createStatement();
         ResultSet resultSet = state.executeQuery(query);
         
         while (resultSet.next())
             p.cognome = resultSet.getString(1);
             p.nome = resultSet.getString(2);
         
             System.out.println("Cognome: " + p.cognome);
             System.out.println("Cognome: " + p.nome);
     }catch(Exception e){
         System.out.println("Errore nella connessione: " + e);
         System.exit(1);
     }
     finally{
         if(connessione != null){
             try{
                 connessione.close();
             }catch(Exception e){
                 System.out.println("Errore nella chiusura della connessione");
             }
         }
     }
    
    }
    
    
    
}

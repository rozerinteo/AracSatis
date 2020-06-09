/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Rozerin
 */
public class DBConnection {
    
     private Connection connection;
     
    // public static void main(String[] args){
     
    public Connection connect(){
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/bbbbb", "root", "123");
            
            /*String query = "select * from bayi";
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getInt("bayi_id"));
            }*/
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
         return this.connection;
        
    }
//}
}
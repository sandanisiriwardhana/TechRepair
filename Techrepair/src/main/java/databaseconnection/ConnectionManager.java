/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sandani Siriwardhana
 */
public class ConnectionManager {
    
    public static Connection conn() {
        try{
            String url = "jdbc:mysql://localhost:3306/tech repair";
            String user = "Admin";
            String password = "Admin";
                    
            Class.forName("com.mysql.cj.jdbc.Driver" );
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        
        }catch(SQLException | ClassNotFoundException e){
            //JoptionPane.showMessageDialog(null,e);
            System.out.println(e.getMessage());
        }
        return null;
    }
//Mea main method eka ain kranna . Dn mea main method ekae visitya anith evata kranna main thmnta refer
 public static void main(String [] args){
     Connection conn = ConnectionManager.conn();
     
     PreparedStatement pst;
     ResultSet rs;
     try{
     String sqlquery = "SELECT * FROM userlogin";
     pst= conn.prepareStatement(sqlquery);
     rs = pst.executeQuery();
     if (rs.next()){
         System.out.println(rs.getString("idno"));
         
     }
     }catch(SQLException e){
        System.out.println(e.getMessage());
     }
  }   
}

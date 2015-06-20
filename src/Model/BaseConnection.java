/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joanna
 */
public class BaseConnection {
   private final static BaseConnection connection = new BaseConnection();
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/logistyka?zeroDateTimeBehavior=convertToNull";   
   static final String USERNAME = "root";
   static final String PASSWORD = "";
   Connection conn = null;
   Statement stmt = null;
   
  private BaseConnection()
  {
   try {
           Class.forName(JDBC_DRIVER);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(BaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
   
   try{
           conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
           stmt = conn.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(BaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }

   }
  
  public static BaseConnection getConnection()
  {
      return connection;
  }
  
  public void disconnect()
  {
       try {
           conn.close();
           stmt.close();
       } catch (SQLException ex) {
           Logger.getLogger(BaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
      
  }
}

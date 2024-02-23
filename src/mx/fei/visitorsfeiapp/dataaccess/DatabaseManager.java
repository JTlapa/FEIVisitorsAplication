    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chuch
 */
public class DatabaseManager {
    private Connection connection;
    private static final String DATABASE_NAME = "jdbc:mysql://127.0.0.1/visitasfei";
    private static final String DATABASE_USER = "user11";
    private static final String DATABASE_PASSWORD = "110821";
    
    public Connection getConnection() throws SQLException{
        connect();
        return connection;
    }
    
    private void connect() throws SQLException{
        connection=DriverManager.getConnection(DATABASE_NAME,DATABASE_USER,DATABASE_PASSWORD);
    }
    
    public boolean closeConnection() {
        if(connection!=null) {
            try {
                if(!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException exception) {        
                return false;
            }
        }
        return true;
    }
}

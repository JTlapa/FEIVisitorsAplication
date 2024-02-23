/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.dataaccess;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mx.fei.visitorsfeiapp.logic.Visitor;
/**
 *
 * @author chuch
 */
public class VisitorsManager {
    private DatabaseManager dbManager;
    
    public VisitorsManager() {
        dbManager = new DatabaseManager();
    }
    public void addVisitor(Visitor visitor) {
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "INSERT INTO Visitante VALUES (?, ?, ?, ?)";
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,visitor.getId());
            statement.setString(2, visitor.getName());
            statement.setString(3, visitor.getLastname());
            statement.setString(4, visitor.getEmail());
            statement.executeUpdate();
            dbManager.closeConnection();
        } catch(SQLException e) {
            dbManager.closeConnection();
        }
    }
}

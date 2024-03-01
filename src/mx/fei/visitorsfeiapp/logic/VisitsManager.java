/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import mx.fei.visitorsfeiapp.dataaccess.DatabaseManager;
/**
 *
 * @author chuch
 */
public class VisitsManager {
    public int registerAVisitor(Visitor visitor) {
        DatabaseManager dbManager;
        dbManager = new DatabaseManager();
        PreparedStatement statement;
        Connection connection;
        int result = 0;
        String query = "INSERT INTO Visitante VALUES (?, ?, ?, ?, ?)";
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,visitor.getId());
            statement.setString(2, visitor.getName());
            statement.setString(3, visitor.getLastname());
            statement.setString(4, visitor.getEmail());
            statement.setString(5, visitor.getBelonging());
            result = statement.executeUpdate();
            dbManager.closeConnection();
        } catch(SQLException e) {
            dbManager.closeConnection();
            return result;
        }
        return result;
    }
    public int registerCheckIn(Visitor visitor) {
        DatabaseManager dbManager;
        dbManager = new DatabaseManager();
        PreparedStatement statement;
        Connection connection;
        int result;
        String query = "INSERT INTO Visita VALUES (?, 'FEI', ?, ?, Null, ?, ?)";
        
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,visitor.getId());
            statement.setString(2, date);
            statement.setString(3, currentTime);
            statement.setString(4, visitor.getVisiting());
            statement.setString(5, visitor.getSubject());
            result = statement.executeUpdate();
        } catch(SQLException e) {   
            result = 0;
        }
        dbManager.closeConnection();
        return result;
    }
    public int registerCheckOut(String id) {
        DatabaseManager dbManager;
        dbManager = new DatabaseManager();
        PreparedStatement statement;
        Connection connection;
        int result;
        String query = "UPDATE Visita SET horaSalida = ? WHERE codigoV = ? AND fecha = ?";
        
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,currentTime);
            statement.setString(2, id);
            statement.setString(3, date);
            result = statement.executeUpdate();
        } catch(SQLException e) {
            result = 0;
        }
        dbManager.closeConnection();
        return result;
    }
    public ArrayList<Visit> getVisitsByDay(String date){
        boolean band = false;
        DatabaseManager dbManager;
        dbManager = new DatabaseManager();
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "SELECT Visitante.tipo as type, "
                    + "Visitante.codigoV as id, "
                    + "Visitante.nombreV as name, "
                    + "Visitante.correoV as email, "
                    + "Visita.asunto as subject, "
                    + "Visita.horaEntrada as entry, "
                    + "Visita.horaSalida as departure "
                    + "FROM Visita INNER JOIN Visitante "
                    + "ON Visita.codigoV = Visitante.codigoV "
                    + "WHERE Visita.fecha = ?";
        
        ArrayList<Visit> visits = new ArrayList();
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,date);
            result = statement.executeQuery();
            while(result.next()) {
                Visit visit = new Visit();
                visit.setBelonging(result.getString("type"));
                visit.setId(result.getString("id"));
                visit.setName(result.getString("name"));
                visit.setEmail(result.getString("email"));
                visit.setSubject(result.getString("subject"));
                visit.setEntryTime(result.getString("entry"));
                visit.setDepartureTime(result.getString("departure"));
                visits.add(visit);
            }
        } catch(SQLException e) {
            visits = null;
        }
        dbManager.closeConnection();
        return visits;
    }
}

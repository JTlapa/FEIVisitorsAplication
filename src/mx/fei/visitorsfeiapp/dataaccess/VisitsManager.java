/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.dataaccess;

import mx.fei.visitorsfeiapp.logic.Visit;
import mx.fei.visitorsfeiapp.logic.Visitor;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author chuch
 */
public class VisitsManager {
    private DatabaseManager dbManager;
    
    public VisitsManager() {
        dbManager = new DatabaseManager();
    }
    public boolean insertAVisit(Visitor visitor) {
            
        boolean band = false;
        PreparedStatement statement = null;
        Connection connection = null;
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
            statement.executeUpdate();
            band = true;
        } catch(SQLException e) {
            System.out.println(e);
            band = false;
        }
        dbManager.closeConnection();
        return band;
    }
    public boolean registerDepartureTime(String id) {
        boolean band = false;
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "UPDATE Visita SET horaSalida = ? WHERE codigoV = ?";
        String currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1,currentTime);
            statement.setString(2, id);
            statement.executeUpdate();
            band = true;
        } catch(SQLException e) {
            band = false;
        }
        dbManager.closeConnection();
        return band;
        
    }         
    public ArrayList<Visit> getRegisteredVisits(String date){
        boolean band = false;
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "SELECT Visitante.nombreV as name, "
                    + "Visitante.correoV as email, "
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
                visit.setName(result.getString("name"));
                visit.setEmail(result.getString("email"));
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

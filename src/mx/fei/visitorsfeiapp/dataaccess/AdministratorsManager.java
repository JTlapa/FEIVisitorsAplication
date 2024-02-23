/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.dataaccess;

import mx.fei.visitorsfeiapp.logic.Administrator;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author chuch
 */
public class AdministratorsManager {
    private DatabaseManager dbManager;
    
    public AdministratorsManager() {
        dbManager = new DatabaseManager();
    }
    public boolean checkPassword(Administrator admin) {
        boolean band = false;
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "SELECT clave FROM administrador WHERE idAdmin = ? AND codigoF = 'FEI'";
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(admin.getId()));
            result = statement.executeQuery();
            while(result.next()) {
                String clave = result.getString("clave");
                if(clave.equals(admin.getClave())){
                    band = true;
                    break;
                }
            }
        } catch(SQLException e) {
            band = false;
        }
        dbManager.closeConnection();
        return band;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mx.fei.visitorsfeiapp.dataaccess.DatabaseManager;
/**
 *
 * @author chuch
 */
public class Administrator {
    private String id;
    private String clave;
    private DatabaseManager dbManager;
    
    public Administrator(){
        dbManager = new DatabaseManager();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public boolean validatePassword(){
        boolean band = false;
        PreparedStatement statement = null;
        Connection connection = null;
        ResultSet result = null;
        String query = "SELECT clave FROM administrador WHERE idAdmin = ? AND codigoF = 'FEI'";
        try{
            connection = dbManager.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(getId()));
            result = statement.executeQuery();
            while(result.next()) {
                String clave = result.getString("clave");
                if(clave.equals(getClave())){
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

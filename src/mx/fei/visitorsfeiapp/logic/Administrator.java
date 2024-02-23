/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

import mx.fei.visitorsfeiapp.dataaccess.AdministratorsManager;
/**
 *
 * @author chuch
 */
public class Administrator {
    private String id;
    private String clave;
    private AdministratorsManager administratorManager;
    
    public Administrator(){
        this.administratorManager = new AdministratorsManager();
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
        return administratorManager.checkPassword(this);
    }
}

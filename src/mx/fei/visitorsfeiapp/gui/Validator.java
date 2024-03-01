/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.gui;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import mx.fei.visitorsfeiapp.logic.Visitor;
import mx.fei.visitorsfeiapp.logic.Administrator;
import java.util.regex.Pattern;
/**
 *
 * @author chuch
 */
public class Validator {
    public boolean validateVisitorData(Visitor visitor) {
        if(visitor.getBelonging().equals("MemberUV")) {
            return validateMemberUVData(visitor);
        }
        return validateExternalData(visitor);
    }
    public boolean validateExternalData(Visitor visitor) { 
        if(visitor.getName().length() == 0) {
            return false;
        }
        if(visitor.getLastname().length() == 0) {
            return false;
        }
        if(!Pattern.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+", visitor.getEmail())) {
            return false;
        }
        if(!Pattern.matches("[0-9]+", visitor.getId())) {
            return false; 
        }
        return true;
    }
    public boolean validateMemberUVData(Visitor visitor){
        if(visitor.getName().length() == 0) {
            return false;
        }
        if(visitor.getLastname().length() == 0) {
            return false;
        }
        if(!Pattern.matches("[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+", visitor.getEmail())) {
            return false;
        }
        if(!Pattern.matches("[A-Z]{1}[0-9]{8}", visitor.getId())) {
            return false;
        }
        return true;
    }
    public boolean validateDate(String date) {
        LocalDate dateToSearch;
        try{
            dateToSearch = LocalDate.parse(date);
        } catch(DateTimeParseException e) {
            return false;
        }
        LocalDate currentDate = LocalDate.now();
        if(currentDate.compareTo(dateToSearch) < 0) {
            return false;
        }
        return true;
    }
    public boolean validateAdministratorData(Administrator admin){
        return Pattern.matches("[0-9]+", admin.getId());
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 *
 * @author chuch
 */
public class Validator {
    
    
    public boolean validateVisitorData(Visitor visitor) { 
        if((visitor.getName().length() == 0) || (visitor.getLastname().length() == 0)){
            return false;
        }
        String email = visitor.getEmail();
        for(int i=1; i < email.length()-2; i++) {
            if(email.charAt(i) == '@') {
                return true;
            }
        }
        return false;
    }
    public boolean validateIdMember(String id) {
        if((id.length() != 5) || Character.isDigit(id.charAt(0))){
            return false;
        }
        for(int i=1;i<id.length();i++) {
            if(!Character.isDigit(id.charAt(i))){
                return false;
            }
        }
        return true;
    }
    public boolean validateIdExternal(String id) {
        if((id.length() != 5) || !Character.isDigit(id.charAt(0))){
            return false;
        }
        for(int i=1;i<id.length();i++) {
            if(Character.isDigit(id.charAt(i))){
                return false;
            }
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
}

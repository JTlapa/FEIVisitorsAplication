/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

import java.util.ArrayList;
import mx.fei.visitorsfeiapp.dataaccess.VisitsManager;
import mx.fei.visitorsfeiapp.dataaccess.VisitorsManager;
/**
 *
 * @author chuch
 */
public class VisitsAdministrator {
    private Validator validator;
    private VisitsManager visitsManager;
    private VisitorsManager visitorsManager;
    
    public VisitsAdministrator() {
        this.validator = new Validator();
        this.visitsManager = new VisitsManager();
        this.visitorsManager = new VisitorsManager();
    }
    public boolean registerMemberVisit(Visitor visitor) {
        if(!validator.validateVisitorData(visitor)) {
            return false;
        }
        if(!validator.validateIdMember(visitor.getId())) {
            return false;
        }
        visitorsManager.addVisitor(visitor);
        if(visitsManager.insertAVisit(visitor)) {
            return true;
        }
        return false;
    }
    public boolean registerExternalVisit(Visitor visitor, String idType) {
        if(!validator.validateVisitorData(visitor)) {
            return false;
        }
        if(!validator.validateIdExternal(visitor.getId())){
            return false;
        }
                        
        visitorsManager.addVisitor(visitor);
        if(visitsManager.insertAVisit(visitor)) {
            return true;
        }
        return false;
    }
    public boolean checkOut(String id) {
        return this.visitsManager.registerDepartureTime(id);
    }
    public ArrayList<Visit> getVisitsByDay(String date){
        ArrayList<Visit> visits=null;
        if(validator.validateDate(date)) {
            visits = visitsManager.getRegisteredVisits(date);
        }
        return visits;
    }
}

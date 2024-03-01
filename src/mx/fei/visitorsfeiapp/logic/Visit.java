/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.visitorsfeiapp.logic;

/**
 *
 * @author chuch
 */
public class Visit {
    private String entryTime;
    private String departureTime;
    private String name;
    private String email;
    private String belonging;
    private String id;
    private String subject;

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBelonging() {
        return belonging;
    }

    public void setBelonging(String belonging) {
        this.belonging = belonging;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    @Override
    public boolean equals(Object object) {
        if((object == null) || (object.getClass() != this.getClass())) {
            return false;
        }
        Visit otherVisit = (Visit) object;
        if(!otherVisit.getId().equals(this.getId())) {
            return false;
        }
        if(!otherVisit.getName().equals(this.getName())) {
            return false;
        }
        return true;
    }
}

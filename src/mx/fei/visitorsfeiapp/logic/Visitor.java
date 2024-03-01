package mx.fei.visitorsfeiapp.logic;

public class Visitor {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String subject;
    private String visiting;
    private String belonging;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getVisiting() {
        return visiting;
    }
    public void setVisiting(String visiting) {
        this.visiting = visiting;
    }   
    public String getBelonging() {
        return belonging;
    }
    public void setBelonging(String belonging) {
        this.belonging = belonging;
    }   
}

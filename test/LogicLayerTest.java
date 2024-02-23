/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;
import mx.fei.visitorsfeiapp.logic.Administrator;
import mx.fei.visitorsfeiapp.logic.VisitsAdministrator;
import mx.fei.visitorsfeiapp.logic.Visitor;
/**
 *
 * @author chuch
 */
public class LogicLayerTest {
    
    public LogicLayerTest() {
    }
    
   @Test
    public void testValidatePasswordSuccess() {
        Administrator admin = new Administrator();
        admin.setId("1");
        admin.setClave("abcd");
        assertTrue(admin.validatePassword());
    }
    
    @Test
    public void testRegisterMemberVisitSuccess() {
        VisitsAdministrator visitsAdmin = new VisitsAdministrator();
        Visitor visitor = new Visitor();
        visitor.setId("S3659");
        visitor.setName("Jesus");
        visitor.setLastname("Tlapa");
        visitor.setEmail("je@o.c");
        visitor.setSubject("Clases");
        assertTrue(visitsAdmin.registerMemberVisit(visitor));
    }
    
    
    @Test
    public void testRegisterExternalVisitSuccess() {
        VisitsAdministrator visitsAdmin = new VisitsAdministrator();
        Visitor visitor = new Visitor();
        visitor.setId("1ABCD");
        visitor.setName("Jose");
        visitor.setLastname("Tlapa");
        visitor.setEmail("jo@t.l");
        visitor.setSubject("Comedor");
        visitor.setVisiting("Director");
        assertTrue(visitsAdmin.registerExternalVisit(visitor, "INE"));
    }
    
    @Test
    public void testCheckOutSuccess() {
        VisitsAdministrator visitsAdmin = new VisitsAdministrator();
        assertTrue(visitsAdmin.checkOut("S3659"));
    }
    
    @Test
    public void testGetVisitsByDaySuccess() {
        VisitsAdministrator visitsAdmin = new VisitsAdministrator();
        assertNotNull(visitsAdmin.getVisitsByDay("2024-02-23"));
    }
}

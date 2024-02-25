/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Assert;
import mx.fei.visitorsfeiapp.logic.Administrator;
import mx.fei.visitorsfeiapp.logic.VisitsManager;
import mx.fei.visitorsfeiapp.logic.Visitor;
import mx.fei.visitorsfeiapp.gui.Validator;
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
        VisitsManager visitsAdmin = new VisitsManager();
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
        VisitsManager visitsAdmin = new VisitsManager();
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
        VisitsManager visitsAdmin = new VisitsManager();
        assertTrue(visitsAdmin.checkOut("S3659"));
    }
    
    @Test
    public void testGetVisitsByDaySuccess() {
        VisitsManager visitsAdmin = new VisitsManager();
        assertNotNull(visitsAdmin.getVisitsByDay("2024-02-23"));
    }
    
    @Test
    public void testValidateVisitorDataFalse() {
        Visitor visitor = new Visitor();
        visitor.setName("Jesus");
        visitor.setLastname("tlapa");
        visitor.setSubject("clases");
        visitor.setId("S36a9");
        visitor.setBelonging("MemberUV");
        Validator validator = new Validator();
        assertFalse(validator.validateVisitorData(visitor));
    }
}

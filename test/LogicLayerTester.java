import mx.fei.visitorsfeiapp.logic.*;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chuch
 */
public class LogicLayerTester {
    
    @Test
    public void testRegisterAVisitorSuccess() {
        Visitor visitor = new Visitor();
        visitor.setBelonging("MemberUV");
        visitor.setId("S22013690");
        visitor.setName("Zaido");
        visitor.setLastname("ramirez");
        visitor.setEmail("zS22013693@estudiantes.uv");
        int expectedResult = 1;
        VisitsManager visits = new VisitsManager();
        int currentResult = visits.registerAVisitor(visitor);
        assertEquals(expectedResult, currentResult);
    }
    
    @Test
    public void testRegisterCheckInSuccess() {
        Visitor visitor = new Visitor();
        visitor.setId("S21015826");
        visitor.setSubject("Comedor");
        int expectedResult = 1;
        VisitsManager visits = new VisitsManager();
        int currentResult = visits.registerCheckIn(visitor);
        assertEquals(expectedResult, currentResult);
    }
    
    @Test
    public void testRegisterCheckOutSuccess() {
        int expectedResult = 1;
        VisitsManager visits = new VisitsManager();
        int currentResult = visits.registerCheckOut("S22013659");
        assertEquals(expectedResult, currentResult);
    }
    
    @Test

    public void testGetVisitsByDaySuccess() {
        ArrayList <Visit> expectedList = new ArrayList();
        Visit visit = new Visit();
        visit.setId("2345678");
        visit.setName("Will");
        expectedList.add(visit);
        visit = new Visit();
        visit.setId("4915");
        visit.setName("Mark");
        expectedList.add(visit);
        
        String date = "2024-01-01";
        VisitsManager visits = new VisitsManager();
        ArrayList <Visit> currentList = visits.getVisitsByDay(date);
                
        assertEquals(currentList, expectedList);
    }
}
    
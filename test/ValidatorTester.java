import mx.fei.visitorsfeiapp.gui.Validator;
import mx.fei.visitorsfeiapp.logic.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ValidatorTester {
    private static final Validator validator = new Validator();
    
    @Test
    public void testValidateMemberUVDataSuccess() {
        Visitor visitor = new Visitor();
        visitor.setBelonging("MemberUV");
        visitor.setId("S22013659");
        visitor.setName("Jesus");
        visitor.setLastname("Tlapa");
        visitor.setEmail("jesus@tlapa.com");
        assertTrue(validator.validateVisitorData(visitor));
    }
    
    @Test
    public void testValidateMemberUVDataFailed() {        
        Visitor visitor = new Visitor();
        visitor.setBelonging("MemberUV");
        visitor.setId("s22a3659");
        visitor.setName("Jesus");
        visitor.setLastname("Tlapa");
        visitor.setEmail("jesus@tlapa.com");
        assertFalse(validator.validateMemberUVData(visitor));
    }
    
    @Test
    public void testValidateExternalDataSuccess() {
        Visitor visitor = new Visitor();
        visitor.setBelonging("External");
        visitor.setId("12345");
        visitor.setName("Mario");
        visitor.setLastname("Ronaldo");
        visitor.setEmail("mario@ronaldo.com");
        assertTrue(validator.validateExternalData(visitor));
    }
    
    @Test
    public void testValidateExternalDataFailed() {        
        Visitor visitor = new Visitor();
        visitor.setBelonging("External");
        visitor.setId("abcd8");
        visitor.setName("Jesus");
        visitor.setLastname("Hernandez");
        visitor.setEmail("jesus@gmail.mx.com");
        assertFalse(validator.validateExternalData(visitor));
    }
    
    @Test
    public void testValidateDateSuccess() {
        String date = "2024-01-01";
        assertTrue(validator.validateDate(date));
    }
    
    @Test
    public void testValidateDateFailed() {
        String date = "2024/01/01";
        assertFalse(validator.validateDate(date));
    }
    
    @Test
    public void testValidateAdministratorDataSuccess() {
        Administrator admin = new Administrator();
        admin.setId("5");
        assertTrue(validator.validateAdministratorData(admin));
    }
    
    @Test
    public void testAdministratorDataFailed() {
        Administrator admin = new Administrator();
        admin.setId("1A");
        assertFalse(validator.validateAdministratorData(admin));
    }
}

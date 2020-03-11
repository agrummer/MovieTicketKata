package de.saxsys.dojo.ticketkata;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco Dierenfeldt
 */
public class CinemaCashRegisterTest {
    
    /**
     * Test of startPurchase method, of class CinemaCashRegister.
     */
    @Test
    public void testPurchaseNo3DParquetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchaseNo3DParquetWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true; // general seating
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 44.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DParquetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DParquetWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 56.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DLogeWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeWeekdayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 64.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DLogeMovieDayNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeMovieDayNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 56.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DLogeWeekendNoGroupMidageNoStudent() {
        System.out.println("testPurchase3DLogeWeekendNoGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.SAT;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 70.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageNoStudent() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageNoStudent");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 50.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageWithStudents() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageWithStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 44.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        isStudent = true;
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorNoStudents() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorNoStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 45.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorAsStudents() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorAsStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 45.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        isStudent = true;
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenNoStudents() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenNoStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 44.5F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenAsStudents() {
        System.out.println("testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenAsStudents");
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 44.5F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        isStudent = true;
        instance.addTicket(age, isStudent);
        
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchaseNo3DParquetWeekdayGroupMidageNoStudent() {
        System.out.println("testPurchaseNo3DParquetWeekdayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 138.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DParquetWeekdayGroupMidageNoStudent() {
        System.out.println("testPurchase3DParquetWeekdayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 207.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchase3DParquetMovieDayGroupMidageNoStudent() {
        System.out.println("testPurchase3DParquetMovieDayGroupMidageNoStudent");
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 207.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchasebigEnoughSchoolclassWithTwoTeachers() {
        System.out.println("testPurchasebigEnoughSchoolclassWithTwoTeachers");
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 12;
        boolean isStudent = false;
        
        float expResult = 144.0F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 24; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        instance.addTicket(age, isStudent);
        age = 27;
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testPurchaseTooSmallSchoolclassWithTwoTeachers() {
        System.out.println("testPurchaseTooSmallSchoolclassWithTwoTeachers");
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        boolean is3D = false;
        int age = 12;
        boolean isStudent = false;
        
        float expResult = 111.00F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 18; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        instance.addTicket(age, isStudent);
        age = 27;
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testPurchaseMix() {
        System.out.println("testPurchaseMix");
        int runtime = 125;
        Day day = Day.THU;
        boolean isParquet = false;
        boolean is3D = true;
        int age = 12;
        boolean isStudent = false;
        
        float expResult = 297.50F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        for (int i = 0; i < 7; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 75;
        for (int i = 0; i < 4; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 27;
        isStudent = true;
        for (int i = 0; i < 8; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult, result, 0.0);
    }
    
    /*
     * Tests the re-initialisation in the startPurchase method
     */
    @Test
    public void testMultipleTransactionsWitheSameCinemaCashRegister(){
        System.out.println("testMultipleTransactionsWitheSameCinemaCashRegister");
        int runtime = 90;
        Day day = Day.MON;
        boolean isParquet = true;
        boolean is3D = true;
        int age = 35;
        boolean isStudent = false;
        
        float expResult = 70.00F;
        
        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(expResult,result,0.0f);
        
        instance.startPurchase(runtime, day, isParquet, is3D);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        result = instance.finishPurchase();
        assertEquals(expResult,result,0.0f);
    }
}

package de.saxsys.dojo.ticketkata;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Marco Dierenfeldt
 */
public class CinemaCashRegisterTest {

    @Test
    public void testSingleTicketPurchase() {
        int runtime = 60;
        Day day = Day.MON;
        boolean isParquet = true;
        String title = "The Last Emperor";
        int age = 30;
        boolean isStudent = false;

        float expResult = 11.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseNo3DParquetWeekdayNoGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Rain Man";
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParquetWeekdayNoGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Driving Miss Daisy in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 56.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeWeekdayNoGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = false;
        String title = "Dances with Wolves in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 64.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeMovieDayNoGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = false;
        String title = "The Silence of the Lambs in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 56.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeWeekendNoGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.SAT;
        boolean isParquet = false;
        String title = "Unforgiven in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 70.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DLogeWeekendNoGroupMidageWithStudent() {
        int runtime = 90;
        Day day = Day.SUN;
        boolean isParquet = false;
        String title = "The Fugitive in 3D";
        int age = 23;
        boolean isStudent = false;

        float expResult = 84.5F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        isStudent = true;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageNoStudent() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Forrest Gump";
        int age = 35;
        boolean isStudent = false;

        float expResult = 50.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }


    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupMidageWithStudents() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Braveheart";
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        isStudent = true;
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }


    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorNoStudents() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "The English Patient";
        int age = 35;
        boolean isStudent = false;

        float expResult = 45.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupSeniorAsStudents() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Titanic";
        int age = 35;
        boolean isStudent = false;

        float expResult = 45.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 68;
        isStudent = true;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenNoStudents() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Shakespeare in Love";
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.5F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }


    @Test
    public void testPurchaseOverlengthNo3DParquetWeekdayNoGroupChildrenAsStudents() {
        int runtime = 145;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "American Beauty";
        int age = 35;
        boolean isStudent = false;

        float expResult = 44.5F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        instance.addTicket(age, isStudent);
        age = 10;
        isStudent = true;
        instance.addTicket(age, isStudent);

        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseNo3DParquetWeekdayGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "Gladiator";
        int age = 35;
        boolean isStudent = false;

        float expResult = 138.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParquetWeekdayGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.TUE;
        boolean isParquet = true;
        String title = "A Beautiful Mind in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 207.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchase3DParquetMovieDayGroupMidageNoStudent() {
        int runtime = 72;
        Day day = Day.THU;
        boolean isParquet = true;
        String title = "Chicago in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 207.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 23; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchasebigEnoughSchoolclassWithTwoTeachers() {
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        String title = "The Lord of the Rings: The Return of the King";
        int age = 12;
        boolean isStudent = false;

        float expResult = 144.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 24; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        instance.addTicket(age, isStudent);
        age = 27;
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }


    @Test
    public void testPurchaseTooSmallSchoolclassWithTwoTeachers() {
        int runtime = 72;
        Day day = Day.WED;
        boolean isParquet = true;
        String title = "Million Dollar Baby";
        int age = 12;
        boolean isStudent = false;

        float expResult = 111.00F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 18; i++) {
            instance.addTicket(age, isStudent);
        }
        age = 45;
        instance.addTicket(age, isStudent);
        age = 27;
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPurchaseMix() {
        int runtime = 125;
        Day day = Day.THU;
        boolean isParquet = false;
        String title = "Crash in 3D";
        int age = 12;
        boolean isStudent = false;

        float expResult = 297.50F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
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
        assertEquals(title, expResult, result, 0.0);
    }

    /*
     * Tests the re-initialisation in the startPurchase method
     */
    @Test
    public void testMultipleTransactionsWitheSameCinemaCashRegister() {
        int runtime = 90;
        Day day = Day.MON;
        boolean isParquet = true;
        String title = "The Departed in 3D";
        int age = 35;
        boolean isStudent = false;

        float expResult = 70.00F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0f);

        instance.startPurchase(title, runtime, day, isParquet);
        for (int i = 0; i < 5; i++) {
            instance.addTicket(age, isStudent);
        }
        result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0f);
    }

    @Test
    public void testNon3DMovieWith3DInTitle() {
        int runtime = 60;
        Day day = Day.MON;
        boolean isParquet = true;
        String title = "No Country in 3D for Old Men";
        int age = 30;
        boolean isStudent = false;

        float expResult = 11.0F;

        CinemaCashRegister instance = new CinemaCashRegister();
        instance.startPurchase(title, runtime, day, isParquet);
        instance.addTicket(age, isStudent);
        float result = instance.finishPurchase();
        assertEquals(title, expResult, result, 0.0);
    }

    @Test
    public void testPrintAllPurchases() {
        CinemaCashRegister instance = new CinemaCashRegister();

        instance.startPurchase("Slumdog Millionaire", 90, Day.WED, false);
        instance.addTicket(22, false);
        instance.addTicket(19, true);
        instance.finishPurchase();

        instance.startPurchase("The Hurt Locker", 120, Day.THU, true);
        instance.addTicket(36, false);
        for (int i = 0; i < 22; i++) {
            instance.addTicket(14, true);
        }
        instance.finishPurchase();

        instance.startPurchase("The King's Speech", 160, Day.FRI, false);
        instance.addTicket(46, false);
        instance.finishPurchase();

        instance.startPurchase("The Artist", 75, Day.SAT, false);
        instance.addTicket(34, false);
        instance.addTicket(30, false);
        instance.finishPurchase();

        instance.startPurchase("Argo", 85, Day.SAT, false);
        instance.addTicket(22, false);
        instance.addTicket(19, true);
        instance.addTicket(19, true);
        instance.addTicket(21, true);
        instance.finishPurchase();

        instance.writeAllPurchasesToCSV();

        // Visually inspect the CSV written to disk
    }
}

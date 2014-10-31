/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.Salaried;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class SalariedTest extends TestCase {
    
    public SalariedTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SalariedTest.class);
        return suite;
    }

    /**
     * Test of setOvertime method, of class Salaried.
     */
    public void testSetOvertime() {
        System.out.println("setOvertime");
        int newOvertime = 0;
        Salaried instance = jackline;
        instance.setOvertime(newOvertime);
    }

    /**
     * Test of setOvertimeRate method, of class Salaried.
     */
    public void testSetOvertimeRate() {
        System.out.println("setOvertimeRate");
        int newRate = 0;
        Salaried instance = jackline;
        instance.setOvertimeRate(newRate);
    }

    /**
     * Test of getSalary method, of class Salaried.
     */
    public void testGetSalary() {
        System.out.println("getSalary");
        Salaried instance = jackline;
        int expResult = 21000;
        int result = instance.getSalary();
        assertEquals(expResult, result);
    }
    /**
     * Test of toString method, of class Salaried.
     */
    public void testToString() {
        System.out.println("toString");
        Salaried instance = jackline;
        String expResult = "Name: jackline  Employee Status: Salaried  Overtime Hours: 5  Overtime Rate: $200  Total Salary: $21000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    Salaried jackline = new Salaried("jackline", 20000, 5, 200);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.Hourly;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class HourlyTest extends TestCase {
    
    public HourlyTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(HourlyTest.class);
        return suite;
    }

    /**
     * Test of setHours method, of class Hourly.
     */
    public void testSetHours() {
        System.out.println("setHours");
        int newHours = 0;
        Hourly instance = jackob;
        instance.setHours(newHours);
    }

    /**
     * Test of setHourlyRate method, of class Hourly.
     */
    public void testSetHourlyRate() {
        System.out.println("setHourlyRate");
        int newRate = 1;
        Hourly instance = jackob;
        instance.setHourlyRate(newRate);
    }
    /**
     * Test of getSalary method, of class Hourly.
     */
    public void testGetSalary() {
        System.out.println("getSalary");
        Hourly instance = jackob;
        int expResult = 500;
        int result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Hourly.
     */
    public void testToString() {
        System.out.println("toString");
        Hourly instance = jackob;
        String expResult = "Name: jackob  Employee Status: Hourly  Hourly Rate: $10  Hours: 50  Total Salary: $500";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    Hourly jackob = new Hourly("jackob", 10, 50);
}

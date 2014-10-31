/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.Manager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class ManagerTest extends TestCase {
    
    public ManagerTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(ManagerTest.class);
        return suite;
    }

    /**
     * Test of setBonus method, of class Manager.
     */
    public void testSetBonus() {
        System.out.println("setBonus");
        int newBonus = 0;
        Manager instance = jacky;
        instance.setBonus(newBonus);
    }

    /**
     * Test of getSalary method, of class Manager.
     */
    public void testGetSalary() {
        System.out.println("getSalary");
        Manager instance = jacky;
        int expResult = 30000;
        int result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Manager.
     */
    public void testToString() {
        System.out.println("toString");
        Manager instance = jacky;
        String expResult = "Name: jacky  Employee Status: Manager  Bonus: $10000  Total Salary: $30000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
     Manager jacky = new Manager ("jacky", 20000, 10000);
}

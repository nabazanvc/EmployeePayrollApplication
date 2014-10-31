/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.empList;
import java.util.ArrayList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class empListTest extends TestCase {
    
    public empListTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(empListTest.class);
        return suite;
    }

    /**
     * Test of addManager method, of class empList.
     */
    public void testAddManager() {
        System.out.println("addManager");
        String empName = "john";
        int empSalary = 0;
        int bonus = 0;
        empList instance = new empList();
        instance.addManager(empName, empSalary, bonus);
    }

    /**
     * Test of addSalaried method, of class empList.
     */
    public void testAddSalaried() {
        System.out.println("addSalaried");
        String empName = "john";
        int salary = 0;
        int overtimeHours = 0;
        int overtimeRate = 0;
        empList instance = new empList();
        instance.addSalaried(empName, salary, overtimeHours, overtimeRate);
    }

    /**
     * Test of addHourly method, of class empList.
     */
    public void testAddHourly() {
        System.out.println("addHourly");
        String empName = "john";
        int hourlyRate = 0;
        int rate = 0;
        empList instance = new empList();
        instance.addHourly(empName, hourlyRate, rate);
    }

    /**
     * Test of getList method, of class empList.
     */
    public void testGetList() {
        System.out.println("getList");
        empList instance = new empList();
        ArrayList expResult = new ArrayList();
        ArrayList result = instance.getList();
        assertEquals(expResult, result);
    }

    /**
     * Test of changeAllOvertime method, of class empList.
     */
    public void testChangeAllOvertime() {
        System.out.println("changeAllOvertime");
        int newOverTime = 0;
        empList instance = new empList();
        instance.changeAllOvertime(newOverTime);
    }
    /**
     * Test of changeAllHourlyRate method, of class empList.
     */
    public void testChangeAllHourlyRate() {
        System.out.println("changeAllHourlyRate");
        int newRate = 0;
        empList instance = new empList();
        instance.changeAllHourlyRate(newRate);
    }

    /**
     * Test of toString method, of class empList.
     */
    public void testToString() {
        System.out.println("toString");
        empList instance = new empList();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    empList emp = new empList();
}

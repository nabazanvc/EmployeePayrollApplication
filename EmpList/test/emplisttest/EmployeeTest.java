/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.Employee;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class EmployeeTest extends TestCase {
    public EmployeeTest(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(EmployeeTest.class);
        return suite;
    }

    /**
     * Test of setSalary method, of class Employee.
     */
    public void testSetSalary() {
        System.out.println("setSalary");
        int newSalary = 5;
        Employee instance = jack;
        instance.setSalary(newSalary);
    }

    /**
     * Test of getName method, of class Employee.
     */
    public void testGetName() {
        System.out.println("getName");
        Employee instance = jack;
        String expResult = "jack";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSalary method, of class Employee.
     */
    public void testGetSalary() {
        System.out.println("getSalary");
        Employee instance = jack;
        int expResult = 20000;
        int result = instance.getSalary();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Employee.
     */
    public void testToString() {
        System.out.println("toString");
        Employee instance = jack;
        String expResult = "Name: jack Salary: $20000";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
     Employee jack = new Employee("jack", 20000);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import emplist.EmployeeProject;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class EmployeeProjectTest extends TestCase {
    
    public EmployeeProjectTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(EmployeeProjectTest.class);
        return suite;
    }

    /**
     * Test of main method, of class EmployeeProject.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EmployeeProject.main(args);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emplisttest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Nathan
 */
public class EmplistSuite extends TestCase {
    
    public EmplistSuite(String testName) {
        super(testName);
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("EmplistSuite");
        suite.addTest(EmployeeTest.suite());
        suite.addTest(HourlyTest.suite());
        suite.addTest(ManagerTest.suite());
        suite.addTest(EmployeeProjectTest.suite());
        suite.addTest(SalariedTest.suite());
        suite.addTest(empListTest.suite());
        return suite;
    }
}

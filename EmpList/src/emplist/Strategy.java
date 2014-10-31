package emplist;

import java.util.ArrayList;

/**
 * @author Nathan Bazan
 */
public interface Strategy {
    ArrayList<Employee> execute(ArrayList<Employee> empList);
}

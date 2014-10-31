package emplist;

import java.io.Serializable;

/**
 * @author Nathan Bazan
 */
public class Employee implements Serializable{

    public Employee(String empName, int empSalary){
        name=empName;
        salary=empSalary;
    }
    
    public void setSalary(int newSalary){
        salary=newSalary;
    }
    
    public String getName(){
        return name;
    }
    
    public int getSalary(){
        return salary;
    }
    
    /*Employee.toString() overrides the Object.toString() method in order to 
     * return a string that is more visually appealing and useful for my 
     * program.
    */
    @Override
    public String toString(){
        String str = "Name: " + getName() + " Salary: $" + getSalary();
        return str;
    }

    private String name;
    private int salary;
}

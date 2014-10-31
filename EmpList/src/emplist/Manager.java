package emplist;

/**
 * @author Nathan Bazan
 */
public class Manager extends Employee {
    //constructor that calls constructor method of Employee using the super() method
    public Manager(String empName, int empSalary, int bonus){
        super(empName, empSalary);
        this.bonus=bonus;
    }
    
    public void setBonus(int newBonus){
        bonus= newBonus;
    }
    
    /*overrides Employee.getSalary with a method that sets the salary to be
     *Employee.getSalary + bonus and returns the salary.
    */
    @Override
    public int getSalary(){
        int sal = super.getSalary() + bonus;
        return sal;
    }
    
    /*Manager.toString() overrides the Employee.toString() method in order to 
     * return a string that is more visually appealing and useful for my 
     * program.
    */
    @Override
    public String toString(){
        String str = "Name: " + super.getName() + "  Employee Status: Manager  Bonus: $" + bonus + "  Total Annual Pay: $" + getSalary();
        return str;
    }
    private int bonus;
}

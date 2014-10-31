package emplist;

/**
 * @author Nathan Bazan
 */
public class Salaried extends Employee{
    //constructor that calls constructor method of Employee using the super() method
    public Salaried(String empName, int empSalary, int overtimeHours, int overtimeRate){
        super(empName, empSalary);
        this.overtimeHours=overtimeHours;
        this.overtimeRate=overtimeRate;
    }
    
    public void setOvertime(int newOvertime){
        overtimeHours= newOvertime;
    }
    
    public void setOvertimeRate(int newRate){
        overtimeRate=newRate;
    }
    
    /*overrides Employee.getSalary with a method that sets the salary to be
     *Employee.getSalary + hours of overtime worked times the rate, then returns 
     *the salary.
    */
    @Override
    public int getSalary(){
        int sal = super.getSalary() + (overtimeHours * overtimeRate);
        return sal;
    }
    
    /*Salaried.toString() overrides the Employee.toString() method in order to 
     * return a string that is more visually appealing and useful for my 
     * program.
    */
    @Override
    public String toString(){
        String str = "Name: " + super.getName() + "  Employee Status: Salaried  Overtime Hours: " +overtimeHours+ "  Overtime Rate: $"+overtimeRate+"  Total Annual Pay: $" + getSalary();
        return str;
    }
    
    private int overtimeHours;
    private int overtimeRate;
}

package emplist;

/*
 * @author Nathan Bazan
 */
public class Hourly extends Employee {
    //constructor that calls constructor method of Employee using the super() method
    public Hourly(String empName, int hourlyRate, int hours){
        super(empName, hourlyRate * hours);
        this.hourlyRate=hourlyRate;
        this.hours=hours;       
    }
    
    public void setHours(int newHours){
        hours=newHours;
    }
    
    public void setHourlyRate(int newRate){
        hourlyRate=newRate;
    }
    
    /*overrides Employee.getSalary with a method that sets the salary to be
     * hourly rate times hours and returns the salary.
    */
    @Override
    public int getSalary(){
        int sal = hourlyRate * hours;
        return sal;
    }
    
    /*Hourly.toString() overrides the Employee.toString() method in order to 
     * return a string that is more visually appealing and useful for my 
     * program.
    */
    @Override
    public String toString(){
        String str = "Name: " + super.getName() + "  Employee Status: Hourly  Hourly Rate: $"+hourlyRate+ "  Hours: "+ hours+ "  Total Annual Pay: $" + getSalary();
        return str;
    }
    
    private int hourlyRate;
    private int hours;
}

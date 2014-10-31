package emplist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class empList {
    public empList(){
        empList= new ArrayList<>();
    }
    
    public empList(ArrayList<Employee> emp){
        empList= emp;
    }
    public void setList (ArrayList<Employee> inputList){
        empList=inputList;
    }
    
    public void addManager(String empName, int empSalary, int bonus){
        Manager manager = new Manager(empName, empSalary, bonus);
        empList.add(manager);
    }
    
    public void addSalaried(String empName, int salary, int overtimeHours, int overtimeRate){
        Salaried salaried = new Salaried(empName, salary, overtimeHours, overtimeRate);
        empList.add(salaried);
    }
    
    public void addHourly(String empName, int hourlyRate, int rate){
        Hourly hourly = new Hourly(empName, hourlyRate, rate);
        empList.add(hourly);
    }
    
    public int getSize(){
        return empList.size();
    }
    
    public ArrayList<Employee> getList(){
        return empList;
    }
   
    /*
     * for every employee in empList, if it is an instance of Salaried class,
     * set the overtimeRate for that entry to newOverTime.
     */
    public void changeAllOvertime(int newOverTime){
        for (Employee e:empList){
            if (e instanceof Salaried){
                ((Salaried) e).setOvertimeRate(newOverTime);
            }
        }
    }
    
    /*
     * for every employee in empList, if it is an instance of Hourly class,
     * set the hourlyRate for that entry to newOverTime.
     */
    public void changeAllHourlyRate(int newRate){
        for (Employee e: empList){
            if (e instanceof Hourly){
                ((Hourly)e).setHourlyRate(newRate);
            }
        }
    }
    
    public ArrayList<Employee> execute(Strategy strategy){
        return strategy.execute(empList);
    }
    
    public void toFile(){
        try
        {
         FileOutputStream empFileOutput= new FileOutputStream("EmpData1");
         ObjectOutputStream empObjectOutput= new ObjectOutputStream(empFileOutput);
         empObjectOutput.writeObject(empList);
         empObjectOutput.close();
         empFileOutput.close();
        }
         catch(IOException ioe){
             ioe.printStackTrace();
             return;
        }
    }
    
    public void fromFile(){
        ArrayList<Employee> newArrayList= new ArrayList<>();
        try
        {
            FileInputStream empFileInput = new FileInputStream("EmpData1");
            ObjectInputStream empObjectInput = new ObjectInputStream(empFileInput);
            newArrayList = (ArrayList<Employee>) empObjectInput.readObject();
            empObjectInput.close();
            empFileInput.close();
        }
        catch(IOException ioe){
             ioe.printStackTrace();
             return;
        }
        catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
        }
        empList = newArrayList;
    }
    
    /*empList.toString() overrides the ArrayList.toString() method in order to 
     * return a string that is more visually appealing and useful for my 
     * program.
    */
    @Override
    public String toString(){
        String listString = new String();
        for (Employee e: empList){
            listString+= e+ "/t";
        }
        return listString;
    }
    
    private ArrayList<Employee> empList;
    
}

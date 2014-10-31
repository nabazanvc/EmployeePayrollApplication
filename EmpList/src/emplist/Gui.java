package emplist;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Nathan Bazan
 */
public class Gui{
    /*Constructor for a Gui that builds a frame, adds panels and buttons,
     * then displays the frame to the user.
    */
     public Gui(){
        GridLayout buttonsLayout = new GridLayout(0,2);
        empList= new empList();
        empList.fromFile();
        
        JFrame guiFrame = new JFrame();        
        final JPanel buttonsFrame = new JPanel();
        buttonsFrame.setLayout(buttonsLayout);
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Employee Management System 2.0");
        guiFrame.setSize(1000,500);
        guiFrame.setLocationRelativeTo(null);
        
        textArea = new JTextArea(5, empList.getSize());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setText("Welcome to the Employee Payroll System!\n");
        textArea.append("Your employees have been loaded from the file!\n");
        textArea.append("Be sure to use the correct notation to add new Employees!");
        
        final JScrollPane scrollPane = new JScrollPane(textArea,  
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,  
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
        
        addManager = new JTextField(10);
        addManager.setActionCommand(managerAdder);
        JLabel managerLabel = new JLabel(managerAdder, SwingConstants.LEFT);
        addManager.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that parses input
             * into the JTextField and adds it to a String array. Checks if salary
             * and bonus are integers. If they are, then invokes
             * the addManager method to add an entry to the ArrayList<Employee> emplist
             * and displays a message to the user confirming the action. If they
             * aren't the user is alerted. Then resets the JTextField to empty.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String[] text = (addManager.getText().split(","));
                if (isInt(text[1]) == false  || isInt(text[2]) == false){
                    textArea.setText("Salary and Bonus must be integers");
                }
                else{
                    empList.addManager(text[0],Integer.parseInt(text[1]),Integer.parseInt(text[2]));
                    textArea.setText("Manager Added!");
                }
                addManager.setText("");
            }
        });
        
        addSalaried = new JTextField(10);
        addSalaried.setActionCommand(salariedAdder);
        JLabel salaryLabel = new JLabel(salariedAdder, SwingConstants.LEFT);
        addSalaried.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that parses input
             * into the JTextField and adds it to a String array. Checks if salary,
             * overtime hours and rate are integers. If they are, then invokes
             * the addSalaried method to add an entry to the ArrayList<Employee> emplist
             * and displays a message to the user confirming the action. If they
             * aren't the user is alerted. Then resets the JTextField to empty.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String[] text = (addSalaried.getText().split(","));
                if (isInt(text[1]) == false  || isInt(text[2]) == false || isInt(text[3]) == false){
                    textArea.setText("Salary, overtime hours, and rate must be integers");
                }
                else{
                    empList.addSalaried(text[0],Integer.parseInt(text[1]),Integer.parseInt(text[2]), Integer.parseInt(text[3]));
                    textArea.setText("Salaried Employee Added!");
                }
                addSalaried.setText("");
            }
        });
        
        addHourly = new JTextField(10);
        addHourly.setActionCommand(managerAdder);
        JLabel hourlyLabel = new JLabel(hourlyAdder, SwingConstants.LEFT);
        addHourly.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that parses input
             * into the JTextField and adds it to a String array. Checks if hourly
             * rate and hours are integers. If they are, then invokes the addHourly
             * method to add an entry to the ArrayList<Employee> emplist and 
             * displays a message to the user confirming the action. If they
             * aren't the user is alerted. Then resets the JTextField to empty.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                String[] text = (addHourly.getText().split(","));
                if (isInt(text[1]) == false  || isInt(text[2]) == false){
                    textArea.setText("Salary, overtime hours, and rate must be integers");
                }
                else{
                    empList.addHourly(text[0],Integer.parseInt(text[1]),Integer.parseInt(text[2]));
                    textArea.setText("Hourly Employee Added!");
                }
                addHourly.setText("");
            }
        });
        
        changeOvertime = new JTextField(10);
        changeOvertime.setActionCommand(overtimeChanger);
        JLabel overtimeLabel = new JLabel(overtimeChanger, SwingConstants.LEFT);
        changeOvertime.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that parses input
             * into the JTextField. Checks if input represents an int. If true,
             * sets textInt to that result , then invokes the changeAllOvertime 
             * method to change the salary of every Overtime object in 
             * ArrayList<Employee> emplist and displays a message to the user 
             * confirming the action.If not, the user is alerted. Then resets the JTextField to empty.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (isInt(changeOvertime.getText()) == false){
                    textArea.setText("Overtime Rate must be an integer");
                }
                else{
                    int textInt = Integer.parseInt(changeOvertime.getText());
                    empList.changeAllOvertime(textInt);
                    textArea.setText("All Overtime Rates Changed to:" + "$"+ textInt);
                }
                changeOvertime.setText("");
            }
        });
        
        changeHourly = new JTextField(10);
        changeHourly.setActionCommand(hourlyChanger);
        JLabel hourlyRateLabel = new JLabel(hourlyChanger, SwingConstants.LEFT);
        changeHourly.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that parses input
             * into the JTextField. Checks if input represents an int. If true,
             * sets textInt to that result , then invokes the changeHourly
             * method to change the salary of every Hourly object in 
             * ArrayList<Employee> emplist and displays a message to the user 
             * confirming the action.If not, the user is alerted. Then resets the JTextField to empty.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (isInt(changeHourly.getText()) == false){
                    textArea.setText("Hourly Rate must be an integer");
                }
                else{
                    int textInt = Integer.parseInt(changeHourly.getText());
                    empList.changeAllHourlyRate(textInt);
                    textArea.setText("All Hourly Rates Changed to:" + "$"+ textInt);
                }
                changeHourly.setText("");
            }
        });
        
        JButton displayAll = new JButton( "Display All Employees");
        displayAll.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result of calling 
             * empList.getList. The textArea is reset to empty, then each member
             * of all is iterated through and appended to the textArea.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> all = empList.getList();
                textArea.setText("");
                for (Employee e: all){
                    textArea.append(e.toString()+ "\n");
                }
            }
        });
        
        JButton displayManagers = new JButton( "Display Managers");
        displayManagers.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result of calling 
             * empList.getList. The textArea is reset to empty, then each member
             * of managers is iterated through and checked to see if it is an instance 
             * of the Manager class and appended to the textArea if it is.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> managers = empList.getList();
                textArea.setText("");
                for (Employee e: managers){
                    if (e instanceof Manager){
                        textArea.append(e.toString()+ "\n");
                    }
                }
            }
        });
        
        JButton displaySalaried = new JButton( "Display Salaried");
        displaySalaried.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result of calling 
             * empList.getList. The textArea is reset to empty, then each member
             * of salaried is iterated through and checked to see if it is an instance 
             * of the Salaried class and appended to the textArea if it is.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> salaried = empList.getList();
                textArea.setText("");
                for (Employee e: salaried){
                    if (e instanceof Salaried){
                        textArea.append(e.toString()+ "\n");
                    }
                }
            }
        });
        
        JButton displayHourly = new JButton( "Display Hourly");
        displayHourly.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result of calling 
             * empList.getList. The textArea is reset to empty, then each member
             * of hourly is iterated through and checked to see if it is an instance 
             * of the Hourly class and appended to the textArea if it is.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> hourly = empList.getList();
                textArea.setText("");
                for (Employee e: hourly){
                    if (e instanceof Hourly){
                        textArea.append(e.toString()+ "\n");
                    }
                }
            }
        });
        
        JButton displayNameSorted = new JButton( "Sort by Name and Display");
        displayNameSorted.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result sorting empList by 
             * name as a result of calling empList.execute with a new ThreadedMergeSortByName. 
             * The textArea is reset to empty, then each member of toSort is 
             * iterated through and appended to the textArea.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> toSort = empList.execute(new ThreadedMergeSortByName());
                textArea.setText("");
                for (Employee e: toSort){
                    textArea.append(e.toString()+ "\n");
                }
            }
        });
        
        JButton displaySalarySorted = new JButton( "Sort by Salary and Display");
        displaySalarySorted.addActionListener(new ActionListener()
        {
            /*overrides actionPerformed method with a method that creates a new
             * ArrayList<Employee> and sets it to the result sorting empList by 
             * salary as a result of calling empList.execute with a new ThreadedMergeSort. 
             * The textArea is reset to empty, then each member of toSort is 
             * iterated through and appended to the textArea.
            */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ArrayList<Employee> toSort = empList.execute(new ThreadedMergeSort());
                textArea.setText("");
                for (Employee e: toSort){
                    textArea.append(e.toString()+ "\n");
                }
            }
        });
        
        JButton toFile = new JButton( "Save Employee List to File");
        toFile.addActionListener(new ActionListener()
        {   
            @Override
            public void actionPerformed(ActionEvent event)
            {
                empList.toFile();
                textArea.setText("Employee List Saved!");
            }
        });
        
        JButton fromFile = new JButton( "Load Employee List From File");
        fromFile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                empList.fromFile();
                textArea.setText("Employee List Loaded!");
            }
        });
        
        buttonsFrame.add(managerLabel);
        buttonsFrame.add(addManager);
        buttonsFrame.add(salaryLabel);
        buttonsFrame.add(addSalaried);
        buttonsFrame.add(hourlyLabel);
        buttonsFrame.add(addHourly);
        buttonsFrame.add(overtimeLabel);
        buttonsFrame.add(changeOvertime);
        buttonsFrame.add(hourlyRateLabel);
        buttonsFrame.add(changeHourly);
        buttonsFrame.add(displayManagers);
        buttonsFrame.add(displaySalaried);
        buttonsFrame.add(displayHourly);
        buttonsFrame.add(displayAll);
        buttonsFrame.add(displaySalarySorted);
        buttonsFrame.add(displayNameSorted);
        buttonsFrame.add(toFile);
        buttonsFrame.add(fromFile);
        guiFrame.add(scrollPane, BorderLayout.CENTER);
        guiFrame.add(buttonsFrame, BorderLayout.SOUTH);
        guiFrame.setVisible(true);
        
        
    }
     /*Checks if the string is an int by iterating through every character and
      * checking if that character is a digit. If so, it returns true after the
      * last character is checked. If not, false is returned.
      */
    private boolean isInt(String str){
        for (int i=0; i<str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
            }
            else{
                return false;
            }
        }
        return true;
     }
        private JTextArea textArea;
        private empList empList;
        protected static final String overtimeChanger = "Replace Overtime Rate for all Salaried Employees with:";
        protected static final String hourlyChanger = "Replace Hourly Rate for all Hourly Employees with:";
        protected static final String managerAdder = "Add Manager:Enter in 'Name,Salary,Bonus' format:";
        protected static final String salariedAdder = "Add Salaried Employee:Enter in 'Name,Salary,Overtime Hours,Overtime Rate' format:";
        protected static final String hourlyAdder = "Add Hourly Employee:Enter in 'Name,Hourly Rate,Hours' format:";
        JTextField changeOvertime;
        JTextField changeHourly;
        JTextField addManager;
        JTextField addSalaried;
        JTextField addHourly;
}
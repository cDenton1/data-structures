import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

   public static void main(String[] args) {
    
    JOptionPane.showMessageDialog(null, "Employee Data Searching and Searching Program! \n Press OK to start");

    // Enter the full fill path for the files
    Scanner scanner = null;
    while (scanner == null) {
            String filePath = JOptionPane.showInputDialog(null, "Enter the full path of employee data file");

    // Declaring the that we have found a file
    File file = new File(filePath);

    // Ensuring the path is legitimate, if not it'll shoot a message saying it didn't work and for us to try again.
    try {
        scanner = new Scanner(file);
        JOptionPane.showMessageDialog(null, "Read employee data from file " + filePath);
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Couldn't find path, try again please");

    }
    
    // Extremely unhappy with this atm, will fix this later.
    Employee[] employees = new Employee[1000];
    int employeeCount = 0;
    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split(">");

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        double hours = Double.parseDouble(parts[2]);

        //employees[count] = e;
        //count++;

    }
    JOptionPane.showInputDialog(null, "Enter the name of the employee to search");
    }

}
}

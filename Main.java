import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {

		Employee[] employees = new Employee[1000];
		int index = 0;
		
		String filePath = JOptionPane.showInputDialog("Enter the full path of employee data file: ");
		
		// Scanner object to read the file.
		try (Scanner fileScanner = new Scanner(new File(filePath))) {
		
			System.out.println("Reading employee data from " + filePath);
			
			while (fileScanner.hasNextLine() && index < employees.length) {
				String line = fileScanner.nextLine();
				String[] data = line.split(",");
				
				int ID = Integer.parseInt(data[0]);
				String name = data[1];
				double hoursWorked = Double.parseDouble(data[2]);
				double hourlyRate = Double.parseDouble(data[3]);
				double deductionProvince = Double.parseDouble(data[4]);
				double deductionFederal = Double.parseDouble(data[5]);
				double educationAllowance = Double.parseDouble(data[6]);
				
				employees[index++] = new Employee(
					ID, name, hoursWorked, hourlyRate,
					deductionProvince, deductionFederal, educationAllowance
				);
			}
		
		} catch (Exception e) {
			System.out.println("File not found, please try again"); // Prints an error message if the file is not found.
			return; // Exit the program if the file is not found.
		}
		
		System.out.println("Loaded " + index + " employees"); // Prints the number of employees loaded into the array.

		// call selection sort
		long sStart = System.currentTimeMillis();
		SelectionSort.selectionSort(employees, new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return Double.compare(e1.calcHourlySalary(), e2.calcHourlySalary());
			}
		});
		long sEnd = System.currentTimeMillis();

		System.out.println("\nThe performance of our sorting algorithms");
		
		System.out.println("###########################################");
		System.out.println("SelectionSort time: " + (sEnd - sStart) + " ms");
		
		String sortedemployeeBySalary = "sortedemployeeBySalary.csv";
		
		try (java.io.PrintWriter writer = new java.io.PrintWriter(new File(sortedemployeeBySalary))) {
			for (int i = 0; i < index; i++) {
				writer.println(employees[i].toString());
			}
			System.out.println("Data successfully saved to " + sortedemployeeBySalary);
		} 
		catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
		
		// Call quicksort
		long qStart = System.currentTimeMillis();
		QuickSort.sort(employees);
		long qEnd = System.currentTimeMillis();
		
		System.out.println("------------------------------------------------------");
		System.out.println("QuickSort time: " + (qEnd - qStart) + " ms");
		
		String sortedemployeeByName = "sortedemployeeByName.csv";
		
		try (java.io.PrintWriter writer = new java.io.PrintWriter(new File(sortedemployeeByName))) {
			for (int i = 0; i < index; i++) {
				writer.println(employees[i].toString());
			}
			System.out.println("Data successfully saved to " + sortedemployeeByName);
		} catch (Exception e) {
			System.out.println("An error has occurred. " + e.getMessage());
		}
		
		System.out.println("###########################################");

		// Used in tandem with binary search to find employee ID.
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name of the employee to search: ");
		String searchName = input.nextLine();
		int pos = BinarySearch.search(employees, searchName, 0, index - 1);
		
		if (pos == -1) {
			System.out.println("Employee name not found.");
		} else {
			System.out.println("Employee found at index " + pos);
		}
	}
}


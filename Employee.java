public class Employee implements Comparable<Employee> {
	
	//Variable declaration
    int ID;
    String name;
    double hoursWorked;
    double hourlyRate;
    double deductionProvince;
    double deductionFederal;
    double educationAllowance;

	//Employee object
	public Employee(int ID, String name, double hoursWorked, double hourlyRate, double deductionProvince, double deductionFederal, double educationAllowance) {
		this.ID = ID;
		this.name = name;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
		this.deductionProvince = deductionProvince;
		this.deductionFederal = deductionFederal;
		this.educationAllowance = educationAllowance;
	}

	public String getName() {
		return name;
	}

	// Step 2 requirement
	public double calcHourlySalary() {
		double gross = hoursWorked * hourlyRate;
		double deductions = gross * (deductionProvince + deductionFederal);
		return gross - deductions + educationAllowance;
	}

	// Used by SelectionSort (salary-based)
	@Override
	public int compareTo(Employee other) {
		// return Double.compare(this.calcHourlySalary(), other.calcHourlySalary());
		return this.name.compareToIgnoreCase(other.name);
	}

	@Override
	public String toString() {
		return ID + "," + name + "," + hoursWorked + "," + hourlyRate + "," + deductionProvince + "," + deductionFederal + "," + educationAllowance;
	}
}

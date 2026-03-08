public class BinarySearch {

    // Performs a search by employee name
    public static int search(Employee[] employees, String name, int low, int high) {

        // Base case: name not found
        if (low > high) {
            return -1;
        }

        // Find middle index
        int mid = (low + high) /2;

        // Compare middle name with target name
        int result = employees[mid].getName().compareToIgnoreCase(name);

        // If names match
        if (result == 0) {

            // Checked left side to return first occurrence
            if (mid > 0 && employees[mid - 1].getName().equalsIgnoreCase(name)) {
                return search(employees, name, low, mid - 1);
            }
            return mid;
        }
        // Search left half
        else if (result > 0) {
            return search(employees, name, low, mid - 1);
        }

        // Search right half
        else {
            return search(employees, name, mid + 1, high);
        }
    }


}


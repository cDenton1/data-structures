public class BinarySearch {

    public static int search(Employee[] employees, String name, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) /2;
        int result = employees[mid].getName().compareToIgnoreCase(name);

        if (result == 0) {
            if (mid > 0 && employees[mid - 1].getName().equalsIgnoreCase(name)) {
                return search(employees, name, low, mid - 1);
            }
            return mid;
        }
        else if (result > 0) {
            return search(employees, name, low, mid - 1);
        }
        else {
            return search(employees, name, mid + 1, high);
        }
    }


}


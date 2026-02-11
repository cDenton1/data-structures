public class SelectionSort {
    public static <T extends Employee> void selectionSort(T[] array) {

        for(int i = 0; i < array.length - 1; i++) {
            int min = i;
    
            for(int j = i + 1; j < array.length; j++) {
                if (array[j].calcHourlySalary() < array[min].calcHourlySalary()) {
                    min = j;
                }
            }
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

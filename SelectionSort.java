// SelectionSort uses O(n^2). This means the more data, the more time it'll take to process the data.
import java.util.Comparator;

public class SelectionSort {

    // This public static method is T in order to account for other data types.
    public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
        
        // Begins with 0 as a starting point to work off of all the upcoming numbers.
        for(int i = 0; i < array.length - 1; i++) { // First index of the unsorted section.
            int min = i; // Until a larger number is found, "i" is assumed to be the smallest.
             
            // The following inner loop is to scan the rest of the array and see if there's anything smaller than the current minimum.
            for(int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[j], array[min]) < 0) {
                    min = j;
                }
            }

            // This is basically swapping the smaller number with the other larger number that was being compared to it.
            T temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}

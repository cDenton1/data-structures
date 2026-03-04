
public class QuickSort {

	public static <T extends Comparable<T>> void sort(T[] array) {
		quickSort(array, 0, array.length - 1);		// call quicksort with the array, first index and last
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
		if (low < high) {
			int p = partition(array, low, high);	// step for recursion
			quickSort(array, low, p - 1);			// left of pivot
			quickSort(array, p + 1, high);			// right of pivot
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
		T pivot = array[high];						// last element is the pivot
		int i = low - 1;							// for tracking element position
		for (int j = low; j < high; j++) {			// move through the array
			if (array[j].compareTo(pivot) <= 0) {	// comparable, if less than the pivot
				i++;								// move i forward
				swap(array, i, j);					// swap element at i with element at i
			}
		}
		swap(array, i + 1, high);					// pivot in correct position, after smaller and before larger
		return i + 1;								// return the index
	}
	
	// swap two elements in the array, used above
	private static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

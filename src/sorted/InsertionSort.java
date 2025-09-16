package sorted;

import static sorted.SelectionSort.mySwap;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        if (array == null || array.length < 2) return;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                mySwap(array, j - 1, j);
                j--;
            }
        }
    }
}

package sorted;

import java.util.Arrays;

import static sorted.SelectionSort.mySwap;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    mySwap(array, i, j);
                }
            }
        }
        return array;
    }
}

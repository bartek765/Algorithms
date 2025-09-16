package sorted;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] array, int[] array2) {
        int[] sortedArray = new int[array.length + array2.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            sortedArray[array.length + i] = array2[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public static int[] merge2(int[] array1, int[] array2) {
        int[] sortedArray = new int[array1.length + array2.length];
        int nIndex = 0;
        int rIndex = 0;

        for (int wIndex = 0; wIndex < sortedArray.length; wIndex++) {
            if (nIndex < array1.length && (rIndex >= array2.length || array1[nIndex] <= array2[rIndex])) {
                sortedArray[wIndex] = array1[nIndex++];
            } else {
                sortedArray[wIndex] = array2[rIndex++];
            }
        }
        return sortedArray;
    }

    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge2(left, right);
    }
}


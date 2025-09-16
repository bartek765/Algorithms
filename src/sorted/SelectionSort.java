package sorted;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int findMinimumIndex = findMinimum(array, i);
            mySwap(array, i, findMinimumIndex);
        }
        return array;
    }

    private static int findMinimum(int[] array, int startIndex) {
        int temp = array[startIndex];
        int tempIndex = startIndex;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
                tempIndex = i;
            }
        }
        return tempIndex;
    }

    public static void mySwap(int[] array, int i, int j) {
        int helpInt = array[i];
        array[i] = array[j];
        array[j] = helpInt;
    }
}

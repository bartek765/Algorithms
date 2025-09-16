package sorted;

import java.util.Arrays;
import java.util.Random;

import static sorted.BubbleSort.bubbleSort;
import static sorted.InsertionSort.insertionSort;
import static sorted.MergeSort.*;
import static sorted.QuickSort.quickSort;

public class Runner {
    private static int[] randomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100_000); // liczby 0..99_999
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {99, 40, 27, 83, 11, 0, 12};

     //   System.out.println("Przykładowa tablica posortowana:");
        //System.out.println(Arrays.toString(bubbleSort(array)));

     //   int[] array1 = {3, 5, 7, 9, 11};
//int[] array2 = {1, 2, 6, 7};
      //  int[] arr = merge2(array1, array2);
    //    System.out.println(Arrays.toString(arr));

        // 2. Tablice testowe do pomiaru czasu
        int[] sizes = {10, 100, 1000, 10_000};

        int[] a = {7, 3, 8, 1, 10, 2, 4};
        int n = a.length;
        quickSort(a,0,n-1);
        System.out.println(Arrays.toString(a));

        //System.out.printf("%-10s | %10s%n", "Size", "Time [ms]");
       // System.out.println("-----------------------------");

//        for (int size : sizes) {
//            int[] arr = randomArray(size);
//
//            System.out.println("Losowa tablica (" + size + "): " +
//                    Arrays.toString(Arrays.copyOf(arr, Math.min(10, arr.length))));
//
//            long start = System.nanoTime();
//            arr = merge(array1,array2);
//            long end = System.nanoTime();
//
//            long timeMs = (end - start) / 1_000_000; // ns -> ms
//            System.out.printf("%-10d | %10d%n", size, timeMs);
//            System.out.println(Arrays.toString(Arrays.copyOf(arr, Math.min(10, arr.length))));
//
//            int[][] testInsertionSort = {
//                    { 1, 2, 5, 4, 10, 10, -1, 5 },
//                    { -5, 7, -2, -5, -100, 100, 52, 150 },
//                    { 5, 0, 0, 0, 1, -1 },
//                    { 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0 }
//            };
//
//            for (int t = 0; t < testInsertionSort.length; t++) {
//                insertionSort(testInsertionSort[t]);
//                System.out.println(Arrays.toString(testInsertionSort[t]));
//            }
//        }
    }
}


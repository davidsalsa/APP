package huiswerk.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

        int[]a = {8, 1, 4, 1, 5, 9, 2, 6, 5};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(a);
        System.out.println(Arrays.toString(a));

        int[]b = {8, 1, 4, 1, 5, 9, 2, 6, 5};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(b,0, b.length-1);
        System.out.println(Arrays.toString(b));

        int[] c = {8, 1, 4, 1, 5, 9, 2, 6, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(c, 0, c.length-1);
        System.out.println(Arrays.toString(c));

    }
}

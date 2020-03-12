package huiswerk.sort;


import java.util.Arrays;

public class Sort
{
    public static void main(String[] args) {

//        Integer []a = {8, 1, 4, 1, 5, 9, 2, 6, 5};
//        InsertionSort<Integer> insertionSort = new InsertionSort<>();
//        insertionSort.insertionSort(a);
//        System.out.println(Arrays.toString(a));

        Integer[]b = {2, 4, 8, 42, 12, 1, 18, 33};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.mergeSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));

//        Integer[] c = {8, 1, 4, 1, 5, 9, 2, 6, 5};
//        QuickSort<Integer> quickSort = new QuickSort<>();
//        quickSort.quicksort(c, 0, c.length-1);
//        System.out.println(Arrays.toString(c));
    }
}

package huiswerk.sort.generics;

public class InsertionSortGeneric<AnyType extends Comparable<? super AnyType>> {

    public  <T extends Comparable<T>> void insertionSort(T[] arr) {
        for(int i = 1; i< arr.length; i++) {
            T tmp = arr[i];
            int j = i;
            while(j > 0 && tmp.compareTo(arr[j-1]) < 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = tmp;
        }
    }
}

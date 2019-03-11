package huiswerk.sort.generics;

public class QuickSortGeneric<AnyType extends Comparable<? super AnyType>> {
    <T extends Comparable<T>> int partition(T arr[], int low, int high) {
        T pivot = arr[high];
        int i = (low-1);

        for (int j=low; j<high; j++) {
            if ( pivot.compareTo(arr[j])>= 1)
            {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public <T extends Comparable<T>> void sort(T arr[], int low, int high) {
        if (low < high){
            int pi = partition(arr, low, high);

            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

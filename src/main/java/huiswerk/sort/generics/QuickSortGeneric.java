package huiswerk.sort.generics;

public class QuickSortGeneric<AnyType extends Comparable<? super AnyType>> {
    <T extends Comparable<T>> int partition(T arr[], int low, int high)
    {
        int median3 = (low + high + (high/2))/3;
        T pivot = arr[median3];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if ( pivot.compareTo(arr[j])>= 1)
            {
                i++;

                // swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSortGeneric()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public <T extends Comparable<T>> void sort(T arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}

package huiswerk2020.Generics;

public class Min<T extends  Comparable<T>>{

    public static void main(String[] args){
        Min min = new Min();

        String[] arr = {"Henry", "Bob", "Matilda", "Aaron"};

        System.out.println(min.min(arr));
    }

    private T min(T[] arr){
        T smallestItem = arr[0];
        for(T item : arr){
            if(item.compareTo(smallestItem) < 0){
                smallestItem = item;
            }
        }
        return smallestItem;
    }
}

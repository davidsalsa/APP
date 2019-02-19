package huiswerk.hashing;

public class HashPP {

    private static int[] array = new int[11];

    public static void main(String[] args){
        insert(2,1);
        insert(4,1);
        insert(5,1);
        insert(1,1);
        insert(8,1);
        insert(14,1);
        insert(12,1);

        System.out.println(array);
    }

    private static int hash(int x){
        return x *7;
    }

    private static void insert(int key, int value){
        int index = hash(key) % value;
        System.out.println(key);
        array[index] = value;
    }

}

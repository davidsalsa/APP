package huiswerk.hashing;

public class HashPP {

    private int[] array = new int[11];

    public static void main(String[] args){
        HashPP hashPP = new HashPP();

        hashPP.insert(2);
        hashPP.insert(4);
        hashPP.insert(5);
        hashPP.insert(1);
        hashPP.insert(8);
        hashPP.insert(14);
        hashPP.insert(12);

        System.out.println(hashPP.toString());
    }

    public String toString(){
        StringBuilder print = new StringBuilder();
        for (int value : array) {
            print.append(value).append("\n");
        }
    return print.toString();
    }

    private int hash(int x){
        return x *7;
    }

    private void insert(int key){
        int index = hash(key) % array.length;
        array[index] = key;
    }

}

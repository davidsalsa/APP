package huiswerk2020.recursion;

public class Faculteit {

    public static void main(String[] args){
        System.out.println(faculteit(5));
        System.out.println(som(5));
    }

    private static int faculteit(int n) {
        if (n == 1)
            return n;

        return faculteit(n - 1) * n;
    }

    private static int som(int n){
        if(n == 1)
            return n;

        return som(n-1) + n;
    }


}

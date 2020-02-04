package huiswerk2020.recursion;

public class Faculteit {

    public static void main(String[] args){
        System.out.println(faculteit(5));
        System.out.println(fac_nonrec(5));
        System.out.println(som(5));
        System.out.println(som_nonrec(5));
        System.out.println(count1FromBinary(7));
        System.out.println(reverse("reverse"));
    }

    private static int faculteit(int n) {
        if (n == 1)
            return n;

        return faculteit(n - 1) * n;
    }

    public static int fac_nonrec(int n) {
        int result;
        result =n;

        for(int i=1;i<n;n--) {
            result = result * (n-1);
        }
        return result;
    }

    private static int som(int n){
        if(n == 1)
            return n;

        return som(n-1) + n;
    }

    public static int som_nonrec(int n) {
        int result;
        result =n;

        for(int i=1;i<n;n--) {
            result = result + (n-1);
        }
        return result;
    }

    public static int count1FromBinary(int n) {
        if(n == 0) {
            return 0;
        }
        if(n % 2 == 0) {
            return  count1FromBinary(n/2);
        }

        return count1FromBinary(n/2) +1;
    }


    public static String reverse(String myStr) {
        if (myStr.isEmpty()){
            return myStr;
        }
        return reverse(myStr.substring(1)) + myStr.charAt(0);
    }


}

package huiswerk.recursie;

public class recursie {
	public static void main(String[] args) {
		System.out.println(fac_rec(5));
		System.out.println(fac_nonrec(5));
		System.out.println(som_rec(5));
		System.out.println(som_nonrec(5));
		System.out.println(count1FromBinary(1));
		System.out.println(reverse("hello"));
	}
	//vraag 1
	public static int fac_rec(int n){
		int result;
		result = n;
		if(n>1) {
			result = result * fac_rec(n-1);
		}
		return result;
	}
	
	public static int fac_nonrec(int n) {
		int result;
		result =n;
		
		for(int i=1;i<n;n--) {
			result = result * (n-1);
		}
		return result;
	}
	
	//vraag 2
	
	public static int som_rec(int n){
		int result;
		result = n;
		if(n>1) {
			result = result + som_rec(n-1);
		}
		return result;
	}
	
	public static int som_nonrec(int n) {
		int result;
		result =n;
		
		for(int i=1;i<n;n--) {
			result = result + (n-1);
		}
		return result;
	}
	
	//vraag 23
	public static int count1FromBinary(int n) {
		if(n == 0) {
			return 0;
		}
		if(n % 2 == 0) {
			return  count1FromBinary(n/2);
		}
		
		return count1FromBinary(n/2) +1;
	}
	
	//vraag  49
	public static String reverse(String myStr) {
		if (myStr.isEmpty()){
			 return myStr;
			}
			return reverse(myStr.substring(1)) + myStr.charAt(0);
	}
	
}

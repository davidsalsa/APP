package huiswerk.generics;

import java.util.Arrays;


public class Main{
	
	public static void main(String[] args) {
		Address address0 = new Address("StreetOne", 1);
		Address address1 = new Address("StreetOne", 2);
		Address address2 = new Address("StreetA", 1);
		Address address3 = new Address("StreetA", 2);
		Address address4 = new Address("StreetA", 3);
		Address address5 = new Address("StreetB", 5);
		Address address6 = new Address("StreetB", 3);
		Address[] addressList = {address0, address1, address2, address3, address4, address5, address6};

		Arrays.sort(addressList);
		
		System.out.println(addressList[0].toString() +" "+ addressList[0].toInt());
	}
}

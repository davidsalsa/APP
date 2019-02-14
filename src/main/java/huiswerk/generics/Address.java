package huiswerk.generics;

public class Address implements Comparable<Address>{

	private String street;
	private int houseNumber;
	
	public Address(String street, int houseNumber) {
		this.street = street;
		this.houseNumber = houseNumber;
	}
	
	public String toString() {
		return this.street;
	}
	
	public int toInt() {
		return this.houseNumber;
	}

	@Override
	public int compareTo(Address o) {
		
		return 0;
	}
	
}

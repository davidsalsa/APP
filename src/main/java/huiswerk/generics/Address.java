package huiswerk.generics;

public class Address implements Comparable<Address>{

	private String street;
	private int houseNumber;

	public Address(String street, int houseNumber) {
		this.street = street;
		this.houseNumber = houseNumber;
	}

	public String toString() {
		return this.street + " " + this.houseNumber;
	}

	@Override
	public int compareTo(Address address) {
		int comparison = street.compareTo(address.street);

		if(comparison == 0){
			return houseNumber - address.houseNumber;
		}

		return comparison;
	}

}

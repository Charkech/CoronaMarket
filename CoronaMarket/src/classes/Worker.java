package classes;

abstract class Worker {
	static private int ID=1;
	private String FirstName;
	private String LastName;
	private String Address;
	private int PhoneNumber;
	public void getID() {System.out.println(ID);}
	public void getFirstName() {System.out.println(FirstName);}
	public void getLastName() {System.out.println(LastName);}
	public void getAddress() {System.out.println(Address);}
	public void getPhoneNumber() {System.out.println(PhoneNumber);}
}


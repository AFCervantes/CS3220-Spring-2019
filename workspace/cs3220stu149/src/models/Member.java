package models;

public class Member {
	
	static int count = 0;
	
	int id;
	String firstName;
	String lastName;
	
	public Member(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = count++;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
	
	

}

package models;

public class GuestBookEntry {

	static int count = 0;
	
	int id;
	String name;
	String message;
	
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		
		this.id = count++;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
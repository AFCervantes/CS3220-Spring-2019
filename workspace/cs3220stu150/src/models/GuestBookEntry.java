package models;

import java.util.Date;

public class GuestBookEntry {

	static int count = 0;
	
	int id;
	String name;
	String message;
	Date date;
	
	public GuestBookEntry() {
		date = new Date();
		this.id = count++;
	}
	
	public GuestBookEntry(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.date = new Date();
		
		this.id = count++;
	}
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
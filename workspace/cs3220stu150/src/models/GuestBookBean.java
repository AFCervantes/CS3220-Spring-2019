package models;

import java.util.ArrayList;
import java.util.List;

public class GuestBookBean {
	
	List<GuestBookEntry> guestbook;
	
	public GuestBookBean() {
		this.guestbook = new ArrayList<GuestBookEntry>();
		
		this.guestbook.add(new GuestBookEntry("John", "Hello"));
	}
	
	
	public void setAddEntry(String dummy) {
		GuestBookEntry entry = new GuestBookEntry();
		guestbook.add( entry );
	}

	public GuestBookEntry getLastEntry() {
		return guestbook.get( guestbook.size() - 1 );
	}
	
	public List<GuestBookEntry> getGuestbook(){
		return guestbook;
	}
	
	public void setGuestbook(List<GuestBookEntry> guestbook) {
		this.guestbook = guestbook;
	}
}

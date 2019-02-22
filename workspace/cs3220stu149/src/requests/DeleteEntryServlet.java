package requests;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/requests/DeleteEntry")
public class DeleteEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Get the index of the entry being deleted
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Get a reference to the guest book		
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
							
		// Remove the entry from the guest book
		for (GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id) {
				guestbookEntries.remove( entry );
				break;
			}
		}
		
		// Redirect the user back to the main page
		response.sendRedirect("GuestBook");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

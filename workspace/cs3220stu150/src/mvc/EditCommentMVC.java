package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/mvc/editcomment")
public class EditCommentMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected GuestBookEntry getEntry(int id) {
		
		// Get a reference to the Guest Book in the Servlet Context
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
		
		// Delete a entry from the guest book
		for (GuestBookEntry entry : guestbookEntries) {
			if (entry.getId() == id) 
				return entry;
			
		}
		
		return null;
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestBookEntry entry = null;
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			entry = getEntry(id);
		} catch(Exception e) {}
		
		if (entry == null)
			response.sendRedirect("guestbook");
		else {
			request.setAttribute("entry", entry);
			request.getRequestDispatcher("/WEB-INF/views/EditComment.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "You must enter your name");
		}
		
		if (message == null || message.trim().length() == 0) {
			hasError = true;
			request.setAttribute("messageError", "You must a message");
		}
		
		if (hasError)
			doGet(request, response);
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			GuestBookEntry entry = getEntry(id);
			
			entry.setName(name);
			entry.setMessage(message);
			
			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("guestbook");
		}
		
		
	}

}









package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class AddCommentMVC
 */
@WebServlet("/mvc/addcomment")
public class AddCommentMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/AddComment.jsp").forward(request, response);
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
			// Get a reference to the Guest Book in the Servlet Context
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
			
			// Add a new Entry to the guest book using the name and message that were submitted
			guestbookEntries.add( new GuestBookEntry(name, message) );
			
			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("guestbook");
		}
	}

}
















package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/mvc/guestbook")
public class GuestBookMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create an array list of guest book entries
		ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		
		// Pre-populate the list of entries
		entries.add(new GuestBookEntry("John Doe", "Hello, World!"));
		entries.add(new GuestBookEntry("Mary Jane", "Hi."));
		entries.add(new GuestBookEntry("Joe Boxer", "Howdy"));
		
		// Add the array list of guest book entries to the ServletContext
		ServletContext context = this.getServletContext();		
		context.setAttribute("guestbookEntries", entries);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/GuestBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class GuestBookServlet
 */
@WebServlet("/requests/GuestBook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create an array list of Guest Book Entries
		ArrayList<GuestBookEntry> guestbookEntries = new ArrayList<GuestBookEntry>();
		
		// Add some entries to my array list
		guestbookEntries.add(new GuestBookEntry("John Doe", "Hello, World!"));
		guestbookEntries.add(new GuestBookEntry("Mary Jane", "Hi."));
		guestbookEntries.add(new GuestBookEntry("Joe Boxer", "Howdy"));		
		
		// Store the array list in the Servlet Context
		ServletContext context = this.getServletContext();
		context.setAttribute("guestbookEntries", guestbookEntries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a reference to the Print Write to talk back to the client
		PrintWriter out = response.getWriter();
		
		// The template text/html
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Guest Book</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Guest Book <small>CS3220</small></h1>");
		
		
		// Insert the page-specific content here...
		out.println("	<table class=\"table table-bordered table-striped table-hover\">");
		out.println("		<tr>");
		out.println("			<th>Name</th>");
		out.println("			<th>Message</th>");
		out.println("			<th>Actions</th>");
		out.println("		<tr>");
		
		// Get a reference to our guest book
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
		
		for (GuestBookEntry entry : guestbookEntries) {
			out.println("		<tr>");
			out.println("			<td>" + entry.getName() + "</td>");
			out.println("			<td>" + entry.getMessage() + "</td>");
			out.println("			<td>");
			out.println("				<a href=\"EditEntry?id=" + entry.getId() + "\">Edit</a>");
			out.println("				| ");
			out.println("				<a href=\"DeleteEntry?id=" + entry.getId() + "\">Delete</a>");
			out.println("			</td>");
			out.println("		</tr>");
		}
		
		out.println("	</table>");
		
		
		out.println("<a href=\"AddNewEntry\">Add Comment</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

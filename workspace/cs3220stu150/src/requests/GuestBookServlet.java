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


@WebServlet("/requests/GuestBook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create an array list of guest book entries
		ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		
		// Pre-populate the list of entries
		entries.add(new GuestBookEntry("John Doe", "Hello, World!"));
		entries.add(new GuestBookEntry("May Jane", "Hi."));
		entries.add(new GuestBookEntry("Joe Boxer", "Howdy"));
		
		// Add the array list of guest book entries to the ServletContext
		ServletContext context = this.getServletContext();		
		context.setAttribute("guestbookEntries", entries);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Guest Book</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>My Guest Book</h1>");
		out.println("	<table class=\"table table-bordered table-striped table-hover\">");
		out.println("		<tr>");
		out.println("			<th>Name</th>");
		out.println("			<th>Message</th>");
		out.println("			<th>Actions</th>");
		out.println("		</tr>");
		
		// Read our entries from the Servlet Context		
		
		ServletContext context = this.getServletContext();
		ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) context.getAttribute("guestbookEntries");
		
		
		for( GuestBookEntry entry : guestbookEntries ) {
			out.println("		<tr>");
			out.println("			<td>" + entry.getName() + "</td>");
			out.println("			<td>" + entry.getMessage() + "</td>");
			out.println("			<td>");
			out.println("				<a href=\"EditEntry?id=" + entry.getId() + "\">Edit</a> | ");
			out.println("				<a href=\"DeleteEntry?id=" + entry.getId() + "\">Delete</a>");
			out.println("			</td>");
			out.println("		</tr>");
		}
		
		
		out.println("	</table> ");
		
		
		out.println("<a class=\"btn btn-primary\" href=\"AddNewEntry\">Add Comment</a>");
		out.println("<a class=\"btn btn-success\" href=\"../cookies/AddNewEntryWithCookies\">Add Comment with Cookies</a>");
		out.println("<a class=\"btn btn-warning\" href=\"../sessions/AddNewEntryWithSessions\">Add Comment with Sessions</a>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

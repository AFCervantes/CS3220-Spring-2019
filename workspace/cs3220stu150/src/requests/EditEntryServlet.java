package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class EditEntryServlet
 */
@WebServlet("/requests/EditEntry")
public class EditEntryServlet extends HttpServlet {
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
		
		// Get the entry to be modified
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntry(id);
		
		if (entry == null){
			response.sendRedirect("GuestBook");
			return;
		}
		
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Edit Comment</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Edit Comment</h1>");
		
		out.println("	<form action=\"EditEntry\" method=\"post\">");
		
		out.println("		Name: <input value=\"" + entry.getName() + "\" type=\"text\" name=\"name\"> <br>");
		
		out.println("		Message: <br>");
		out.println("		<textarea name=\"message\">" + entry.getMessage() + "</textarea> <br>");
		
		out.println("		<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
		
		out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Save Comment\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the entry to be modified
		int id = Integer.parseInt(request.getParameter("id"));
		GuestBookEntry entry = getEntry(id);
		
		if (entry != null){
			
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			
			entry.setName(name);
			entry.setMessage(message);			
		}
		
		response.sendRedirect("GuestBook");		
	}

}










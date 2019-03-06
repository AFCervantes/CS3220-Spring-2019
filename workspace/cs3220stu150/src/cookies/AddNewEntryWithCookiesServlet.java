package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/cookies/AddNewEntryWithCookies")
public class AddNewEntryWithCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String getName( HttpServletRequest request )
    {
        Cookie[] cookies = request.getCookies();
        
        if( cookies != null )
            for( Cookie cookie : cookies )
                if( cookie.getName().equals( "usersName" ) )
                    return cookie.getValue();

        return null;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Add Comment with Cookies</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Add Comment with Cookies</h1>");
		
		out.println("	<form action=\"AddNewEntryWithCookies\" method=\"post\">");
		
		String name = getName(request);
		
		if (name == null)
			out.println("		Name: <input type=\"text\" name=\"name\"> <br>");
		else
			out.println("       Name: <strong>" + name + "</strong> <br>");
		
		out.println("		Message: <br>");
		out.println("		<textarea name=\"message\"></textarea> <br>");
		out.println("		<input class=\"btn btn-success\" type=\"submit\" name=\"submitBtn\" value=\"Add Comment\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Check to see if the Add New Entry form was submitted
		// We'll do so by validating the inputs
		
		String name = getName(request);
		
		if (name == null)
			name = request.getParameter("name");
		
		String message = request.getParameter("message");
		
		if (name != null && name.trim().length() > 0 &&
			message != null && message.trim().length() > 0) {
					
			Cookie cookie = new Cookie("usersName", name);
			cookie.setPath( request.getContextPath() );
			response.addCookie( cookie );
			
			// Get a reference to the Guest Book in the Servlet Context
			ArrayList<GuestBookEntry> guestbookEntries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("guestbookEntries");
			
			// Add a new Entry to the guest book using the name and message that were submitted
			guestbookEntries.add( new GuestBookEntry(name, message) );
			
			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("../requests/GuestBook");
		}
		else
			doGet(request, response);
		
	}

}

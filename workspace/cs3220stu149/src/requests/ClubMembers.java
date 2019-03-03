package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Member;

@WebServlet("/requests/members")
public class ClubMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<Member> members = new ArrayList<Member>();
		members.add(new Member("John", "Doe"));
		members.add(new Member("Mary", "Jane"));
		members.add(new Member("Joe", "Boxer"));
		
		getServletContext().setAttribute("members", members);
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
		out.println("	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("	<title>Club Members</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Club Members</h1>");
		
		out.println("	<table class=\"table\">");
		out.println("		<tr><th>First Name</th><th>Last Name</th></tr>");
		
		ArrayList<Member> members = (ArrayList<Member>) getServletContext().getAttribute("members");
		
		for( Member member : members) {
			out.println("		<tr>");
			out.println("			<td>" + member.getFirstName() + "</td>");
			out.println("			<td>" + member.getLastName() + "</td>");
			out.println("		</tr>");
		}
		
		out.println("	</table>");
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		firstName = firstName == null ? "" : firstName;
		lastName = lastName == null ? "" : lastName;
		
		out.println("	<hr class=\"my-4\">");
		out.println("	<form action=\"members\" method=\"post\">");
		
		
		if (request.getAttribute("firstNameError") != null)
			out.println("<p class=\"text-danger\">" + request.getAttribute("firstNameError") + "</p>");
		
		out.println("		<input type=\"text\" value=\"" + firstName + "\" placeholder=\"Enter your First Name\" name=\"firstName\"><br>");
		
		String lastNameErrorMessage = (String) request.getAttribute("lastNameError");		
		if (lastNameErrorMessage != null)
			out.println("<p class=\"text-danger\">" + lastNameErrorMessage + "</p>");
		
		out.println("		<input type=\"text\" value=\"" + lastName + "\"placeholder=\"Enter your Last Name\" name=\"lastName\"><br>");
		out.println("		<input type=\"submit\" value=\"Add Member\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		boolean isValidFirstName, isValidLastName;
		
		// Validate the first name
		if (firstName == null || firstName.trim().length() == 0)
			isValidFirstName = false;
		else
			isValidFirstName = true;
		
		// Validate the last name
		isValidLastName = lastName != null && lastName.trim().length() > 0;
		
		if (isValidFirstName && isValidLastName) {
			// Adding a new member
			ArrayList<Member> members = (ArrayList<Member>) getServletContext().getAttribute("members");
			members.add(new Member(firstName, lastName));
			response.sendRedirect("members");
			return;
		}
		// If we get here, there's a problem
		else {
			if (!isValidFirstName)
				request.setAttribute("firstNameError", "You must enter a first name");
			
			if (!isValidLastName)
				request.setAttribute("lastNameError", "You must enter a last name");
		}
		
		doGet(request, response);
		
		
	}

}











package requests.phonebook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/phonebook")
public class PhoneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		ArrayList<Contact> phonebook = new ArrayList<Contact>();
		phonebook.add(new Contact("John", "Doe",  "(555)123-4567"));
		phonebook.add(new Contact("Mary", "Jane", "(555)123-4568"));
		phonebook.add(new Contact("Joe", "Boxer", "(444)333-1111"));
		
		getServletContext().setAttribute("phonebook", phonebook);
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
		out.println("	<title>Phonebook</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Phonebook</h1>");
		out.println("   <div class=\"my-4\">");
		out.println("		<form action=\"phonebook\" method=\"get\">");	
		out.println("		<input type=\"text\" name=\"searchQuery\" placeholder=\"Enter your search\">");
		out.println("		<input type=\"submit\" value=\"Search\">");
		out.println("		</form>");
		out.println("   </div>");
		out.println("	<table class=\"table\">");
		out.println("		<tr><th>Name</th><th>Phone</th><th>Actions</th></tr>");
		
		ArrayList<Contact> phonebook = (ArrayList<Contact>) getServletContext().getAttribute("phonebook");
		
		// if the parameter sort exists, and it's equal to name, then sort by last name
		
		
		// Get the search query if it exists
		
		for(Contact contact : phonebook) {
			
			
			out.println("		<tr>");
			out.println("			<td>" + contact.getLastName() + ", " + contact.getFirstName() + "</td>");
			out.println("			<td>" + contact.getPhoneNumber() + "</td>");
			out.println("			<td>Edit | Delete</td>");
			out.println("		</tr>");
		}
		
		
		out.println("	</table>");
			
		out.println("   <div class=\"my-4\">");
		out.println("		<h3>Add New Contact</h3>");
		out.println("		<hr class=\"my-4\">");
		out.println("		<form action=\"phonebook\" method=\"post\">");
		
		String firstNameError = (String) request.getAttribute("firstNameError");
		String lastNameError = (String) request.getAttribute("lastNameError");
		String phoneNumberError = (String) request.getAttribute("phoneNumberError");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		
		firstName = firstName == null ? "" : firstName;
		lastName = lastName == null ? "" : lastName;
		phone = phone == null ? "" : phone;
		
		if (firstNameError != null)
			out.println("<p class=\"text-danger\">" + firstNameError + "</p>");
		
		out.println("			<input type=\"text\" name=\"firstName\" value=\"" + firstName + "\" placeholder=\"Enter your first name\"><br>");
		
		if (lastNameError != null)
			out.println("<p class=\"text-danger\">" + lastNameError + "</p>");
		
		out.println("			<input type=\"text\" name=\"lastName\" value=\"" + lastName + "\" placeholder=\"Enter your last name\"><br>");
		
		if (phoneNumberError != null)
			out.println("<p class=\"text-danger\">" + phoneNumberError + "</p>");
		
		out.println("			<input type=\"phone\" name=\"phone\" value=\"" + phone + "\"placeholder=\"(xxx) xxx-xxxx\"><br>");
		out.println("			<input type=\"submit\" value=\"Add New Contact\">");
		out.println("		</form>");
		out.println("   </div>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get the first name, last name, and phone from my request object
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		
		// Validate the inputs
		boolean isValidFirstName = firstName != null && firstName.trim().length() > 0;
		boolean isValidLastName = lastName != null && lastName.trim().length() > 0;
		boolean isValidPhoneNumber = phone != null && phone.trim().length() > 0;
		
		
		if (isValidFirstName && isValidLastName && isValidPhoneNumber) {		
			ArrayList<Contact> phonebook = (ArrayList<Contact>) getServletContext().getAttribute("phonebook");			
			phonebook.add(new Contact(firstName, lastName, phone));
			response.sendRedirect("phonebook");
			return;
		}
		else {
			// Introudcing the REQUEST scope
			if (!isValidFirstName)
				request.setAttribute("firstNameError", "You must enter a first name");
			if (!isValidLastName)
				request.setAttribute("lastNameError", "You must enter a last name");
			if (!isValidPhoneNumber)
				request.setAttribute("phoneNumberError", "You must enter a phone number");
		}
		
		doGet(request, response);
	}

}













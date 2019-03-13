package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		out.println("	<title>Login</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Login</h1>");
				
		String errorMessage = (String) request.getAttribute("error");
		if (errorMessage != null)
			out.println("<p class=\"text-danger\">" + errorMessage + "</p>");
		
		out.println("	<form action=\"Login\" method=\"post\">");
		out.println("		<input name=\"name\" type=\"text\" placeholder=\"Enter your name\"><br>");
		out.println("		<input name=\"password\" type=\"password\" placeholder=\"Enter your password\"><br>");
		out.println("		<input type=\"submit\" value=\"Login\">");
		out.println("	</form>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// Select * from Users where username like '" + name + "' AND password like '" + password + "'
		
		if (name.equals("Albert") && password.equals("abcd")) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedInName", name);
			response.sendRedirect("MembersOnly");
		}
		else {
			request.setAttribute("error", "Invalid username and/or password");
		}
		
		doGet(request, response);
	}

}









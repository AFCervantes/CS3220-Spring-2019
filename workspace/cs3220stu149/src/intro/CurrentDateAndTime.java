package intro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/intro/CurrentDateAndTime"}, loadOnStartup=1)
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Get a reference to the Servlet Context (Global Scope, Application Scope)
		ServletContext context = this.getServletContext();
		
		// Store the counter and the initial value of 0 in the servlet context
		context.setAttribute("dateAndTimeCounter", 0);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the servlet context
		ServletContext context = this.getServletContext();
		
		// Get the current counter value
		int count = (int) context.getAttribute("dateAndTimeCounter");
		
		// Increment the value by 1
		count++;
		
		// Store a new Integer object, with the updated value, in the Servlet Context
		context.setAttribute("dateAndTimeCounter", count);
		
		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a reference to the Print Write to talk back to the client
		PrintWriter out = response.getWriter();
		
		// The template text/html
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Date and Time</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>Current Date &amp; Time</h1>");
		
		// Insert the page-specific content here...
		out.println("<h3>");
		out.println("   The current date and time is: " + new Date());
		out.println("</h3>");
		
		out.println("<a href=\"Metrics\" class=\"btn btn-primary\">Metrics</a>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

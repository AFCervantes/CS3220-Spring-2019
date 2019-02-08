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

@WebServlet(urlPatterns="/intro/CurrentDateAndTime", loadOnStartup=1)
public class CurrentDateAndTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init(ServletConfig config) throws ServletException {
		// Don't forget to call super.initi(config)
		super.init(config);
		
		// Get a reference to the servlet context
		ServletContext context = this.getServletContext();
		
		// Add our counter to the context
		context.setAttribute("dateAndTimeCounter", 0);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get a reference to the servlet context
		ServletContext context = this.getServletContext();
		
		// Get the current value of count
		int count = (int) context.getAttribute("dateAndTimeCounter");
		
		// Increment the count
		count++;
		
		// Store the incremented value back into the servlet context
		context.setAttribute("dateAndTimeCounter", count);
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Current Time</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>The Current Date &amp; Time is: " + new Date() + "</h1>");
		
		// Insert the page-specific content here...
		out.println("<a class=\"btn btn-primary\" href=\"DateAndTimeMetrics\">Metrics</a>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package responses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responses/countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int count = 5;
	
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
		out.println("	<title>Dynamic Time</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<h1>");
		
		if ( count > 0 ) {
			int delay = 1;
			
			response.setHeader( "Refresh", delay + "" );
			//response.setIntHeader( "Refresh", 1 );
			out.println("T-Minus " + count + " second(s), and counting...");			
			count--;
		}
		else {
			out.println("<span class=\"text-danger\">Blast Off!</span>");
			// Reset the counter, but don't send the REFRESH header
			count = 5;
		}
		
		
		out.println("	</h1>");
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

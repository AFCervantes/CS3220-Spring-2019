package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

/**
 * Servlet implementation class EditCommentDb
 */
@WebServlet("/db/editcomment")
public class EditCommentDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private GuestBookEntry getEntry(int id) throws ServletException {
		
		GuestBookEntry entry = null;
		
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu150";
            String username = "cs3220stu150";
            String password = "";

            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook where id = " + id );
            
            if( rs.next() )
            {
            	
            	String name = rs.getString("name");
            	String message = rs.getString("message");
            	
            	entry = new GuestBookEntry(id, name, message);
            }
                     
        }
        catch( SQLException e )
        {
            throw new ServletException( e );
        }
        finally
        {
            try
            {
                if( c != null ) c.close();
            }
            catch( SQLException e )
            {
                throw new ServletException( e );
            }
                       
        }
		
		return entry;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookEntry entry = null;
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			entry = getEntry(id);
		} catch(Exception e) {}
		
		if (entry == null)
			response.sendRedirect("guestbook");
		else {
			request.setAttribute("entry", entry);
			request.getRequestDispatcher("/WEB-INF/views/EditComment.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0) {
			hasError = true;
			request.setAttribute("nameError", "You must enter your name");
		}
		
		if (message == null || message.trim().length() == 0) {
			hasError = true;
			request.setAttribute("messageError", "You must a message");
		}
		
		if (hasError)
			doGet(request, response);
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu150";
	            String username = "cs3220stu150";
	            String password = /* Your Password Goes Here */																																																	"moBc!!v*";

	            c = DriverManager.getConnection( url, username, password );
	            
	            Statement stmt = c.createStatement();
	            String sql = "UPDATE guestbook SET name = '" + name + "', message = '" + message + "' WHERE id = " + id;
	            stmt.executeUpdate(sql);
	            	                     
	        }
	        catch( SQLException e )
	        {
	            throw new ServletException( e );
	        }
	        finally
	        {
	            try
	            {
	                if( c != null ) c.close();
	            }
	            catch( SQLException e )
	            {
	                throw new ServletException( e );
	            }
	                       
	        }
			
			
			// Send the User (Client) back to the GuestBook page
			response.sendRedirect("guestbook");
		}
		
		
	}

}

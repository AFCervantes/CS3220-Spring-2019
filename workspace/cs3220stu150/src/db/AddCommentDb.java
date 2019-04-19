package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


@WebServlet("/db/addcomment")
public class AddCommentDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/AddComment.jsp").forward(request,  response);
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
			
			// Insert the record into the database
			Connection c = null;
	        try
	        {
	            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu150";
	            String username = "cs3220stu150";
	            String password = "";

	            c = DriverManager.getConnection( url, username, password );
	            
	            //String sql = "INSERT INTO guestbook (name, message) VALUES('" + name + "', '" + message + "')";
	            String sql = "INSERT INTO guestbook (name, message) VALUES (?, ?)";
	            System.out.println("Query: " + sql);
	            
	            PreparedStatement pstmt = c.prepareStatement(sql);
	            pstmt.setString(1, name);
	            pstmt.setString(2, message);
	            
	            int numberOfRowsAffected = pstmt.executeUpdate();
	            
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

package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;


@WebServlet("/db/guestbook")
public class GuestBookDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu150";
            String username = "cs3220stu150";
            String password = "";

            c = DriverManager.getConnection( url, username, password );
            
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook" );

            // Create an array list of guestbook entries to hold the data we retrieve from db
            ArrayList<GuestBookEntry> guestbookEntries = new ArrayList<GuestBookEntry>();
            
            // For each record, create a new entry and add it to the list
            while( rs.next() )
            {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
            	String message = rs.getString("message");
            	
            	GuestBookEntry entry = new GuestBookEntry(id, name, message);
            	guestbookEntries.add( entry );
            }
            
            request.setAttribute("guestbookEntries", guestbookEntries);
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
            
            request.getRequestDispatcher("/WEB-INF/views/GuestBook.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

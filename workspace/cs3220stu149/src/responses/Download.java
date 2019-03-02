package responses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responses/download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// image.png?id=12345
		response.setContentType( "image/jpg" );
        response.setHeader( "Content-Disposition",
            "attachment; filename=cark.jpg" );

        FileInputStream in = new FileInputStream( "/Users/albert/Desktop/coffee.jpg" );
        OutputStream out = response.getOutputStream();

        byte buffer[] = new byte[2048];
        
        int bytesRead;
        
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );

        in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

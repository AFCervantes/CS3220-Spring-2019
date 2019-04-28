package cs3220.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RequestInfoTag extends SimpleTagSupport {

    String type;

    public RequestInfoTag()
    {
    }

    public void setType( String type )
    {
        this.type = type;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        if( type.equalsIgnoreCase( "method" ) )
            out.print( request.getMethod() );
        else if( type.equalsIgnoreCase( "uri" ) )
            out.println( request.getRequestURI() );
        else if( type.equalsIgnoreCase( "client" ) )
            out.println( request.getRemoteAddr() );
        else
            out.println( "Unsupported type." );
    }

}

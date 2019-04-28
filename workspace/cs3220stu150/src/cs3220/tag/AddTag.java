package cs3220.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport {

    int op1, op2;

    public AddTag()
    {
        op1 = op2 = 0;
    }

    public void setOp1( int i )
    {
        op1 = i;
    }

    public void setOp2( int i )
    {
        op2 = i;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        out.print( op1 + op2 );
    }

}
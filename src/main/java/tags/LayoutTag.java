package tags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class LayoutTag implements SimpleTag {
    JspContext jspContext;


    @Override
    public void doTag() throws JspException, IOException {

    }

    @Override
    public void setParent(JspTag jspTag) {

    }

    @Override
    public JspTag getParent() {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext) {

    }

    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}

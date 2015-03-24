package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.RequestDispatcher;

public final class CustomerDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n");
      out.write("<HTML>\n");
      out.write("    <HEAD>\n");
      out.write("        <TITLE>CustomerDetails</TITLE>\n");
      out.write("    </HEAD>\n");
      out.write("    <BODY>\n");
      out.write("        <H3>Customer Details</H3>\n");
      out.write("            ");
      out.write("\n");
      out.write("            \n");
      out.write("            ");

                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                if (firstName == null) {
                    firstName = "";
                }
                if (lastName == null) {
                    lastName = "";
                }
                if (firstName.length() > 0 && lastName.length() > 0) {  // there is no need to display form as name already provided
                    RequestDispatcher dispatcher = getServletContext().
                            getRequestDispatcher("/servlets.CustomerServlet");
                    dispatcher.forward(request, response);
                }
                // else prepare appropriate instructions for form
                out.print("<P><B>Please enter ");
                if (firstName.length() == 0) {
                    out.print("first name");
                    if (lastName.length() == 0) {
                        out.print(" and ");
                    }
                }
                if (lastName.length() == 0) {
                    out.print("last name");
                }
                out.println("</B></P>");
            
      out.write("\n");
      out.write("\n");
      out.write("        <FORM ACTION=\n");
      out.write("              \"http://localhost:8080/MultiTier/CustomerServlet\">\n");
      out.write("            <P>First name:\n");
      out.write("                <INPUT TYPE=\"TEXT\" NAME=\"firstname\" VALUE=\"");
      out.print( firstName);
      out.write("\"></P>\n");
      out.write("            <P>Last name:\n");
      out.write("                <INPUT TYPE=\"TEXT\" NAME=\"lastname\" VALUE=\"");
      out.print( lastName);
      out.write("\"></P>\n");
      out.write("            <INPUT TYPE=\"SUBMIT\">\n");
      out.write("        </FORM>\n");
      out.write("    </BODY>\n");
      out.write("</HTML>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

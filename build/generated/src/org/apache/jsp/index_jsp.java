package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.RequestDispatcher;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sharing Unwanted</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>\n");
      out.write("        <h1>Login</h1>\n");
      out.write("        \n");
      out.write("        ");

            RequestDispatcher dispatcher;
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            if (name == null || pwd == null) {
                name = "";
                pwd = "";
            }
            if (name.length() > 0 && pwd.length() > 0) {
                dispatcher = getServletContext().getRequestDispatcher("/servlet/LogonServlet");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"http://localhost:8080/MultiTier/LogonServlet\">\n");
      out.write("            <p> ID <input type=\"text\" name=\"usr_id\" maxlength=\"25\" size=\"26\" required></p>\n");
      out.write("            <p> Password <input type=\"text\" name=\"usr_pwd\" maxlength=\"16\" size=\"17\" required></p>\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        <p><a HREF=\"/MultiTier/register.jsp\">Register</a></p>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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

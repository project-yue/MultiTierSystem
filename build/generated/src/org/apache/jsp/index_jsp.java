package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
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

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

    Date createTime = new Date(request.getSession().getCreationTime());
    Date lastAccessTime = new Date(request.getSession().getLastAccessedTime());
    String title = "Welcome Back to Share Unwanted";
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    String userIDKey = new String("userID");
    String userID = new String("Stranger");
    String greeting = "";

    // Check if this is new comer on your web page.
    if (request.getSession().isNew()) {
        title = "Welcome to my website";
        request.getSession().setAttribute(userIDKey, userID);
        request.getSession().setAttribute(visitCountKey, visitCount);
    }
    if (request.getSession().getAttribute("user_id") == null) {
        title = "Hello stranger";
    } else {
        title = "Hello" + request.getSession().getAttribute("user_id");
    }
    greeting += title;
    visitCount = (Integer) request.getSession().getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    userID = (String) request.getSession().getAttribute(userIDKey);
    request.getSession().setAttribute(visitCountKey, visitCount);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Sharing Unwanted</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      beans.UserBean user = null;
      synchronized (session) {
        user = (beans.UserBean) _jspx_page_context.getAttribute("user", PageContext.SESSION_SCOPE);
        if (user == null){
          user = new beans.UserBean();
          _jspx_page_context.setAttribute("user", user, PageContext.SESSION_SCOPE);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "id", "guest", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "name", "Guest", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "pwd", "undefined", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "share", "0", null, null, false);
          out.write("\n");
          out.write("            ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("user"), "use", "0", null, null, false);
          out.write("\n");
          out.write("            <h4>\n");
          out.write("                Hello, ");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.UserBean)_jspx_page_context.findAttribute("user")).getName())));
          out.write(" \n");
          out.write("                (");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.UserBean)_jspx_page_context.findAttribute("user")).getId())));
          out.write(")<br/>\n");
          out.write("            </h4>\n");
          out.write("            <p>You have shared ");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.UserBean)_jspx_page_context.findAttribute("user")).getShare())));
          out.write(",\n");
          out.write("                and used ");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.UserBean)_jspx_page_context.findAttribute("user")).getUse())));
          out.write(" items</p>\n");
          out.write("            ");
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("        <p>Session ID: ");
 out.print(request.getSession().getId()); 
      out.write("</p>\n");
      out.write("        <p>Created time: ");
 out.print(createTime); 
      out.write("</p>\n");
      out.write("        <p>Last access time: ");
 out.print(lastAccessTime); 
      out.write("</p>\n");
      out.write("        <p>User ID: ");
 out.print(userID); 
      out.write("</p>\n");
      out.write("        <p>Number of visits: ");
 out.print(visitCount);
      out.write("</p>\n");
      out.write("\n");
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

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import beans.ItemBean;

public final class items_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <style>\n");
      out.write("            table {\n");
      out.write("                float:left;\n");
      out.write("                width:45%;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>\n");
      out.write("\n");
      out.write("        <h4>\n");
      out.write("            Hello, ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString(org.apache.jasper.runtime.JspRuntimeLibrary.handleGetProperty(_jspx_page_context.findAttribute("user"), "name")));
      out.write(" \n");
      out.write("            (");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString(org.apache.jasper.runtime.JspRuntimeLibrary.handleGetProperty(_jspx_page_context.findAttribute("user"), "id")));
      out.write(")<br/>\n");
      out.write("        </h4>\n");
      out.write("\n");
      out.write("        <p>You have shared ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString(org.apache.jasper.runtime.JspRuntimeLibrary.handleGetProperty(_jspx_page_context.findAttribute("user"), "share")));
      out.write(",\n");
      out.write("            and used ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString(org.apache.jasper.runtime.JspRuntimeLibrary.handleGetProperty(_jspx_page_context.findAttribute("user"), "use")));
      out.write(" items\n");
      out.write("        </p>\n");
      out.write("        <p>\n");
      out.write("            ");

                java.util.ArrayList<beans.ItemBean> availableRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("item_list");
                out.println("<table border=1>");
                out.print("<tr>");
                out.print("<th> ID </th>");
                out.print("<th> NAME </th>");
                out.print("<th> HEAT</th>");
                out.print("<th> AVAILABILITY</th>");
                out.print("</tr>");
                for (ItemBean ib : availableRlts) {
                    out.print("<tr>");
                    out.print("<th>" + ib.getId() + "</th>");
                    out.print("<th>" + ib.getName() + "</th>");
                    out.print("<th>" + ib.getHeat() + "</th>");
                    out.print("<th>" + ib.getAvailable() + "</th>");
                    out.print("</tr>");
                }

                out.println("</table>");
                out.println("<table border=1>");
                out.print("<tr><td colspan=\"4\" align=\"center\">"
                        + "You are Using Below Items</td></tr>");
                out.print("<tr>");
                out.print("<th> ID </th>");
                out.print("<th> NAME </th>");
                out.print("<th> HEAT</th>");
                out.print("<th> AVAILABILITY</th>");
                out.print("</tr>");
                java.util.ArrayList<beans.ItemBean> usingRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("under_use_list");
                out.print(usingRlts.size());
                for (ItemBean ib : usingRlts) {
                    out.print("<tr>");
                    out.print("<th>" + ib.getId() + "</th>");
                    out.print("<th>" + ib.getName() + "</th>");
                    out.print("<th>" + ib.getHeat() + "</th>");
                    out.print("<th>" + ib.getAvailable() + "</th>");
                    out.print("</tr>");
                }
                out.println("</table>");
            
      out.write("\n");
      out.write("        </p>\n");
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

<%-- 
    Document   : index
    Created on : 21/03/2015, 12:45:41 PM
    Author     : Yue Li 1251124
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App</title>
    </head>
    <body>
        <h1>Login</h1>
        <%@ page import = "javax.servlet.RequestDispatcher" %>
        <%
            RequestDispatcher dispatcher;
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");
            if (name == null || pwd == null) {
                name = "";
                pwd = "";
            }
            if(name.length() > 0 && pwd.length() > 0){
                dispatcher = getServletContext().getRequestDispatcher("/servlet/LogonServlet");
            }
        %>

        <form>

            <input type="submit">
        </form>
        <p><a HREF="/MultiTier/register.jsp">Register</a></p>
    </body>
</html>

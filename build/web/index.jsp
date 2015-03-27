<%-- 
    Document   : index
    Created on : 21/03/2015, 12:45:41 PM
    Author     : Yue Li 1251124
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*, java.util.*"%>
<%
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
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sharing Unwanted</title>
    </head>
    <body>
        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>
        <h3><%= greeting%></h3>
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
            if (name.length() > 0 && pwd.length() > 0) {
                dispatcher = getServletContext().getRequestDispatcher("/servlet/LogonServlet");
            }
        %>

        <form action="http://localhost:8080/MultiTier/LogonServlet">
            <p> ID <input type="text" name="usr_id" maxlength="25" size="26" required></p>
            <p> Password <input type="text" name="usr_pwd" maxlength="16" size="17" required></p>
            <input type="submit" value="Login">
        </form>

        <p>Session ID: <% out.print(request.getSession().getId()); %></p>
        <p>Created time: <% out.print(createTime); %></p>
        <p>Last access time: <% out.print(lastAccessTime); %></p>
        <p>User ID: <% out.print(userID); %></p>
        <p>Number of visits: <% out.print(visitCount);%></p>

        <p><a HREF="/MultiTier/register.jsp">Register</a></p>
    </body>
</html>

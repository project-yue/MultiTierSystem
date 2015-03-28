<%-- 
    Document   : index
    Created on : 21/03/2015, 12:45:41 PM
    Author     : Yue Li 1251124
--%>

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
        <jsp:useBean id="user" class="beans.UserBean" scope="session">
            <jsp:setProperty name="user" 
                             property="id"
                             value = "guest"/>
            <jsp:setProperty name="user" 
                             property="name"
                             value = "Guest"/>
            <jsp:setProperty name="user" 
                             property="pwd"
                             value = "undefined"/>
            <jsp:setProperty name="user" 
                             property="share"
                             value = "0"/>
            <jsp:setProperty name="user" 
                             property="use"
                             value = "0"/>
        </jsp:useBean>

        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>

        <h4>
            Hello, <jsp:getProperty name="user" property="name"/> 
            (<jsp:getProperty name="user" property="id" />)<br/>
        </h4>
        <p>You have shared <jsp:getProperty name="user" property="share" />,
            and used <jsp:getProperty name="user" property="use" /> items</p>

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
            <p> Password <input type="password" name="usr_pwd" maxlength="16" size="17" required></p>
            <input type="submit" value="Login">
        </form>

        <p>Session ID: <% out.print(request.getSession().getId()); %></p>
        <p>Created time: <% out.print(createTime); %></p>
        <p>Last access time: <% out.print(lastAccessTime); %></p>
        <p>Number of visits: <% out.print(visitCount);%></p>

        <p><a HREF="/MultiTier/register.jsp">Register</a></p>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 21/03/2015, 12:45:41 PM
    Author     : Yue Li 1251124 Jiajie Ji 1127766
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*, java.util.*"%>
<%
    Date createTime = new Date(request.getSession().getCreationTime());
    Date lastAccessTime = new Date(request.getSession().getLastAccessedTime());
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    if (request.getSession().isNew()) {
        request.getSession().setAttribute(visitCountKey, visitCount);
    }
    visitCount = (Integer) request.getSession().getAttribute(visitCountKey);
    visitCount = visitCount + 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sharing Unwanted</title>
    </head>
    <body>


        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>
        
        <h1>Login</h1>
        

        <form id="log_submit" action="http://localhost:8080/MultiTier/LoginServlet" 
              onsubmit="return validateForm()">
            <p> ID <input type="text" name="id" maxlength="25" size="26"></p>
            <p> Password <input type="password" name="pwd" maxlength="16" size="17"></p>
            <input type="submit" value="Login">
        </form>

        <script>
            function validateForm() {
                var x = document.forms["log_submit"]["id"].value;
                var y = document.forms["log_submit"]["pwd"].value;
                if (x === "" || y === "") {
                    alert("You must have Username and password");
                    return false;
                }
            }
        </script>


        <p>Session ID: <% out.print(request.getSession().getId()); %></p>
        <p>Created time: <% out.print(createTime); %></p>
        <p>Last access time: <% out.print(lastAccessTime); %></p>
        <p>Number of visits: <% out.print(visitCount);%></p>

        <p><a HREF="/MultiTier/register.jsp">Register</a></p>
    </body>
</html>

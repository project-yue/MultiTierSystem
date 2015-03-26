<%-- 
    Document   : register new users, should redirect users to show_items once 
registered, and show the items list
    Created on : 24/03/2015, 11:39:01 AM
    Author     : Yue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping App</title>
    </head>
    <body>
        <h1>Registration</h1>

    <from ACTION=
          "http://localhost:8080/MultiTier/RegistrationServlet">

        <p>ID:
            <input type="text" NAME="id" size="" required></p>
        <P>name:
            <INPUT TYPE="TEXT" NAME="name" required></P>
        <P>password:
            <INPUT TYPE="TEXT" NAME="pwd" required></P>
        <INPUT TYPE="SUBMIT">
    </from>

    <p><a HREF="/MultiTier/index.jsp">Return</a></p>
</body>
</html>

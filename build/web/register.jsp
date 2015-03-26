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

        <FORM ACTION=
              "http://localhost:8080/MultiTier/RegistrationServlet">
            <P>First name:
                <INPUT TYPE="TEXT" NAME="firstname" required></P>
            <P>Last name:
                <INPUT TYPE="TEXT" NAME="lastname" required></P>
            <INPUT TYPE="SUBMIT">
        </FORM>

        <p><a HREF="/MultiTier/index.jsp">Return</a></p>
    </body>
</html>

<%-- 
    Document   : register new users, should redirect users to show_items once 
registered, and show the items list
    Created on : 24/03/2015, 11:39:01 AM
    Author     : Yue
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Share Unwanted</title>
    </head>
    <body>
        <h1>Registration</h1>


        <form action="http://localhost:8080/MultiTier/RegistrationServlet">
            <p>ID:
                <input type="text" name="id" maxlength="25" size="26" required></p>
            <p>name:
                <input type="text" name="name" maxlength="30" size="31"  required></p>
            <p>password:
                <input type="password" name="pwd" maxlength="16" size="17" required></p>
            <input type="submit" value="Register">
        </form>

        <p><a HREF="/MultiTier/index.jsp">Back to home</a></p>

    </body>
</html>

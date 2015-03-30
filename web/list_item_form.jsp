<%-- 
    Document   : use_item_form
    Created on : 29/03/2015, 2:56:32 AM
    Author     : yue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Use Item Form</title>
    </head>
    <body>
        <form action=http://localhost:8080/MultiTier/ShareServlet>
            <p>Return Item ID<input type="text" name="item_id" required></p>
            <input type="submit" value="Share">
        </form>
    </body>
</html>

<%-- 
    Document   : task_complete
    Created on : 29/03/2015, 9:44:52 PM
    Author     : yue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Task complete</title>
    </head>
    <body>
        <p>update complete</p>
        <p><a HREF="/MultiTier/index.jsp">
                <% request.getSession().invalidate();%>
                Complete Transaction</a></p>
    </body>
</html>

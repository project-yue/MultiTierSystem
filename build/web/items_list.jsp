<%-- 
    Document   : items_list
    Created on : 28/03/2015, 11:31:06 AM
    Author     : Yue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sharing Unwanted</title>
    </head>
    <body>

        <h3>Hello, welcome to Sharing unwanted. A place for people to share items for free</h3>

        <h4>
            Hello, <jsp:getProperty name="user" property="name"/> 
            (<jsp:getProperty name="user" property="id" />)<br/>
        </h4>

        <p>You have shared <jsp:getProperty name="user" property="share" />,
            and used <jsp:getProperty name="user" property="use" /> items
        </p>
        <%@page import="java.io.*, java.util.*" %>
        <% List eList = (List) session.getAttribute("item_list");
            request.setAttribute("eList", eList);
        %>
</html>

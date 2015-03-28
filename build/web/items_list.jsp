<%-- 
    Document   : items_list
    Created on : 28/03/2015, 11:31:06 AM
    Author     : Yue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.io.*, java.util.*, beans.ItemBean"%>
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
        <p>
            <%
                java.util.ArrayList<beans.ItemBean> results = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("item_list");
                out.print(results.size());
                for (ItemBean ib : results) {
                    out.println(ib.getId());
                    out.println(ib.getName());
                    out.println(ib.getHeat());
                    out.println(ib.getAvailable());
                }
            %>
        </p>
</html>

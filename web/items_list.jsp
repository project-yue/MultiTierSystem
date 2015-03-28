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
        <style>
            table {
                float:left;
                width:45%;
            }
        </style>
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
        <p><a HREF="/MultiTier/index.jsp">Return</a></p>
        <table border="1">        
            <tr>
            <tr>
                <td colspan="4" align="center">Available Items</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <form action=http://localhost:8080/MultiTier/RegistrationServlet>
                        <input type="text" required> 
                        <input type="submit" value="Acquire">
                    </form>
                </td>
            </tr>
            <th>ID</th>
            <th>NAME</th>
            <th> HEAT</th>
            <th>AVAILABILITY</th>
                <%
                    java.util.ArrayList<beans.ItemBean> availableRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("item_list");
                    for (ItemBean ib : availableRlts) {
                        out.print("<tr>");
                        out.print("<th>" + ib.getId() + "</th>");
                        out.print("<th>" + ib.getName() + "</th>");
                        out.print("<th>" + ib.getHeat() + "</th>");
                        out.print("<th>" + ib.getAvailable() + "</th>");
                        out.print("</tr>");
                    }
                %>
        </table>
        <table border=1>
            <tr>
                <td colspan="4" align="center">You are Using Below Items</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <form action="http://localhost:8080/MultiTier/RegistrationServlet">
                        <input type="text" required> 
                        <input type="submit"value="Return!">
                    </form>
                </td>
            </tr>

            <tr>
                <th> ID </th>
                <th> NAME </th>
                <th> HEAT</th>
                <th> AVAILABILITY</th>
            </tr>
            <%
                java.util.ArrayList<beans.ItemBean> usingRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("under_use_list");
                for (ItemBean ib : usingRlts) {
                    out.print("<tr>");
                    out.print("<th>" + ib.getId() + "</th>");
                    out.print("<th>" + ib.getName() + "</th>");
                    out.print("<th>" + ib.getHeat() + "</th>");
                    out.print("<th>" + ib.getAvailable() + "</th>");
                    out.print("</tr>");
                }
            %>
        </table>

    </body>
</html>

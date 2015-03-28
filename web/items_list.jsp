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
        <p>
            <%
                java.util.ArrayList<beans.ItemBean> availableRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("item_list");
                out.println("<table border=1>");
                out.print("<tr>");
                out.print("<tr><td colspan=\"4\" align=\"center\">"
                        + "Available Items</td></tr>");
//                need to check the text length
                out.print("<tr><td colspan=\"4\" align=\"center\">"
                        + "<form action=\"http://localhost:8080/MultiTier/RegistrationServlet\"><input type=\"text\" required> <input type=\"submit\" "
                        + "value=\"Acquire\"></form></td></tr>");
//                make a servlet for acquiring
                out.print("<th> ID </th>");
                out.print("<th> NAME </th>");
                out.print("<th> HEAT</th>");
                out.print("<th> AVAILABILITY</th>");
                out.print("</tr>");
                for (ItemBean ib : availableRlts) {
                    out.print("<tr>");
                    out.print("<th>" + ib.getId() + "</th>");
                    out.print("<th>" + ib.getName() + "</th>");
                    out.print("<th>" + ib.getHeat() + "</th>");
                    out.print("<th>" + ib.getAvailable() + "</th>");
                    out.print("</tr>");
                }

                out.println("</table>");
                out.println("<table border=1>");
                out.print("<tr><td colspan=\"4\" align=\"center\">"
                        + "You are Using Below Items</td></tr>");
                out.print("<tr><td colspan=\"4\" align=\"center\">"
                        + "<form action=\"http://localhost:8080/MultiTier/RegistrationServlet\"> <input type=\"text\" required> <input type=\"submit\" "
                        + "value=\"Return!\"></form></td></tr>");
//                make a servlet for returning process
                out.print("<tr>");
                out.print("<th> ID </th>");
                out.print("<th> NAME </th>");
                out.print("<th> HEAT</th>");
                out.print("<th> AVAILABILITY</th>");
                out.print("</tr>");
                java.util.ArrayList<beans.ItemBean> usingRlts = (java.util.ArrayList<beans.ItemBean>) request.getAttribute("under_use_list");
//                out.print(usingRlts.size());
                for (ItemBean ib : usingRlts) {
                    out.print("<tr>");
                    out.print("<th>" + ib.getId() + "</th>");
                    out.print("<th>" + ib.getName() + "</th>");
                    out.print("<th>" + ib.getHeat() + "</th>");
                    out.print("<th>" + ib.getAvailable() + "</th>");
                    out.print("</tr>");
                }
                out.println("</table>");
            %>
        </p>
</html>

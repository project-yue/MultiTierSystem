<%-- 
    Document   : login_success
    Created on : 27/03/2015, 11:13:41 AM
    Author     : yue
--%>

<%@page import="beans.ItemBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <%@page import="java.io.*, java.util.*, beans.UserBean, database.UserDatabase"%>
        <jsp:useBean id="user" class="beans.UserBean" scope="request">

        </jsp:useBean>
        <%
            // set up user bean
            UserBean eb = new UserBean();
            ArrayList<Cookie> cookieLst = (ArrayList<Cookie>) request.getAttribute("cookies");
            eb.setId(cookieLst.get(0).getValue());
            eb.setName(cookieLst.get(1).getValue());
            eb.setPwd(cookieLst.get(2).getValue());
            eb.setShare(cookieLst.get(3).getValue());
            eb.setUse(cookieLst.get(4).getValue());
            request.setAttribute("user", eb);
            request.setAttribute("id", eb.getId());
        %>


        <h4>
            Hello, <jsp:getProperty name="user" property="name"/> 
            (<jsp:getProperty name="user" property="id" />)<br/>
        </h4>
        <p>
            You have shared <jsp:getProperty name="user" property="share" />,
            and used <jsp:getProperty name="user" property="use" /> items
        </p>
        <form action="http://localhost:8080/SharedUnwanted/CommandsServlet">
            <select name="select_">
                <option value="list">List Item</option>
                <option value="return">Return Item</option>
                <option value="use">Use Item</option>
            </select>
            <input type="text" name="select_input">
            <input type="text" hidden name="usr_id" value="<%= eb.getId()%>">
            <input type="text" hidden name="usr_pwd" value="<% eb.getPwd(); %>">
            <input type="submit" />
        </form>
        <p>
            <a HREF="/SharedUnwanted/index.jsp">
                <% request.getSession().invalidate();%>
                Logout</a>
        </p>
        <table border="1">        
            <tr>
            <tr>
                <td colspan="4" align="center">Available Items</td>
            </tr>
            <tr>
                <td colspan="4" align="center">
                    <form action=http://localhost:8080/SharedUnwanted/RegistrationServlet>
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
                    <form action="http://localhost:8080/SharedUnwanted/RegistrationServlet">
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

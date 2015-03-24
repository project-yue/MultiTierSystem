<%-- 
    Document   : complexBean
    Created on : 25/03/2015, 12:00:03 AM
    Author     : mk29
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EL and Complex JavaBeans</title>
        <style>
            body, td {font-family:verdana;font-size:10pt;}
        </style>
    </head>
    <body>
        <h2>EL and Complex JavaBeans</h2>
        <table border="1">
            <tr>
                <td>${person.name}</td>
                <td>${person.age}</td>
                <td>${person["address"].line1}</td>
                <td>${person["address"].town}</td>
                <td>${person.address.phoneNumbers[0].std}
                    ${person.address.phoneNumbers[0].number}</td>
                <td>${person.address.phoneNumbers[1].std}
                    ${person.address.phoneNumbers[1].number}</td>
            </tr>
        </table>
    </body>
</html>
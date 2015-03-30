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

        <form name="regi_submit" action="http://localhost:8080/SharedUnwanted/RegisterServlet"
              onsubmit="return validateForm()" >
            <p>ID:
                <input type="text" name="id" maxlength="25" size="26" required></p>
            <p>name:
                <input type="text" name="name" maxlength="30" size="31"  required></p>
            <p>password:
                <input type="password" name="pwd" maxlength="16" size="17" required></p>
            <input type="submit" value="Register">
        </form>

        <script>
            function validateForm() {
                var x = document.forms["regi_submit"]["id"].value;
                if (x === "guest") {
                    alert("guest is reserved");
                    return false;
                }
            }
        </script>

        <p><a HREF="/SharedUnwanted/index.jsp">Back to home</a></p>

    </body>
</html>

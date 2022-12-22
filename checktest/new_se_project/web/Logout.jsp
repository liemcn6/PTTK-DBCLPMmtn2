<%-- 
    Document   : Logout.jsp
    Created on : Apr 23, 2020, 9:08:14 AM
    Author     : yash_garala 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%session.invalidate();
       response.sendRedirect("LogIn.jsp");%>
    </body>
</html>

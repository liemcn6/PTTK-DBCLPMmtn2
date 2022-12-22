<%-- 
    Document   : newuser
    Created on : Jan 24, 2020, 3:57:32 PM
    Author     : user1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library User Registration</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
         <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <center><h1><marquee>Registration Form </marquee></h1><br>
        <div class="container">
        <form name="registration" action="add_new_user.jsp">
            <table border="0" width="350" height="250">
                <tbody>
                    <hr>
                    <tr><td colspan="3">Name : </td>
                        <td width="100"><input type="text" name="name" value="" required=""/></tr>
                    <tr><td colspan="3">Password : </td>
                        <td><input type="password" name="pass" required=""/></td></tr>
                    <tr><td colspan="3">Email Id : </td>
                        <td><input type="email" name="mail" required=""/><br></td></tr>
                    <tr><td colspan="3">Branch : </td>
                        <td><select name="branch" required=""><option>CE</option>
                                <option>IT</option><option>EC</option></select></td></tr>
                    
                    <tr>
                        <td><button class="button button2">submit</button></td></tr>
                </tbody>
            </table>
        </form></div></center>
    </body>
</html>

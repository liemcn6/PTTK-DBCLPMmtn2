<%-- 
    Document   : L_add_user
    Created on : Apr 22, 2020, 11:51:16 PM
    Author     : yash_garala 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add user</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <center>
        <h1><marquee>Registration Form </marquee></h1><br>
    <body>
        <div class="container">
        <form action="L_add_data.jsp" method="POST">
        <table border="0" width="350" height="250">
                <tbody>
                    
                    <tr><td colspan="3">Name : </td>
                        <td width="100"><input type="text" name="name" value="" required=""/></tr>
                    <tr><td colspan="3">Password : </td>
                        <td><input type="password" name="pass" required=""/></td></tr>
                    <tr><td colspan="3">Email Id : </td>
                        <td><input type="email" name="mail" required=""/><br></td></tr>
                    <tr><td colspan="3">Branch : </td>
                        <td><select name="branch" required=""><option>CE</option>
                                <option>IT</option><option>EC</option></select></td></tr>
                    <tr><td colspan="4"> super user<input type="checkbox" name="super_user" value="1" /> </td>
                        </tr>
                    <tr>
                        <td><button class=" button2">submit</button></td></tr>
                </tbody>
            </table>
        </form>  
        </div>
    </body></center>
</html>

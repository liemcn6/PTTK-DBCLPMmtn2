<%-- 
    Document   : temp_login.jsp
    Created on : Apr 23, 2020, 9:39:19 AM
    Author     : yash_garala 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
 <body>
        <center>
            <h1>Library Management</h1>
        <hr>
        <%
            String s=(String)request.getAttribute("str");
            if(s!=null)
            out.print(s);
        %>
        <div class="container">
           <form name="login" action="LibraryManagement" method="POST" >
            
            
            <table border="0">
                
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" ></td>
                    </tr>
                    <tr>
                       

                    </tr>
                    <tr>
                       
                        <td><button class=" button button2">Submit</button>
                           </td><td> <a href="newuser.jsp">Register</a>
                        </td>
                    </tr>
                    
                </tbody>
               
            </table>
                        
        </form>
        </div>
       </center>
    </body>
</html>

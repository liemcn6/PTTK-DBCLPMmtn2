<%-- 
    Document   : View_your_detail
    Created on : Jan 30, 2020, 6:51:09 PM
    Author     : Lenovo
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View your detail</title>
    </head>
 <%!
         String name,email,branch,password,id;
         ResultSet rs;
 
        %>
    <%
//        out.print((String)session.getAttribute("user_id"));
             try{
                // out.print("xx");
                 session=request.getSession();
                 String username=(String)session.getAttribute("username");
                 //out.print(username);
                int id=(Integer)session.getAttribute("id");
//                 out.print(id);
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                String sql="SELECT * FROM `test` WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1,id);
                rs = statement.executeQuery(); 
                rs.next();
                 name = rs.getString("username");
                 password = rs.getString("password");
                 this.id = rs.getString("id");
                 email = rs.getString("email");
                 branch = rs.getString("branch");
                 
                 
             }catch(Exception e)
             {
//                 out.print(e);
             }
    %>
    <center>
    <body>
        <h1>your detail</h1>
        <table border="1" width="350" height="250">
                <tbody>
                    <hr>
                    <tr><td colspan="3">Name : </td>
                        <td width="200"><% out.print(name); %></tr>
                    <tr><td colspan="3">Password : </td>
                        <td width="200"><% out.print(password); %></td></tr>
                    <tr><td colspan="3">Email Id : </td>
                        <td width="200"><br><% out.print(email); %></td></tr>
                    <tr><td colspan="3">Branch : </td>
                        <td width="200"><% out.print(branch); %></td></tr>
                    <tr><td colspan="3">Id : </td>
                        <td width="200"><% out.print(id); %></td></tr>
                    
                    
                </tbody>
            </table>
    </body>
    </center>
</html>

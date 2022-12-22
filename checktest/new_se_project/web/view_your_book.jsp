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
         String book1,book1_date,book2,book2_date,book3,book3_date;
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
                String sql="SELECT * FROM `user_book` WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1,id);
                rs = statement.executeQuery(); 
                rs.next();
                 book1 = rs.getString("book1");
                 book1_date = rs.getString("book1_date");
                 book2 = rs.getString("book2");
                 book2_date = rs.getString("book2_date");
                 book3 = rs.getString("book3");
                 book3_date = rs.getString("book3_date");
             }catch(Exception e)
             {
                // out.print(e);
             }
    %>
    <center>
    <body>
        <h1>your detail</h1>
        <table border="1" width="" height="250">
           <thead>
               <tr><td colspan="3"><h2> BOOK NAME</h2></td>
                   <td  width=""><h2>BOOK RETURN DATE</h2></td> </tr>
           </thead>
            <tbody>
                    <hr>
                    <tr><td colspan="3"><% out.print(book1); %></td>
                        <td width=""><% out.print(book1_date); %></tr>
                    <tr><td colspan="3"><% out.print(book2); %></td>
                        <td width=""><% out.print(book2_date); %></td></tr>
                    <tr><td colspan="3"><% out.print(book3); %></td>
                        <td width=""><br><% out.print(book3_date); %></td></tr>
                    
                </tbody>
            </table>
    </body>
    </center>
</html>

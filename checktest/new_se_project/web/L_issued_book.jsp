<%-- 
    Document   : View_your_detail
    Created on : Jan 30, 2020, 6:51:09 PM
    Author     : Lenovo
--%>

<%@page import="java.sql.Statement"%>
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
        <link href="style.css" rel="stylesheet" type="text/css">
        <link href="css/login.css" rel="stylesheet" type="text/css">
    </head>
    <center>
        <div class="container">
        <form action="L_issued_book.jsp" method="POST">
            book name:<input type="text" name="book_name" value="" /><br>
            user name:<input type="text" name="user_name" value="" />
        <button class="button button2">serch</button>
        </form>
            </div>
 <%!
         String user_email,book_id,book_name,book_author,user_name,user_id,branch;
         ResultSet rs;
 
        %>
    <%
             try{
                 String serch_book_name=request.getParameter("book_name");
                 String serch_user_name=request.getParameter("user_name");
                 session=request.getSession();
                 String username=(String)session.getAttribute("username");
                int id=(Integer)session.getAttribute("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                String sql,sql2;
                  Statement stmt;
                  if(serch_book_name==null && serch_user_name==null)
                {
//                    sql="SELECT * FROM `book_detail`";
                    sql="Select * from book_detail bd JOIN issued_book ib ON bd.book_id = ib.book_id JOIN test t ON t.id=ib.user_id ";
                    stmt = con.createStatement();
//                PreparedStatement statement = con.prepareStatement(sql);
//                statement.setInt(1,id);
                    rs = stmt.executeQuery(sql);
                }
                else if(serch_book_name.length()!=0)
                {
                    
//                    out.print("this is serch book ");
                   sql="Select * from book_detail bd JOIN issued_book ib ON bd.book_id = ib.book_id JOIN test t ON t.id=ib.user_id WHERE book_name=? ";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1,serch_book_name);
//                    rs = statement.executeQuery(sql);
                    rs = statement.executeQuery();
                }
                else if(serch_user_name.length()!=0)
                {
                   sql="Select * from book_detail bd JOIN issued_book ib ON bd.book_id = ib.book_id JOIN test t ON t.id=ib.user_id WHERE username=?";
                     PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1,serch_user_name);
                    rs = statement.executeQuery();
                }
                 out.print("<table border='1' width='' height=''>");
                 out.print("<thead>");
                 out.print("<tr><td><h2> BOOK ID</h2></td>");
                 out.print("<td ><h2>BOOK NAME</h2>");
                 out.print("<td><h2>BOOK AUTHOR</h2>");
                 out.print("<td><h2>USERNAME</h2>");
                 out.print("<td><h2>USER ID</h2>");
                 out.print("<td><h2>USER EMAIL</h2>");
                 out.print("<td><h2>USER BRANCH</h2>");
                 out.print("</td> </tr>");
                 out.print("</thead>");
                 while(rs.next())
                {
                    book_id = rs.getString("book_id");
                    book_name = rs.getString("book_name");
                    book_author= rs.getString("book_author");
                    user_name = rs.getString("username");
                    user_id = rs.getString("id");
                    user_email = rs.getString("email");
                    branch = rs.getString("branch");
                    out.print("<tbody>");
                    out.print("<tr><td>"+book_id+"</td>");
                    out.print("<td>"+book_name+"</td>");
                    out.print("<td>"+book_author+"</td>");
                    out.print("<td>"+user_name+"</td>");
                    out.print("<td>"+user_id+"</td>");
                    out.print("<td>"+user_email+"</td>");
                    out.print("<td>"+branch+"</td></tr>");
                }    
                out.print("</tbody>");
                out.print("</table>");
              }                 
             catch(Exception e)
             {
                 out.print(e);
             }
    %>
    </center>
  
</html>

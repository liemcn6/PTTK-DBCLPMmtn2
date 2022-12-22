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
        <form action="L_view_book.jsp" method="POST">
            book name:
        <input type="text" name="book_name" value="" />
        <button class="button button2">serch</button>
        </form>
            </div>
 <%!
         String book_id,book_name,book_author,no_of_book;
         ResultSet rs;
 
        %>
    <%
             try{
                 String serch_book_name=request.getParameter("book_name");
                 
                 session=request.getSession();
                 String username=(String)session.getAttribute("username");
                int id=(Integer)session.getAttribute("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                String sql;
                  Statement stmt;
                if(serch_book_name==null)
                {
                    sql="SELECT * FROM `book_detail`";
                    stmt = con.createStatement();
//                PreparedStatement statement = con.prepareStatement(sql);
//                statement.setInt(1,id);
                    rs = stmt.executeQuery(sql);
                }
                else
                {
                   sql="SELECT * FROM `book_detail` WHERE book_name=?";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1,serch_book_name);
//                    rs = statement.executeQuery(sql);
                    rs = statement.executeQuery();
                }
//                rs = stmt.executeQuery(sql); 
//                 branch = rs.getString("branch");
                    
                 out.print("<table border='1' width='' height=''>");
                 out.print("<thead>");
                 out.print("<tr><td><h2> BOOK ID</h2></td>");
                 out.print("<td ><h2>BOOK NAME</h2>");
                 out.print("<td><h2>BOOK AUTHOR</h2>");
                 out.print("<td><h2>NO OF BOOK</h2>");
                 out.print("</td> </tr>");
                 out.print("</thead>");
                 while(rs.next())
                {
                    book_id = rs.getString("book_id");
                    book_name = rs.getString("book_name");
                    book_author= rs.getString("book_author");
                    no_of_book = rs.getString("no_of_book");

                    out.print("<tbody>");
                    out.print("<tr><td>"+book_id+"</td>");
                    out.print("<td>"+book_name+"</td>");
                    out.print("<td>"+book_author+"</td>");
                    out.print("<td>"+no_of_book+"</td></tr>");
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

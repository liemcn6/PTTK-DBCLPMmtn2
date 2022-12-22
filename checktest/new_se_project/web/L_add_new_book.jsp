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
        <form action="L_add_new_book.jsp" method="POST">
            book name:<input type="text" name="book_name" value="" />
            book author:<input type="text" name="book_author" value="" />
            no of book:<input type="text" name="no_of_book" value="" />
        <button class="button button2">add book</button>
        </form>
            </div>
 <%!
         String book_name,book_author,no_of_book;
         ResultSet rs;
 
        %>
    <%
           try{
                book_name=request.getParameter("book_name");
                book_author=request.getParameter("book_author");
                no_of_book=request.getParameter("no_of_book");
                 session=request.getSession();
                 Class.forName("com.mysql.jdbc.Driver");
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                 String sql;
                 Statement stmt;
                    sql="INSERT INTO `book_detail` (`book_id`, `book_name`, `book_author`, `no_of_book`) VALUES (NULL, ?,?,?); ";
                    //stmt = con.createStatement();
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1,book_name);
                    statement.setString(2,book_author);
                    statement.setString(3,no_of_book);
                    statement.execute();
             }                 
             catch(Exception e)
             {
//                 out.print(e);
             }
    %>
    </center>
  
</html>

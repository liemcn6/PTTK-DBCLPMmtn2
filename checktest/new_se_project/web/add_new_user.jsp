<%-- 
    Document   : add_new_user
    Created on : Mar 22, 2020, 10:58:01 AM
    Author     : Lenovo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        try{
        Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");   
       String sql="INSERT INTO `test` (`username`, `password`, `superuser`, `id`, `email`, `branch`) VALUES (?, ?, '0', NULL, ?, ?);";
       String name=request.getParameter("name");
       String password=request.getParameter("pass");
       String email=request.getParameter("mail");
       String branch=request.getParameter("branch");
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setString(1,name);
       statement.setString(2,password);
       statement.setString(3,email);
       statement.setString(4,branch);
       statement.execute();
       out.print("222222222222222222222");
       sql= "SELECT * FROM `test` WHERE username=? and password=? and email=?";
       statement = con.prepareStatement(sql);
       statement.setString(1,name);
       statement.setString(2,password);
       statement.setString(3,email);
       ResultSet rs=statement.executeQuery();
       rs.next();
       out.print("1111111111111111111111");
       sql="INSERT INTO `user_book` (`id`, `book1`, `book1_date`, `book2`, `book2_date`, `book3`, `book3_date`) VALUES (?, NULL, NULL, NULL, NULL, NULL, NULL); ";
       statement = con.prepareStatement(sql);
       statement.setInt(1,rs.getInt("id"));
       statement.execute();

       response.sendRedirect("LogIn.jsp");
        }catch(Exception e)
        {
            out.print(e);
        }


    %>
</html>

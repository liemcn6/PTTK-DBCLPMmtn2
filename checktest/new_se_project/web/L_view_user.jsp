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
        <form action="L_view_user.jsp" method="POST">
            book name:
        <input type="text" name="user_name" value="" />
        <button class="button button2">serch</button>
        </form>
            </div>
 <%!
         String username,id,email,branch;
         ResultSet rs;
 
        %>
    <%
             try{
                 String serch_user_name=request.getParameter("user_name");
                 
                 session=request.getSession();
                 String username=(String)session.getAttribute("username");
                int id=(Integer)session.getAttribute("id");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                String sql;
                  Statement stmt;
                if(serch_user_name==null)
                {
                    sql="SELECT * FROM `test` ";
                    stmt = con.createStatement();
//                PreparedStatement statement = con.prepareStatement(sql);
//                statement.setInt(1,id);
                    rs = stmt.executeQuery(sql);
                }
                else
                {
                   sql="SELECT * FROM `test` WHERE username=?";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1,serch_user_name);
//                    rs = statement.executeQuery(sql);
                    rs = statement.executeQuery();
                }
//                rs = stmt.executeQuery(sql); 
//                 branch = rs.getString("branch");
                    
                 out.print("<table border='1' width='' height=''>");
                 out.print("<thead>");
                 out.print("<tr><td><h2> ID</h2></td>");
                 out.print("<td ><h2>USERNAME </h2>");
                 out.print("<td><h2>EMAIL</h2>");
                 out.print("<td><h2>BARNCH</h2>");
                 out.print("<td><h2>SUPERUSER</h2>");
                 out.print("</td> </tr>");
                 out.print("</thead>");
                 while(rs.next())
                {
                    this.username = rs.getString("username");
                    this.id = rs.getString("id");
                    email= rs.getString("email");
                    branch = rs.getString("branch");
                    int s=rs.getInt("superuser");
                    out.print("<tbody>");
                    out.print("<tr><td>"+this.id +"</td>");
                    out.print("<td>"+this.username+"</td>");
                    out.print("<td>"+email+"</td>");
                    out.print("<td>"+branch+"</td>");
                    if(s==0)
                    {
                         out.print("<td>NO</td></tr>");
                    }
                    else{out.print("<td>YES</td></tr>");}
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

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%-- 
    Document   : renew_book
    Created on : Jan 30, 2020, 7:38:00 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>renew book</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <center>
        <div class="container">
    <form action="L_renew_book.jsp" method="POST">
        user id
        <input type="text" name="id" value="" />
         <button class="button button2">serch</button>
    </form>
            </div>
    <%!
         String book1=null,book2=null,book3=null;
               ResultSet rs;
               int serch_id=0;
 
        %>
    <%
         try{
             serch_id=Integer.parseInt(request.getParameter("id"));
               if(serch_id != 0)
               {
               
               //     int serch_id=Integer.parseInt(request.getParameter("id"));
                    session=request.getSession();
                    String username=(String)session.getAttribute("username");
                    //out.print(username);
                   int id=(Integer)session.getAttribute("id");
   //                 out.print(id);
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                   String sql="SELECT * FROM `user_book` WHERE id=?";
                   PreparedStatement statement = con.prepareStatement(sql);
                   statement.setInt(1,serch_id);
                   rs = statement.executeQuery(); 
                   rs.next();
                    book1 = rs.getString("book1");
                    book2 = rs.getString("book2");
                   book3 = rs.getString("book3");
                
             }
               }catch(Exception e)
                {
                    //out.print(e);
                }
    %>
    
        <body>
            <h1>renew book</h1>
            <form action="renewbook" method="POST">
                <input type="text" name="serch_id" value=<% out.print(serch_id); %> readonly="readonly" />
            <table border="0">
                <tbody>
                    <tr>
                        <td> book1 </td>
                        <td> <% out.print(book1); %> </td>
                     </tr>
                    <tr>
                         <td> how many days </td>
                         <td>                            
                            <%
                                out.print("<select name='book1_day'>");
                                for(int i=0;i<=30;i++)
                                out.print("<option>"+i+"</option>");
                                out.print("</select>");
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td> book2 </td>
                        <td> <% out.print(book2); %> </td>
                        </tr>
                    <tr>
                         <td> how many days </td>
                        <td>
                       
                            
                            <%
                                out.print("<select name='book2_day'>");
                                for(int i=0;i<=30;i++)
                                out.print("<option>"+i+"</option>");
                                out.print("</select>");
                            %>
                        </td>
                    </tr>
                    <tr>
                        <td> book3 </td>
                        <td> <% out.print(book3); %> </td>
                    </tr>
                    <tr>
                         <td> how many days </td>
                        <td>
                            
                            <%
                                out.print("<select name='book3_day'>");
                                for(int i=0;i<=30;i++)
                                out.print("<option>"+i+"</option>");
                                out.print("</select>");
                            %>
                        </td>
                    </tr>
                </tbody>
            </table>
 
                        <button class="button button2">submit</button>
        </form>
            </body>
     </center>
</html>

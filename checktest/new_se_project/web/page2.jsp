<%-- 
    Document   : page2
    Created on : Jan 30, 2020, 5:31:22 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--<%@page contentType="text/css" %>--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
       <% 
            session=request.getSession(false);
            String s1=(String)session.getAttribute("super");
            
            if( s1==null)
            {
                String sub = "Pleas login";
                   String str = "<font color=\"red\">" + sub + "</font>";
                request.setAttribute("str", str);
                //response.sendRedirect("LogIn.jsp");
                RequestDispatcher disp = request.getRequestDispatcher("LogIn.jsp");
                disp.include(request, response);
                return;
                //response.sendRedirect("LogIn.jsp");
            }
        %>
    <center>
        <table border="0" >
           
           <tbody>
               <tr>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/view_your_book.jsp'">View your book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/pre_register_your_book.jsp'" >pre register your book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/View_your_detail.jsp'">View your detail</button></td>
                 </tr>
                  
           </tbody>
       </table>
        <button class="button button2" onclick="window.location.href='/SEpro/renew_book.jsp'">renew book</button>
           <button class="button button2" onclick="window.location.href='/SEpro/L_view_book.jsp'" >View book</button>
           <br>
           <button class="button button2" onclick="window.location.href='/SEpro/Logout.jsp'" >log out</button>
        </center>
    </body>
</html>
  

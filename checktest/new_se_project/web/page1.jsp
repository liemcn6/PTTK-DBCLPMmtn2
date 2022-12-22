<%-- 
    Document   : page1
    Created on : Jan 26, 2020, 10:18:12 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_view_book.jsp'" >View book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_issued_book.jsp'">issued book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_view_user.jsp'" >View user</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_add_user.jsp'" >Add user</button></td>
                               
               </tr>
               <tr>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_renew_book.jsp'">renew book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_add_book.jsp'" >add book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_return_book.jsp'">Return book</button></td>
                   <td><button class="button button2" onclick="window.location.href='/SEpro/L_add_new_book.jsp'">add new book</button></td>
               </tr>
           </tbody>
       </table>
                 <br>
           <button class="button button2" onclick="window.location.href='/SEpro/Logout.jsp'" >log out</button>
    
        </center>

      
    </body>
</html>

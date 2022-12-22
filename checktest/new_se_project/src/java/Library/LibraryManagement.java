/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet(name = "LibraryManagement", urlPatterns = {"/LibraryManagement"})
public class LibraryManagement extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
         String username = request.getParameter("username");
           String password = request.getParameter("password");
           int flag=0;
           String sub = "Invalid username OR password";
        try (PrintWriter out = response.getWriter()) {
           //String a  = (String)request.getParameter("remamber");
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
//            Statement stmt = con.createStatement();
            String sql="SELECT * FROM `test` WHERE username=? AND password=?"; 
//            String sql = "select * from test  WHERE username = ? and password = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            try{
            ResultSet rs = statement.executeQuery();    
                        
            if(rs.next())
            {

                
                int x=rs.getInt("superuser");
                String s=rs.getString("username");
                
                 HttpSession session=request.getSession();
                 session.setAttribute("username", username);
                   int id=rs.getInt("id");
                 session.setAttribute("id",id);
                 String sup=rs.getString("superuser");
                 session.setAttribute("super",sup );
                if(x==1)
                {
                   response.sendRedirect("page1.jsp");
                
                }
                else 
                {
                   response.sendRedirect("page2.jsp"); 
                }
                
            }
            else
            {
                          
                   sub = "Invalid  password or username";
                   flag=1;
                   String str = "<font color=\"red\">" + sub + "</font>";
                request.setAttribute("str", str);
                //response.sendRedirect("LogIn.jsp");
                RequestDispatcher disp = request.getRequestDispatcher("LogIn.jsp");
                disp.include(request, response);
            }
            }catch(Exception e)
            {
                 String str = "<font color=\"red\">" + sub + "</font>";
                request.setAttribute("str", str);
                RequestDispatcher disp = request.getRequestDispatcher("/LogIn.jsp");
                disp.include(request, response);
            }     
            
           }
         if(flag==1)
           {
               PrintWriter out = response.getWriter();
               out.print("1111111111");
               String str = "<font color=\"red\">" + sub + "</font>";
                request.setAttribute("str", str);
                //response.sendRedirect("LogIn.jsp");
                RequestDispatcher disp = request.getRequestDispatcher("LogIn.jsp");
                disp.include(request, response);
           }
              
        }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}



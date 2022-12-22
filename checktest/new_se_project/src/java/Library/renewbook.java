/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import com.sun.java.swing.plaf.windows.resources.windows;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class renewbook extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String book1=request.getParameter("book1_day");
            String book2=request.getParameter("book2_day");
            String book3=request.getParameter("book3_day");
            HttpSession session=request.getSession(false);
           int id=Integer.parseInt(request.getParameter("serch_id"));
           if(id==0)
           {
             id=(Integer)session.getAttribute("id");
           }
             try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java","root", "");        
                String sql="SELECT * FROM `user_book` WHERE id=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet   rs = statement.executeQuery(); 
                rs.next();
                String book1_date=rs.getString("book1_date");
                String book2_date=rs.getString("book2_date");
                String book3_date=rs.getString("book3_date");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c1 = Calendar.getInstance();
                Calendar c2 = Calendar.getInstance();
                Calendar c3 = Calendar.getInstance();

                try{
               //Setting the date to the given date
                    c1.setTime(sdf.parse(book1_date));
                    c2.setTime(sdf.parse(book2_date));
                    c3.setTime(sdf.parse(book3_date));
                }catch(ParseException e){
                        e.printStackTrace();
                }
                c1.add(Calendar.DAY_OF_MONTH, Integer.parseInt(book1));
                c2.add(Calendar.DAY_OF_MONTH, Integer.parseInt(book2));
                c3.add(Calendar.DAY_OF_MONTH, Integer.parseInt(book3));
                String new_book1_Date = sdf.format(c1.getTime()); 
                String new_book2_Date = sdf.format(c2.getTime()); 
                String new_book3_Date = sdf.format(c3.getTime()); 
                sql="UPDATE user_book SET book1_date=?,book2_date=?,book3_date=? WHERE id=?";
                 statement = con.prepareStatement(sql);
                statement.setString(1, new_book1_Date);
                statement.setString(2, new_book2_Date);
                statement.setString(3, new_book3_Date);
                 statement.setInt(4, id);
//                 out.print(sql);
                
                statement.executeUpdate();
                out.print("update sucessfuly");
                String sup=(String) session.getAttribute("super");
//                return;
                if(sup.equals("0"))
                {
                    RequestDispatcher disp = request.getRequestDispatcher("/page2.jsp");
                    disp.include(request, response);
                }
                else
                {
                    RequestDispatcher disp = request.getRequestDispatcher("/page1.jsp");
                    disp.include(request, response);
                }
                //RequestDispatcher disp = request.getRequestDispatcher("/page2.jsp");
                //disp.include(request, response);
//                 window.history.back();
                
            }catch(Exception e)
            {
                out.print(e);
            }
            
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(renewbook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(renewbook.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(renewbook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(renewbook.class.getName()).log(Level.SEVERE, null, ex);
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

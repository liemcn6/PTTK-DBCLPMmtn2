package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NhanVienDAO;
import dao.ThanhVienDAO;
import model.NhanVien;
import model.ThanhVien;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	public static final int ADMIN = 0;
	public static final int MEMBER = 1;
	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String tenDangNhap = request.getParameter("username");
			String matKhau = request.getParameter("password");
		    ThanhVien tv = new ThanhVien();
		    tv.setTenDangNhap(tenDangNhap);
		    tv.setMatKhau(matKhau);
		    String url = "";
		    ThanhVienDAO tvDAO = new ThanhVienDAO();
		    HttpSession session = request.getSession();
		    if(tvDAO.checkLogin(tv)) {
		    	if(tv.getVaiTro() == ADMIN){
	                NhanVien admin = new NhanVienDAO().getNhanVien(tv);
	                url = "/view/gdChinhQL.jsp";
                    session.setAttribute("admin", admin);    
	           }
		    	// forward request and response to the view
			    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			    dispatcher.forward(request, response);
		    } else {
		    	// forward request and response to the login view
				response.sendRedirect("login?err=fail");
//		    	url = "/view/Login.jsp";
//			    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//			    dispatcher.forward(request, response);
		    }
		} catch (Exception ex) {
			response.sendRedirect("login?err=fail");
			ex.printStackTrace();
		}
			   
	}
}


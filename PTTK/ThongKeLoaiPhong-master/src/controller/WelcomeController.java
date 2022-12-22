package controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/gdChinhQL"})
public class WelcomeController extends HttpServlet {

	public WelcomeController() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("view/gdChinhQL.jsp");
		rd.forward(req, resp);
	}
}

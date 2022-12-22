package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALQuyenHan;
import QuanLyThuVien.model.DAL.Object.QuyenHan;

public class BLLQuyenHan  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private DALQuyenHan dal_quyenHan;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_quyenHan = new DALQuyenHan(jdbcURL);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/QuyenHanQuanLy/insert":
				insertQuyenHan(request, response);
				break;
			case "/QuyenHanQuanLy/delete":
				deleteQuyenHan(request, response);
				break;
			case "/QuyenHanQuanLy/update":
				updateQuyenHan(request, response);
				break;
			default: // list
				listQuyenHan(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
}

	private void listQuyenHan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void updateQuyenHan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		QuyenHan record = new QuyenHan();

		record.setIdQuyen(Integer.parseInt(request.getParameter("txtidQuyen")));
		record.setTenQuyen(request.getParameter("txtTenQuyen"));

		try {
			dal_quyenHan.Update(record);
			response.sendRedirect("/QuanLyThuVien/QuyenHanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void deleteQuyenHan(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maQuyenHan"));

		try {
			dal_quyenHan.Delete(code);
			response.sendRedirect("/QuanLyThuVien/QuyenHanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void insertQuyenHan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		QuyenHan record = new QuyenHan();
		record.setIdQuyen(Integer.parseInt(request.getParameter("txtidQuyen")));
		record.setTenQuyen(request.getParameter("txtTenQuyen"));
		try {
			dal_quyenHan.Add(record);
			response.sendRedirect("/QuanLyThuVien/QuyenHanQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	}

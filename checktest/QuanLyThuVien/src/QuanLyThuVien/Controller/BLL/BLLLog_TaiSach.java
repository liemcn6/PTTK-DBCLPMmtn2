package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALLog_TaiSach;
import QuanLyThuVien.model.DAL.Object.Log_TaiSach;

public class BLLLog_TaiSach  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALLog_TaiSach dal_log_TaiSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_log_TaiSach = new DALLog_TaiSach(jdbcURL);
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
			case "/Log_TaiSachQuanLy/insert":
				insertLog_TaiSach(request, response);
				break;
			case "/Log_TaiSachQuanLy/delete":
				deleteLog_TaiSach(request, response);
				break;
			case "/Log_TaiSachQuanLy/update":
				updateLog_TaiSach(request, response);
				break;
			default: // list
				listLog_TaiSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listLog_TaiSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Log_TaiSach> listLog_TaiSach = new ArrayList<Log_TaiSach>();

		try {
			listLog_TaiSach = dal_log_TaiSach.getAll();
			request.setAttribute("listLog_TaiSach", listLog_TaiSach);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Log_TaiSachQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private void updateLog_TaiSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Log_TaiSach record = new Log_TaiSach();

		record.setId_LogTaiSach(Integer.parseInt(request.getParameter("txtidLog_TaiSach")));
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		//record.setNgayTaiVe(request.getParameter("txtNgayTaiVe")); --sai biến date--
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txMaCuonSach")));

		try {
			dal_log_TaiSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/Log_TaiSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}

	private void deleteLog_TaiSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maLog_TaiSach"));

		try {
			dal_log_TaiSach.Delete(code);
			response.sendRedirect("/QuanLyThuVien/Log_TaiSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void insertLog_TaiSach(HttpServletRequest request, HttpServletResponse response)	
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		Log_TaiSach record = new Log_TaiSach();


		record.setId_LogTaiSach(Integer.parseInt(request.getParameter("txtidLog_TaiSach")));
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		//record.setNgayTaiVe(request.getParameter("txtNgayTaiVe"));--sai biến date--
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txMaCuonSach")));

		try {
			dal_log_TaiSach.Add(record);
			response.sendRedirect("/QuanLyThuVien/Log_TaiSachQuanLy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	}

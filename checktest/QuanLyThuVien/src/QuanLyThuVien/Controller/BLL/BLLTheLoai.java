package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTheLoai;
import QuanLyThuVien.model.DAL.Object.TheLoai;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

@WebServlet(name = "TheLoaiQuanLy", urlPatterns = { "/TheLoaiQuanLy", "/TheLoaiQuanLy/delete", "/TheLoaiQuanLy/list",
		"/TheLoaiQuanLy/insert", "/TheLoaiQuanLy/update", "/TheLoaiQuanLy/edit" })
public class BLLTheLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;
	private DALTheLoai dal_theLoai;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_theLoai = new DALTheLoai(jdbcURL);
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
			case "/TheLoaiQuanLy/insert":
				insertTheLoai(request, response);
				break;
			case "/TheLoaiQuanLy/delete":
				deleteTheLoai(request, response);
				break;
			case "/TheLoaiQuanLy/update":
				updateTheLoai(request, response);
				break;
			case "/TheLoaiQuanLy/edit":
				editTheLoai(request, response);
			default: // list
				listTheLoai(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editTheLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int code = Integer.parseInt(request.getParameter("maTheLoai"));

		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();

		try {
			listTheLoai = dal_theLoai.getAll();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("listTheLoai", listTheLoai);

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			TheLoai theLoai = new TheLoai();
			theLoai = dal_theLoai.GetOne(code);
			request.setAttribute("theLoaiIU", theLoai);
			request.getRequestDispatcher("/TheLoaiQuanLy" + "?pages=" + pages).forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listTheLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();

		int pages = 0, minRes = 0, maxRes = 0, total = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}
		int maTheLoai = 0;
		if (request.getParameter("maTheLoai") != null) {
			maTheLoai = (int) Integer.parseInt(request.getParameter("maTheLoai"));
		}
		String search = "default";
		if (request.getParameter("txtSearch") != null) {
			search = request.getParameter("txtSearch");
		}
		String sort = "default";
		if (request.getParameter("selectSort") != null) {
			sort = request.getParameter("selectSort");
		}
		try {
			total = dal_theLoai.getSoLuongPhanTu(search);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		if (total <= soDongTrenMotTrang) {
			minRes = 1;
			maxRes = total;
		} else {
			minRes = (pages - 1) * soDongTrenMotTrang + 1;
			maxRes = minRes + soDongTrenMotTrang - 1;
		}

		int soTrang = 0;
		if (total % soDongTrenMotTrang == 0) {
			soTrang = (int) (total / soDongTrenMotTrang);
		} else {
			soTrang = (int) (total / soDongTrenMotTrang) + 1;
		}
		int maxCode = 0;

		try {
			maxCode = dal_theLoai.maxCode("TheLoai");
			listTheLoai = dal_theLoai.getAllPhanTrang(minRes, maxRes, sort, search);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			RequestDispatcher dispatcher = request.getRequestDispatcher("TheLoaiQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateTheLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheLoai record = new TheLoai();

		record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
		record.setTenTheLoai((request.getParameter("txtTenTheLoai")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_theLoai.Update(record);
			response.sendRedirect("/QuanLyThuVien/TheLoaiQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteTheLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int code = Integer.parseInt(request.getParameter("maTheLoai"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		int total = 0;
		try {
			total = dal_theLoai.getSoLuongPhanTu("default");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		int soTrang = 0;
		if (total % soDongTrenMotTrang == 0) {
			soTrang = (int) (total / soDongTrenMotTrang);
		} else {
			soTrang = (int) (total / soDongTrenMotTrang) + 1;
		}

		if (pages > soTrang)
			pages = soTrang;

		try {
			dal_theLoai.Delete(code);
			response.sendRedirect("/QuanLyThuVien/TheLoaiQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertTheLoai(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheLoai record = new TheLoai();

		record.setMaTheLoai(Integer.parseInt(request.getParameter("txtMaTheLoai")));
		record.setTenTheLoai(request.getParameter("txtTenTheLoai"));

		try {
			dal_theLoai.Add(record);

			int total = 0;
			try {
				total = dal_theLoai.getSoLuongPhanTu("default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/TheLoaiQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

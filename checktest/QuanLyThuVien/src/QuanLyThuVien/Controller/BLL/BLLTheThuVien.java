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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALTheThuVien;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.TheThuVien;

@WebServlet(name = "TheThuVienQuanLy", urlPatterns = { "/TheThuVienQuanLy", "/TheThuVienQuanLy/delete",
		"/TheThuVienQuanLy/list", "/TheThuVienQuanLy/insert", "/TheThuVienQuanLy/update", "/TheThuVienQuanLy/edit" })
public class BLLTheThuVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 5;
	private DALTheThuVien dal_theThuVien;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_theThuVien = new DALTheThuVien(jdbcURL);
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
			case "/TheThuVienQuanLy/insert":
				insertTheThuVien(request, response);
				break;
			case "/TheThuVienQuanLy/delete":
				deleteTheThuVien(request, response);
				break;
			case "/TheThuVienQuanLy/edit":
				editTheThuVien(request, response);
				break;

			case "/TheThuVienQuanLy/update":
				updateTheThuVien(request, response);
				break;
			default: // list
				listTheThuVien(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maThe"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			TheThuVien theThuVien = new TheThuVien();
			theThuVien = dal_theThuVien.GetOne(code);
			request.setAttribute("theThuVienIU", theThuVien);
			request.getRequestDispatcher("/TheThuVienQuanLy" + "?pages=" + pages).forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<TheThuVien> listTheThuVien = new ArrayList<TheThuVien>();

		int pages = 0, minRes = 0, maxRes = 0, total = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
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
			total = dal_theThuVien.getSoLuongPhanTu(0, search);
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

			maxCode = dal_theThuVien.maxCode("TheThuVien");

			listTheThuVien = dal_theThuVien.getAllPhanTrang(minRes, maxRes, 0, sort, search);

			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listTheThuVien", listTheThuVien);

			RequestDispatcher dispatcher = request.getRequestDispatcher("TheThuVienQuanLy.jsp");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheThuVien record = new TheThuVien();

		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		if (request.getParameter("dateNgayCapThe") != null) {
			try {
				Date NgayCapThe = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayCapThe"));
				record.setNgayCapThe(new java.sql.Date(NgayCapThe.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("dateNgayHetHan") != null) {
			try {
				Date NgayHetHan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayHetHan"));
				record.setNgayHetHan(new java.sql.Date(NgayHetHan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoSachDuocMuon(Integer.parseInt(request.getParameter("numberSoSachDuocMuon")));
		record.setSoSachDangMuon(Integer.parseInt(request.getParameter("numberSoSachDangMuon")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_theThuVien.Update(record);
			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maThe"));

		try {
			dal_theThuVien.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_theThuVien.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertTheThuVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TheThuVien record = new TheThuVien();

		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		if (request.getParameter("dateNgayCapThe") != null) {
			try {
				Date NgayCapThe = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayCapThe"));
				record.setNgayCapThe(new java.sql.Date(NgayCapThe.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("dateNgayHetHan") != null) {
			try {
				Date NgayHetHan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayHetHan"));
				record.setNgayHetHan(new java.sql.Date(NgayHetHan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setSoSachDuocMuon(Integer.parseInt(request.getParameter("numberSoSachDuocMuon")));
		record.setSoSachDangMuon(Integer.parseInt(request.getParameter("numberSoSachDangMuon")));

		try {
			dal_theThuVien.Add(record);

			int total = 0;
			try {
				total = dal_theThuVien.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/TheThuVienQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

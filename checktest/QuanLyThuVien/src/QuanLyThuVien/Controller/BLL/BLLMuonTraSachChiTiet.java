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

import QuanLyThuVien.model.DAL.DALMuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;

@WebServlet(name = "MuonTraSachChiTiet", urlPatterns = { "/MuonTraSachChiTiet", "/MuonTraSachChiTiet/delete",
		"/MuonTraSachChiTiet/list", "/MuonTraSachChiTiet/insert", "/MuonTraSachChiTiet/update",
		"/MuonTraSachChiTiet/edit" })
public class BLLMuonTraSachChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;
	private DALMuonTraSachChiTiet dal_muonTraSachChiTiet;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_muonTraSachChiTiet = new DALMuonTraSachChiTiet(jdbcURL);
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
			case "/MuonTraSachChiTiet/insert":
				insertMuonTraSachChiTiet(request, response);
				break;
			case "/MuonTraSachChiTiet/delete":
				deleteMuonTraSachChiTiet(request, response);
				break;
			case "/MuonTraSachChiTiet/edit":
				editMuonTraSachChiTiet(request, response);
				break;
			case "/MuonTraSachChiTiet/update":
				updateMuonTraSachChiTiet(request, response);
				break;
			default: // list
				listMuonTraSachChiTiet(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maMuonSach"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
			muonTraSachChiTiet = dal_muonTraSachChiTiet.GetOne(code);
			request.setAttribute("muonTraSachChiTietIU", muonTraSachChiTiet);
			request.getRequestDispatcher("/MuonTraSachChiTiet" + "?pages=" + pages).forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<MuonTraSachChiTiet> listMuonTraSachChiTiet = new ArrayList<MuonTraSachChiTiet>();

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
			total = dal_muonTraSachChiTiet.getSoLuongPhanTu(0, search);
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
			maxCode = dal_muonTraSachChiTiet.maxCode("muonTraSachChiTiet");
			listMuonTraSachChiTiet = dal_muonTraSachChiTiet.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listMuonTraSachChiTiet", listMuonTraSachChiTiet);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MuonTraSachChiTiet.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSachChiTiet record = new MuonTraSachChiTiet();
		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		if (request.getParameter("dateNgayMuon") != null) {
			try {
				Date ngayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayMuon"));
				record.setNgayMuon(new java.sql.Date(ngayMuon.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("dateNgayHenTra") != null) {
			try {
				Date ngayHenTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayHenTra"));
				record.setNgayHenTra(new java.sql.Date(ngayHenTra.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("dateNgayTra") != null) {
			try {
				Date ngayTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayTra"));
				record.setNgayTra(new java.sql.Date(ngayTra.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		record.setTrangThai(request.getParameter("selectTrangThai"));
		record.setSoLuong(Integer.parseInt(request.getParameter("numberSoLuong")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_muonTraSachChiTiet.Update(record);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachChiTiet" + "?pages=" + pages);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maMuonSach"));

		try {
			dal_muonTraSachChiTiet.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_muonTraSachChiTiet.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/MuonTraSachChiTiet" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertMuonTraSachChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSachChiTiet record = new MuonTraSachChiTiet();
		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		if (request.getParameter("dateNgayMuon") != null) {
			try {
				Date ngayMuon = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayMuon"));
				record.setNgayMuon(new java.sql.Date(ngayMuon.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (request.getParameter("dateNgayHenTra") != null) {
			try {
				Date ngayHenTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayHenTra"));
				record.setNgayHenTra(new java.sql.Date(ngayHenTra.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("dateNgayTra") != null) {
			try {
				Date ngayTra = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayTra"));
				record.setNgayTra(new java.sql.Date(ngayTra.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		record.setTrangThai(request.getParameter("selectTrangThai"));
		record.setSoLuong(Integer.parseInt(request.getParameter("numberSoLuong")));

		try {
			dal_muonTraSachChiTiet.Add(record);

			// Sau khi insert sẽ về pages cuối
			int total = 0;
			try {
				total = dal_muonTraSachChiTiet.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/MuonTraSachChiTiet" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

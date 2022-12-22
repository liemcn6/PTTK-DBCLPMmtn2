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

import QuanLyThuVien.model.DAL.DALMuonTraSach;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

@WebServlet(name = "MuonTraSachQuanLy", urlPatterns = { "/MuonTraSachQuanLy", "/MuonTraSachQuanLy/delete",
		"/MuonTraSachQuanLy/list", "/MuonTraSachQuanLy/insert", "/MuonTraSachQuanLy/update",
		"/MuonTraSachQuanLy/edit" })
public class BLLMuonTraSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;
	private DALMuonTraSach dal_muonTraSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_muonTraSach = new DALMuonTraSach(jdbcURL);
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
			case "/MuonTraSachQuanLy/insert":
				insertMuonTraSach(request, response);
				break;
			case "/MuonTraSachQuanLy/delete":
				deleteMuonTraSach(request, response);
				break;
			case "/MuonTraSachQuanLy/update":
				updateMuonTraSach(request, response);
				break;
			case "/MuonTraSachQuanLy/edit":
				editMuonTraSach(request, response);
				break;
			default: // list
				listMuonTraSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void deleteMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maMuonSach"));

		try {
			dal_muonTraSach.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_muonTraSach.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<MuonTraSach> listMuonTraSach = new ArrayList<MuonTraSach>();

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
			total = dal_muonTraSach.getSoLuongPhanTu(0, search);
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
			maxCode = dal_muonTraSach.maxCode("MuonTraSach");
			listMuonTraSach = dal_muonTraSach.getAllPhanTrang(minRes, maxRes, 0, sort, search);


			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listMuonTraSach", listMuonTraSach);
			RequestDispatcher dispatcher = request.getRequestDispatcher("MuonTraSachQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSach record = new MuonTraSach();

		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setTienDatCoc(request.getParameter("numberTienDatCoc"));
		record.setGhiChu(request.getParameter("txtGhiChu"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_muonTraSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void editMuonTraSach(HttpServletRequest request, HttpServletResponse response)
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
			MuonTraSach muonTraSach = new MuonTraSach();
			muonTraSach = dal_muonTraSach.GetOne(code);
			request.setAttribute("muonTraSachIU", muonTraSach);
			request.getRequestDispatcher("/MuonTraSachQuanLy" + "?pages=" + pages).forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertMuonTraSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		MuonTraSach record = new MuonTraSach();

		record.setMaMuonSach(Integer.parseInt(request.getParameter("txtMaMuonSach")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		record.setTienDatCoc(request.getParameter("numberTienDatCoc"));
		record.setGhiChu(request.getParameter("txtGhiChu"));

		try {
			dal_muonTraSach.Add(record);

			// Sau khi insert sẽ về pages cuối
			int total = 0;
			try {
				total = dal_muonTraSach.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			// response.sendRedirect("/QuanLyThuVien/MuonTraSachQuanLy" + "?pages=" +
			// soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

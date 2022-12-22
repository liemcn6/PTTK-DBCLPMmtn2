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

import QuanLyThuVien.model.DAL.DALCuonSach;
import QuanLyThuVien.model.DAL.Object.CuonSach;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

@WebServlet(name = "CuonSachQuanLy", urlPatterns = { "/CuonSachQuanLy", "/CuonSachQuanLy/delete",
		"/CuonSachQuanLy/list", "/CuonSachQuanLy/insert", "/CuonSachQuanLy/update", "/CuonSachQuanLy/edit" })
public class BLLCuonSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 5;

	private DALCuonSach dal_cuonSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_cuonSach = new DALCuonSach(jdbcURL);
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
			case "/CuonSachQuanLy/insert":
				insertCuonSach(request, response);
				break;
			case "/CuonSachQuanLy/delete":
				deleteCuonSach(request, response);
				break;
			case "/CuonSachQuanLy/update":
				updateCuonSach(request, response);
				break;
			case "/CuonSachQuanLy/edit":
				editCuonSach(request, response);
				break;
			default: // list
				listCuonSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		int code = Integer.parseInt(request.getParameter("maCuonSach"));

		try {
			CuonSach cuonSach = new CuonSach();
			cuonSach = dal_cuonSach.GetOne(code);
			request.setAttribute("cuonSachIU", cuonSach);
			request.getRequestDispatcher("/QuanLyThuVien/CuonSachQuanLy" + "?pages=" + pages).forward(request,
					response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<CuonSach> listCuonSach = new ArrayList<CuonSach>();

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
			total = dal_cuonSach.getSoLuongPhanTu(0, search);
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
			maxCode = dal_cuonSach.maxCode("cuonSach");
			listCuonSach = dal_cuonSach.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listCuonSach", listCuonSach);

			request.getRequestDispatcher("CuonSachQuanLy.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		// Đọc được tiếng Việt
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// Tạo mới record để add vào CSDL
		CuonSach record = new CuonSach();

		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		record.setViTri(request.getParameter("txtViTri"));
		record.setTrangThai(request.getParameter("txtTrangThai"));

		// Thêm và chuyển hướng đến nơi hiển thị
		try {
			dal_cuonSach.Add(record);

			// Sau khi insert sẽ về pages cuối
			int total = 0;
			try {
				total = dal_cuonSach.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		CuonSach record = new CuonSach();

		record.setMaCuonSach(Integer.parseInt(request.getParameter("txtMaCuonSach")));
		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		record.setViTri(request.getParameter("txtViTri"));
		record.setTrangThai(request.getParameter("txtTrangThai"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_cuonSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteCuonSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maCuonSach"));

		try {
			dal_cuonSach.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_cuonSach.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/CuonSachQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}

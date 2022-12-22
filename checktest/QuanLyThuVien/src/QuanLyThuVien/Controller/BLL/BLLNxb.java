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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALNxb;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.DocGia;
import QuanLyThuVien.model.DAL.Object.Nxb;

@WebServlet(name = "NxbQuanLy", urlPatterns = { "/NxbQuanLy", "/NxbQuanLy/delete", "/NxbQuanLy/list",
		"/NxbQuanLy/insert", "/NxbQuanLy/update", "/NxbQuanLy/edit", "/NxbDanhSach", "/NxbNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLNxb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;
	private DALNxb dal_nxb;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_nxb = new DALNxb(jdbcURL);
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
			case "/NxbQuanLy/insert":
				insertNxb(request, response);
				break;
			case "/NxbQuanLy/delete":
				deleteNxb(request, response);
				break;
			case "/NxbQuanLy/edit":
				editNxb(request, response);
				break;
			case "/NxbQuanLy/update":
				updateNxb(request, response);
				break;
			default: // list
				listNxb(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editNxb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maNxb"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			Nxb nxb = new Nxb();
			nxb = dal_nxb.GetOne(code);
			request.setAttribute("nxbIU", nxb);
			request.getRequestDispatcher("/NxbQuanLy" + "?pages=" + pages).forward(request, response);
			;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updateNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Nxb record = new Nxb();
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setTenNxb(request.getParameter("txtTenNxb"));
		record.setGhiChu(request.getParameter("txtGhiChu"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_nxb.Update(record);
			response.sendRedirect("/QuanLyThuVien/NxbQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maNxb"));

		try {
			dal_nxb.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_nxb.getSoLuongPhanTu("default");
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

			response.sendRedirect("/QuanLyThuVien/NxbQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertNxb(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Nxb record = new Nxb();
		record.setMaNxb(Integer.parseInt(request.getParameter("txtMaNxb")));
		record.setTenNxb(request.getParameter("txtTenNxb"));
		record.setGhiChu(request.getParameter("txtGhiChu"));
		try {
			dal_nxb.Add(record);

			int total = 0;
			try {
				total = dal_nxb.getSoLuongPhanTu("default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/NxbQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listNxb(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<Nxb> listNxb = new ArrayList<Nxb>();

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
			total = dal_nxb.getSoLuongPhanTu(search);
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
			maxCode = dal_nxb.maxCode("Nxb");
			listNxb = dal_nxb.getAllPhanTrang(minRes, maxRes, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listNxb", listNxb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("NxbQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

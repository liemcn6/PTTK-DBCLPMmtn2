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

import QuanLyThuVien.model.DAL.DALDocGia;
import QuanLyThuVien.model.DAL.Object.DocGia;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

@WebServlet(name = "DocGiaQuanLy", urlPatterns = { "/DocGiaQuanLy", "/DocGiaQuanLy/delete", "/DocGiaQuanLy/list",
		"/DocGiaQuanLy/insert", "/DocGiaQuanLy/update", "/DocGiaQuanLy/edit", "/DocGiaDanhSach", "/DocGiaNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLDocGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 5;
	private DALDocGia dal_docGia;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_docGia = new DALDocGia(jdbcURL);
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
			case "/DocGiaQuanLy/insert":
				insertDocGia(request, response);
				break;
			case "/DocGiaQuanLy/delete":
				deleteDocGia(request, response);
				break;
			case "/DocGiaQuanLy/update":
				updateDocGia(request, response);
				break;
			case "/DocGiaQuanLy/edit":
				editDocGia(request, response);
				break;
			default: // list
				listDocGia(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		
		int code = Integer.parseInt(request.getParameter("maDocGia"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		
		try {
			DocGia docGia = new DocGia();
			docGia = dal_docGia.GetOne(code);
			request.setAttribute("docGiaIU", docGia);
			request.getRequestDispatcher("/DocGiaQuanLy" + "?pages=" + pages).forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DocGia record = new DocGia();

		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		record.setTenDocGia(request.getParameter("txtTenDocGia"));
		record.setGioiTinh(request.getParameter("txtGioiTinh"));
		if (request.getParameter("dateNgaySinh") != null) {
			try {
				Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgaySinh"));
				record.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setDiaChi(request.getParameter("txtDiaChi"));
		record.setEmail(request.getParameter("txtEmail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_docGia.Update(record);
			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maDocGia"));

		try {
			dal_docGia.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_docGia.getSoLuongPhanTu("default");
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

			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DocGia record = new DocGia();
		record.setMaDocGia(Integer.parseInt(request.getParameter("txtMaDocGia")));
		record.setTenDocGia(request.getParameter("txtTenDocGia"));
		record.setGioiTinh(request.getParameter("txtGioiTinh"));
		if (request.getParameter("dateNgaySinh") != null) {
			try {
				Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgaySinh"));
				record.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setDiaChi(request.getParameter("txtDiaChi"));
		record.setEmail(request.getParameter("txtEmail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		try {
			dal_docGia.Add(record);

			// Sau khi insert sẽ về pages cuối
			int total = 0;
			try {
				total = dal_docGia.getSoLuongPhanTu("default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/DocGiaQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listDocGia(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<DocGia> listDocGia = new ArrayList<DocGia>();

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
			total = dal_docGia.getSoLuongPhanTu(search);
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
			maxCode = dal_docGia.maxCode("docGia");
			listDocGia = dal_docGia.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listDocGia", listDocGia);

			RequestDispatcher dispatcher = request.getRequestDispatcher("DocGiaQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.PagesPerMinute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import QuanLyThuVien.model.DAL.DALDauSach;
import QuanLyThuVien.model.DAL.DALNxb;
import QuanLyThuVien.model.DAL.DALTheLoai;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;

/**
 * BLLdal_dauSach.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author IT100soDongTrenMotTrang
 */
@WebServlet(name = "DauSachQuanLy", urlPatterns = { "/DauSachQuanLy", "/DauSachQuanLy/delete", "/DauSachQuanLy/list",
		"/DauSachQuanLy/insert", "/DauSachQuanLy/update", "/DauSachQuanLy/edit", "/DauSachDanhSach",
		"/DauSachNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLDauSach extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;

	private DALDauSach dal_dauSach;
	private DALNxb dal_nxb;
	private DALTheLoai dal_theLoai;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DALDauSach(jdbcURL);
			dal_nxb = new DALNxb(jdbcURL);
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
		try {
			switch (action) {
			case "/DauSachQuanLy/insert":
				insertDauSach(request, response);
				break;
			case "/DauSachQuanLy/delete":
				deleteDauSach(request, response);
				break;
			case "/DauSachQuanLy/update":
				updateDauSach(request, response);
				break;
			case "/DauSachQuanLy/edit":
				editDauSach(request, response);
				break;
			case "/DauSachDanhSach":
				listDauSachDanhSachPhanTrang(request, response);
				break;
			case "/DauSachNoiDung":
				dauSachNoiDung(request, response);
				break;
			default:
				listDauSach(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		List<DauSach> listDauSach = new ArrayList<DauSach>();

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
		String loaiSach = "eBooks";
		if (request.getParameter("selectLoaiSach") != null) {
			loaiSach = request.getParameter("selectLoaiSach");
		}
		try {
			total = dal_dauSach.getSoLuongPhanTu(loaiSach, 0, search);
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
			maxCode = dal_dauSach.maxCode("DauSach");
			listDauSach = dal_dauSach.getAllPhanTrang(loaiSach, minRes, maxRes, 0, sort, search);
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("selectLoaiSach", loaiSach);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listDauSach", listDauSach);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("listNxb", listNxb);

			request.getRequestDispatcher("DauSachQuanLy.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listDauSachDanhSachPhanTrang(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		List<DauSach> listDauSach = new ArrayList<DauSach>();

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
		String loaiSach = "eBooks";
		/*
		 * if (request.getParameter("selectLoaiSach") != null) { loaiSach =
		 * request.getParameter("selectLoaiSach"); }
		 */
		try {
			total = dal_dauSach.getSoLuongPhanTu(loaiSach, maTheLoai, search);
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
			maxCode = dal_dauSach.maxCode("DauSach");
			listDauSach = dal_dauSach.getAllPhanTrang(loaiSach, minRes, maxRes, maTheLoai, sort, search);
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listDauSach", listDauSach);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("listNxb", listNxb);

			request.getRequestDispatcher("DauSachDanhSach.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listDauSachDanhSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		List<DauSach> listDauSach = new ArrayList<DauSach>();
		try {
			listDauSach = dal_dauSach.getAll();
			request.setAttribute("listDauSach", listDauSach);

			request.getRequestDispatcher("DauSachDanhSach.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		// Chuyển cái tên của NXB và Thể loại từ Parameter txtMaNxb và txtMaTheLoai
		// thành số tương ứng
		try {
			record.setMaNxb((dal_dauSach.getMaNxb(request.getParameter("txtTenNxb"))).getMaNxb());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			record.setMaTheLoai((dal_dauSach.getMaTheLoai(request.getParameter("txtTenTheLoai"))).getMaTheLoai());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAnhBia(is);
						i++;
					} else if (i == 1) {
						record.setAnhTacGia(is);
						i++;
					} else if (i == 2) {
						record.setFilePDF(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNgonNgu"));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Integer.parseInt(request.getParameter("numberGia")));
		record.setLoaiSach(request.getParameter("selectLoaiSach"));

		try {
			dal_dauSach.Add(record);

			// Sau khi insert sẽ về pages cuối
			int total = 0;
			try {
				total = dal_dauSach.getSoLuongPhanTu(request.getParameter("selectLoaiSach"), 0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy" + "?pages=" + soTrang + "&selectLoaiSach="
					+ request.getParameter("selectLoaiSach"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		DauSach record = new DauSach();

		record.setMaDauSach(Integer.parseInt(request.getParameter("txtMaDauSach")));
		// Chuyển cái tên của NXB và Thể loại từ Parameter txtMaNxb và txtMaTheLoai
		// thành số tương ứng
		try {
			record.setMaNxb((dal_dauSach.getMaNxb(request.getParameter("txtTenNxb"))).getMaNxb());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			record.setMaTheLoai((dal_dauSach.getMaTheLoai(request.getParameter("txtTenTheLoai"))).getMaTheLoai());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		record.setTenSach(request.getParameter("txtTenSach"));
		record.setMoTa(request.getParameter("txtMoTa"));
		record.setTacGia(request.getParameter("txtTacGia"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAnhBia(is);
						i++;
					} else if (i == 1) {
						record.setAnhTacGia(is);
						i++;
					} else if (i == 2) {
						record.setFilePDF(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		if (request.getParameter("dateNamXuatBan") != null) {
			try {
				Date namXuatBan = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNamXuatBan"));
				record.setNamXuatBan(new java.sql.Date(namXuatBan.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setNgonNgu(request.getParameter("txtNgonNgu"));
		record.setTrangThai(request.getParameter("txtTrangThai"));
		record.setGia(Integer.parseInt(request.getParameter("numberGia")));
		record.setLoaiSach(request.getParameter("selectLoaiSach"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_dauSach.Update(record);
			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy" + "?pages=" + pages + "&selectLoaiSach="
					+ request.getParameter("selectLoaiSach"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void editDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		List<Nxb> listNxb = new ArrayList<Nxb>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		try {
			listNxb = dal_nxb.getAll();
			listTheLoai = dal_theLoai.getAll();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		request.setAttribute("listTheLoai", listTheLoai);
		request.setAttribute("listNxb", listNxb);

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			DauSach dauSach = new DauSach();
			dauSach = dal_dauSach.GetOne(code);
			request.setAttribute("dauSachIU", dauSach);
			request.getRequestDispatcher(
					"/DauSachQuanLy" + "?pages=" + pages + "&selectLoaiSach=" + request.getParameter("selectLoaiSach"))
					.forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void dauSachNoiDung(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		try {
			DauSach dauSach = new DauSach();
			dauSach = dal_dauSach.GetOne(code);
			request.setAttribute("dauSachDetail", dauSach);
			request.getRequestDispatcher("DauSachNoiDung.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteDauSach(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maDauSach"));

		String loaiSach = "eBooks";
		if (request.getParameter("selectLoaiSach") != null) {
			loaiSach = request.getParameter("selectLoaiSach");
		}

		try {
			dal_dauSach.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_dauSach.getSoLuongPhanTu(loaiSach, 0, "default");
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

			response.sendRedirect("/QuanLyThuVien/DauSachQuanLy" + "?pages=" + pages + "&selectLoaiSach="
					+ request.getParameter("selectLoaiSach"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}

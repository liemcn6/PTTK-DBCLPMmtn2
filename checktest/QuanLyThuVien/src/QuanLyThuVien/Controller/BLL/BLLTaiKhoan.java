package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.Part;

import QuanLyThuVien.model.DAL.DALQuyenHan;
import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;
import QuanLyThuVien.model.DAL.Object.QuyenHan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;
import QuanLyThuVien.model.DAL.Object.ThongBao;

@WebServlet(name = "TaiKhoanQuanLy", urlPatterns = { "/TaiKhoanQuanLy", "/TaiKhoanQuanLy/delete",
		"/TaiKhoanQuanLy/list", "/TaiKhoanQuanLy/insert", "/TaiKhoanQuanLy/update", "/TaiKhoanQuanLy/edit" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 4;
	private DALTaiKhoan dal_taiKhoan;
	private DALQuyenHan dal_quyenHan;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_taiKhoan = new DALTaiKhoan(jdbcURL);
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
		try {
			switch (action) {
			case "/TaiKhoanQuanLy/insert":
				insertTaiKhoan(request, response);
				break;
			case "/TaiKhoanQuanLy/delete":
				deleteTaiKhoan(request, response);
				break;
			case "/TaiKhoanQuanLy/update":
				updateTaiKhoan(request, response);
				break;
			case "/TaiKhoanQuanLy/edit":
				editTaiKhoan(request, response);
				break;
			default: // list
				listTaiKhoan(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int code = Integer.parseInt(request.getParameter("maTaiKhoan"));
		List<QuyenHan> listQuyenHan = new ArrayList<QuyenHan>();

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan = dal_taiKhoan.GetOne(code);
			listQuyenHan = dal_quyenHan.getAll();
			request.setAttribute("taiKhoanIU", taiKhoan);
			request.setAttribute("listQuyenHan", listQuyenHan);

			request.getRequestDispatcher("/TaiKhoanQuanLy" + "?pages=" + pages).forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<TaiKhoan> listtaiKhoan = new ArrayList<TaiKhoan>();
		List<QuyenHan> listQuyenHan = new ArrayList<QuyenHan>();

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
			total = dal_taiKhoan.getSoLuongPhanTu(0, search);
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
			maxCode = dal_taiKhoan.maxCode("TaiKhoan");
			listtaiKhoan = dal_taiKhoan.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			listQuyenHan = dal_quyenHan.getAll();
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listTaiKhoan", listtaiKhoan);
			request.setAttribute("listQuyenHan", listQuyenHan);

			RequestDispatcher dispatcher = request.getRequestDispatcher("TaiKhoanQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TaiKhoan record = new TaiKhoan();
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		record.seteMail(request.getParameter("txteMail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		record.setMatKhau(request.getParameter("txtMatKhau"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAvartarInputStream(is);
						i++;
					} else {
						record.setAvartarInputStream(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}

		try {
			record.setIdQuyen(dal_taiKhoan.getIDQuyen(request.getParameter("txtTenQuyen")).getIdQuyen());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_taiKhoan.Update(record);
			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maTaiKhoan"));

		try {
			dal_taiKhoan.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_taiKhoan.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void insertTaiKhoan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		TaiKhoan record = new TaiKhoan();
		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));
		record.seteMail(request.getParameter("txteMail"));
		record.setSoDienThoai(request.getParameter("txtSoDienThoai"));
		record.setMatKhau(request.getParameter("txtMatKhau"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setAvartarInputStream(is);
						i++;
					} else {
						record.setAvartarInputStream(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}

		try {
			record.setIdQuyen(dal_taiKhoan.getIDQuyen(request.getParameter("txtTenQuyen")).getIdQuyen());
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}

		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));

		try {
			dal_taiKhoan.Add(record);

			int total = 0;
			try {
				total = dal_taiKhoan.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/TaiKhoanQuanLy" + "?pages=" + soTrang);
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

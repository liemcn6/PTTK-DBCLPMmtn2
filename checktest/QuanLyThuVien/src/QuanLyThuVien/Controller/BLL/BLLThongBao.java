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

import QuanLyThuVien.model.DAL.DALThongBao;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;
import QuanLyThuVien.model.DAL.Object.ThongBao;

@WebServlet(name = "ThongBaoQuanLy", urlPatterns = { "/ThongBaoQuanLy", "/ThongBaoQuanLy/delete",
		"/ThongBaoQuanLy/list", "/ThongBaoQuanLy/insert", "/ThongBaoQuanLy/update", "/ThongBaoQuanLy/edit",
		"/ThongBaoDanhSach", "/ThongBaoNoiDung" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLThongBao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 4;
	private DALThongBao dal_thongBao;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_thongBao = new DALThongBao(jdbcURL);
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
			case "/ThongBaoQuanLy/insert":
				insertThongBao(request, response);
				break;
			case "/ThongBaoQuanLy/delete":
				deleteThongBao(request, response);
				break;
			case "/ThongBaoQuanLy/update":
				updateThongBao(request, response);
				break;
			case "/ThongBaoQuanLy/edit":
				editThongBao(request, response);
				break;
			default: // list
				listThongBao(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int code = Integer.parseInt(request.getParameter("maThongBao"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			ThongBao thongBao = new ThongBao();
			thongBao = dal_thongBao.GetOne(code);
			request.setAttribute("thongBaoIU", thongBao);
			request.getRequestDispatcher("/ThongBaoQuanLy" + "?pages=" + pages).forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void listThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<ThongBao> listThongBao = new ArrayList<ThongBao>();

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
			total = dal_thongBao.getSoLuongPhanTu(0, search);
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
			maxCode = dal_thongBao.maxCode("ThongBao");

			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);

			listThongBao = dal_thongBao.getAllPhanTrang(minRes, maxRes, 0, sort, search);
			request.setAttribute("listThongBao", listThongBao);

			RequestDispatcher dispatcher = request.getRequestDispatcher("ThongBaoQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void updateThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ThongBao record = new ThongBao();
		record.setIdThongBao(Integer.parseInt(request.getParameter("txtIdThongBao")));
		record.setTenThongBao(request.getParameter("txtTenThongBao"));
		record.setNoiDung(request.getParameter("txtNoiDung"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setHinhAnhInputStream(is);
						i++;
					} else {
						record.setHinhAnhInputStream(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}

		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			dal_thongBao.Update(record);
			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deleteThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("maThongBao"));

		try {
			dal_thongBao.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_thongBao.getSoLuongPhanTu(0, "default");
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

			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertThongBao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ThongBao record = new ThongBao();
		record.setIdThongBao(Integer.parseInt(request.getParameter("txtIdThongBao")));
		record.setTenThongBao(request.getParameter("txtTenThongBao"));
		record.setNoiDung(request.getParameter("txtNoiDung"));
		int i = 0;
		try {
			for (Part part : request.getParts()) {
				String fileName = extractFileName(part);
				if (fileName != null && fileName.length() > 0) {
					InputStream is = part.getInputStream();
					if (i == 0) {
						record.setHinhAnhInputStream(is);
						i++;
					} else {
						record.setHinhAnhInputStream(is);
						i++;
					}
				}
			}
		} catch (ServletException e1) {
			e1.printStackTrace();
		}

		record.setMaTaiKhoan(Integer.parseInt(request.getParameter("txtMaTaiKhoan")));

		try {
			dal_thongBao.Add(record);

			int total = 0;
			try {
				total = dal_thongBao.getSoLuongPhanTu(0, "default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/ThongBaoQuanLy" + "?pages=" + soTrang);
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

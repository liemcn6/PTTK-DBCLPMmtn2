package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALPhieuPhat;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

@WebServlet(name = "PhieuPhatQuanLy", urlPatterns = { "/PhieuPhatQuanLy", "/PhieuPhatQuanLy/delete",
		"/PhieuPhatQuanLy/list", "/PhieuPhatQuanLy/insert", "/PhieuPhatQuanLy/update", "/PhieuPhatQuanLy/edit" })
public class BLLPhieuPhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;
	private DALPhieuPhat dal_phieuPhat;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_phieuPhat = new DALPhieuPhat(jdbcURL);
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
			case "/PhieuPhatQuanLy/insert":
				insertPhieuPhat(request, response);
				break;
			case "/PhieuPhatQuanLy/delete":
				deletePhieuPhat(request, response);
				break;
			case "/PhieuPhatQuanLy/update":
				updatePhieuPhat(request, response);
				break;
			case "/PhieuPhatQuanLy/edit":
				editPhieuPhat(request, response);
				break;
			default: // list
				listPhieuPhat(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editPhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int code = Integer.parseInt(request.getParameter("idPhieuPhat"));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			PhieuPhat phieuPhat = new PhieuPhat();
			phieuPhat = dal_phieuPhat.GetOne(code);
			request.setAttribute("phieuPhatIU", phieuPhat);
			request.getRequestDispatcher("/PhieuPhatQuanLy" + "?pages=" + pages).forward(request, response);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void listPhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<PhieuPhat> listPhieuPhat = new ArrayList<PhieuPhat>();

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
			total = dal_phieuPhat.getSoLuongPhanTu(search);
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

		LocalDate toDate = LocalDate.now();
		try {
			maxCode = dal_phieuPhat.maxCode("phieuPhat");
			listPhieuPhat = dal_phieuPhat.getAllPhanTrang(minRes, maxRes, sort, search);
			request.setAttribute("maxCode", maxCode);
			request.setAttribute("txtSearch", search);
			request.setAttribute("selectSort", sort);
			request.setAttribute("soTrang", soTrang);
			request.setAttribute("total", total);
			request.setAttribute("soTrangHienTai", pages);
			request.setAttribute("listPhieuPhat", listPhieuPhat);
			request.setAttribute("toDate", toDate);
			RequestDispatcher dispatcher = request.getRequestDispatcher("PhieuPhatQuanLy.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void updatePhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhieuPhat record = new PhieuPhat();
		record.setIdPhieuPhat(Integer.parseInt(request.getParameter("txtIDPhieuPhat")));
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		if (request.getParameter("dateNgayLap") != null) {
			try {
				Date NgayLap = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayLap"));
				record.setNgayLap(new java.sql.Date(NgayLap.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setTienPhat(Integer.parseInt(request.getParameter("numberTienPhat")));

		int pages = 0;
		if (request.getParameter("pages") != null) {
			pages = (int) Integer.parseInt(request.getParameter("pages"));
		} else {
			pages = 1;
		}

		try {
			
			dal_phieuPhat.Update(record);
			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void deletePhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int code = Integer.parseInt(request.getParameter("idPhieuPhat"));

		try {
			dal_phieuPhat.Delete(code);

			int pages = 0;
			if (request.getParameter("pages") != null) {
				pages = (int) Integer.parseInt(request.getParameter("pages"));
			} else {
				pages = 1;
			}

			int total = 0;
			try {
				total = dal_phieuPhat.getSoLuongPhanTu("default");
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

			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy" + "?pages=" + pages);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertPhieuPhat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		PhieuPhat record = new PhieuPhat();
		record.setIdPhieuPhat(Integer.parseInt(request.getParameter("txtIDPhieuPhat")));
		record.setMaNhanVien(Integer.parseInt(request.getParameter("txtMaNhanVien")));
		record.setMaThe(Integer.parseInt(request.getParameter("txtMaThe")));
		if (request.getParameter("dateNgayLap") != null) {
			try {
				Date NgayLap = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dateNgayLap"));
				record.setNgayLap(new java.sql.Date(NgayLap.getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		record.setTienPhat(Integer.parseInt(request.getParameter("numberTienPhat")));

		try {
			dal_phieuPhat.Add(record);

			int total = 0;
			try {
				total = dal_phieuPhat.getSoLuongPhanTu("default");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

			int soTrang = 0;
			if (total % soDongTrenMotTrang == 0) {
				soTrang = (int) (total / soDongTrenMotTrang);
			} else {
				soTrang = (int) (total / soDongTrenMotTrang) + 1;
			}

			response.sendRedirect("/QuanLyThuVien/PhieuPhatQuanLy" + "?pages=" + soTrang);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

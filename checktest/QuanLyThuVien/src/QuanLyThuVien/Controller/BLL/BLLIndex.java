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

import QuanLyThuVien.model.DAL.DALCuonSach;
import QuanLyThuVien.model.DAL.DALDauSach;
import QuanLyThuVien.model.DAL.DALNxb;
import QuanLyThuVien.model.DAL.DALTheLoai;
import QuanLyThuVien.model.DAL.DALThongBao;
import QuanLyThuVien.model.DAL.Object.CuonSach;
import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.TheLoai;
import QuanLyThuVien.model.DAL.Object.ThongBao;

/**
 * BLLdal_dauSach.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 * @author IT100soDongTrenMotTrang
 */
@WebServlet(name = "index", urlPatterns = { "/index" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BLLIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int soDongTrenMotTrang = 6;

	private DALDauSach dal_dauSach;
	private DALThongBao dal_thongBao;
	private DALTheLoai dal_theLoai;
	private DALCuonSach dal_cuonSach;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		try {
			dal_dauSach = new DALDauSach(jdbcURL);
			dal_thongBao = new DALThongBao(jdbcURL);
			dal_theLoai = new DALTheLoai(jdbcURL);
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		List<ThongBao> listThongBao = new ArrayList<ThongBao>();
		List<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		List<DauSach> listDauSach = new ArrayList<DauSach>();
		List<CuonSach> listCuonSach = new ArrayList<CuonSach>();
		try {
			listDauSach = dal_dauSach.getAllPhanTrang("eBooks", 0, 1000, 0, "default", "default");
			listThongBao = dal_thongBao.getAll();
			listTheLoai = dal_theLoai.getAll();
			listCuonSach = dal_cuonSach.getAll();
			request.setAttribute("listDauSach", listDauSach);
			request.setAttribute("listTheLoai", listTheLoai);
			request.setAttribute("listThongBao", listThongBao);
			request.setAttribute("listCuonSach", listCuonSach);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}

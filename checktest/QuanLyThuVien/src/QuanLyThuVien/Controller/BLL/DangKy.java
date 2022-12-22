package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import QuanLyThuVien.model.DAL.DALDocGia;
import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.DocGia;

/**
 * Servlet implementation class DangKy
 */
@WebServlet(name = "DangKy", urlPatterns = { "/DangKy" })
public class DangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALDocGia dal_dg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			dal_dg = new DALDocGia("jdbc:sqlserver://localhost:1433;databaseName=QuanLyThuVien;user=sa;password=123456;");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthdate = request.getParameter("birthdate");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		DocGia newDG = null;
		response.setContentType("text/plain");

		try {
			List<DocGia> list = dal_dg.getAll();
			for (DocGia dg : list) {
				if (email.equals(dg.getEmail())) {
					newDG = dg;
					break;
				}
			}

			if (newDG == null) {
				newDG = new DocGia();
				newDG.setTenDocGia(name);
				newDG.setGioiTinh(sex);
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);

				newDG.setNgaySinh(new java.sql.Date(date.getTime()));
				newDG.setDiaChi(address);
				newDG.setEmail(email);
				newDG.setSoDienThoai(phone);
				dal_dg.Add(newDG);
				response.getWriter().write("Success");
			} else {
				response.getWriter().write("errorEmail");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

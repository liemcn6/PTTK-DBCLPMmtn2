package QuanLyThuVien.Controller.BLL;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import QuanLyThuVien.model.DAL.DALTaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

/**
 * Servlet implementation class DangNhap
 */
@WebServlet(name = "DangNhap", urlPatterns = { "/DangNhap" })
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DALTaiKhoan dal_tk;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		String jdbcURL = "jdbc:sqlserver://localhost;databaseName=QuanLyThuVien;user=sa;password=123456;";
		// getServletContext().getInitParameter("jdbcURL");
		try {
			dal_tk = new DALTaiKhoan(jdbcURL);
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
		try {
			List<TaiKhoan> listTK = dal_tk.getAll();
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			TaiKhoan tkDN = null;
			response.setContentType("text/plain");
			// response.getWriter().write(name + ":" + name.length() + "; " + password + ":"
			// + password.length() + " ");

			for (TaiKhoan tk : listTK) {
				// response.getWriter().write(tk.getSoDienThoai() + ":" +
				// tk.getSoDienThoai().length() + "; " + tk.getMatKhau() + ":" +
				// tk.getMatKhau().length() + " ");
				// if (name.equals(tk.getMaThe()) && password.equals(tk.getMatKhau())) {
				if (name.equals(tk.getSoDienThoai()) && password.equals(tk.getMatKhau())) {
					tkDN = tk;
					break;
					// }
				}
			}
			if (tkDN == null) {
				response.getWriter().write("False");
			} else {
				session.setAttribute("tkDN", tkDN);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}

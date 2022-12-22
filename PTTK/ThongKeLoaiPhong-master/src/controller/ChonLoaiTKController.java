package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import dao.NhanVienDAO;
import dao.ThanhVienDAO;
import model.NhanVien;
import model.ThanhVien;

@WebServlet(urlPatterns = {"/gdChonLoaiTK"})
public class ChonLoaiTKController extends HttpServlet {
	public static final String LOAI_PHONG = "LOAI_PHONG";
	public static final String LUOT_THUE = "LUOT_THUE";
	
	public ChonLoaiTKController() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("view/gdChonLoaiTK.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String doiTuongTK = request.getParameter("doiTuongTK");
		String kieuTK = request.getParameter("kieuTK");
		String url = "/view/gdTKLoaiPhong.jsp";
	    
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		    dispatcher.forward(request, response);
	    
			   
	}
}

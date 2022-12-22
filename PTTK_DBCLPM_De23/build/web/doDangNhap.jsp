<%-- 
    Document   : doDangNhap
    Created on : Nov 7, 2021, 4:19:40 PM
    Author     : Xuan Toog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
    import="java.util.*, dao.*, model.*"   
        %>
<%
    String tendangnhap = (String) request.getParameter("tendangnhap");
    String matkhau = (String) request.getParameter("matkhau");
    
    ThanhVien tv = new ThanhVien();
    tv.setTendangnhap(tendangnhap);
    tv.setMatkhau(matkhau);
    
    ThanhVienDAO tvDAO = new ThanhVienDAO();
    boolean check = tvDAO.checkDangNhap(tv);
    out.println(check);
    
    if(check){
        NhanVien nv = tvDAO.getNhanVienByTendangnhap(tendangnhap); // get thông tin nhân viên
        
        DaiLyTrungGianDAO dailyDAO = new DaiLyTrungGianDAO();
        DaiLyTrungGian daily = dailyDAO.getDaiLyTrungGianByThanhVienId(nv.getId());
        session.setAttribute("daily", daily);
        
        if(nv.getVitricongviec().equals("nvkho")){
            session.setAttribute("nvkho", nv);
            response.sendRedirect("nvkho\\gdNhanVienKho.jsp");
        }
        if(nv.getVitricongviec().equals("nvquanly")){
            session.setAttribute("nvquanly", nv);
            response.sendRedirect("nvquanly\\gdNhanVienQuanLy.jsp");
        }
    }
    else {
        response.sendRedirect("gdDangNhap.jsp?err=fail");
    }
    
%>

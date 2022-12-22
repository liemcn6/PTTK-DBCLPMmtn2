<%-- 
    Document   : doDangnhap.jsp
    Created on : Nov 25, 2022, 1:32:55 PM
    Author     : DELL
--%>

<%@page import="dao.ThanhvienDAO"%>
<%@page import="model.Thanhvien325"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String username = (String) request.getParameter("username");
    String password = (String) request.getParameter("password");
    Thanhvien325 tv = new Thanhvien325();
    tv.setUsername(username);
    tv.setPassword(password);
    ThanhvienDAO dao = new ThanhvienDAO();
    boolean kq = dao.kiemtraDangnhap(tv);
    if (kq && (tv.getVaitro().equalsIgnoreCase("nhanvien"))) {
        session.setAttribute("nhanvien", tv);
        response.sendRedirect("nv\\gdchinhnv325.jsp");
    } else if (kq && (tv.getVaitro().equalsIgnoreCase("quanly"))) {
        session.setAttribute("quanly", tv);
        response.sendRedirect("ql\\gdchinhql325.jsp");
    } else {
        response.sendRedirect("index.jsp?err=fail");
    }
%>


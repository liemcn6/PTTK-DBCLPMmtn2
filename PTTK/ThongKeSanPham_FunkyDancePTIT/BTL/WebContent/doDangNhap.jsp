<%@page import="dao.ThanhVienDAO"%>
<%@page import="model.ThanhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String username = (String)request.getParameter("username");
	String password = (String)request.getParameter("password");
	
	ThanhVien tv2 = new ThanhVien();
	tv2.setUsername(username);
	tv2.setPassword(password);
	
	ThanhVienDAO dao = new ThanhVienDAO();
	boolean kq = dao.kiemtraDangNhap(tv2);
	
  if( kq = true)
		{
	  session.setAttribute("username", tv2);
	
	  
	  response.sendRedirect("GDQL.jsp");
	  
		
		}
		
	else {
		response.sendRedirect("GDDangNhap.jsp?err=fail");
	}
%>
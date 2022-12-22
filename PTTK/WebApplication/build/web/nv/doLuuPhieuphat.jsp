<%-- 
    Document   : doLuuPhieuphat
    Created on : Dec 1, 2022, 12:09:01 AM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.SachmuonDAO"%>
<%@page import="model.Thebandoc325"%>
<%@page import="dao.PhieuphatDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Sachmuon325"%>
<%@page import="model.Thanhvien325"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Thanhvien325 nv = (Thanhvien325) session.getAttribute("nhanvien");
  if (nv == null) {
       response.sendRedirect("../index.jsp?err=timeout");
    }

    List<Sachmuon325> list =(ArrayList<Sachmuon325>) session.getAttribute("listTramuon");
    Thebandoc325 tbd =(Thebandoc325) session.getAttribute("tbd");
    int idpm =(int) session.getAttribute("idpm");
    int idnv = nv.getId();
    PhieuphatDAO dao = new PhieuphatDAO();
    SachmuonDAO daosm = new SachmuonDAO();
    boolean kq=dao.luuPhieuphat(tbd.getId(), idpm, idnv);
    System.out.println("sizee"+ list.size());
    if (kq ) {
        boolean kq1= daosm.updateIdphatListStm(list);
        if(kq1){
        response.sendRedirect("gdinphieu325.jsp");
        }else{
            response.sendRedirect("gdchinhnv325.jsp");
        }
    } else {
        %>
        <script type="text/javascript">
         alert("Lỗi phieuphat!");
         history.back();
        </script>
        <%

    }
%>

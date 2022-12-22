<%-- 
    Document   : doUpdateSachmuon
    Created on : Nov 30, 2022, 8:49:18 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Thanhvien325"%>
<%@page import="dao.SachmuonDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Sachmuon325"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Thanhvien325 nv = (Thanhvien325) session.getAttribute("nhanvien");
    if (nv == null) {
        response.sendRedirect("../index.jsp?err=timeout");
    }

    List<Sachmuon325> list1 = (ArrayList<Sachmuon325>) session.getAttribute("list1");

    List<Sachmuon325> list0 = (ArrayList<Sachmuon325>) session.getAttribute("list0");
    
    SachmuonDAO dao = new SachmuonDAO();
    List<Sachmuon325> listTramuon = new ArrayList<>();
    boolean kq = dao.updateListSachmuon(list1);
    if (kq) {

        for (Sachmuon325 a : list1) {
           
                if (!(a.getNgaytra().toString().equals(a.getNgayphaitra().toString()))) {
                if (a.getNgaytra().after(a.getNgayphaitra())) {
                    listTramuon.add(a);
                }
            
            }
            
        }
        int idpm = 0;
        if (listTramuon.size() > 0) {
            idpm = listTramuon.get(0).getPhieumuon().getId();
        }
        String mavachPhieumuon = "";
        if (list0.size() > 0) {
            mavachPhieumuon = list0.get(0).getPhieumuon().getMavachPhieumuon();
        } else if (listTramuon.size() > 0) {
            mavachPhieumuon = listTramuon.get(0).getPhieumuon().getMavachPhieumuon();
        }
        session.setAttribute("listTramuon", listTramuon);
        session.setAttribute("idpm", idpm);
        session.setAttribute("mavachPhieumuon", mavachPhieumuon);
        if (listTramuon.size() > 0) {
            response.sendRedirect("doLuuPhieuphat.jsp");
        } else if (list0.size() > 0) {
            
            //inPhieumuon();
            %>
        <script type="text/javascript">
         alert("Trả sách thành công");
         location.assign("gdinphieu325.jsp");
        </script>
        <%
        } else {

        session.removeAttribute("listTramuon");
        session.removeAttribute("list0");
        session.removeAttribute("list1");
        session.removeAttribute("mavachPhieumuon");
        session.removeAttribute("mavachSach");
        session.removeAttribute("tbd");
         %>
        <script type="text/javascript">
         alert("Trả sách thành công");
         location.assign("gdchinhnv325.jsp");
        </script>
        <%
    }

} else {
%>
<script type="text/javascript">
    alert("Lỗi !");
    history.back();
</script>
<%
    }
%>


<%-- 
    Document   : doThemNhaCungCap
    Created on : Nov 7, 2021, 4:29:25 PM
    Author     : Xuan Toog
--%>

<%@page import="model.NhaCungCap"%>
<%@page import="dao.NhaCungCapDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String ma = request.getParameter("ma");
            String ten = request.getParameter("tenNCC");
            String diaChi = request.getParameter("diachi");
            String sdt = request.getParameter("sdt");

            NhaCungCapDAO nccDAO = new NhaCungCapDAO();
            
            boolean exist = nccDAO.existMaNCC(ma);
//            out.print(exist);
            if(exist) {
                response.sendRedirect("\\gdThemNhaCungCap.jsp?err=existMaNCC&ma="+ma+"&ten="+ten+"&diaChi="+diaChi+"&sdt="+sdt);
            } else {
                int status = nccDAO.createNhaCungCap(new NhaCungCap(ma, ten, diaChi, sdt));

                if(status==1) {
        %>
                <script type="text/javascript">
                    if(confirm("Thêm nhà cung cấp thành công! Bạn có muốn trở về trang chủ?")){
                        window.location.href = "<%= request.getContextPath() %>/nvkho/gdNhanVienKho.jsp";
                    }
                </script>
        <%
            }
            if(status==0) {
        %>
                <script type="text/javascript">
                    if(confirm("Thêm nhà cung cấp thất bại! Bạn có muốn quay lại thêm nhà cung cấp?")){
                        window.location.href = "<%= request.getContextPath() %>/nvkho/gdThemNhaCungCap.jsp";
                    }
                </script>
        <%
            }
            }
        %>
    </body>
</html>

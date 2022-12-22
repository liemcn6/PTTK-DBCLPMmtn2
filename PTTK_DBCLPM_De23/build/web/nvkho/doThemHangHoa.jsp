<%-- 
    Document   : doThemHangHoa
    Created on : Nov 7, 2021, 4:28:45 PM
    Author     : Xuan Toog
--%>

<%@page import="model.*"%>
<%@page import="dao.*"%>
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
            String tenHH = request.getParameter("tenHH");
            String moTa = request.getParameter("mota");
            HangHoa hh = new HangHoa(ma, tenHH, moTa);
            
            HangHoaDAO hhDAO = new HangHoaDAO();
            boolean exist = hhDAO.existMaHH(ma);
            out.print(exist);
            if(exist) {
                response.sendRedirect("\\gdThemHangHoa.jsp?err=existMaHH&ma="+ma+"&tenHH="+tenHH+"&mota="+moTa);
            } else {
                int status = hhDAO.createHangHoa(hh);
                if(status==1) {
        %>
                <script type="text/javascript">
                    if(confirm("Thêm hàng hóa thành công! Bạn có muốn trở về trang chủ?")){
                        window.location.href = "<%= request.getContextPath() %>/nvkho/gdNhanVienKho.jsp";
                    }
                </script>
        <%
            }
            if(status==0) {
        %>
                <script type="text/javascript">
                    if(confirm("Thêm nhà cung cấp thất bại! Bạn có muốn quay lại trang thêm hàng hóa?")){
                        window.location.href = "<%= request.getContextPath() %>/nvkho/gdThemHangHoa.jsp";
                    }
                </script>
        <%
            }
            }
        %>
    </body>
</html>

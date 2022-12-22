<%-- 
    Document   : doNhapHang
    Created on : Nov 7, 2021, 4:28:34 PM
    Author     : Xuan Toog
--%>

<%@page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    NhanVien nv = (NhanVien) session.getAttribute("nvkho"); // lấy thông tin nhân viên kho
    int nvkhoID = nv.getId(); // lấy id của nhân viên kho

    DaiLyTrungGian daily = (DaiLyTrungGian) session.getAttribute("daily"); // lấy thông tin đại lý
    int dailyID = daily.getId(); // lấy id của đại lý

    NhaCungCap ncc = (NhaCungCap) session.getAttribute("ncc"); // lấy thông tin nhà cung cấp
    int nccID = Integer.parseInt(session.getAttribute("nccID").toString()); // lấy id của nhà cung cấp

    PhieuNhap phieunhap = (PhieuNhap) session.getAttribute("phieunhap"); // lấy phiếu nhập từ gdNhapHang.jsp ra

    ArrayList<PhieuNhap_HangHoa> list_hanghoanhap
            = (ArrayList<PhieuNhap_HangHoa>) session.getAttribute("list_hanghoanhap");
//    out.println(list_mathangnhap);

    phieunhap.setThoigiannhaphang(new java.util.Date());
    phieunhap.setGhichu(request.getParameter("ghichu"));
    phieunhap.setNhanVienKho(nv);
    phieunhap.setDaiLyTrungGian(daily);
    phieunhap.setNhaCungCap(ncc);
    phieunhap.setListPhieuNhap_HangHoa(list_hanghoanhap);

    boolean status = false;
    if(list_hanghoanhap.size() > 0){ // nếu danh sách mặt hàng nhập không rỗng
        PhieuNhapDAO pnDAO = new PhieuNhapDAO();
        status = pnDAO.luuPhieuNhap(phieunhap);
    }
//    out.println(status);

    if(status == true) {
%>
        <script type="text/javascript">
            if (confirm("Thêm phiếu nhập thành công! Bạn có muốn trở về trang chủ?")) {
                window.location.href = "<%= request.getContextPath() %>/nvkho/gdNhanVienKho.jsp";
            }
        </script>
<%
    }
    if(status == false ) {
%>
        <script type="text/javascript">
            if (confirm("Thêm phiếu nhập thất bại! Bạn có muốn quay lại trang tìm nhà cung cấp để nhập hàng?")) {
                window.location.href = "<%= request.getContextPath() %>/nvkho/gdTimVaChonNhaCungCap.jsp?action=gdNhanVienKho";
            }
        </script>
<%
    }
%>

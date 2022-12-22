<%-- 
    Document   : gdNhapHang
    Created on : Nov 7, 2021, 4:23:04 PM
    Author     : Xuan Toog
--%>

<%@page import="java.util.HashSet"%>
<%@page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=991344888073378&height=250&width=250&ext=1638422277&hash=AeRcCjdTkxdAuvh6c48">
        <script src="https://kit.fontawesome.com/22e9af292e.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhập hàng</title>
        <style>
            .custom-a {
                color: #346E9F
            }
            .custom-button {
                background-color: white;
                border : none;
            }
            .custom-button:hover {
                color: #563D7C !important;
            }
            .custom-button-2 {
                background-color: #cccccc;
                border : none;
                color : black !important;
            }
            .custom-button-2:hover {
                color: #346E9F !important; 
            }
            .btn-purple:hover {
                background-color: #6a4b99 !important;
            }
        </style>
        <%
            NhanVien nv = (NhanVien) session.getAttribute("nvkho");
            DaiLyTrungGian daily = (DaiLyTrungGian) session.getAttribute("daily");
            NhaCungCap ncc = new NhaCungCap();

            PhieuNhap phieunhap; // khai báo phiếu nhập

            String tenHH = ""; // khai báo tên hàng hóa cần tìm
            ArrayList<HangHoa> hhs = new ArrayList<HangHoa>();; // khai báo danh sách hàng hóa chứa tên mặt hàng cần tìm
            ArrayList<PhieuNhap_HangHoa> list_hanghoanhap = new ArrayList<PhieuNhap_HangHoa>(); // khai báo danh sách HoaDonNhap_HangHoa
            HashSet<String> set;
            
            String action = (String) request.getParameter("action"); // kiểm tra xem được gọi từ trang nào?
            if (action.equals("gdTimNhaCungCap")) {
                ArrayList<NhaCungCap> nccs = (ArrayList<NhaCungCap>) session.getAttribute("nccs");
                int index = Integer.parseInt(request.getParameter("index"));
                // lấy id nhà cung cấp mà người dùng đã chọn
                int nccID = nccs.get(index).getId();
                session.setAttribute("nccID", nccID); // thêm nccID vào session
//                out.println(nccID);

                ncc = nccs.get(index);
                session.setAttribute("ncc", ncc); // thêm ncc vào session
//                out.println("<br>" + ncc);

                // khởi tạo hóa đơn nhập
                phieunhap = new PhieuNhap();
                session.setAttribute("phieunhap", phieunhap); // gán hoadonnhap vào session

                // tạo 1 danh sách nhập hàng nhập mới
                list_hanghoanhap = new ArrayList<PhieuNhap_HangHoa>();
                session.setAttribute("list_hanghoanhap", list_hanghoanhap);
                
                set = new HashSet();
                session.setAttribute("set", set);

//                out.println(list_mathangnhap);
            }
            if (action.equals("timHH")) {
                // lấy nccID từ session
                int nccID = Integer.parseInt(session.getAttribute("nccID").toString());
//                out.println(nccID);
                // lấy thông từ ncc từ session
                ncc = (NhaCungCap) session.getAttribute("ncc");
//                out.println("<br>" + ncc);

                tenHH = request.getParameter("tenHH");
                session.setAttribute("tenHH", tenHH);
                
                HangHoaDAO mathangDAO = new HangHoaDAO();
                hhs = mathangDAO.searchHangHoa(tenHH);
                session.setAttribute("hhs", hhs);

                // lấy danh sách mặt hàng đã nhập
                list_hanghoanhap = (ArrayList<PhieuNhap_HangHoa>) session.getAttribute("list_hanghoanhap");
                
                //
                set = (HashSet<String>) session.getAttribute("set");
            }
            if (action.equals("themHHnhap")) {
                // lấy nccID từ session
                int nccID = Integer.parseInt(session.getAttribute("nccID").toString());
//                out.println(nccID);
                // lấy thông từ ncc từ session
                ncc = (NhaCungCap) session.getAttribute("ncc");
//                out.println("<br>" + ncc);

                // hiển thị phần tìm kiếm mặt hàng
                tenHH = session.getAttribute("tenHH").toString();
                HangHoaDAO mathangDAO = new HangHoaDAO();
                hhs = mathangDAO.searchHangHoa(tenHH);
                session.setAttribute("hhs", hhs);

                // lấy danh sách mặt hàng đã nhập
                list_hanghoanhap = (ArrayList<PhieuNhap_HangHoa>) session.getAttribute("list_hanghoanhap");
                //
                set = (HashSet<String>) session.getAttribute("set");

                int index = Integer.parseInt(request.getParameter("index"));

                HangHoa hh = hhs.get(index);
                if(set.contains(hh.getMa())) {
                    float donGia = 0;
                    int soLuong = 0;
                    if (request.getParameter("donGia") != "") {
                        donGia = Float.parseFloat(request.getParameter("donGia"));
                    }
                    if (request.getParameter("soLuong") != "") {
                        soLuong = Integer.parseInt(request.getParameter("soLuong"));
                    }
                    
                    for(PhieuNhap_HangHoa o : list_hanghoanhap) {
                        if(o.getHangHoa().getId() == hh.getId()) {
                            o.setDongia(donGia);
                            o.setSoluong(soLuong + o.getSoluong());
                        }
                    }
                    
                } else {
                    float donGia = 0;
                    int soLuong = 0;
                    if (request.getParameter("donGia") != "") {
                        donGia = Float.parseFloat(request.getParameter("donGia"));
                    }
                    if (request.getParameter("soLuong") != "") {
                        soLuong = Integer.parseInt(request.getParameter("soLuong"));
                    }
                    list_hanghoanhap.add(new PhieuNhap_HangHoa(donGia, soLuong, hh));
                    set.add(hh.getMa());
                }

                session.setAttribute("list_hanghoanhap", list_hanghoanhap); // cập nhật lại ds mặt hàng nhập
//                out.println(list_mathangnhap);
                session.setAttribute("set", set);
            }
            if (action.equals("xoaHHnhap")) {
                // lấy nccID từ session
                int nccID = Integer.parseInt(session.getAttribute("nccID").toString());
//                out.println(nccID);
                // lấy thông từ ncc từ session
                ncc = (NhaCungCap) session.getAttribute("ncc");
//                out.println("<br>" + ncc);

                // hiển thị phần tìm kiếm mặt hàng
                tenHH = session.getAttribute("tenHH").toString();
                HangHoaDAO hanghoaDAO = new HangHoaDAO();
                hhs = hanghoaDAO.searchHangHoa(tenHH);
                session.setAttribute("hhs", hhs);

                // lấy danh sách mặt hàng đã nhập
                list_hanghoanhap = (ArrayList<PhieuNhap_HangHoa>) session.getAttribute("list_hanghoanhap");

                int index = Integer.parseInt(request.getParameter("index"));
                
                String ten = list_hanghoanhap.get(index).getHangHoa().getMa();
                set = (HashSet<String>) session.getAttribute("set");
                set.remove(ten);
                session.setAttribute("set", set);
                        
                list_hanghoanhap.remove(index);
                session.setAttribute("list_hanghoanhap", list_hanghoanhap); // cập nhật lại ds mặt hàng nhập

                
            }


        %>
    </head>
    <body>
        <div style="height: auto; background-color: #346E9F; color: #F5F5F5" class="d-flex justify-content-between align-items-center">
            <a href="#" style="color: #F5F5F5" class="pl-5"><i class="fab fa-cloudversify fa-4x"></i></a>
            <div><h2>ĐẠI LÝ XUẤT NHẬP HÀNG TRUNG GIAN PỜ TÍT</h2></div>
            <div class="mr-4">
                <div><i class="far fa-user-circle fa-2x"></i></div>
            </div>
        </div>
        
        <div class="d-flex flex-row" style="height: 90vh;">
            <div style="border-right: 1px solid #346E9F; background: #F4F5F7;" class="d-flex flex-column px-4">
                <div class="py-4">
                    <a href="#" class="custom-a">
                        <div class="d-flex">
                            <span class="pt-2 pr-2"><i class="fas fa-box-open"></i></span>
                            <span>Quản lý <br>hàng hóa</span>
                        </div>
                    </a>
                </div>
                <div class="py-4">
                    <a href="#" class="custom-a">
                        <div class="d-flex">
                            <span class="pt-2 pr-2"><i class="fas fa-truck"></i></span>
                            <span>Quản lý <br>nhà cung cấp</span>
                        </div>
                    </a>
                </div>
                <div class="py-4">
                    <a href="#" class="custom-a">
                        <div class="d-flex">
                            <span class="pt-2 pr-2"><i class="fas fa-handshake"></i></span>
                            <span>Quản lý <br>đại lý con</span>
                        </div>
                    </a>
                </div>
                <div class="py-4">
                    <a href="gdTimVaChonNhaCungCap.jsp?action=gdNVKho" class="custom-a">
                        <div class="d-flex" style="color: #563D7C !important">
                            <span class="pr-2"><i class="fas fa-download"></i></span>
                            <span>Nhập hàng</span>
                        </div>
                    </a>
                </div>
                <div class="py-4">
                    <a href="#" class="custom-a">
                        <div class="d-flex">
                            <span class="pr-2"><i class="fas fa-upload"></i></span>
                            <span>Xuất hàng</span>
                        </div>
                    </a>
                </div>
            </div>
            <div class="container pl-3">
                <div class="pt-4 d-flex flex-row justify-content-between">
                    <div>
                        <h4>Nhập hàng</h4>
                    </div>
                    <div>
                        <p><b>Nhà cung cấp:</b> <%= ncc.getTen() %></p>
                        <p><b>Nhân viên kho:</b> <%= nv.getHoten()%></p>
                    </div>
                </div>
                    
                <div>
                    <div class="mt-3 row">
                        <div class="col-9">
                            <form action="gdNhapHang.jsp" method="POST">
                                <div class="form-row pl-1">
                                    <input type="hidden" name="action" value="timHH"/>
                                    <input class="form-control col-6" type="text" name="tenHH" 
                                           placeholder="Tên hàng hóa..." value="<%= tenHH%>"/>
                                    <button class="text-primary text-center ml-2 custom-button" type="submit">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="justify-content-end">
                            <a href="gdThemHangHoa.jsp" target="_blank">
                                <button style="background-color: #563D7C; color: #FFE484 !important;" 
                                        class="btn btn-purple">
                                    Thêm hàng hóa mới
                                </button>
                            </a>
                        </div>
                    </div>
                    
                    <br/>
                    
                    <div>
                        <table class="table table-hover">
                            <tr class="table-primary">
                                <th>ID</th>
                                <th>Mã</th>
                                <th>Tên hàng hóa</th>
                                <th>Mô tả</th>
                                <th>Đơn giá (VNĐ)</th>
                                <th>Số lượng</th>
                                <th>Thao tác</th>
                            </tr>
                            <% for (int i = 0; i < hhs.size(); i++) {%>
                            <tr>
                                <form action="gdNhapHang.jsp" method="post">
                                    <input type="hidden" name="action" value="themHHnhap"/>
                                    <td>
                                        <%= hhs.get(i).getId()%>
                                        <input type="hidden" name="index" value="<%= i%>"/>
                                    </td>
                                    <td><%= hhs.get(i).getMa()%></td>
                                    <td><%= hhs.get(i).getTen()%></td>
                                    <td><%= (hhs.get(i).getMota()!=null) ? hhs.get(i).getMota()!=null : ""%></td>
                                    <td><input type="number" name="donGia" required/></td>
                                    <td><input type="number" name="soLuong" required/></td>
                                    <td>
                                        <button class="custom-button-2" type="submit">Thêm</button>
                                    </td>
                                </form> 
                            </tr>
                            <% }%>
                        </table>
                    </div>
                    <%
                        list_hanghoanhap = (ArrayList<PhieuNhap_HangHoa>) session.getAttribute("list_hanghoanhap");

                        float tongtien = 0; // tổng tiền của tất cả các mặt hàng nhập
                        ArrayList<Float> thanhtiens = new ArrayList<Float>(); // thành tiền của từng mặt hàng nhập

                        for (PhieuNhap_HangHoa mhnhap : list_hanghoanhap) {
                            float tmp = mhnhap.getDongia() * mhnhap.getSoluong();
                            thanhtiens.add(tmp);
                            tongtien += tmp;
                        }

                        session.setAttribute("tongtien", tongtien);

                    %>
                    <br/>
                    <div>
                        <h4 style="text-align: center;">Danh sách hàng nhập</h4>
                            <table class="table table-hover">
                                <tr class="table-primary">
                                    <th>TT</th>
                                    <th>Mã</th>
                                    <th>Tên hàng hóa</th>
                                    <th>Giá nhập (VNĐ)</th>
                                    <th>Số lượng</th>
                                    <th>Thành tiền (VNĐ)</th>
                                    <th>Thao tác</th>
                                </tr>

                                <% for (int i = 0; i < list_hanghoanhap.size(); i++) {%>    
                                <tr>

                                <form action="gdNhapHang.jsp" method="post">
                                    <input type="hidden" name="action" value="xoaHHnhap"/>
                                    <td>
                                        <%= i + 1%>
                                        <input type="hidden" name="index" value="<%=i%>"/>
                                    </td>
                                    <td><%= list_hanghoanhap.get(i).getHangHoa().getMa()%></td>
                                    <td><%= list_hanghoanhap.get(i).getHangHoa().getTen()%></td>
                                    <td><%= String.format("%,.0f", list_hanghoanhap.get(i).getDongia()) %></td>
                                    <td><%= list_hanghoanhap.get(i).getSoluong()%></td>
                                    <td><%= String.format("%,.0f", thanhtiens.get(i)) %></td>
                                    <td>
                                        <button class="custom-button-2" type="submit">Xóa</button>
                                    </td>
                                </form> 
                                </tr>
                                <% }%>
                            </table>
                    </div>
                    <c:set var = "tt" value = "<%= tongtien %>" />        
                    <div class="text-right"><b>Tổng tiền (VNĐ):</b> <%= String.format("%,.0f", tongtien) %></div>
                    
                    <br>
                    
                    <div class="text-right">
                        <form action="doNhapHang.jsp" method="POST" class="">
                            <label for="ghichu">Ghi chú: </label>
                            <input type="text" name="ghichu" id="ghichu" placeholder="Ghi chú ..."/>
                            <br/><br/>
                            <input type="submit" value="Lưu phiếu nhập" class="btn btn-primary"/>
                        </form>
                    </div>
                    
                    <br/><br/>
                </div>
            </div>
        </div>
    </body>
</html>

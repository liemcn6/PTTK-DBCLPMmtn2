<%-- 
    Document   : gdTimVaChonNhaCungCap
    Created on : Nov 7, 2021, 4:23:52 PM
    Author     : Xuan Toog
--%>

<%@page import="dao.NhaCungCapDAO"%>
<%@page import="model.NhaCungCap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=991344888073378&height=250&width=250&ext=1638422277&hash=AeRcCjdTkxdAuvh6c48">
        <script src="https://kit.fontawesome.com/22e9af292e.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm và chọn nhà cung cấp</title>
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
            .btn-purple:hover {
                background-color: #6a4b99 !important;
            }
        </style>
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
                <div class="pt-4"><h4>Tìm và chọn nhà cung cấp</h4></div>
                <div>
                    <%
                        String action = request.getParameter("action");
                        
                        String tenNCC = "";
                        ArrayList<NhaCungCap> nccs = new ArrayList<NhaCungCap>();
                        if (action.equals("timNCC")) {
                            tenNCC = request.getParameter("tenNCC");
                            NhaCungCapDAO nccDAO = new NhaCungCapDAO();
                            nccs = nccDAO.searchNhaCungCap(tenNCC);
                            session.setAttribute("nccs", nccs);
                        }
                    %>
                    <div class="mt-3 row">
                        <div class="col-9">
                            <form action="gdTimVaChonNhaCungCap.jsp" method="POST">
                                <div class="form-row pl-1">
                                    <input type="hidden" name="action" value="timNCC"/>
                                    <input class="form-control col-6" type="text" name="tenNCC" 
                                           placeholder="Tên nhà cung cấp..." value="<%= tenNCC%>"/>
                                    <button class="text-primary text-center ml-2 custom-button" type="submit">
                                        <i class="fas fa-search"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="justify-content-end">
                            <a href="gdThemNhaCungCap.jsp" target="_blank">
                                <button style="background-color: #563D7C; color: #FFE484 !important;" 
                                        class="btn btn-purple">
                                    Thêm nhà cung cấp mới
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
                                <th>Tên</th>
                                <th>Địa chỉ</th>
                                <th>Số điện thoại</th>
                                <th>Thao tác</th>
                            </tr>
                            <% for (int i = 0; i < nccs.size(); i++) {%>
                            <tr>
                                <td><%= nccs.get(i).getId()%></td>
                                <td><%= nccs.get(i).getMa()%></td>
                                <td><%= nccs.get(i).getTen()%></td>
                                <td><%= nccs.get(i).getDiachi()%></td>
                                <td><%= nccs.get(i).getSodienthoai()%></td>
                                <td><a href="gdNhapHang.jsp?action=gdTimNhaCungCap&&index=<%= i %>">Nhập hàng</a></td>
                            </tr>
                            <% }%>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

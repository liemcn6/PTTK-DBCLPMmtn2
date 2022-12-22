<%-- 
    Document   : gdThemNhaCungCap
    Created on : Nov 7, 2021, 4:24:06 PM
    Author     : Xuan Toog
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="https://platform-lookaside.fbsbx.com/platform/profilepic/?asid=991344888073378&height=250&width=250&ext=1638422277&hash=AeRcCjdTkxdAuvh6c48">
        <script src="https://kit.fontawesome.com/22e9af292e.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm nhà cung cấp mới</title>
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
                        <div class="d-flex" style="color: #563D7C !important">
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
                        <div class="d-flex">
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
            <div>
                <%
                    String ma = "", ten = "", diaChi = "", sdt="";
                    if(request.getParameter("ma") != null) {
                        ma = (String) request.getParameter("ma");
                    }
                    if(request.getParameter("ten")!= null) {
                        ten = (String) request.getParameter("ten");
                    }
                    if(request.getParameter("diaChi")!= null) {
                        diaChi = (String) request.getParameter("diaChi");
                    }  
                    if(request.getParameter("sdt")!= null) {
                        sdt = (String) request.getParameter("sdt");
                    }  
                %>
                <div class="p-4"><h4>Thêm nhà cung cấp</h4></div>
                <div class="row">
                    <div class="col-6 ml-5 pl-5">
                        <form action="doThemNhaCungCap.jsp" method="post">
                            <div class="form-group">
                                <label for="ma" class="col-form-label">
                                    Mã nhà cung cấp  
                                    <span style="color: red;">*</span> :
                                </label>
                                <input type="text" name="ma" id="ma" value="<%=ma%>" required/>
                                <%
                                    if(request.getParameter("err") != null && request.getParameter("err").equals("existMaNCC")) {
                                %>
                                <div class="d-flex justify-content-start">    
                                    <small class="text-danger">Mã nhà cung cấp đã tồn tại!</small>
                                </div>
                                <%
                                    }  
                                %>
                            </div>
                            <div class="form-group">
                                <label for="tenNCC" class="col-form-label">
                                    Tên nhà cung cấp
                                    <span style="color: red;">*</span> :
                                </label>
                                <input type="text" name="tenNCC" id="tenNCC" value="<%=ten%>" required/>
                            </div>
                            <div class="form-group">
                                <label for="diachi" class="col-form-label">Địa chỉ: </label>
                                <input type="text" name="diachi" id="diachi" value="<%=diaChi%>"/>
                            </div>
                            <div class="form-group">
                                <label for="sdt" class="col-form-label">Số điện thoại: </label>
                                <input type="text" name="sdt" id="sdt" value="<%=sdt%>"/>
                            </div>
                            <div class="form-group ml-5 pl-3">
                                <input type="submit" value="Lưu" class="btn btn-primary"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

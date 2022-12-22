<%-- 
    Document   : gdDangNhap
    Created on : Nov 7, 2021, 4:21:18 PM
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
        <title>Đăng nhập</title>
    </head>
    <body>
        <div style="height: auto; background-color: #346E9F; color: #F5F5F5" class="d-flex justify-content-between align-items-center">
            <a href="#" style="color: #F5F5F5" class="pl-5"><i class="fab fa-cloudversify fa-4x"></i></a>
            <div><h2>ĐẠI LÝ XUẤT NHẬP HÀNG TRUNG GIAN PỜ TÍT</h2></div>
            <div class="mr-4">
            </div>
        </div>
        
        <div class="container w-25 mt-5 pt-5">
            <%
                if(request.getParameter("err") != null && request.getParameter("err").equals("fail")) {
            %>
            <div class="d-flex justify-content-center">    
                <small class="text-danger">Tên đăng nhập hoặc mật khẩu sai!</small>
            </div>
            <%
                }
            %>
            <form action="doDangNhap.jsp" method="POST">
                <div class="mb-3">
                    <label for="tendangnhap" class="form-label">Tên đăng nhập:</label>
                    <input type="text" name="tendangnhap" placeholder="Tên đăng nhập" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="matkhau" class="form-label">Mật khẩu:</label>
                    <input type="password" name="matkhau" placeholder="Mật khẩu" class="form-control">
                </div>
                <div class="mb-3 text-center">
                <input type="submit" value="Đăng nhập" class="btn btn-primary">
                </div>
            </form>
        </div>
    </body>
</html>

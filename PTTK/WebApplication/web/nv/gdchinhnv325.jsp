<%@page import="model.Thanhvien325"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản Lý Thư Viện Quốc Gia</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <div class="main-wrapper">
            <div class="header" style="background-color: #0f0906" >
                <div class = "img-header bg-primary">
                    <img src="../img/bglast.png" alt="Chania"> 
                    <span class ="welcome"> Chào bạn,
                            <%
                            Thanhvien325 nv = (Thanhvien325)session.getAttribute("nhanvien");
                             if(nv==null){
                             response.sendRedirect("../index.jsp?err=timeout");
                             }else{
                                 String hoten=nv.getHoten().getHodem().toString()+" "+ nv.getHoten().getTen().toString();
                                 %>
                                 <%= hoten %>
                              <%
                             }
                             %>
                        </span>
                    <div> <hr> </div>
                    <div class = "text" style="color: black">
                        <h4>TRANG CHỦ NHÂN VIÊN</h4>
                    </div>
                </div>
                
                <div class ="header-below">
                    <ul class="nav  bg-primary justify-content-end nav-pills" >
                        <li class="nav-item " style="background-color: #917a71">
                            <a class="nav-link" href="../index.jsp">Đăng xuất</a>
                        </li>
                    </ul>
                </div>
                 <div> <hr> </div>
                <div class="page-wrapper">
                    <video autoplay muted loop id="myVideo">
                        <source src="../img/rain.mp4" type="video/mp4">
                    </video>
                    <div class="content" style="margin-top: -20px">
                        <div class="row">
                       
                        <div class="col-md-6">
                            <div class="row ">
                                <button type="button"  class="btn btn-danger btn-lg btn-block"  data-toggle="tooltip" title="Cần cấp phát quyền truy cập">Quản lí thẻ bạn đọc</button>
                            </div>
                            <div class="row">
                                <button type="button" class="btn btn-danger btn-lg btn-block"  data-toggle="tooltip" title="Cần cấp phát quyền truy cập">Quản lí nhà cung cấp</button>
                            </div>
                            <div class="row">
                                <button type="button" class=" btn btn-danger btn-lg btn-block" data-toggle="tooltip" title="Thống kê các đối tượng liên quan">Quản lí đầu sách</button>
                            </div>
                            <div class="row">
                                <button type="button" class=" btn btn-danger btn-lg btn-block" data-toggle="tooltip" title="Thống kê các đối tượng liên quan">Đổi mật khẩu</button>
                            </div><!-- comment -->
                        </div>
                        <div class="col-md-6">
                            <div class="row ">
                                <button type="button"  class="btn btn-danger btn-lg btn-block"  data-toggle="tooltip" title="Cần cấp phát quyền truy cập">Nhập sách</button>
                            </div>
                            <div class="row">
                                <button type="button" class="btn btn-danger btn-lg btn-block"  data-toggle="tooltip" title="Cần cấp phát quyền truy cập">Mượn sách</button>
                            </div>
                            <div class="row">
                                <a href="gdquetthe325.jsp" class=" btn btn-danger btn-lg btn-block" data-toggle="tooltip" title="Thống kê các đối tượng liên quan">Trả sách</a>
                            </div>
                            <div class="row">
                                <button type="button" class=" btn btn-danger btn-lg btn-block" data-toggle="tooltip" title="Xem thống kê các sách đã mượn của bạn đọc bất kì">Xem thống kê sách đã mượn của bạn đọc</button>
                            </div><!-- comment -->
                            
                        </div>
                                 
                        </div>
                    </div>
                </div>
            </div>
                <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
                    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
                    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        </div>
    </body>
    <footer class=" grid-container bg-primary text-center text-white"  style="position: absolute;bottom: 0;width:100%; margin: 0px">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2022 Registered:
            <a class="text-white" href="https://mdbootstrap.com/">Thư Viện Quốc Gia</a>
        </div>
    </footer>
</html>
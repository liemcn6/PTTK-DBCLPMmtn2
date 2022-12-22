<%-- 
    Document   : gdquetthebd
    Created on : Nov 26, 2022, 11:33:17 PM
    Author     : DELL
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Thebandoc325"%>
<%@page import="dao.ThebandocDAO"%>
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
        <link rel="stylesheet" href="../css/scanmavach.css"/>
    </head>  
    <body>
        <div class="main-wrapper">
            <div class="header" style="background-color: #0f0906" >
                <div class = "img-header bg-primary">
                    <img src="../img/bglast1.png" alt="Chania"> 
                    <div> <hr> </div>
                    <div class = "text" style="color: black">
                        <h4>QUÉT MÃ VẠCH SÁCH ĐƯỢC TRẢ</h4>
                    </div>
                </div>

                <div class ="header-below">
                    <ul class="nav  bg-primary justify-content-end nav-pills" >
                        <li class="nav-item " style="text-decoration: none">
                            <a class="nav-link" style="color: black">Chào bạn,
                                <%  Thanhvien325 nv = (Thanhvien325) session.getAttribute("nhanvien");
                                    if (nv == null) {
                                        response.sendRedirect("../index.jsp?err=timeout");
                                    } else {
                                        String hoten = nv.getHoten().getHodem().toString() + " " + nv.getHoten().getTen().toString();
                                %>
                                <%= hoten%>
                                <%
                                    }
                                %>
                            </a>
                        </li>
                    </ul>
                </div>
                <div> <hr> </div>

            </div>
            <div class="page-wrapper">
                <video autoplay muted loop id="myVideo">
                        <source src="../img/rain.mp4" type="video/mp4">
                 </video>
                <div class="content">
                <div class="container_scanner">
                    <div class="input_area">
                        <form class="form_maSV" style="margin-top: 30px;height: 120px" action="gdtrasach325.jsp">
                            <input class="form-control" placeholder="Nhập mã vạch sách trả" autofocus style="border-radius: 6px" required type="text" name="mavachSach"/>
                            <div style="margin-top: 50px">
                                <button class="btn bt-lg btn-danger mt-5 float-right" type="button" name="back" onclick="history.back()">Quay lại</button>
                                <button class="btn bt-lg btn-danger mt-5 float-left" type="submit">Cập nhật</button>
                            </div>
                        </form>
                    </div>
                    
                </div>
                    <div style="height: 100px"><label></label></div>
                </div>

            </div>

        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
                    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
                    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
                    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <footer class=" grid-container bg-primary text-center text-white" style="position: absolute;bottom: 0;width:100%; margin: 0px">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2022 Registered:
            <a class="text-white" href="https://mdbootstrap.com/">Thư Viện Quốc Gia</a>
        </div>
    </footer>
</html>

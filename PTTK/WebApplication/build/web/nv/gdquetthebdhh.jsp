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
        <link rel="stylesheet" href="../css/scanSV.css"/>
    </head>  
    <body>
        <div class="main-wrapper">
            <div class="header" style="background-color: #0f0906" >
                <div class = "img-header bg-primary">
                    <img src="../img/bglast1.png" alt="Chania"> 
                    <div> <hr> </div>
                    <div class = "text" style="color: black">
                        <h4>TÌM KIẾM THÔNG TIN BẠN ĐỌC</h4>
                    </div>
                </div>

                <div class ="header-below">
                    <ul class="nav  bg-primary justify-content-end nav-pills" >
                        <li class="nav-item " style="text-decoration: none">
                            <a class="nav-link" style="color: black">Chào bạn,
                                <%                                    Thanhvien325 nv = (Thanhvien325) session.getAttribute("nhanvien");
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

                <div class="input_area">
                    <form class="form_maSV">
                        <div class="row">
                            <div class="col-md-4">
                                <label>Nhập mã vạch bạn đọc</label>
                                <input class="form-control" type="text" name="mavachBD" required/>
                            </div>
                            <div class="col-md-8" style="margin-top: 28px">
                                <div class="row">
                                    <div class="col-md-2"></div>
                                    <button class="btn bt-lg btn-danger col-md-4" type="submit">Tìm kiếm</button>
                                    <div class="col-md-6"></div>

                                </div>
                            </div>
                        </div>
                        
                    </form>
     
                    <form class="form_maSV" style="margin-top: 50px">
                        <div class="row">
                            <div class="col-md-4 text-center" style="margin-top: 10px; margin-left: 30px">
                                <label style="color: #555; font-size: 15px; ">Nhập mã vạch bạn đọc</label>
                            </div>
                            <div class="col-md-4" style="margin-left: -85px">
                                <input class="form-control" type="text" name="mavachBD" required style="border-width: 1px; border-color: black; border-radius: 4px"/>
                            </div>
                            <div class="col-md-4">
                                <button class="btn bt-lg btn-danger" type="submit">Cập nhật</button>
                            </div>
                        </div>
                    </form>
                    

                    <div class="col-md-18">
                        <table class="table table-hover">
                            <thead class="table-dark" align="center">
                                <tr>
                                    <th scope="col">Mã bạn đọc</th>
                                    <th scope="col">Họ và tên</th>
                                    <th scope="col">Địa chỉ</th>
                                    <th scope="col">Ngày sinh</th>
                                    <th scope="col">SĐT</th>
                                </tr>
                            </thead>
                            <%
                                boolean check = true;
                                Thebandoc325 tbd = new Thebandoc325();
                                String dc = "";
                                String ns = "";
                                if (request.getParameter("mavachBD") != null) {
                                    try {

                                        check = false;
                                        String mavachBD = (String) request.getParameter("mavachBD");
                                        ThebandocDAO dao = new ThebandocDAO();
                                        tbd = dao.getTheBD(mavachBD);

                                        if (tbd.getDiachi().getToanha() != null) {
                                            dc = tbd.getDiachi().getSonha() + ", " + tbd.getDiachi().getToanha() + ", " + tbd.getDiachi().getXompho()
                                                    + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
                                        } else {
                                            dc = tbd.getDiachi().getSonha() + ", " + tbd.getDiachi().getXompho()
                                                    + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
                                        }

                                        Date d = tbd.getNgaysinh();
                                        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
                                        ns = fd.format(d);
                            %>
                            <tbody align="center">
                                <tr>

                                    <td><%= tbd.getId()%></td>
                                    <td><%= tbd.getTen().getHodem() + " " + tbd.getTen().getTen()%></td>
                                    <td><%= dc%></td>
                                    <td><%= ns%></td>
                                    <td><%= tbd.getSdt()%></td>
                                </tr>

                            </tbody>
                            <%
                            } catch (Exception e) {
                            %>
                            <script type="text/javascript">
                                alert("Không tìm thấy bạn đọc có mã vạch này!");
                                history.back();
                            </script>
                            <%
                                    }
                                }
                            %>

                        </table>
                        <div class="row" style="padding-left: 10px; width: 110%;">
                            <a href="gdchinhnv.jsp" class="btn bt-lg btn-danger" >Trở về</a>
                            <%
                                if (!check) {
                            %>
                            <a href="gdtrasach.jsp?ma=<%= tbd.getId()%>&ten=<%= tbd.getTen().getHodem() + " " + tbd.getTen().getTen()%>&ns=<%= ns%>&dc=<%=dc%>&sdt=<%= tbd.getSdt()%>" style="margin-left: 60%;" class="btn bt-lg btn-danger" >Tiếp tục</a>
                            <br>
                            <%
                                }
                            %>

                        </div>
                    </div>


                </div>


            </div>

        </div>
    </body>
    <footer class=" grid-container bg-primary text-center text-white" style="position: absolute;bottom: 0;width:100%; margin: 0px">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2022 Registered:
            <a class="text-white" href="https://mdbootstrap.com/">Thư Viện Quốc Gia</a>
        </div>
    </footer>
</html>

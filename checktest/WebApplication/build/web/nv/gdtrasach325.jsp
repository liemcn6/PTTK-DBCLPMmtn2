<%-- 
    Document   : gdtrasach
    Created on : Nov 27, 2022, 5:13:18 PM
    Author     : DELL
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="dao.SachmuonDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Sachmuon325"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.Thanhvien325"%>
<%@page import="model.Thebandoc325"%>
<%@page import="dao.ThebandocDAO"%>
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
        <%

            boolean check = true;
            boolean test = true;

            List<Sachmuon325> list0 = new ArrayList<>();
            List<Sachmuon325> list1 = new ArrayList<>();
            List<Sachmuon325> listfake = new ArrayList<>();
            Thebandoc325 tbd =new Thebandoc325();
            String dc = "";
            String ns = "";
            SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");

    //kiem tra cach trang nay bi goi
            String mavachSach = request.getParameter("mavachSach");
            String mavachBD = request.getParameter("mavachBD");
            if ((mavachSach == null) || (mavachSach.trim().length() == 0)) {//goi tu trang quet the ban doc
                if (mavachBD != null || (mavachBD.trim().length() != 0)) {

                    try {

                        session.setAttribute("mavachBD", mavachBD);
    //lay thong tin chi tiet ban doc 
                        tbd = (new ThebandocDAO()).getTheBD(mavachBD);
                        

                        if (tbd.getMa() == null) {
        %>
        <script type="text/javascript">
            alert("Không tìm thấy bạn đọc có mã vạch này!");
            history.back();
        </script>
        <%
            }
            session.setAttribute("tbd", tbd);
            if (tbd.getDiachi().getToanha() != null) {
                dc = tbd.getDiachi().getSonha() + " " + tbd.getDiachi().getToanha() + ", " + tbd.getDiachi().getXompho()
                        + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
            } else {
                dc = tbd.getDiachi().getSonha() + " " + tbd.getDiachi().getXompho()
                        + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
            }

            Date d = tbd.getNgaysinh();

            ns = fd.format(d);

            // lay ds sachmuon chua tra + datra
            SachmuonDAO daosm = new SachmuonDAO();
            list0 = daosm.getListSachmuon(mavachBD, false);
            list1 = daosm.getListSachmuon(mavachBD, true);
            //listfake.addAll(list1);
            if (list0.size() > 0) {
                check = false;
            }
            session.setAttribute("list0", list0);
            session.setAttribute("list1", list1);
            //session.setAttribute("fake", listfake);
        } catch (Exception e) {
        %>
        <script type="text/javascript">
            alert("Không tìm thấy bạn đọc có mã vạch này!");
            history.back();
        </script>
        <%
                }
            }
        } else {// goi tu trang quet sach duoc tra
            try {
                session.setAttribute("mavachSach", mavachSach);
//lay thong tin chi tiet ban doc 
                //Thebandoc325 tbd = null;
                tbd = (Thebandoc325) session.getAttribute("tbd");
                session.setAttribute("tbd", tbd);
                if (tbd.getDiachi().getToanha() != null) {
                    dc = tbd.getDiachi().getSonha() + " " + tbd.getDiachi().getToanha() + ", " + tbd.getDiachi().getXompho()
                            + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
                } else {
                    dc = tbd.getDiachi().getSonha() + " " + tbd.getDiachi().getXompho()
                            + ", " + tbd.getDiachi().getPhuongxa() + ", " + tbd.getDiachi().getQuanhuyen() + ", " + tbd.getDiachi().getTinhthanh();
                }

                Date d = tbd.getNgaysinh();

                ns = fd.format(d);

                //ds sachmuon chua tra + datra cap nhat
                list0 = (ArrayList<Sachmuon325>) session.getAttribute("list0");
                list1 = (ArrayList<Sachmuon325>) session.getAttribute("list1");

                check = false;
                boolean tmp = false;
                for (Sachmuon325 i : list0) {
                    if (i.getSach().getMavach().equalsIgnoreCase(mavachSach)) {
                        tmp = true;
                        list0.remove(i);

                        long millis = System.currentTimeMillis();
                        i.setNgaytra(new java.sql.Date(millis));
                        list1.add(i);
                        listfake.add(i);

                        if (list0.size() == 0) {
                            test = false;
                        }

                    }

                    session.setAttribute("list0", list0);
                    session.setAttribute("list1", list1);

                }
                if (!tmp) {
        %>
        <script type="text/javascript">
            alert("Không tìm thấy sách có mã vạch này trong danh sách sách chưa trả của bạn đọc! Hoặc bạn đã quét sách này rồi!");
            history.back();

        </script>
        <%
                    }

                } catch (Exception e) {

                }

            }

        %>

        <div class="main-wrapper">
            <div class="header" style="background-color: #0f0906" >
                <div class = "img-header bg-primary">
                    <img src="../img/bglast1.png" alt="Chania"> 
                    <div> <hr> </div>
                    <div class = "text" style="color: black">
                        <h4>TRẢ SÁCH</h4>
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
                <%
                    //Thebandoc325 tbd = new Thebandoc325();
                    tbd = (Thebandoc325) session.getAttribute("tbd");
                %>
                <div class="input_area">
                    <div class="form_maSV">
                        <div class="row">
                            <div class="col-md-8">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Mã bạn đọc:</label> <%= tbd.getMa()%></h4>
                            </div>
                            <div class="col-md-4">
                                <h4 style="color: black; font-size: 16px; margin-left: 40px"> <label style="color: #555; font-size: 15px"> Tên bạn đọc:</label> <%= tbd.getTen().getHodem() + " " + tbd.getTen().getTen()%></h4>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-md-8">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Địa chỉ:</label> <%= dc%></h4>
                            </div>
                            <div class="col-md-4">
                                <h4 style="color: black; font-size: 16px; margin-left: 40px"> <label style="color: #555; font-size: 15px">Số điện thoại:</label> <%= tbd.getSdt()%></h4>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Ngày sinh:</label> <%= ns%></h4>
                            </div>
                            <div class="col-md-6">

                            </div>
                        </div>
                    </div>

                </div>

                <div class="col-md-18">
                    <label style="color: #555; font-size: 15px;">Danh sách sách mượn chưa trả:</label>
                    <table class="table table-hover">
                        <thead class="table-dark" align="center">

                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên sách</th>
                                <th scope="col">Tác giả</th>
                                <th scope="col">Mã vạch</th>
                                <th scope="col">Ngày mượn</th>
                                <th scope="col">Ngày phải trả</th>

                            </tr>
                        </thead>

                        <tbody align="center">
                            <%
                                if (list0.size() > 0) {
                                    for (int i = 0; i < list0.size(); i++) {
                            %>

                            <tr>

                                <td><%= i + 1%></td>
                                <td><%= list0.get(i).getSach().getDausach().getMa()%></td>
                                <td><%= list0.get(i).getSach().getDausach().getTen()%></td>
                                <td><%= list0.get(i).getSach().getDausach().getTacgia()%></td>
                                <td><%= list0.get(i).getSach().getMavach()%></td>
                                <td><%= fd.format(list0.get(i).getNgaymuon())%></td>
                                <td><%= fd.format(list0.get(i).getNgayphaitra())%></td>

                            </tr>
                            <%
                                    }
                                }
                            %>

                        </tbody>
                    </table>
                    <label style="color: #555; font-size: 15px;margin-top: 20px">Danh sách sách mượn đã trả:</label>
                    <table class="table table-hover">
                        <thead class="table-dark" align="center">
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên sách</th>
                                <th scope="col">Tác giả</th>
                                <th scope="col">Mã vạch</th>
                                <th scope="col">Ngày mượn</th>
                                <th scope="col">Ngày trả</th>
                            </tr>
                        </thead>

                        <tbody align="center">
                            <%
                                if (list1.size() > 0) {
                                    for (int i = 0; i < list1.size(); i++) {
                            %>

                            <tr>

                                <td><%= i + 1%></td>
                                <td><%= list1.get(i).getSach().getDausach().getMa()%></td>
                                <td><%= list1.get(i).getSach().getDausach().getTen()%></td>
                                <td><%= list1.get(i).getSach().getDausach().getTacgia()%></td>
                                <td><%= list1.get(i).getSach().getMavach()%></td>
                                <td><%= fd.format(list1.get(i).getNgaymuon())%></td>
                                <td><%= fd.format(list1.get(i).getNgaytra())%></td>

                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>



                    <div class="row" style="padding: 0px 50px;justify-content: space-between; width: 100%; margin-top: 50px">
                        <a href="gdchinhnv325.jsp" class="btn bt-lg btn-danger" >Về trang chủ</a>
                        <%
                            if (!check) {
                        %>
                        <a href="gdtrasach325.jsp?mavachBD=<%= session.getAttribute("mavachBD")%>" class="btn bt-lg btn-danger" >Đặt lại</a>
                        <%
                            if (test) {
                        %>
                        <a href="gdquetsachtra325.jsp" class="btn bt-lg btn-danger" >Tiếp tục</a>
                        <%
                            }
                            if (listfake.size() > 0) {
                        %>
                        <a href="doUpdateSachmuon.jsp" class="btn bt-lg btn-danger" > Submit </a>
                        <br>
                        <%
                                }
                            }
                        %>

                    </div>
                    <%
                        if (check) {
                    %>
                    <div style="height: 32px"></div>
                    <%
                        }
                    %>
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
                
                
    <footer class=" grid-container bg-primary text-center text-white" style="bottom: 0;width:100%;margin: 0px">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2022 Registered:
            <a class="text-white" href="https://mdbootstrap.com/">Thư Viện Quốc Gia</a>
        </div>
    </footer>
</html>


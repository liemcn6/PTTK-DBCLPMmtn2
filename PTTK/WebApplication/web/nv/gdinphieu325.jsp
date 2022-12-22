<%-- 
    Document   : gdinphieu325.jsp
    Created on : Nov 30, 2022, 10:48:52 PM
    Author     : DELL
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Sachmuon325"%>
<%@page import="model.Thebandoc325"%>
<%@page import="model.Thanhvien325"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>In Phiếu</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/style.css">
        <link rel="stylesheet" href="../css/scanSV.css"/>
    </head>
    <%
        Thanhvien325 nv = (Thanhvien325) session.getAttribute("nhanvien");
        if (nv == null) {
            response.sendRedirect("../index.jsp?err=timeout");
        }
        SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        List<Sachmuon325> list = (ArrayList<Sachmuon325>) session.getAttribute("listTramuon");
        List<Sachmuon325> list0 = (ArrayList<Sachmuon325>) session.getAttribute("list0");
        Thebandoc325 tbd = (Thebandoc325) session.getAttribute("tbd");
        String mvpm = (String) session.getAttribute("mavachPhieumuon");
        String mvbd = (String) session.getAttribute("mavachBD");
    %>

    <body>
        <h1 class="text-center mt-5" style="color: black; font-size: 42px">In phiếu</h1>
        
            <div class="page-wrapper">
                <%
                     if (list0.size()>0) {
                    %>
                <h3 class="text-center" style="color: black;">Phiếu mượn</h3>
                <div class="input_area">
                    <div class="form_maSV">
                        <div class="row">
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Mã bạn đọc:</label> <%= tbd.getMa()%></h4>
                            </div>
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Tên bạn đọc:</label> <%= tbd.getTen().getHodem() + " " + tbd.getTen().getTen()%></h4>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 5px">
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Mã vạch bạn đọc:</label> <%=mvbd%></h4>
                            </div>
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px">Mã vạch phiếu mượn:</label> <%=mvpm%></h4>
                            </div>
                        </div>
                    </div>

                </div>
                  <div class="col-md-18">
                       
                      <table class="table table-hover" style="margin-top: -50px">
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
                            <%
                               
                                    for (int i = 0; i < list0.size(); i++) {
                            %>
                        <tbody align="center">
                           

                            <tr>

                                <td><%= i + 1%></td>
                                <td><%= list0.get(i).getSach().getDausach().getMa()%></td>
                                <td><%= list0.get(i).getSach().getDausach().getTen()%></td>
                                <td><%= list0.get(i).getSach().getDausach().getTacgia()%></td>
                                <td><%= list0.get(i).getSach().getMavach()%></td>
                                <td><%= fd.format(list0.get(i).getNgaymuon())%></td>
                                <td><%= fd.format(list0.get(i).getNgayphaitra())%></td>
                                
                            </tr>
                           

                        </tbody>
                          <%
                                    }
                                    %>
                    </table>
                    
                            <h4 class="text-center" style="color: black; font-size: 16px;position: absolute; right: 0; margin-right: 80px"> <label style="color: #555; font-size: 15px"> Tổng số sách còn mượn :</label> <%=list0.size()%></h4>

                 
                                   
                   
                </div>
                                     <%
                                }
                           
                                 if (list.size()>0) {
                                %>
                <h3 class="text-center" style="color: black; margin-top: 100px">Phiếu phạt</h3>
                <div class="input_area">
                    <div class="form_maSV">
                        <div class="row">
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Mã bạn đọc:</label> <%= tbd.getMa()%></h4>
                            </div>
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Tên bạn đọc:</label> <%= tbd.getTen().getHodem() + " " + tbd.getTen().getTen()%></h4>
                            </div>
                        </div>
                        <div class="row" style="margin-top: 5px">
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px"> Mã vạch bạn đọc:</label> <%=mvbd%></h4>
                            </div>
                            <div class="col-md-6">
                                <h4 style="color: black; font-size: 16px; margin-left: 80px"> <label style="color: #555; font-size: 15px">Mã vạch phiếu mượn:</label> <%=mvpm%></h4>
                            </div>
                        </div>
                    </div>

                </div>
                  <div class="col-md-18">
                      
                      <table class="table table-hover" style="margin-top: -50px">
                        <thead class="table-dark" align="center">

                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Mã</th>
                                <th scope="col">Tên sách</th>
                                <th scope="col">Tác giả</th>
                                <th scope="col">Mã vạch</th>
                                <th scope="col">Ngày mượn</th>
                                <th scope="col">Ngày phải trả</th>
                                <th scope="col">Ngày trả</th>
                                <th scope="col">Số tiền phạt(VNĐ)</th>
                               
                            </tr>
                        </thead>

                        <tbody align="center">
                           
 <%
                               double tong =0, gia=0;
                                    for (int i = 0; i < list.size(); i++) {
                                        gia=(0.2*(list.get(i).getSach().getDausach().getGiabia()));
                                        tong+=gia;
                            %>
                            <tr>

                                <td><%= i + 1%></td>
                                <td><%= list.get(i).getSach().getDausach().getMa()%></td>
                                <td><%= list.get(i).getSach().getDausach().getTen()%></td>
                                <td><%= list.get(i).getSach().getDausach().getTacgia()%></td>
                                <td><%= list.get(i).getSach().getMavach()%></td>
                                <td><%= fd.format(list.get(i).getNgaymuon())%></td>
                                <td><%= fd.format(list.get(i).getNgayphaitra())%></td>
                                <td><%= fd.format(list.get(i).getNgaytra())%></td>
                                <td><%= gia%></td>
                                
                            </tr>
                           
 <%
                                    }
                                    %>
                        </tbody>
                       
                    </table>
                    
                        

                   
                                        <h4 class="text-center" style="color: black; font-size: 16px; position: absolute; right: 0; margin-right: 80px"> <label style="color: #555; font-size: 15px"> Tổng tiền phạt :</label> <%=tong + " VNĐ"%></h4>
                                    <%
                                        List<Sachmuon325> listTramuon = new ArrayList<>();
                                    session.setAttribute("listTramuon", listTramuon);
                                }
                            %>
                    
                    <div class="row" style="padding: 0px 50px;justify-content: space-between; width: 100%; margin-top: 50px">
                        <a href="gdchinhnv325.jsp" class="btn bt-lg btn-danger" >Về trang chủ</a>
                        

                    </div>
                    
                </div>
            </div>
       
    </body>
</html>

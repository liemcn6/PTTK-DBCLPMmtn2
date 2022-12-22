<%-- 
    Document   : phieumuon
    Created on : Nov 11, 2022, 6:56:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/phieumuon.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="information_Reader">
            <h3>Phiếu mượn</h3>
            <div class="row">
                <div class="col-4">
                    <div>Mã bạn đọc: B18DCCN132</div>
                    <div>Họ và tên: Đoàn Trọng Đán</div>
                    <div>Điện thoại: 0966310752</div>
                </div>
                <div class="col-4">
                    <div>Mã vạch: /////////</div>
                    <div>Ngày sinh: 03/01/2000</div>
                    <div>Địa chỉ: Nam Trực, Nam Định</div>
                </div>
                <div class="col-4">
                    <div>Mã phiếu: /////////</div>                   
                </div>
            </div>
            <h4>Danh sách sách mượn chưa trả: </h4>
            <div>
                <table  class="table">
                    <thead>
                    <th style="width: 100px">Mã</th>
                    <th>Tên Sách</th>
                    <th>Tác giả</th>
                    <th>Mã vạch</th>
                    <th>Ngày mượn</th>
                    <th>Ngày trả</th>
                    <tbody>
                        <tr>
                            <td>Dc345</td>
                            <td>Lập trình hướng đối tượng</td>
                            <td>Lê Bá Chi</td>
                            <td>//////////</td>
                            <td>10/05/2022</td>
                            <td>10/06/2022</td>
                        </tr>
                        <tr>
                            <td>Ec341</td>
                            <td>Cấu trúc dữ liệu và giải thuật</td>
                            <td>Mai Xuân Bách</td>
                            <td>//////////</td>
                            <td>10/05/2022</td>
                            <td>10/06/2022</td>
                        </tr>
                    </tbody>
                    </thead>
                </table>
            </div>
            <button class="quayve btn left btn-success">Quay về</button>
        </div>
    </body>
</html>
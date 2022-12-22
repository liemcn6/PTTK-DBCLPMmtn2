<%-- 
    Document   : Thongtinbandoc
    Created on : Nov 11, 2022, 6:53:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/thongtinbandoc.css"/>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div class="information_Reader">
            <h3>Thông tin bạn đọc</h3>
            <div class="row">
                <div class="col-6">
                    <div>Mã bạn đọc: B18DCCN132</div>
                    <div>Họ và tên: Đoàn Trọng Đán</div>
                    <div>Điện thoại: 0966310752</div>
                </div>
                <div class="col-6">
                    <div>Mã vạch: /////////</div>
                    <div>Ngày sinh: 03/01/2000</div>
                    <div>Địa chỉ: Nam Trực, Nam Định</div>
                </div>
            </div>
            <h4>Danh sách sách mượn chưa trả: </h4>
            <div>
                <table  class="table">
                    <thead>
                    <th style="width: 100px">STT</th>
                    <th>Tên Sách</th>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Tây du ký</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Tam quốc diễn nghĩa</td>
                        </tr>
                    </tbody>
                    </thead>
                </table>
            </div>
            <h4>Danh sách sách mượn đã trả: </h4>
            <div>
                <table class="table">
                    <thead>
                    <th style="width: 100px">STT</th>
                    <th>Tên Sách</th>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Đại số 1</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>Giải tích 2</td>
                        </tr>
                    </tbody>
                    </thead>
                </table>
            </div>
            <div class="input_area">
                <form class="form_maSV">
                    <label>Nhập mã sách chọn mượn</label>
                    <input class="form-control"/>
                    <button class="btn btn-primary mt-5 float-left" type="submit">Xác nhận</button>
                </form>
            </div>
        </div>
    </body>
</html>

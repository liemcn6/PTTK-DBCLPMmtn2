<%-- 
    Document   : login
    Created on : Nov 11, 2022, 6:54:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/login.css"/>
    <div id="login">
        <h2 class="text-center text-white pt-5">Quản lý thư viện Quốc gia</h2>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="doDangnhap.jsp" method="post">
                            <h3 class="text-center text-info">Đăng nhập</h3>
                            <%
                            if(request.getParameter("err") !=null &&
                           request.getParameter("err").equalsIgnoreCase("timeout")){
                            %> 
                            <p style="color: red">Hết phiên làm việc. Vui lòng đăng nhập lại!</p>
                            <%
                            }else if(request.getParameter("err") !=null &&
                           request.getParameter("err").equalsIgnoreCase("fail")){
                            %>
                            <p style="color: red">Sai tên đăng nhập/mật khẩu!</p>
                            <%
                            }
                        %>
                            <div class="form-group">
                                <label for="username" class="text-info">Tên đăng nhập:</label><br>
                                <input type="text" name="username" id="username" class="form-control" placeholder="Nhập tên người dùng" required>
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Mật khẩu:</label><br>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Nhập mật khẩu" required>
                            </div>
                            <div class="form-group" style="position: absolute; bottom: 0px;right: 50px;">
                                <input type="submit" name="submit" class="btn btn-primary btn-md" value="Đăng nhập">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

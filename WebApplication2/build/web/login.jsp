<%-- 
    Document   : login
    Created on : Nov 11, 2022, 6:54:46 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/login.css"/>
    <div id="login">
        <h3 class="text-center text-white pt-5">Quản lý thư viện Quốc gia</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="LoginController" method="post">
                            <h3 class="text-center text-info">Đăng nhập</h3>
                            <p>${mess}</p>
                            <div class="form-group">
                                <label for="username" class="text-info">Tài khoản:</label><br>
                                <input type="text" name="tendangnhap" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Mật khẩu:</label><br>
                                <input type="text" name="matkhau" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" name="Đăng nhập" class="btn btn-info btn-md" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Đổi mật khẩu</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Place favicon.ico in the root directory -->
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">
    <link rel="shortcut icon" type="image/ico" href="images/favicon.ico" />
    <!-- Plugin-CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/icofont.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/cardslider.css">
    <link rel="stylesheet" href="css/responsiveslides.css">
    <!-- Main-Stylesheets -->
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/overright.css">
    <link rel="stylesheet" href="css/theme.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="js/jQuery.js"></script>
</head>

<body data-spy="scroll" data-target="#mainmenu" data-offset="50">
    <header class="relative" id="sc1">
        <!-- Header-background-markup -->
        <div class="overlay-bg relative">
            <img src="images/slide/slide2.jpg" alt="">
        </div>
        <!-- Mainmenu-markup-start -->
        <div class="mainmenu-area navbar-fixed-top" data-spy="affix" data-offset-top="10">
            <nav class="navbar">
                <div class="container">
                    <div class="navbar-header">
                        <div class="space-10"></div>
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainmenu">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!--Logo-->
                        <!-- <a href="#sc1" class="navbar-left show"><img src="images/logo.png" alt="library"></a> -->
                        <div class="space-10"></div>
                    </div>
                    <!--Mainmenu list-->
                    <div class="navbar-right in fade" id="mainmenu">
                        <ul class="nav navbar-nav nav-white text-uppercase">
                            <li>
                                <a href="index.html">Trang chủ</a>
                            </li>
                            <li>
                                <a href="#">Giới thiệu</a>
                            </li>
                            <li>
                                <a href="notification.html">Thông báo</a>
                            </li>
                            <li>
                                <a href="room.html">Phòng đọc</a>
                            </li>
                            <li>
                                <a href="feedback.html">Phản hồi</a>
                            </li>
                            <li>
                                <a href="books.html">Sách</a>
                            </li>
                            <li class="active">
                                <a href="login.html">Đăng nhập</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <div class="space-100"></div>
        <!-- Mainmenu-markup-end -->
        <!-- Header-jumbotron -->
        <div class="space-100"></div>
        <div class="header-text">
            <div class="container">
                <div class="row wow fadeInUp">
                    <div class="col-xs-12 col-sm-10 col-sm-offset-1 text-center">
                        <div class="jumbotron">
                            <h1 class="text-white">Đổi mật khẩu</h1>
                        </div>
                        <div class="title-bar white">
                            <ul class="list-inline list-unstyled">
                                <li><i class="icofont icofont-square"></i></li>
                                <li><i class="icofont icofont-square"></i></li>
                            </ul>
                        </div>
                        <div class="space-40"></div>
                    </div>
                </div>
                <div class="row wow fadeInUp" data-wow-delay="0.5s">
                    <div class="row">
                        <div class="col-xs-12 col-md-8 col-md-offset-4">
                            <form action="#" id = "register_form">
                                <div class="space-20"></div>
                                <div class="row">
                                    <div class="col-xs-12 col-md-7">
                                        <div class="form-group">
                                            <label for="old_password">Nhập mật khẩu cũ</label>
                                            <input type="password" id="old_password" class="form-control bg-none" placeholder="Old password...">
                                            <span id="old_password_error" style="color: red"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="space-20"></div>
                                <div class="row">
                                    <div class="col-xs-12 col-md-7">
                                        <div class="form-group">
                                            <label for="new_password">Mật khẩu mới</label>
                                            <input type="password" id="new_password" class="form-control bg-none" placeholder="New password...">
                                            <span id="new_password_error" style="color: red"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="space-20"></div>
                                <div class="row">
                                    <div class="col-xs-12 col-md-7">
                                        <div class="form-group">
                                            <label for="confirm_password">Xác nhận mật khẩu mới</label>
                                            <input type="password" id="confirm_password" class="form-control bg-none" placeholder="Confirm new password...">
                                            <span id="confirm_password_error" style="color: red"></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="space-20"></div>
                                <div class="row">
                                 <div class="col-xs-12 col-sm-6">
                                    <button id="btnDMK" type="button" class="btn btn-default">Đổi mật khẩu<i class="fa fa-long-arrow-right"></i></button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="space-100"></div>
    <!-- Header-jumbotron-end -->
</header>
<!-- Footer-Area-End -->
<!-- Vandor-JS -->
<script src="js/vendor/jquery-1.12.4.min.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<!-- Plugin-JS -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script src="js/jquery.cardslider.min.js"></script>
<script src="js/pagination.js"></script>
<script src="js/scrollUp.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/plugins.js"></script>
<!-- Active-JS -->
<script src="js/main.js"></script>
<script>
	$(document).ready(function(){
		$("#old_password_error").hide();
		$("#new_password_error").hide();
		$("#confirm_password_error").hide();

		
		var old_password_error = false;
		var new_password_error = false;
		var confirm_password_error = false;


		$("#old_password").focusout(function() {
			checkOldPassword();
		});
		$("#new_password").focusout(function() {
			checkNewPassword();
		});
		$("#confirm_password").focusout(function() {
			checkConfirmPassword();
		});

		function checkOldPassword(){
			if($("#old_password").val().length <= 0){
				$("#old_password_error").html("Bạn chưa nhập mật khẩu");
				old_password_error = true;
				$("#old_password_error").show();
			}
			else{
				old_password_error = false;
				$("#old_password_error").hide();
			}
		}
		function checkNewPassword(){
			if($("#new_password").val().length < 6 || $("#new_password").val().length > 15){
				$("#new_password_error").html("Password phải có 6-15 kí tự");
				password_error = true;
				$("#new_password_error").show();
			}else if($("#new_password").val().length == 0){
				$("#new_password_error").html("Vui lòng nhập mật khẩu mới");
				confirm_password_error = true;

				$("#new_password_error").show();
			}
			else{
				password_error = false;
				$("#new_password_error").hide();
			}
		}
		function checkConfirmPassword(){
			if($("#confirm_password").text() != $("#new_password").text()){
				$("#confirm_password_error").html("Password không giống nhau");
				confirm_password_error = true;

				$("#confirm_password_error").show();
			}
			else if($("#confirm_password").val().length == 0){
				$("#confirm_password_error").html("Vui lòng nhập xác nhận mật khẩu mới");
				confirm_password_error = true;

				$("#confirm_password_error").show();

			}
			else{
				confirm_password_error = false;
				$("#confirm_password_error").hide();
			}
		}
		
		$("#btnDMK").click(function(){
			checkOldPassword();
			checkNewPassword();
			checkConfirmPassword();

			if( old_password_error || new_password_error || confirm_password_error){

			}
			else{
				var oldPassword = $("#old_password").val();
				var newPassword = $("#new_password").val();
				$.post("DoiMatKhau", {oldPassword : oldPassword, newPassword : newPassword}, function(result){
					if(result == "success")
						alert("Đổi mật khẩu thành công");
					else if(result == "error")
						alert("Xảy ra lỗi!!!");
					else 
						alert("Mật khẩu không đúng");
				});
			}
		});
	});
</script>
</body>

</html>
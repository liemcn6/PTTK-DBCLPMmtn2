<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js" lang="zxx">


<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Phòng đọc</title>
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
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="css/responsive.css">
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body data-spy="scroll" data-target="#mainmenu" data-offset="50">
	<header class="relative" id="sc1">
		<!-- Header-background-markup -->
		<div class="overlay-bg relative">
			<img src="images/slide/slide3.jpg" alt="">
		</div>
		<!-- Mainmenu-markup-start -->
		<div class="mainmenu-area navbar-fixed-top" data-spy="affix"
			data-offset-top="10">
			<nav class="navbar">
				<div class="container">
					<div class="navbar-header">
						<div class="space-10"></div>
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#mainmenu">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<!--Logo-->
						<!-- <a href="#sc1" class="navbar-left show"><img src="images/logo.png" alt="library"></a> -->
						<div class="space-10"></div>
					</div>
					<!--Toggle-button-->

					<!--Active User-->
					<div class="nav navbar-right">
						<div class="active-user navbar-left active">
							<ul class="list-unstyled">
								<li><a href="#" class="dropdown-toggle"
									data-toggle="dropdown"> <img src="images/active_user.png"
										class="img-circle img-thumbnail" alt="library" />
								</a>
									<ul class="dropdown-menu">
										<li><a href="#"> <span><i
													class="icofont icofont-user"></i></span> Thông tin cá nhân
										</a></li>
										<!-- <li>
                                            <a href="#"> <span><i class="icofont icofont-notification"></i></span> Notifications</a>
                                        </li> -->
										<li><a href="#"> <span><i
													class="icofont icofont-ui-password"></i></span> Đổi mật khẩu
										</a></li>
										<li><a href="#"> <span><i
													class="icofont icofont-read-book"></i></span> Sách của tôi
										</a></li>
										<li><a href="#"> <span><i
													class="icofont icofont-logout"></i></span> Đăng xuất
										</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
					<!--Mainmenu list-->
					<div class="navbar-right in fade" id="mainmenu">
						<ul class="nav navbar-nav nav-white text-uppercase">
							<li><a href="index.jsp">Trang chủ</a></li>
							<li><a href="#">Giới thiệu</a></li>
							<li><a href="noitification.jsp">Thông báo</a></li>
							<li class="active"><a href="room.jsp">Phòng đọc</a></li>
							<li><a href="feedback.jsp">Phản hồi</a></li>
							<li><a href="books.jsp">Sách</a></li>
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
							<h1 class="text-white">Phòng đọc sách tổng hợp</h1>
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
			</div>
		</div>
		<div class="space-100"></div>
		<!-- Header-jumbotron-end -->
	</header>
	<section>
		<div class="space-80"></div>
		<div class="container">
			<div class="row">
				<!-- Sidebar-Start -->
				<div class="col-xs-12 col-md-3">
					<aside>
						<div class="sigle-sidebar">
							<h4>
								<i class="icofont icofont-listine-dots"></i> Danh mục
							</h4>
							<hr>
							<ul class="list-unstyled menu-tip">
								<li><a href="#" class="active">Phòng đọc sách tổng hợp</a></li>
								<li><a href="#">Phòng đọc đa phương tiện</a></li>
								<li><a href="#">Phòng mượn sách</a></li>
								<li><a href="#">Phòng cấp thẻ</a></li>
								<li><a href="#">Phòng đọc báo - tạp chí</a></li>
								<li><a href="#">Phòng thiếu nhi</a></li>
							</ul>
						</div>
						<div class="space-20"></div>
					</aside>
				</div>
				<!-- Sidebar-End -->
				<div class="col-xs-12 col-md-9">
					<h4>Giới thiệu phòng</h4>

					<hr>
					<div class="space-20"></div>

					<!-- Thông tin phòng ở đây -->
					<p>- Là kho tài liệu có giá trị, quý hiếm và đầy đủ nhất của
						thư viện, được tổ chức kho đóng và sắp xếp theo số đăng ký cá
						biệt.</p>
					<p>- Có chức năng lưu trữ, bảo quản lâu dài và cung cấp thông
						tin trên nhiều lĩnh vực tri thức, gồm: tài liệu tiếng việt, tài
						liệu ngoại văn, tài liệu tra cứu.</p>

					<p>- Nhằm đáp ứng nhu cầu nghiên cứu, học tập và sử dụng tại
						chỗ vốn tài liệu cho các đối tượng bạn đọc.</p>

					<p>Vốn tài liệu:</p>

					<p>- Sách Tiếng Việt: 75.874 bản / 66.500 nhan đề</p>

					<p>- Sách Ngoại văn: 7.722 bản / 5.148 nhan đề</p>

					<p>Lịch làm việc trong tuần:</p>

					<p>- Ngày làm việc: Thứ ba, thứ tư, thứ năm, thứ sáu, thứ bảy,
						chủ nhật.</p>

					<p>- Ngày nghỉ: Thứ hai.</p>
					<p>+ Buổi sáng: Từ 7 giờ 30 phút đến 11 giờ 30 phút</p>

					<p>+ Buổi chiều: Từ 13 giờ đến 16 giờ 45 phút</p>

					<p>Thủ thư:</p>
					<p>Huỳnh Hồng Phúc</p>

				</div>

			</div>
		</div>
		<div class="space-80"></div>
	</section>
	<!-- Footer-Area -->
	<footer class="black-bg text-white">
		<div class="space-60"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-4">
					<a href="#"><img src="images/logo.png" alt="library"></a>
					<div class="space-20"></div>
					<p>Đến, đọc, tận hưởng.</p>
					<div class="space-10"></div>
					<ul class="list-inline list-unstyled social-list">
						<li><a href="#"><i
								class="icofont icofont-social-facebook"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-twitter"></i></a></li>
						<li><a href="#"><i class="icofont icofont-social-behance"></i></a></li>
						<li><a href="#"><i class="icofont icofont-brand-linkedin"></i></a></li>
					</ul>
					<div class="space-10"></div>
					<ul class="list-unstyled list-inline tip yellow">
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
						<li><i class="icofont icofont-square"></i></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
					<h4 class="text-white">Liên hệ</h4>
					<div class="space-20"></div>
					<table class="table border-none addr-dt">
						<tr>
							<td><i class="icofont icofont-social-google-map"></i></td>
							<td><address>Số 1, Võ Văn Ngân, Thủ Đức, TP. Hồ
									Chí Minh</address></td>
						</tr>
						<tr>
							<td><i class="icofont icofont-email"></i></td>
							<td>susislibrary@domain.com</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-phone"></i></td>
							<td>+62 582 528 527 21</td>
						</tr>
						<tr>
							<td><i class="icofont icofont-globe-alt"></i></td>
							<td><a href="www.susislibrary.jsp" target="_blank">www.susislibrary.com</a></td>
						</tr>
					</table>
				</div>
				<!-- <div class="col-xs-12 col-sm-4 col-md-3 col-md-offset-1">
                    <h4 class="text-white">Useful Link</h4>
                    <div class="space-20"></div>
                    <ul class="list-unstyled menu-tip">
                        <li><a href="books.jsp">Costumer Service</a></li>
                        <li><a href="books.jsp">Help Desk</a></li>
                        <li><a href="books.jsp">Forum</a></li>
                        <li><a href="books.jsp">Staff Profile</a></li>
                        <li><a href="books.jsp">Live Chat</a></li>
                    </ul>
                </div> -->
			</div>
		</div>
		<div class="space-60"></div>
	</footer>
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

</body>

</html>
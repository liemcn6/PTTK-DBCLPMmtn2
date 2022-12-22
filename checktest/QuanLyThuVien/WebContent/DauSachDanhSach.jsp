<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html class="no-js" lang="zxx">


<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Sách</title>
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
			<img src="images/slide/slide1.jpg" alt="">
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
							<li><a href="room.jsp">Phòng đọc</a></li>
							<li><a href="feedback.jsp">Phản hồi</a></li>
							<li class="active"><a href="books.jsp">Sách</a></li>
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
							<h1 class="text-white">Chọn sách của bạn và tận hưởng</h1>
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
				<div class="col-xs-12 col-md-2">
					<aside>
						<div class="sigle-sidebar">
							<h4>
								<i class="icofont icofont-listine-dots"></i>Thể Loại
							</h4>
							<hr>
							<ul class="list-unstyled menu-tip">
								<c:forEach var="theLoai" items="${listTheLoai}">
									<li><a
										href="/QuanLyThuVien/DauSachDanhSach?maTheLoai=<c:out value='${theLoai.getMaTheLoai()}' />"><c:out
												value="${theLoai.getTenTheLoai() }"></c:out></a></li>
								</c:forEach>
							</ul>
							<a href="#" class="btn btn-primary btn-xs">Xem thêm</a>

						</div>

						<div class="space-20"></div>
					</aside>
				</div>
				<!-- Sidebar-End -->
				<div class="col-xs-12 col-md-10 pull-right">
					<h4>Tìm kiếm</h4>
					<div class="space-5"></div>
					<form method="post" action="/QuanLyThuVien/DauSachDanhSach">
						<div class="input-group">
							<input type="text" class="form-control" id="txtSearch"
								name="txtSearch"
								placeholder="Nhập tên sách hoặc tên tác giả, ngôn ngữ,..."
								value="${txtSearch}"> <input type="hidden"
								class="form-control" id="pages" name="pages"
								value="${soTrangHienTai}">
							<div class="input-group-btn">
								<input type="submit" value="Tìm Kiếm"
									class="btn btn-primary icofont icofont-search-alt-2">
							</div>
						</div>
						<div class="space-30"></div>
						<div class="row">
							<div class="pull-left col-xs-12 col-sm-5 col-md-6">
								<!-- <p>Kết quả <a href="#" class="text-primary">"How To Be a Designer"</a></p> -->
								<p>
									<strong><c:out value="${listDauSach.size() }"></c:out></strong>
									of <strong><c:out value="${total }"></c:out></strong> cuốn sách
									được tìm thấy
								</p>
							</div>
							<!-- sắp xếp(từ từ tính) -->
							<div class="pull-right col-xs-12 col-sm-7 col-md-6">

								<div class="form-group">
									<label class="control-label col-xs-4" for="sort">Sắp
										xếp theo : </label>
									<div class="col-xs-8">
										<div class="form-group">
											<select name="selectSort" id="selectSort"
												class="form-control" onchange="this.form.submit()">
												<option value="AZ">A-Z</option>
												<option value="ZA">Z-A</option>
												<option value="TacGia">Tác Giả</option>
												<option value="NamXuatBan">Năm Xuất Bản</option>
											</select>
										</div>
									</div>
									<script type="text/javascript">
										document.getElementById("selectSort").value = "${selectSort}";
									</script>
								</div>
					</form>
				</div>
			</div>
			<hr>
			<div class="space-20"></div>
			<div class="row">


				<c:forEach var="dauSach" items="${listDauSach}">
					<div class="col-xs-12 col-md-6">
						<div class="category-item well yellow">
							<div class="media">
								<div class="media-left">
									<img
										src="http://localhost:8080/QuanLyThuVien/getAnhBia?maDauSach=${dauSach.getMaDauSach() }"
										class="media-object" alt="Not found image" width="auto"
										height="290px">
								</div>
								<div class="media-body">
									<h5>
										<c:out value="${dauSach.getTenSach()}" />
									</h5>
									<h6>
										<c:out value="${dauSach.getTacGia()}" />
									</h6>
									<div class="space-10"></div>
									<ul class="list-inline list-unstyled rating-star">
										<li class="active"><i class="icofont icofont-star"></i></li>
										<li class="active"><i class="icofont icofont-star"></i></li>
										<li class="active"><i class="icofont icofont-star"></i></li>
										<li class="active"><i class="icofont icofont-star"></i></li>
										<li><i class="icofont icofont-star"></i></li>
									</ul>
									<div class="space-10"></div>
									<p>
										<c:out value="${dauSach.getMoTa()}" />
									</p>
									<a
										href="/QuanLyThuVien/DauSachNoiDung?maDauSach=<c:out value='${dauSach.getMaDauSach()}' />"
										class="text-primary">Xem sách</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

				<div class="space-60"></div>
				<div class="row">
					<div class="col-xs-12">
						<div class="shop-pagination pull-right">
							<ul id="" class="pagination-sm pagination">
								<li class="page-item first"><a
									href="/QuanLyThuVien/DauSachDanhSach?pages=1" class="page-link">First</a></li>
								<c:if test="${soTrangHienTai >=2 }">
									<li class="page-item prev"><a
										href="/QuanLyThuVien/DauSachDanhSach?pages=<c:out value='${soTrangHienTai-1}'/>&txtSearch=<c:out value='${txtSearch}'/>&selectSort=<c:out value='${selectSort}'/>"
										class="page-link">Previous</a></li>
								</c:if>
								<c:forEach var="i" begin="1" end="${soTrang}" step="1">
									<c:if test="${soTrangHienTai == i }">
										<li class="page-item active"><a
											href="/QuanLyThuVien/DauSachDanhSach?pages=<c:out value='${i}'/>&txtSearch=<c:out value='${txtSearch}'/>&selectSort=<c:out value='${selectSort}'/>"
											class="page-link"><c:out value="${i}"></c:out></a></li>
									</c:if>
									<c:if test="${soTrangHienTai != i }">
										<li class="page-item "><a
											href="/QuanLyThuVien/DauSachDanhSach?pages=<c:out value='${i}'/>&txtSearch=<c:out value='${txtSearch}'/>&selectSort=<c:out value='${selectSort}'/>"
											class="page-link"><c:out value="${i}"></c:out></a></li>
									</c:if>
								</c:forEach>
								<c:if test="${soTrangHienTai < soTrang }">
									<li class="page-item next"><a
										href="/QuanLyThuVien/DauSachDanhSach?pages=<c:out value='${soTrangHienTai+1}'/>&txtSearch=<c:out value='${txtSearch}'/>&selectSort=<c:out value='${selectSort}'/>"
										class="page-link">Next</a></li>
								</c:if>
								<li class="page-item last"><a
									href="/QuanLyThuVien/DauSachDanhSach?pages=<c:out value='${soTrang}'/>&txtSearch=<c:out value='${txtSearch}'/>&selectSort=<c:out value='${selectSort}'/>"
									class="page-link">Last</a></li>
							</ul>
						</div>
					</div>
				</div>
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
							<td><a href="www.susislibrary.com" target="_blank">www.susislibrary.com</a></td>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chọn loại thống kê</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="main-wrapper style=" background-color:rgba(0, 128, 0, 0.3);">
		<div class="header">

			<div class="header-left ">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					<!-- Brand/logo -->
					<a class="navbar-brand" href="gdChinhQL.html"> <img
						src="img/ptit.jpg" alt="logo"
						style="width: 60px; border-radius: 14px;">
					</a>

					<!-- Links -->
					<ul class="nav" style="color: white">
						<li class="nav-item"><a class="nav-link" href="gdChinhQL">Trang
								Chủ</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Thông
								Báo</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Trang
								Kế</a></li>
					</ul>
				</nav>
			</div>
			<div class="page-wrapper">

				<div class="content">
					<div class="col-md-6">
						<div class="row ">
							<button type="button" class="btn btn-danger btn-lg btn-block"
								data-toggle="tooltip" title="Cần cấp phát quyền truy cập">TKTC
								THEO THỜI GIAN *</button>
						</div>
						<div class="row">
							<button type="button" class="btn btn-danger btn-lg btn-block"
								data-toggle="tooltip" title="Cần cấp phát quyền truy cập">TKĐL
								THEO DOANH THU</button>
						</div>
						<div class="row">
							<button type="button"
								onclick="location.href ='GDChonThoiGianThongKe.jsp'"
								class="btn btn-danger btn-lg btn-block" data-toggle="tooltip"
								title="Xem thống kê sản phẩm">TKSP THEO DOANH THU</button>
						</div>
					</div>
				</div>
			</div>
			<button class="btn btn-dark" style="margin: 15px"
				onclick="location.href ='GDQL.jsp'">Quay Lại</button>
		</div>

	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
<footer class=" grid-container bg-primary text-center text-white">



	<div class="text-center p-3"
		style="background-color: rgba(0, 0, 0, 0.85); padding-bottom: 10px;">
		© 2021 Registered: <a class="text-white"
			href="https://mdbootstrap.com/">Đại Lý Trung Gian CO.LTD</a>
	</div>
	<!-- Copyright -->
</footer>

</div>
<!-- Copyright -->
</footer>
</html>
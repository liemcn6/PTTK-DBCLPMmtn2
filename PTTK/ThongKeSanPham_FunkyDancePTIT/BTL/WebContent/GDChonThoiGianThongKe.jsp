<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thời gian thống kê</title>
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
	<div class="main-wrapper">
		<div class="header bg-primary text-white">
			<div class="header-left ">
				<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
					<!-- Brand/logo -->
					<a class="navbar-brand" href="#"> <img src="img/ptit.jpg"
						alt="logo" style="width: 60px; border-radius: 14px;">
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

		</div>

		<div class="page-wrapper">
			<div class="content3">
				<div class="col-md-6">
					<form action="GDTKSanPham.jsp" class="form-label" method="POST">
						<div class="form-group label label-primary">
							<label style="font-weight: bold">
								<h4>Thống kê sản phẩm theo doanh thu:</h4>
							</label>


						</div>
						<div class=" form-control">
							<div class="form-group">
								<label>Thời gian bắt đầu</label> <input type="date"
									class="form-control" name="ngaybatdau" required>
							</div>
							<div class="form-group">
								<label>Thời gian kết thúc</label> <input type="date"
									class="form-control" name="ngayketthuc" required>

							</div>
							<div class="row">
								<input type="submit" class="btn btn-danger" value="Xem">
							</div>

						</div>
				</div>
			</div>
			</form>

		</div>

	</div>

	</div>
	</div>
	<button class="btn btn-dark" style="margin: 15px"
		onclick="location.href ='GDQL.jsp'">Quay Lại</button>
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
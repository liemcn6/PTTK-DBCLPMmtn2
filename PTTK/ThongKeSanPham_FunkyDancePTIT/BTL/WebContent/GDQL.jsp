<%@page import="model.ThanhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản Lý Đại Lý Trung Gian</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<style>
</style>
</head>

<%

	 ThanhVien tv2 = (ThanhVien)session.getAttribute("username");	
		
%>



<body>
	<div class="main-wrapper">
		<div class="header">
			<div class="img-header bg-primary">
				<img src="img/bg2.jpg" alt="Chania">
				<div class="anh-nen">
					<div class="anh-nen-1">
						<img src="img/flag1.png" alt="Chanifffa">
					</div>

					<div class="anh-nen-2">
						<img src="img/flag2.png" alt="Chania">

					</div>
					<span class="welcome"> <span> </span>Hello username: <%=tv2.getUsername()%></span>
				</div>

				<div>
					<hr>
				</div>


				<div class="text ">
					<h4>ĐẠI LÝ TRUNG GIAN</h4>

				</div>
			</div>

			<div class="header-below">

				<ul class="nav  bg-primary justify-content-end nav-pills">
					<li class="nav-item btn-success"><a
						class="nav-link btn-success" href="doDangNhap.jsp">QUẢN TRỊ</a></li>
					<li class="nav-item btn-success"><a
						class="nav-link btn-success " href="doDangNhap.jsp">CÀI ĐẶT</a></li>
					<li class="nav-item btn-success"><a
						class="nav-link btn-success" href="doDangNhap.jsp">THÔNG TIN</a></li>
					<li class="nav-item btn-success"><a
						class="nav-link btn-success" href="GDDangNhap.jsp">ĐĂNG XUẤT</a></li>
				</ul>
			</div>
		</div>
	</div>




	<div class="page-wrapper">
		<video autoplay muted loop id="myVideo">
			<source src="img/rain.mp4" type="video/mp4">

		</video>

		<div class="content2">

			<button class="btn btn-dark btn-rounded" id="myBtn"
				onclick="myFunction()">Pause</button>
		</div>

		<h2>Hãy lựa chọn một chức năng:</h2>
		<div class="content">
			<div class="col-md-6">
				<div class="row ">
					<button type="button" class="btn btn-danger btn-lg btn-block"
						data-toggle="tooltip" title="Cần cấp phát quyền truy cập">QUẢN
						LÝ XUẤT NHẬP</button>
				</div>
				<div class="row">
					<button type="button" class="btn btn-danger btn-lg btn-block"
						data-toggle="tooltip" title="Cần cấp phát quyền truy cập">
						QUẢN LÝ NHÂN VIÊN</button>
				</div>

				<div class="row">
					<a href="GDTK.jsp" type="button"
						class=" btn btn-danger btn-lg btn-block" data-toggle="tooltip"
						onclick="openPage('GDTK.jsp') title=" Thống kê các đối tượng liênquan" >THEO
						DÕI THỐNG KÊ</a>
				</div>
			</div>
		</div>
	</div>
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
	<div>




		<script>
var video = document.getElementById("myVideo");
var btn = document.getElementById("myBtn");

function myFunction() {
  if (video.paused) {
    video.play();
    btn.innerHTML = "Pause";
  } else {
    video.pause();
    btn.innerHTML = "Play";
  }
}

$(document).ready(function(){
 $('[data-toggle="tooltip"]').tooltip();
});

</script>
	</div>
</body>
<footer class=" grid-container bg-primary text-center text-white">



	<div class="text-center p-3"
		style="background-color: rgba(0, 0, 0, 0.85);">
		© 2021 Registered: <a class="text-white"
			href="https://mdbootstrap.com/">Đại Lý Trung Gian CO.LTD</a>
	</div>
	<!-- Copyright -->
</footer>

</div>
<!-- Copyright -->
</footer>
</html>
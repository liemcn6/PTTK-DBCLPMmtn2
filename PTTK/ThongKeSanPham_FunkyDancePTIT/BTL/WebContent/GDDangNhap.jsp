
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0">
<title>Quản lý đăng nhập</title>

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<%
      if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
          %>
	<h4>Hết phiên làm việc, hãy đăng nhập lại!</h4>
	<%
      }else if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail")){
          %>
	<h4 style="color: red; text-align: center; margin-top: 100px;">Sai
		thông tin đăng nhập!</h4>
	<%
      } 
 %>

	<div class="main-wrapper account-wrapper">
		<div class="account-page">
			<div class="account-center">
				<div class="account-box" style="margin: 0 auto;">
					<form action="doDangNhap.jsp" method="post">
						<a class="" href="#"> <img src="img/ptit.jpg" alt="logo"
							style="width: 70px; border-radius: 14px; display: block; margin-left: auto; margin-right: auto;">
						</a>

						<div class="form-group">
							<h5></h5>
							<h6 style="text-align: center">Hệ Thống Quản Lý Đại Lý Trung
								Gian</h6>
							<label for="username">Tài khoản</label> <input type="text"
								name="username" class="form-control" id="username"
								placeholder="Nhập tên người dùng" required> <small
								id="emailHelp" class="form-text text-muted">Không chia
								sẻ cho bất kì ai.</small>
						</div>
						<div class="form-group">
							<label for="InputPassword1">Mật khẩu</label> <input
								type="password" class="form-control" id="password"
								name="password" placeholder="Nhập mật khẩu" required>
						</div>

						<button type="submit" name="btnDangNhap" value="Đăng nhập"
							class="btn btn-primary loginbtn" style="background-color: red;">Đăng
							nhập</button>
					</form>
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
</body>
</html>
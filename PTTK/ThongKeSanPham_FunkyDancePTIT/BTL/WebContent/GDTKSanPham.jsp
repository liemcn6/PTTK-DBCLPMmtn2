<%@page import="dao.*"%>
<%@page import="model.HangHoa"%>
<%@page import="model.TKSanPham"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,java.text.SimpleDateFormat"%>
<%
String ngaybatdau = (String)request.getParameter("ngaybatdau");
String ngayketthuc = (String)request.getParameter("ngayketthuc");
	ArrayList<TKSanPham> sp  = (new TKSanPhamDAO()).getDanhSachSP(ngaybatdau, ngayketthuc);
	HangHoa hh = new HangHoa();
	

	int S=0;
%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Danh sách chi tiết</title>
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
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Brand/logo -->
			<a class="navbar-brand" href="#"> <img src="img/ptit.jpg"
				alt="logo" style="width: 60px; border-radius: 14px;">
			</a>

			<!-- Links -->
			<ul class="nav" style="color: white">
				<li class="nav-item"><a class="nav-link" href="gdChinhQL">Trang
						Chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Thông Báo</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Trang Kế</a>
				</li>
			</ul>
		</nav>

		<div class="page-wrapper"
			style="margin-left: 100px; margin-right: 100px; padding-top: 150px;">
			<span style="font-weight: bold;">
				<p
					style="font-size: 30px; font-style: italic; font-weight: 600; color: #dc6e22">Danh
					sách sản phẩm từ:</p>
			</span> <span style="font-weight: bold;">
				<p
					style="font-size: 20px; font-style: italic; font-weight: 600; color: #dc6e22">
					Ngày bắt đầu là:
					<%= ngaybatdau%>
				</p>
			</span> <span style="font-weight: bold;">
				<p
					style="font-size: 20px; font-style: italic; font-weight: 600; color: #dc6e22">
					Ngày kết thúc là:
					<%= ngayketthuc %></p>
			</span>

			<div class="col-md-18">
				<%
		if(sp!= null){%>
				<table class="table table-hover">
					<thead class="table-dark" align="center">
						<tr>
							<th scope="col">Mã hàng</th>
							<th scope="col">Tên hàng hóa</th>
							<th scope="col">Bán ra</th>
							<th scope="col">Tổng doanh thu</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<%for (int i = 0; i < sp.size(); i++){
				S+=sp.get(i).getTongtien();
			%>
					<tbody align="center">

						<td><%=sp.get(i).getMaHang()  %></td>
						<td><%= sp.get(i).getTenHang() %></td>
						<td><%= sp.get(i).getSoLuong() %></td>

						<td><%= sp.get(i).getTongtien() %></td>

						<td><form action="GDChiTietHoaDon.jsp" method="post">
								<input type="hidden" name="id_sp"
									value="<%=sp.get(i).getMaHang()%>"> <input
									class="btn btn-primary" type="submit" value="Xem chi tiết">
							</form></td>

					</tbody>
					<%}%>
				</table>
			</div>
			<div class="row" style="padding-left: 10px; width: 110%;">

				<h3 style="margin-left: 60%;">
					Tổng hóa đơn:
					<%= S %>
				</h3>
				<%}
		else {%>
				<h2 style="color: red">Không có sản phẩm nào trong khoảng thời
					gian trên!</h2>
				<%}
		%>

				<br>

			</div>
			<div></div>


			<button class="btn btn-dark" style="margin: 15px"
				onclick="location.href ='GDQL.jsp'">Quay Lại</button>
		</div>
	</div>



	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" 
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
-->
</body>



<footer class=" grid-container bg-primary text-center text-white">



	<div class="text-center p-3"
		style="background-color: rgba(0, 0, 0, 0.85);">
		© 2021 Registered: <a class="text-white">Đại Lý Trung Gian CO.LTD</a>
	</div>
	<!-- Copyright -->
</footer>

</div>
<!-- Copyright -->
</footer>
</html>


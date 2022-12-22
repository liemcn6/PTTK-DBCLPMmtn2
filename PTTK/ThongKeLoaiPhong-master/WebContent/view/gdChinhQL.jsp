<%@page import="model.NhanVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Giao diện nhân viên quản lý</title>
    <style>
    	.container-fluid {
    		background-color: #ffffff;
    		padding-left: 0;
    		padding-right: 0;
    		width: 100%;
    		height: 650px;
		}

		.header {
    		height: 60px;
    		background-image: linear-gradient(0, #fe6433, #f53e2d);
		}

		.header_user {
    		display: flex;
    		height: 100%;
    		width: 50%;
    		background-color: inherit;
    		float: right;
    		flex-direction: row;
    		justify-content: flex-end;
    		align-items: center;
		}

		.header_user p {
    		color: white;
    		margin-right: 5px;
		}
		
		.header_user a {
    		color: white;
    		margin-right: 5px;
		}

		.header_user p:hover {
    		cursor: default;
		}

		.header_user a span {
    		cursor: hand;
    		color: white;
		}

		.header_user a:hover {
    		text-decoration: none;
    		color: inherit;
		}

		.grid_row {
    		display: flex;
    		flex-wrap: wrap;
    		margin-left: -5px;
    		margin-right: -5px;
    		padding-top: 24px;
    		padding-bottom: 24px;
		}

		.grid_column-2 {
    		padding-left: 5px;
    		padding-right: 5px;
    		width: 16.6667%;
		}

		.grid_column-10 {
    		padding-left: 5px;
    		padding-right: 5px;
   		 	width: 83.3333%
		}

		.category {
    		background-color: #fff;
    		border-radius: 2px;
    		width: 100%;
    		height: 100%;
    		display: flex;
    		align-items: center;
    		justify-content: center;
    		flex-direction: column;
    		margin-left: 50px;
		}

		.category_heading {
    		margin-top: 0;
    		font-size: 1.8rem;
    		color: grey;
    		padding: 12px 16px;
    		align-self: center;
    		width: 100%;
    		border-bottom: 1px solid rgba(0, 0, 0, 0.05);
		}

		.category_list {
    		padding: 0 0 8px 0;
    		list-style: none;
    		margin-left: 14px;
    		margin-right: 14px;
    		background-color: red;
		}

		.btn {
    		padding-top: 12px;
    		padding-bottom: 12px;
    		margin-bottom: 10px;
    		width: 100%;
		}

		.btn:hover {
    		background-color: #9dd9f5;
		}
		#templatemo_footer {
			width: 100%;
			text-align: center;
			background: url(images/templatemo_footer.png) no-repeat top
		}
		#templatemo_footer p{
			margin-top: 40px;
		}
		body {
			margin: 0;
			padding: 0;
			color: #999;
			font-family: Tahoma, Geneva, sans-serif;
			font-size: 12px;
			line-height: 1.4em; 
			background-color: #665f5f;
			background-repeat: repeat;
		}
		.content {
			display: flex;
			align-items: center;
			margin-left: 170px;
		}
		
		
    </style>
	
</head>

<body>
    <%
    	NhanVien employee = (NhanVien)session.getAttribute("admin");
    	if(employee==null){
        	response.sendRedirect("login?err=timeout");
    	}
    %>
    <div class="container-fluid">
        <div class="header">
            <div class="header_user">
                <a><span><%=employee.getTen()%></span></a>
                <a><span>|</span></a>
                <a><span><%=employee.getMoTa()%></span></a>
                <a><span>|</span></a>
                <a href="" style="margin-right: 20px">
                    <span>Đăng xuất</span>
                </a>
            </div>
        </div>
        <div class="container">
            <div class="content">
            	<div class="grid_row align-self">
                <div class="grid_column-1">
                    <nav class="category">
                        <h3 class="category_heading" style="text-align: center; margin-bottom: 50px">Chức năng</h3>
                        <div>
                            <button type="button" class="btn" onclick="alert('Chức năng này đang được phát triển')">Quản lý nhà hàng</button>
                            <button type="button" class="btn" onclick="alert('Chức năng này đang được phát triển')">Quản lý phòng</button>
                            <button type="button" class="btn" onclick="alert('Chức năng này đang được phát triển')">Quản lý kho</button>
                            <button type="button" class="btn" onclick="alert('Chức năng này đang được phát triển')">Quản lý nhân viên</button>
                            <button type="button" class="btn" onclick="location='${pageContext.request.contextPath}/view/gdChonLoaiTK.jsp'">Xem thống kê</button>
                        </div>
                    </nav>
                </div>
                <div class="grid_column-10"></div>
            </div>
            </div>
        </div>

    </div>

</body>

</html>
<%@include file="footer.jsp" %>

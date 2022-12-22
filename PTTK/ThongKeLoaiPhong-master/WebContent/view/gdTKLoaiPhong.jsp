<%@page import="model.TKLoaiPhong"%>
<%@page import="model.LoaiPhong"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.NhanVien"%>
<%@page import="model.Phong"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="main.css">
    <title>Giao diện thống kê loại phòng</title>
    <style>
    	.container-fluid {
    		background-color: #f5f5f5;
    		padding-left: 0;
    		padding-right: 0;
    		width: 100%;
    		height: 650px;
		}
		
		span {
			color: black;
		}
		h6 {
			color: black;
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
		.label span{
			font-size: 16px;
			color: black;
		}
		.output_option {
			flex: 1;
			display: flex;
			align-items: center;
			justify-content: space-between;
		}
		.output {
			width: 100%;
			height: 100%;
			margin-left: 100px;
		}
		.spinner {
			width: 40%; 
			height: 40px;
			margin-right: 12px;
		}
		tr {
			text-align: center
		}
		tr:hover {
			background-color: #f2f2f2;
			
		}
		
		tr a:hover {
			cursor: pointer;
			text-decoration: none;
		}
		
		th {
			text-align: center
		}
    </style>

	
</head>

<body>

    <%
    	String timeStart = (String) session.getAttribute("timeStart");
    	String timeEnd = (String) session.getAttribute("timeEnd");
        ArrayList<TKLoaiPhong> listRoom = (ArrayList<TKLoaiPhong>)session.getAttribute("listRoomType");
        NhanVien nv = (NhanVien) session.getAttribute("admin");
        if(timeStart==null || timeEnd==null){
            %><script type="text/javascript">  	
                alert("Vui lòng nhập đầy đủ thời gian bắt đầu và kết thúc thống kê!");     
            </script> <%
         }
    %>
    <script>
		function myFunction() {
  			alert("Không có dữ liệu thống kê!");   
		}
		</script>
    <div class="container-fluid">
        <div class="header">
            <div class="header_user">
                <a><span><%=nv.getTen()%></span></a>
                <a><span>|</span></a>
                <a><span><%=nv.getMoTa()%></span></a>
                <a><span>|</span></a>
                <a href="" style="margin-right: 20px">
                    <span>Đăng xuất</span>
                </a>
            </div>
        </div>
        <div class="container">
            <div class="grid_row">
                <h3 class="category_heading" style="text-align: center; margin-bottom: 50px">Thống kê loại phòng theo số lượt thuê</h3>
                </div>
                <div class="grid_column-10">
                    <div class="search-bar" style="margin-top: -50px; text-align: center; margin-left: 150px;">
                        <h6>Chọn thời gian thống kê:</h6>
                        <form action="<%=request.getContextPath()%>/gdTKLoaiPhong" method="post">
                        	<span>Ngày bắt đầu: </span><span style="color: red">*</span>
                            <input type="date" class="input-search" name="timeStart" <%if(timeStart!=null){%>value="<%=timeStart%>" <%}%>/>
                            <span style="margin-left: 20px">Ngày kết thúc: </span><span style="color: red">*</span>
                             <input type="date" class="input-search" name="timeEnd" <%if(timeEnd!=null){%>value="<%=timeEnd%>" <%}%>/>
                            <input type="submit" value="Tìm" style="margin-left: 20px"/>
                        </form>
                    </div>
                    
                    <%if(listRoom != null){%>
                          <br />
                            <div class="output">
                                <span>Kết quả tìm được</span>
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th class="first-column" scope="col">STT</th>
                                            <th class="second-column" scope="col">Cỡ phòng</th>
                                            <th class="third-column" scope="col">Số giờ sử dụng (h)</th>
                                            <th class="forth-column" scope="col">Tổng tiền (VND)</th>
                                            <th class="forth-column" scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(int i=0; i<listRoom.size(); i++){ %>
                                            <tr class="table-row">
                                                <th scope="row"><%=i+1%></th>
                                                <td><%=listRoom.get(i).getTen()%></td>
                                                <td><%=listRoom.get(i).getTongGioThue()%></td>
                                                <td><%=listRoom.get(i).getTongTien()%></td>
                                                <%if(listRoom.get(i).getTongGioThue()==0){%><td><a onclick="myFunction()">Xem chi tiết</a></td> <%}%>
                                                <%if(listRoom.get(i).getTongGioThue()!=0){%><td><a href="tkCacLanDatPhong?idLoaiPhong=<%=listRoom.get(i).getId()%>">Xem chi tiết</a></td> <%}%>
                                            </tr>
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                    <%}%>
                   
                </div>
            </div>
        </div>
 
    </div>
</body>
</html>
<%@include file="footer.jsp" %>
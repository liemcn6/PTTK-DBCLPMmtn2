<%@page import="model.NhanVienPhucVuPhong"%>
<%@page import="model.DichVuSuDung"%>
<%@page import="model.DichVu"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.TKDatPhong"%>
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
    <link rel="stylesheet" href="gdTimCauHoi\assets\css\main.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <title>Giao diện thống kê các lần đặt phòng theo loại phòng</title>
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
		
		th {
			text-align: center
		}
		
		viewBtn {
			border-color: transparent;
			border-width: 0;
			
		}
    </style>
</head>

<body>
    <%
    	String tenLP = (String) session.getAttribute("tenLP");
        ArrayList<TKDatPhong> listTKDatPhong = (ArrayList<TKDatPhong>)session.getAttribute("listTKBookedRoomType");
        NhanVien nv = (NhanVien) session.getAttribute("admin");
    %>
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
                <h3 class="category_heading" style="text-align: center; margin-bottom: 50px">Các lần loại phòng <%=tenLP%> được đặt</h3>
                </div>
                <div class="grid_column-10">
                 
                    <%if(listTKDatPhong != null){%>
                            <div class="output">
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th class="first-column" scope="col">ID</th>
                                            <th class="second-column" scope="col">Tên khách</th>
                                            <th class="third-column" scope="col">Ngày</th>
                                            <th class="forth-column" scope="col">Giờ bắt đầu</th>
                                            <th class="fifth-column" scope="col">Giờ kết thúc</th>
                                            <th class="sixth-column" scope="col">Đơn giá (VND/h)</th>
                                            <th class="seventh-column" scope="col">Tổng tiền (VND)</th>
                                            <th class="first-column" scope="col"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for(int i=0; i<listTKDatPhong.size(); i++){ %>
                                        	<%
                                        		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        		java.util.Date timeStart = sdf.parse(listTKDatPhong.get(i).getThoiGianDen());
                                        		java.util.Date timeEnd = sdf.parse(listTKDatPhong.get(i).getThoiGianVe());
                                        		String ngay = new SimpleDateFormat("dd/MM/yyyy").format(timeStart);
                                        		String gioBD = new SimpleDateFormat("HH:mm").format(timeStart);
                                        		String gioKT = new SimpleDateFormat("HH:mm").format(timeEnd);
                                        	%>
                                            <tr class="table-row">
                                                <th scope="row"><%=listTKDatPhong.get(i).getId()%></th>
                                                <td><%=listTKDatPhong.get(i).getKhachHang().getTen()%></td>
                                                <td><%=ngay%></td>
                                                <td><%=gioBD%></td>
                                                <td><%=gioKT%></td>
                                                <td><%=listTKDatPhong.get(i).getPhong().getDonGia()%></td>
                                                <td><%=listTKDatPhong.get(i).getTongTien()%></td>
                                                <td><button type="button" class="viewBtn" data-toggle="modal" data-target="#ViewDetailModal<%=i%>">
                                                	<span style="color: black">Xem chi tiết</span>
                                                </button></td>
                                            </tr>
                                            <!-- Modal Xem chi tiet -->
        									<div class="modal fade" id="ViewDetailModal<%=i%>">
        										<div class="modal-dialog">
         											<form method="GET" action="region">
             											<div class="modal-content">
                  										<div class="modal-header">
                  											<h4 class="modal-title">Chi tiết đặt phòng</h4>
                        									<button type="button" class="close" data-dismiss="modal">&times;</button>  
                   										</div>
                   										<div class="modal-body">
                        									<div><label>Tên phòng: </label><%="  "+listTKDatPhong.get(i).getPhong().getTen()%></div>
                          									<div><label>Loại phòng: </label><%="  "+listTKDatPhong.get(i).getPhong().getLoaiPhong().getTen()%></div>
                          									<div><label>Khách hàng: </label><%="  "+listTKDatPhong.get(i).getKhachHang().getTen() +" - "+ listTKDatPhong.get(i).getKhachHang().getTuoi() + " tuổi"%></div>
                    										<div><label>Số điện thoại: </label><%="  "+listTKDatPhong.get(i).getKhachHang().getSdt()%></div>
                    										<div><label>Thời gian đến: </label><%="  "+listTKDatPhong.get(i).getThoiGianDen()%></div>
                    										<div><label>Thời gian về: </label><%="  "+listTKDatPhong.get(i).getThoiGianVe()%></div>
                    										<%if(listTKDatPhong.get(i).getListDVSuDung().size()>0){%>
                    											<div><label>Dịch vụ sử dụng: </label>
                    											<%for(DichVuSuDung dvsd: listTKDatPhong.get(i).getListDVSuDung()) {%>
                    												<div /><%=" • "+dvsd.getDichVu().getTen()+" (số lượng: "+dvsd.getSoLuong()+", đơn giá: "+ dvsd.getDichVu().getGia()+" VNĐ)" %>
                    											<%} %>
                    										<%}%>
                    										<%if(listTKDatPhong.get(i).getListNVPhucVu().size()>0){%>
                    											<div><label>Nhân viên phục vụ phòng: </label>
                    											<%for(NhanVienPhucVuPhong nvpv: listTKDatPhong.get(i).getListNVPhucVu()) {%>
                    												<div /><%=" • "+nvpv.getNhanVienPhucVu().getTen()%>
                    											<%} %>
                    										<%}%>
                    										<div style="margin-top: 20px; text-align: right;">
                    											<label>Thành tiền: <%="  "+listTKDatPhong.get(i).getTongTien()+" VNĐ"%></label>
                    										</div>
                    										</div>
                      									</div>
           											</form>
         										</div>
      										</div>
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
<%-- 
    Document   : header
    Created on : Nov 11, 2022, 6:55:20 PM
    Author     : Admin
--%>

<%@page import="entity.Thanhvien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Trang chủ</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">Quản lý thẻ bạn đọc</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Chức năng
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
            <a class="dropdown-item" href="/thuvienquocgia/scanSV.jsp">Cho mượn sách</a>
          <a class="dropdown-item" href="#">Nhận trả sách</a>
        </div>
      </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <% 
                        Thanhvien tv = (Thanhvien)session.getAttribute("acc"); 
                        out.print(tv.getTen());
                    %></a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="#">Đăng xuất</a>
      </li>
    </ul>
  </div>
</nav>

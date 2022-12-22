<%@page import="dao.ThanhVienDAO"%>
<%@page import="model.ThanhVien"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <title>Đăng nhập</title>
</head>

<body>
<%
      if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
          %> <h4>Hết phiên làm việc. Làm ơn đăng nhập lại!</h4><%
      }else if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("fail")){
          %> <h4 color="red">Sai tên đăng nhập/mật khẩu!</h4><%
      }
      %>
    <div class="container-fluid bg">
        <div class="row justify-content-center">
            <div class="col-md-3 col-sm-6 col-xs-12 row-container" style="margin-top: 150px">
                <form action="<%=request.getContextPath()%>/login" method="post">
                    <h2 style="text-align: center;">Đăng nhập</h2>
                    <div class="form-group">
                        <label for="username">Tên đăng nhập:</label>
                        <input type="text" class="form-control" name="username" placeholder="Tên đăng nhập" value=""/>
                    </div>
                    <div class="form-group">
                        <label for="password">Mật khẩu:</label>
                        <input type="password" class="form-control" name="password" placeholder="Mật khẩu" value=""/>
                        <p class="passwordError"></p>
                    </div>
                    <button type="submit" class="btn btn-success btn-block my-3">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
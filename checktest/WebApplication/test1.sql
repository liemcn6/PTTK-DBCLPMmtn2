CREATE DATABASE quanlythuvien character set UTF8 collate utf8_vietnamese_ci;
use quanlythuvien;
CREATE TABLE `tblthanhvien` (
  `Id` int(10) NOT NULL,
  `ma` varchar(255) NOT NULL,
  `ten` varchar(255) NOT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(255) NOT NULL,
  `ngaysinh` date NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `dienthoai` varchar(255) NOT NULL,
  `vaitro` varchar(255) NOT NULL,
  `ghichu` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tblthanhvien132`
--

INSERT INTO `tblthanhvien` (`Id`, `ma`, `ten`, `tendangnhap`, `matkhau`, `ngaysinh`, `diachi`, `email`, `dienthoai`, `vaitro`, `ghichu`) VALUES
(1, 'b18dccn325', 'Nguyen Quang Liem', 'admin', 'Quangliem3173', '2000-08-03', 'nam truc', 'quangliem301@gmail.com', '0961863173', 'nhanvien', '123234');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tblthanhvien132`
--
ALTER TABLE `tblthanhvien`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tblthanhvien132`
--
ALTER TABLE `tblthanhvien`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;
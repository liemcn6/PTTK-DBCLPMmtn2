-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 10, 2021 lúc 04:18 PM
-- Phiên bản máy phục vụ: 10.4.14-MariaDB
-- Phiên bản PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `demoda`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkLogin` (IN `usr` VARCHAR(255), IN `pwd` VARCHAR(255))  NO SQL
SELECT * FROM tblthanhvien
WHERE tenDangNhap = usr AND matKhau = pwd$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldichvu`
--

CREATE TABLE `tbldichvu` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `moTa` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `gia` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldichvu`
--

INSERT INTO `tbldichvu` (`id`, `ten`, `moTa`, `gia`) VALUES
(1, 'Nước cam', 'Nước cam ép', 10000),
(2, 'Sinh tố', 'Sinh tố hoa quả', 15000),
(3, 'Bia hơi', 'Nước uống có cồn 20%', 8000),
(4, 'Strongbow', 'Nước táo lên men', 20000),
(5, 'Corona', 'Sinh tố lúa mạch', 20000),
(6, 'Xoài dầm', 'Xoài dầm tươi', 15000),
(7, 'Cocacola', 'Nước ngọt có gas', 12000),
(8, 'Moutandew', 'Nước tăng lực', 12000),
(9, 'Nest Cafe', 'Cà phê G7', 10000),
(10, 'Number 1', 'Nước tăng lực', 8000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbldichvusudung`
--

CREATE TABLE `tbldichvusudung` (
  `id` int(10) NOT NULL,
  `tblDichVuid` int(10) NOT NULL,
  `tblPhongThueid` int(10) NOT NULL,
  `soLuong` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tbldichvusudung`
--

INSERT INTO `tbldichvusudung` (`id`, `tblDichVuid`, `tblPhongThueid`, `soLuong`) VALUES
(1, 1, 2, 5),
(2, 3, 1, 4),
(3, 1, 1, 6),
(4, 2, 3, 3),
(5, 4, 4, 2),
(6, 5, 5, 2),
(7, 6, 6, 3),
(8, 7, 7, 4),
(9, 8, 8, 5),
(10, 9, 9, 3),
(11, 10, 10, 2),
(12, 4, 6, 2),
(13, 7, 5, 3),
(14, 8, 7, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblkhachhang`
--

CREATE TABLE `tblkhachhang` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tuoi` int(10) NOT NULL,
  `sdt` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblkhachhang`
--

INSERT INTO `tblkhachhang` (`id`, `ten`, `tuoi`, `sdt`, `diaChi`) VALUES
(1, 'Nguyễn Văn A', 22, '0953412658', 'Nguyễn Trãi, Hà Nội'),
(2, 'Lê Văn B', 29, '0324689513', 'Thanh Xuân, Hà Nội'),
(3, 'Trần Thị C', 25, '0326578956', 'Đống Đa, Hà Nội'),
(4, 'Trần Ngọc D', 20, '0395644745', 'Hà Đông, Hà Nội'),
(5, 'Hồ Anh Khoa', 30, '0963245122', 'Long Biên, Hà Nội'),
(6, 'Nguyễn Văn Toàn', 25, '0941223556', 'Đống Đa, Hà Nội'),
(7, 'Đoàn Văn Hậu', 24, '0963335412', 'Quỳnh Côi, Thái Bình'),
(8, 'Billie Eilish', 19, '0932415688', 'Los Angeles'),
(9, 'Taylor Swift', 31, '0633254689', 'West Reading, Pennsylvania'),
(10, 'Nguyễn Trần Việt Anh', 24, '0963214562', 'Thanh Liêm, Hà Nam');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblloaiphong`
--

CREATE TABLE `tblloaiphong` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `dienTich` int(10) NOT NULL,
  `moTa` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblloaiphong`
--

INSERT INTO `tblloaiphong` (`id`, `ten`, `dienTich`, `moTa`) VALUES
(1, 'S', 50, 'Phù hợp với số lượng khách vừa và nhỏ'),
(2, 'M', 100, 'Phù hợp với số lượng khách trung bình'),
(3, 'L', 150, 'Phù hợp với số lượng khách tương đối lớn'),
(4, 'XL', 200, 'Có thể đáp ứng số lượng khách lớn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnhahang`
--

CREATE TABLE `tblnhahang` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `moTa` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnhahang`
--

INSERT INTO `tblnhahang` (`id`, `ten`, `diaChi`, `moTa`) VALUES
(1, 'Nhà hàng karaoke Graduate', 'K10 Trần Phú, Hà Đông, Hà Nội', 'Địa điểm quen thuộc của sinh viên Bưu Chính');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblnhanvienphucvuphong`
--

CREATE TABLE `tblnhanvienphucvuphong` (
  `id` int(10) NOT NULL,
  `tblNhanVienid` int(10) NOT NULL,
  `tblPhongThueid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblnhanvienphucvuphong`
--

INSERT INTO `tblnhanvienphucvuphong` (`id`, `tblNhanVienid`, `tblPhongThueid`) VALUES
(1, 2, 1),
(2, 3, 1),
(3, 4, 2),
(4, 3, 3),
(5, 4, 3),
(6, 5, 4),
(7, 6, 4),
(8, 2, 5),
(9, 8, 5),
(10, 9, 6),
(11, 10, 6),
(12, 2, 7),
(13, 8, 7),
(14, 4, 8),
(15, 3, 8),
(16, 9, 9),
(17, 2, 9),
(18, 5, 10),
(19, 10, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphieudatphong`
--

CREATE TABLE `tblphieudatphong` (
  `id` int(10) NOT NULL,
  `tblKhachHangid` int(10) NOT NULL,
  `tblPhongThueid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblphieudatphong`
--

INSERT INTO `tblphieudatphong` (`id`, `tblKhachHangid`, `tblPhongThueid`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphong`
--

CREATE TABLE `tblphong` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `moTa` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `donGia` int(10) NOT NULL,
  `tblNhaHangid` int(10) NOT NULL,
  `tblLoaiPhongid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblphong`
--

INSERT INTO `tblphong` (`id`, `ten`, `moTa`, `donGia`, `tblNhaHangid`, `tblLoaiPhongid`) VALUES
(1, '101', 'Không có mô tả', 200000, 1, 1),
(2, '102', 'Không có mô tả', 400000, 1, 2),
(3, '201', 'Không có mô tả', 600000, 1, 3),
(4, '202', 'Không có mô tả', 1000000, 1, 4),
(5, '301', 'Không có mô tả', 400000, 1, 2),
(6, '103', 'Không có mô tả', 400000, 1, 2),
(7, '203', 'Không có mô tả', 1000000, 1, 4),
(8, '303', 'Không có mô tả', 200000, 1, 1),
(9, '401', 'Không có mô tả', 400000, 1, 2),
(10, '402', 'Không có mô tả', 600000, 1, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblphongthue`
--

CREATE TABLE `tblphongthue` (
  `id` int(11) NOT NULL,
  `thoiGianDen` datetime NOT NULL,
  `thoiGianVe` datetime NOT NULL,
  `tblPhongid` int(11) NOT NULL,
  `tblKhachHangid` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblphongthue`
--

INSERT INTO `tblphongthue` (`id`, `thoiGianDen`, `thoiGianVe`, `tblPhongid`, `tblKhachHangid`) VALUES
(1, '2020-12-01 15:00:34', '2020-12-01 17:00:56', 2, 2),
(2, '2020-11-11 10:00:34', '2020-11-11 12:00:34', 3, 1),
(3, '2020-12-14 20:00:35', '2020-12-14 23:30:35', 2, 3),
(4, '2020-07-01 15:00:34', '2020-07-01 18:00:34', 5, 5),
(5, '2021-01-04 17:00:14', '2021-01-04 21:00:14', 6, 6),
(6, '2020-12-23 10:00:44', '2020-12-23 13:00:44', 8, 8),
(7, '2020-12-30 09:00:27', '2020-12-30 12:00:27', 9, 9),
(8, '2020-12-29 08:00:00', '2020-12-29 11:00:00', 10, 10),
(9, '2021-01-05 14:00:51', '2021-01-05 17:00:51', 4, 4),
(10, '2021-01-10 13:00:51', '2021-01-10 18:00:51', 7, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tblthanhvien`
--

CREATE TABLE `tblthanhvien` (
  `id` int(10) NOT NULL,
  `ten` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `tenDangNhap` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `matKhau` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `gioiTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `diaChi` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `cmt` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `sdt` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `vaiTro` int(10) NOT NULL,
  `moTa` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `tblthanhvien`
--

INSERT INTO `tblthanhvien` (`id`, `ten`, `tenDangNhap`, `matKhau`, `ngaySinh`, `gioiTinh`, `diaChi`, `email`, `cmt`, `sdt`, `vaiTro`, `moTa`) VALUES
(1, 'Lê Văn Tuấn', 'admin', 'admin', '1998-12-14', 'Nam', 'Hà Nam, Việt Nam', 'levantuan1110@gmail.com', '035098451789', '0974947421', 0, 'Quản trị hệ thống'),
(2, 'Lê Hồng Nhung', 'nhunglh99', '14121998', '1999-01-04', 'Nữ', 'Hà Đông, Hà Nội', 'nhunglh99@gmail.com', '035096547853', '0954632148', 1, 'Nhân viên phục vụ'),
(3, 'Trần Thu Thủy', 'thuytt99', '14121998', '1999-01-13', 'Nữ', 'Thanh Xuân, Hà Nội', 'thuytt99@gmail.com', '035012345689', '0963541258', 1, 'Nhân viên phục vụ'),
(4, 'Phạm Minh Đức', 'ducpm98', '14121998', '1998-01-14', 'Nam', 'Long Biên, Hà Nội', 'ducpm98@gmail.com', '035012369874', '0921456723', 1, 'Nhân viên phục vụ'),
(5, 'Đặng Đình Lợi', 'loidd98', 'loipc98', '1998-01-13', 'Nam', 'Thanh Liêm, Hà Nam', 'loidd98@gmail.com', '035098002569', '0964258789', 1, 'Nhân viên phục vụ'),
(6, 'Phạm Văn Huấn', 'huanpv98', 'huanthemenk55', '1998-11-09', 'Nam', 'Thanh Liêm, Hà Nam', 'huanpv98@gmail.com', '053612456579', '0932145269', 1, 'Nhân viên phục vụ'),
(7, 'Trần Phượng Linh', 'linhttp98', '14121998', '1998-09-16', 'Nữ', 'Duy Tiên, Hà Nam', 'linhttp98@gmail.com', '035098002146', '0932964587', 0, 'Quản trị hệ thống'),
(8, 'Nhữ Mạnh Tuấn', 'tuannm98', 'kakakakak', '1998-08-18', 'Nam', 'Hà Đông, Hà Nội', 'tuannm98@gmail.com', '036214567895', '0924561236', 1, 'Nhân viên phục vụ'),
(9, 'Tống Tuyết Mai', 'maitt2k', 'jdnasmdf', '2000-11-09', 'Nữ', 'Thanh Xuân, Hà Nội', 'maitt2k@gmail.com', '03245612578', '0932565478', 1, 'Nhân viên phục vụ'),
(10, 'Phan Thanh Thư', 'thupt98', '14121898', '1998-10-06', 'Nữ', 'Lý Nhân, Hà Nam', 'thupt98@gmail.com', '096324562512', '0932654147', 1, 'Nhân viên phục vụ');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbldichvu`
--
ALTER TABLE `tbldichvu`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tbldichvusudung`
--
ALTER TABLE `tbldichvusudung`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblloaiphong`
--
ALTER TABLE `tblloaiphong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblnhahang`
--
ALTER TABLE `tblnhahang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblnhanvienphucvuphong`
--
ALTER TABLE `tblnhanvienphucvuphong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblphieudatphong`
--
ALTER TABLE `tblphieudatphong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblphong`
--
ALTER TABLE `tblphong`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblphongthue`
--
ALTER TABLE `tblphongthue`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `tblthanhvien`
--
ALTER TABLE `tblthanhvien`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbldichvu`
--
ALTER TABLE `tbldichvu`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tbldichvusudung`
--
ALTER TABLE `tbldichvusudung`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tblloaiphong`
--
ALTER TABLE `tblloaiphong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tblnhahang`
--
ALTER TABLE `tblnhahang`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `tblnhanvienphucvuphong`
--
ALTER TABLE `tblnhanvienphucvuphong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `tblphieudatphong`
--
ALTER TABLE `tblphieudatphong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `tblphong`
--
ALTER TABLE `tblphong`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tblphongthue`
--
ALTER TABLE `tblphongthue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `tblthanhvien`
--
ALTER TABLE `tblthanhvien`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

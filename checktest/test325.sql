INSERT INTO `tblthanhvien` ( `username`, `password`,`hodem`,`ten`, `ngaysinh`, `email`, `sdt`, `vaitro`, `tblDiachiid`) VALUES
('hanguyen12', 'admin','Nguyễn Thị','Hà', '2000-08-12', 'hanguyen3012@gmail.com', '0961863173', 'nhanvien', '3'),
('adminhoa12', 'admin','Nguyễn Thị','Hoa', '2000-01-03', 'quahoa012@gmail.com', '0961868173', 'quanly', '10'),
('hang1212', 'admin','Nguyễn Thanh','Hằng', '2000-08-13', 'qhang122@gmail.com', '0961863177', 'quanly', '4'),
('admphong12', 'admin','Nguyễn Quốc','Phong', '2000-08-23', 'quangphong012@gmail.com', '0961863553', 'quanly', '5'),
('anhpham12112', 'admin','Trần Quang','Anh', '2000-07-13', 'quanganh3012@gmail.com', '0961863188', 'quanly', '6'),
('hungevo2012', 'admin','Lê Quang','Hùng', '2000-08-13', 'quanghung3012@gmail.com', '0961863777', 'quanly', '7'),
('linhpham9712', 'admin','Phạm Quang','Linh', '2000-01-03', 'quanglinh3012@gmail.com', '096186771', 'quanly', '8'),
('longaa12', 'admin','Hoàng Quang','Long', '2000-01-03', 'quanglong012@gmail.com', '0961863199', 'nhanvien', '9');
INSERT INTO `tbldiachi` (`sonha`, `toanha`, `xompho`, `phuongxa`, `quanhuyen`, `tinhthanh`) VALUES 
('Sô 66','FLC Building','Hoàng Ngọc','Ngọc Khánh','Ba Đình','Hà Nội'),
('Số 110 ','Sông Đà','Trần Phú','Mộ Lao','Hà Đông','Hà Nội'),
('Số 257 ', null, 'Tôn Thất Thuyết', 'Mỹ Đình 2', 'Từ Liêm', 'Hà Nội'),
('Số 5 ', null, 'Quan Nhân', 'Nhân Chính', 'Thanh Xuân', 'Hà Nội'),
('Số 89 ', null, 'Võ Chí Công', 'Võ Chí Công', 'Tây Hồ', 'Hà Nội'),
('Số 275 ', null, 'Nguyễn Khánh Toàn', 'Quan Hoa', 'cầu Giấy', 'Hà Nội'),
('Số 193 ', null, 'Trần Duy Hưng', 'Trung Hòa', 'cầu Giấy', 'Hà Nội');
ALTER TABLE `tblthanhvien` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tbldiachi` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblthebandoc` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tbldausach` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tbldausachhoadonns` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblhoadonns` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblnhacungcap` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblnhanvien` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblphieumuon` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblphieuphat` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblquanly` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblsach` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
ALTER TABLE `tblsachmuon` ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `tblthanhvien` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tbldiachi` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblthebandoc` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tbldausach` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tbldausachhoadonns` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblhoadonns` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblnhacungcap` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblphieumuon` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblphieuphat` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblsach` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
ALTER TABLE `tblsachmuon` MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `tblthebandoc` DROP COLUMN ma;
ALTER TABLE `tbldausach` DROP COLUMN ma;
use quanlythuvienquocgia;
INSERT INTO `quanlythuvienquocgia`.`tblthebandoc` (`hodem`, `ten`, `ngaysinh`, `sdt`, `mavachBD`, `tblDiachiid`) VALUES 
('Lê Thanh', 'Đông', '2000-02-08', '0317199744', '00005', '3'),
('Phạm Thanh', 'Thanh', '2001-02-08', '0317199444', '00006', '1'),
('Lê Thành', 'Tiến', '2004-08-28', '0317199111', '00007', '15'),
('Lê Thanh', 'Thu', '2005-12-08', '03171997789', '00008', '2'),
('Trần Thị', 'Thảo', '2001-12-18', '0317199256', '00009', '4'),
('Lê Thanh', 'Nhật', '2002-02-08', '0317199778', '00010', '6'),
('Trần Thanh', 'Thư', '2001-02-08', '0317199254', '00011', '5'),
('Hoàng Thanh', 'Long', '2004-12-08', '0317199236', '00012', '7'),
('Lê Thu', 'Khánh', '2001-05-08', '0317199710', '00013', '8'),
('Phạm Thanh', 'Hưng', '2004-04-08', '0317199725', '00014', '9'),
('Lê Thanh', 'Tân', '2000-02-18', '0317194524', '00015', '10'),
('Lê Thư', 'Tâm', '2004-02-07', '0317122744', '00016', '14'),
('Phạm Quốc', 'Hùng', '2005-02-03', '0317144744', '00017', '16'),
('Lý Văn', 'Quý', '2000-02-08', '0317199700', '00018', '18'),
('Lê Văn', 'Trường', '2004-02-07', '0317199782', '00019', '21'),
('Nguyễn Thanh', 'Hoàn', '2000-02-18', '0317192594', '00020', '17');

INSERT INTO `quanlythuvienquocgia`.`tbldausach` (`ten`, `tacgia`, `namxb`, `giabia`, `soluong`) VALUES 
('Đề Thi Cuộc Sống', 'Lôi Mễ', '1999', '72000', '50'),
('999 Câu Nói Đến Chính Mình', ' Miêu Tử', '1980', '202000', '50'),
('Quà tặng cuộc sống', 'Higashino Keigo', '1980', '108000', '40'),
('Không gì là không thể', 'Izumi Kurosawa', '1980', '52000', '80'),
('Ngày 13 Tháng 12', 'Philip Nguyễn', '1998', '200000', '110'),
('Tôi có thể', 'Nguyễn Duy Cần', '1995', '72000', '40'),
('Sống cùng Tony', 'Cruz', '2018', '102000', '50'),
('Thư Viện Cuộc Sống', 'Camilo Chase', '2016', '68000', '50'),
('Hiệu Ứng Nhân Đôi', 'Jonah Berger', '2013', '107000', '100'),
('Lịch sử Học', 'Hoàng Bảo Châu', '2015', '100000', '60'),
('Covid', 'Pamela A', '2021', '60000', '50'),
('Làm Thế Nào Để Tốt Hơn', ' Georges Ohsawa', '1999', '65000', '70'),
('Lãnh Đạo Bán Hàng', 'Eith Rosen', '1990', '122000', '30'),
('Giấc Mơ Cuộc Sống', 'Huỳnh Bửu Sơn', '2009', '175000', '50');
INSERT INTO `quanlythuvienquocgia`.`tblsachmuon` (`ngaymuon`, `ngayphaitra`, `trangthai`, `tblPhieumuonid`, `tblSachid`) VALUES 
('2022-10-28', '2022-11-28', '0', '1', '3'),
('2022-10-28', '2022-11-28', '0', '1', '4'),
('2022-10-28', '2022-11-28', '0', '1', '5');
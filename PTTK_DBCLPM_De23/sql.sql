drop database if exists `pttk_dbclpm_23`;
create database `pttk_dbclpm_23`;

use `pttk_dbclpm_23`;

create table `dailytrunggian` (
	id int auto_increment primary key,
    ma varchar(255) unique,
    ten varchar(255),
    diachi varchar(255),
    sodienthoai varchar(255)
);

create table `thanhvien` (
	id int auto_increment primary key,
    tendangnhap varchar(255) unique,
    matkhau varchar(255),
    hoten varchar(255),
    diachi varchar(255),
    ngaysinh date, 
    email varchar(255) unique,
    sodienthoai varchar(255),
    vitricongviec varchar(255),
    dailytrunggian_id int,
    foreign key (dailytrunggian_id) references dailytrunggian(id)
);

create table `nhacungcap` (
	id int auto_increment primary key,
    ma varchar(255) unique,
    ten varchar(255),
    diachi varchar(255),
    sodienthoai varchar(255)
);

create table `hanghoa` (
	id int auto_increment primary key, 
    ma varchar(255) unique,
    ten varchar(255),
    mota varchar(255)
);

create table `phieunhap` (
	id int auto_increment primary key,
    thoigiannhaphang datetime,
    ghichu varchar(255),
    dailytrunggian_id int,
    nhacungcap_id int, 
    thanhvien_id int,
    foreign key (dailytrunggian_id) references dailytrunggian(id),
    foreign key (nhacungcap_id) references nhacungcap(id),
    foreign key (thanhvien_id) references thanhvien(id)
);

create table `phieunhap_hanghoa` (
	id int auto_increment primary key,
    dongia float,
    soluong int,
    hanghoa_id int, 
    phieunhap_id int,
    foreign key (hanghoa_id) references hanghoa(id),
    foreign key (phieunhap_id) references phieunhap(id)
);


INSERT INTO `pttk_dbclpm_23`.`dailytrunggian` (`id`, `ma`, `ten`, `diachi`, `sodienthoai`) VALUES ('1', 'DL1', 'Đại lý trung gian Pờ Tít', 'Hà Đông', '0123456789');

INSERT INTO `pttk_dbclpm_23`.`thanhvien` (`id`, `tendangnhap`, `matkhau`, `hoten`, `diachi`, `ngaysinh`, `email`, `sodienthoai`, `vitricongviec`, `dailytrunggian_id`) VALUES ('1', 'tung', 'tung', 'Trần Xuân Tùng', 'Hà Nội', '1998-05-14', 'tranxuantung145@gmail.com', '0934456098', 'nvkho', '1');

INSERT INTO `pttk_dbclpm_23`.`nhacungcap` (`id`, `ma`, `ten`, `diachi`, `sodienthoai`) VALUES ('1', 'NCC1', 'Nha cung cap Ha Noi', 'Ha Noi', '0934456111');
INSERT INTO `pttk_dbclpm_23`.`nhacungcap` (`id`, `ma`, `ten`, `diachi`, `sodienthoai`) VALUES ('2', 'NCC2', 'Nha cung cap Son La', 'Son La', '0934456222');
INSERT INTO `pttk_dbclpm_23`.`nhacungcap` (`id`, `ma`, `ten`, `diachi`, `sodienthoai`) VALUES ('3', 'NCC3', 'Nha cung cap Nam Dinh', 'Nam Dinh', '0934456333');
INSERT INTO `pttk_dbclpm_23`.`nhacungcap` (`id`, `ma`, `ten`, `diachi`, `sodienthoai`) VALUES ('4', 'NCC4', 'Nha cung cap Ha Tinh', 'Ha Tinh', '0934456444');

INSERT INTO `pttk_dbclpm_23`.`hanghoa` (`id`, `ma`, `ten`) VALUES ('1', 'HH1', 'Iphone 13');
INSERT INTO `pttk_dbclpm_23`.`hanghoa` (`id`, `ma`, `ten`) VALUES ('2', 'HH2', 'Iphone 12');
INSERT INTO `pttk_dbclpm_23`.`hanghoa` (`id`, `ma`, `ten`) VALUES ('3', 'HH3', 'Iphone 11');
INSERT INTO `pttk_dbclpm_23`.`hanghoa` (`id`, `ma`, `ten`) VALUES ('4', 'HH4', 'Iphone X');
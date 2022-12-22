SELECT tblthebandoc.id as mabandoc,tblthebandoc.hodem,tblthebandoc.ten,tblthebandoc.mavachBD, 
tblphieumuon.mavachPhieumuon,tbldausach.id as masach,tbldausach.ten as tensach,tbldausach.tacgia,tblsach.mavach as mavachsach,
tblsachmuon.ngaymuon,tblsachmuon.ngayphaitra
FROM ((((tblsachmuon inner join tblsach on tblsachmuon.tblSachid=tblsach.id) inner join tbldausach on tblsach.tblDausachid=tbldausach.id)
inner join tblphieumuon on tblphieumuon.id = tblsachmuon.tblPhieumuonid) inner join tblthebandoc on tblthebandoc.id=tblphieumuon.tblThebandocid) 
where tblsachmuon.trangthai=1 and tblthebandoc.mavachBD='00001';
-- layphantuhangcuoi
SELECT    *
FROM      tbldausach
ORDER BY  tbldausach.id DESC
LIMIT     1;
-- capnhatidphieuphatOsachmuon
UPDATE tblsachmuon
SET tblsachmuon.tblphieuphatid = ?
WHERE tblsachmuon.id = ?;

SELECT tblthebandoc.id as mabd, tblthebandoc.hodem,tblthebandoc.ten,tblthebandoc.ngaysinh,tblthebandoc.sdt,tblthebandoc.mavachBD
,tbldiachi.sonha,tbldiachi.toanha,tbldiachi.xompho,tbldiachi.phuongxa,tbldiachi.quanhuyen,tbldiachi.tinhthanh
 FROM tblthebandoc, tbldiachi where mavachBD = 00001 and tbldiachi.id = tblthebandoc.tbldiachiid;
select nhahang.ten as tennhahang, nhahang.diaChi as diaChiNhahang, nhanvien.ten as tenNhanVien, nhanvien.diaChi as diachiNhanVien,nhanvien.sdt as sdtNhanVien, nhanvien.ngayVaoLam, nhanvien.ngayThoiLam, nhanvien.email as emailNhanVien, nvpt.phongBan as phongBanNhanVien, nvpt.chucVu as chucVuNhanVien, lichdk.ten as lichDkTen, lichdk.min as lichDKMin, lichDk.tuanLVId as lichDKTuanLV,ngay.ten as ngaylv, calv.ten as calv from demodb.tblnha_hang nhahang left join demodb.tblnhanvien nhanvien on nhahang.id = nhanvien.nhaHangId left join demodb.tblnvpt nvpt  on nhanvien.id = nvpt.nvId left join demodb.tbllichdk lichdk  on nvpt.nvId = lichdk.nvId left join demodb.tblngaytronglich ngaytronglich on ngaytronglich.lichDkId =lichdk.id left join demodb.tblngay ngay on ngaytronglich.ngayId = ngay.id left join demodb.tblcalv calv on ngaytronglich.caLVId = calv.id where lichdk.nvId = 2 order by lichdk.tuanLVId desc limit 7
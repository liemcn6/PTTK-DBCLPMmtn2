package com.example.demo.DAO;

import com.example.demo.Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LichDKDAO implements DAO {
    public LichDKDAO() {
    }
    public LichDK getLichDKByNVPTId(int id){
        LichDK res = new LichDK();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select lichdk.id, nhahang.ten as tennhahang, " +
                    "nhahang.diaChi as diaChiNhahang, nhanvien.ten as tenNhanVien," +
                    " nhanvien.diaChi as diachiNhanVien, nhanvien.sdt as sdtNhanVien," +
                    " nhanvien.ngaySinh, nhanvien.ngayVaoLam, nhanvien.ngayThoiLam, nhanvien.email as emailNhanVien," +
                    " nvpt.phongBan, nvpt.chucVu," +
                    " lichdk.ten as lichDkTen, lichdk.min as lichDKMin," +
                    " lichDk.tuanLVId, ngay.ten as ngaylv," +
                    " calv.ten as calv from demodb.tblnha_hang nhahang" +
                    " left join demodb.tblnhanvien nhanvien" +
                    " on nhahang.id = nhanvien.nhaHangId" +
                    " left join demodb.tblnvpt nvpt " +
                    " on nhanvien.id = nvpt.nvId" +
                    " left join demodb.tbllichdk lichdk " +
                    " on nvpt.nvId = lichdk.nvId " +
                    " left join demodb.tblngaytronglich ngaytronglich" +
                    " on ngaytronglich.lichDkId =lichdk.id" +
                    " left join demodb.tblngay ngay " +
                    "on ngaytronglich.ngayId = ngay.id" +
                    " left join demodb.tblcalv calv" +
                    " on ngaytronglich.caLVId = calv.id" +
                    " where lichdk.nvId = "+ id +" order by lichdk.tuanLVId desc limit 7");
            while (rs.next()){

                System.out.println(rs.getString("tennhahang"));
                NhaHang nh= new NhaHang(rs.getString("tennhahang"), rs.getString("diaChiNhahang"));

                NVPT nvpt = new NVPT(nh, rs.getString("tenNhanVien"), rs.getString("sdtNhanVien"),
                        rs.getString("diachiNhanVien"), rs.getDate("ngaySinh"), rs.getDate("ngayVaoLam"), rs.getString("ngayThoiLam"),
                        rs.getString("emailNhanVien"), rs.getString("phongBan"), rs.getString("chucVu") );

                res.setNvpt(nvpt);

                res.setTuanLV(new TuanLV(rs.getInt("tuanLVId")));

                res.setMin(rs.getInt("lichDkMin") );

                List< NgayTrongLich> ngayTrongLiches = new ArrayList<NgayTrongLich>();

                Ngay ngay = new Ngay( rs.getString("ngaylv") );
                CaLV calv = new CaLV( rs.getString("calv") );

                ngayTrongLiches.add(new NgayTrongLich(calv, ngay ) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}

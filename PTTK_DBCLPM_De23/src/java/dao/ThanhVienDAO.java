/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.NhanVien;
import model.ThanhVien;

/**
 *
 * @author Xuan Toog
 */
public class ThanhVienDAO extends DAO{
    
    public ThanhVienDAO() {
        super();
    }
    
    public boolean checkDangNhap(ThanhVien tv) {
        boolean status = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from thanhvien where tendangnhap=? and "
                    + "matkhau=?");
            ps.setString(1, tv.getTendangnhap());
            ps.setString(2, tv.getMatkhau());
            
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public NhanVien getNhanVienByTendangnhap(String tendangnhap) {
        NhanVien nv = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from thanhvien where tendangnhap=?");
            ps.setString(1, tendangnhap);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                nv = new NhanVien();
                nv.setId(rs.getInt(1));
                nv.setTendangnhap(rs.getString(2));
                nv.setMatkhau(rs.getString(3));
                nv.setHoten(rs.getString(4));
                nv.setDiachi(rs.getString(5));
                nv.setNgaysinh(stringToDate(rs.getString(6)));
                nv.setEmail(rs.getString(7));
                nv.setSodienthoai(rs.getString(8));
                nv.setVitricongviec(rs.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nv;
    }
    
    public Date stringToDate(String string) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string);
        return date;
    }
}

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.ThanhVien;

public class ThanhVienDAO extends DAO{
	public ThanhVienDAO() {
        super();
    }
     
    public boolean checkLogin(ThanhVien tv){
        boolean kq = false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(tv.getTenDangNhap().contains("true") || tv.getTenDangNhap().contains("=")|| tv.getMatKhau().contains("true") || tv.getMatKhau().contains("="))
            return false;
        String sql = "{call checkLogin(?,?)}";
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,tv.getTenDangNhap());
            cs.setString(2,tv.getMatKhau());
            ResultSet rs = cs.executeQuery();
            
            if(rs.next()){
                tv.setId(rs.getInt("id"));
                tv.setTen(rs.getString("ten"));
                tv.setNgaySinh(rs.getDate("ngaySinh"));
                tv.setGioiTinh(rs.getString("gioiTinh"));
                tv.setDiaChi(rs.getString("diaChi"));
                tv.setEmail(rs.getString("email"));
                tv.setCmt(rs.getString("cmt"));
                tv.setSdt(rs.getString("sdt"));
                tv.setVaiTro(rs.getInt("vaiTro"));
                kq = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
}

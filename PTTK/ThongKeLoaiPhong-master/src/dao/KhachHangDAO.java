package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.KhachHang;

public class KhachHangDAO extends DAO {
	public KhachHangDAO() {
		
	}
	
	public KhachHang getKhachHangByPhongThue(int idPhongThue) {
		String sql = "SELECT `tblkhachhang`.* "
				+ "FROM `tblphongthue` "
				+ "INNER JOIN `tblkhachhang` "
				+ "ON `tblphongthue`.`tblKhachHangid` = `tblkhachhang`.`id` "
				+ "WHERE `tblphongthue`.`id` = ?";
		KhachHang khachHang = new KhachHang();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPhongThue);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	khachHang.setId(rs.getInt("id"));
            	khachHang.setTen(rs.getString("ten"));
            	khachHang.setTuoi(rs.getInt("tuoi"));
            	khachHang.setSdt(rs.getString("sdt"));
            	khachHang.setDiaChi(rs.getString("diaChi"));
            }
		} catch(Exception e){
            e.printStackTrace();
        }
		return khachHang;
	}
	
	
	
}

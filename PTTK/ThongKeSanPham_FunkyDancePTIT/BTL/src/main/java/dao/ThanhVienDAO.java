package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import model.ThanhVien;

public class ThanhVienDAO extends DAO{

	
	public ThanhVienDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean kiemtraDangNhap(ThanhVien tv) {
		boolean kq = false;
		if(tv.getUsername().contains("true") || tv.getUsername().contains("=") 
				|| tv.getPassword().contains("true") || tv.getPassword().contains("="))
			return false;
		String sql = "{call kiemtraDN(?,?)}";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, tv.getUsername());
			cs.setString(2, tv.getPassword());
			ResultSet rs = cs.executeQuery();
			
			if(rs.next()) {
				tv.setHoTen(rs.getString("hoTen"));
				tv.setVaiTro(rs.getString("vaiTro"));
		
				kq = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			kq =false;
		}
		return kq;
	}
}

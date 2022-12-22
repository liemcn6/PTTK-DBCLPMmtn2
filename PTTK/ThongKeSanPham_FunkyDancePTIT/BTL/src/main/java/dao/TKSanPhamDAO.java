package dao;

import java.sql.CallableStatement;

import java.sql.ResultSet;
import java.util.ArrayList;


import model.TKSanPham;


public class TKSanPhamDAO extends DAO{
	private ArrayList<TKSanPham> kq = new ArrayList<TKSanPham>();

	public TKSanPhamDAO() {
		super();
	}
	
	
	
	public ArrayList<TKSanPham> getDanhSachSP(String ngaybatdau, String ngayketthuc){

	
                        String sql = "{call layTksp(?,?)}";
		
		try {
			CallableStatement cs = (CallableStatement)con.prepareCall(sql); 
			cs.setString(1, ngaybatdau);
			cs.setString(2, ngayketthuc);
			ResultSet rs = cs.executeQuery(); 
;
			

			while(rs.next()) {
				
			//	TKSanPham(int maHang, String tenHang, int soLuong, int giaBan, int tongTien) 
	
					TKSanPham tk = new TKSanPham();
			
					tk.setMaHang(rs.getInt(1)); 
					 tk.setTenHang(rs.getString(2)); 
					 tk.setSoLuong(rs.getInt(3)); 
					 tk.setGiaBan(rs.getInt(4)); 
					  tk.setTongtien(rs.getInt(5)); 
					  
		               kq.add(tk);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return kq;
	}
}




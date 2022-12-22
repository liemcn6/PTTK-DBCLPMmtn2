package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DaiLyCon;
import model.HangHoa;
import model.TKHoaDon;

;

public class TKHoaDonDAO extends DAO{
	public TKHoaDonDAO() {
		super();
	}
	public ArrayList<TKHoaDon> getDanhSachHD(int idhh){
		ArrayList<TKHoaDon> kq = null;
		String sql = "{call layDSHD(?)}";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, idhh);
			ResultSet rs = cs.executeQuery();
			
			while(rs.next()) {
				if(kq == null) {
					kq = new ArrayList<TKHoaDon>();
				}
				//public TKHoaDon(int id, int tongTien, HangHoa hh, DaiLyCon dlc) {
					//super(id, tongTien, hh, dlc);
					// TODO Auto-generated constructor stub
				TKHoaDon tk = new TKHoaDon();
				HangHoa hh = new HangHoa();
				DaiLyCon dl = new DaiLyCon();
				tk.setId(rs.getInt(1));
				dl.setTenDL(rs.getString(2).toString());
				tk.setNgayXuat(rs.getDate("ngaygio"));
				tk.setTongTien(rs.getInt("tongTien"));
				hh.setSoLuong(rs.getInt(3));
				tk.setDlc(dl);
				tk.setHh(hh);
				kq.add(tk);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return kq;
		
	}
}
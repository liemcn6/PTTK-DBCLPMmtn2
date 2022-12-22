package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DichVu;
import model.DichVuSuDung;
import model.LoaiPhong;
import model.Phong;

public class DichVuDAO extends DAO{
	public DichVuDAO() {
		
	}
	
	
	
	public ArrayList<DichVuSuDung> getAllDVSuDungByPhongThue(int id) {
		ArrayList<DichVuSuDung> listDVSuDung = new ArrayList<DichVuSuDung>();
		String sql = "SELECT `tbldichvusudung`.`id` as dvSuDungid, `tbldichvusudung`.`soLuong`, `tbldichvu`.* "
				+ "FROM `tbldichvusudung` "
				+ "INNER JOIN `tbldichvu` "
				+ "ON `tbldichvusudung`.`tblDichVuid` = `tbldichvu`.`id` "
				+ "WHERE `tbldichvusudung`.`tblPhongThueid` = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	DichVuSuDung dichVuSuDung = new DichVuSuDung();
	        	dichVuSuDung.setId(rs.getInt("dvSuDungid"));
	        	dichVuSuDung.setSoLuong(rs.getInt("soLuong"));
	        	DichVu dv = new DichVu();
	        	dv.setId(rs.getInt("id"));
	        	dv.setTen(rs.getString("ten"));
	        	dv.setMoTa(rs.getString("moTa"));
	        	dv.setGia(rs.getInt("gia"));
	        	dichVuSuDung.setDichVu(dv);
	        	
	        	listDVSuDung.add(dichVuSuDung);
            } 
		} catch(Exception e){
            e.printStackTrace();
        }
		
		return listDVSuDung;
	}
}

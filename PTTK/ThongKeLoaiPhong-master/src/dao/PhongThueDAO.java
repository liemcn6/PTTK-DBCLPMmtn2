package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.DichVuSuDung;
import model.KhachHang;
import model.LoaiPhong;
import model.NhanVienPhucVuPhong;
import model.Phong;
import model.PhongThue;
import model.TKDatPhong;
import model.TKPhong;

public class PhongThueDAO extends DAO {
	public PhongThueDAO() {
	}
	
	public static ArrayList<PhongThue> getAllPhongThue() {
		ArrayList<PhongThue> listPhongThue = new ArrayList<PhongThue>();
		String sql = "SELECT * FROM `tblphongthue`";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            	PhongThue phongThue = new PhongThue();
            	phongThue.setId(rs.getInt("id"));
            	phongThue.setThoiGianDen(rs.getString("thoiGianDen"));
            	phongThue.setThoiGianVe(rs.getString("thoiGianVe"));
            	
            	TKPhongDAO phongDao = new TKPhongDAO();
            	Phong phong = phongDao.getPhongById(rs.getInt("tblPhongid"));
            	phongThue.setPhong(phong);
            	
            	DichVuDAO dvDAO = new DichVuDAO();
            	ArrayList<DichVuSuDung> listDVSD = dvDAO.getAllDVSuDungByPhongThue(rs.getInt("id"));
            	phongThue.setListDVSuDung(listDVSD);
            	
            	NhanVienDAO nvDao = new NhanVienDAO();
            	ArrayList<NhanVienPhucVuPhong> listNVPVP = nvDao.getAllNVPhucVuPhongByPhongThue(rs.getInt("id"));
            	phongThue.setListNVPhucVu(listNVPVP);
            	
            	listPhongThue.add(phongThue);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listPhongThue;
	}
	
	public ArrayList<TKDatPhong> getTKDatPhongByStage(java.util.Date thoiGianDen, java.util.Date thoiGianVe) {
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		PhongThueDAO bookedRoomDAO = new PhongThueDAO();
		ArrayList<PhongThue> listPhongThue = getAllPhongThue();
		ArrayList<TKDatPhong> listTKBookRoom = new ArrayList<TKDatPhong>();
		
		for(int i = 0; i< listPhongThue.size(); i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				java.util.Date timeStart = sdf.parse(listPhongThue.get(i).getThoiGianDen());
				java.util.Date timeEnd = sdf.parse(listPhongThue.get(i).getThoiGianVe());
				if(timeStart.compareTo(thoiGianDen) >= 0 && timeEnd.compareTo(thoiGianVe) <= 0) {
					int tongTien = 0;
					long soGioSD = ((timeEnd.getTime()-timeStart.getTime())/(1000 * 60 * 60))%24;
					tongTien += soGioSD*listPhongThue.get(i).getPhong().getDonGia();
					ArrayList<DichVuSuDung> listDVSD = listPhongThue.get(i).getListDVSuDung();
					for(int j = 0; j< listDVSD.size(); j++) {
						tongTien += listDVSD.get(j).getSoLuong()*listDVSD.get(j).getDichVu().getGia();
					}
					KhachHang khHang = khachHangDAO.getKhachHangByPhongThue(listPhongThue.get(i).getId());
					PhongThue phongThue = listPhongThue.get(i);
					TKDatPhong tkDatPhong = new TKDatPhong(
							phongThue.getId(), 
							phongThue.getThoiGianDen(), 
							phongThue.getThoiGianVe(), 
							phongThue.getPhong(), 
							phongThue.getListDVSuDung(), 
							phongThue.getListNVPhucVu(), 
							soGioSD, 
							tongTien, 
							khHang);

					listTKBookRoom.add(tkDatPhong);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listTKBookRoom;
	}

}

package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.DichVuSuDung;
import model.KhachHang;
import model.LoaiPhong;
import model.NhanVien;
import model.Phong;
import model.PhongThue;
import model.TKDatPhong;
import model.TKLoaiPhong;
import model.TKPhong;

public class TKPhongDAO extends DAO{
	public TKPhongDAO() {
	}
	
	public ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> listRoom = new ArrayList<Phong>();
		String sql = "SELECT `tblphong`.id, `tblphong`.ten, `tblphong`.moTa, `tblphong`.donGia, "
				+ "`tblloaiphong`.`id` as idLP, `tblloaiphong`.`ten` as tenLP, `tblloaiphong`.`dienTich`, `tblloaiphong`.`moTa` as moTaLP "
				+ "FROM `tblphong` "
				+ "inner JOIN `tblloaiphong` "
				+ "ON `tblphong`.`tblLoaiPhongid`=`tblloaiphong`.`id`";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Phong room = new Phong();
                room.setId(rs.getInt("id"));
                room.setTen(rs.getString("ten"));
                room.setMoTa(rs.getString("moTa"));
                room.setDonGia(rs.getInt("donGia"));
                LoaiPhong roomType = new LoaiPhong();
                roomType.setId(rs.getInt("idLP"));
                roomType.setTen(rs.getString("tenLP"));
                roomType.setDienTich(rs.getInt("dienTich"));
                roomType.setMoTa(rs.getString("moTaLP"));
                room.setLoaiPhong(roomType);
               
                listRoom.add(room);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
		
		return listRoom;
	}
	
	public ArrayList<LoaiPhong> getAllLoaiPhong() {
		String sql = "SELECT * FROM `tblloaiphong`";
		ArrayList<LoaiPhong> lisLoaiPhong = new ArrayList<LoaiPhong>();
		try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                LoaiPhong lp = new LoaiPhong();
                lp.setId(rs.getInt("id"));
                lp.setTen(rs.getString("ten"));
                lp.setDienTich(rs.getInt("dienTich"));
                lp.setMoTa(rs.getString("moTa"));
                lisLoaiPhong.add(lp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
		return lisLoaiPhong;
	}
	
	public LoaiPhong getLoaiPhongById(int id) {
		String sql = "SELECT * FROM `tblloaiphong` where id = ?";
		LoaiPhong lp = new LoaiPhong();
		try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                lp.setId(rs.getInt("id"));
                lp.setTen(rs.getString("ten"));
                lp.setDienTich(rs.getInt("dienTich"));
                lp.setMoTa(rs.getString("moTa"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
		return lp;
	}
	

	public Phong getPhongById(int id) {
		String sql = "SELECT `tblphong`.id, `tblphong`.ten, `tblphong`.moTa, `tblphong`.donGia, "
				+ "`tblloaiphong`.`id` as idLP, `tblloaiphong`.`ten` as tenLP, `tblloaiphong`.`dienTich`, `tblloaiphong`.`moTa` as moTaLP "
				+ "from `tblphong` "
				+ "INNER JOIN `tblloaiphong` "
				+ "ON `tblphong`.`tblLoaiPhongid` = `tblloaiphong`.`id` "
				+ "WHERE `tblphong`.`id` = ?";
		Phong phong = new Phong();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()){
	        	phong.setId(rs.getInt("id"));
	        	phong.setTen(rs.getString("ten"));
	        	phong.setMoTa(rs.getString("moTa"));
	        	phong.setDonGia(rs.getInt("donGia"));
                LoaiPhong roomType = new LoaiPhong();
                roomType.setId(rs.getInt("idLP"));
                roomType.setTen(rs.getString("tenLP"));
                roomType.setDienTich(rs.getInt("dienTich"));
                roomType.setMoTa(rs.getString("moTaLP"));
                phong.setLoaiPhong(roomType);
            } 
		} catch(Exception e){
            e.printStackTrace();
        }
		return phong;
	}
	
//	public ArrayList<TKPhong> getTKPhongByStage(java.util.Date thoiGianDen, java.util.Date thoiGianVe) {
//		KhachHangDAO khachHangDAO = new KhachHangDAO();
//		PhongThueDAO bookedRoomDAO = new PhongThueDAO();
//		ArrayList<PhongThue> listPhongThue = bookedRoomDAO.getAllPhongThue();
//		ArrayList<TKPhong> listTKRoom = new ArrayList<TKPhong>();
//		for(int i = 0; i< listPhongThue.size(); i++) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			try {
//				java.util.Date timeStart = sdf.parse(listPhongThue.get(i).getThoiGianDen());
//				java.util.Date timeEnd = sdf.parse(listPhongThue.get(i).getThoiGianVe());
//				if(timeStart.compareTo(thoiGianDen) >= 0 && timeEnd.compareTo(thoiGianVe) <= 0) {
//					int tongTien = 0;
//					long soGioSD = ((timeEnd.getTime()-timeStart.getTime())/(1000 * 60 * 60))%24;
//					tongTien += soGioSD*listPhongThue.get(i).getPhong().getDonGia();
//					ArrayList<DichVuSuDung> listDVSD = listPhongThue.get(i).getListDVSuDung();
//					for(int j = 0; j< listDVSD.size(); j++) {
//						tongTien += listDVSD.get(j).getSoLuong()*listDVSD.get(j).getDichVu().getGia();
//					}
//					KhachHang khHang = khachHangDAO.getKhachHangByPhongThue(listPhongThue.get(i).getId());
//					Phong p = listPhongThue.get(i).getPhong();
//					TKPhong tkPhong = new TKPhong(
//							p.getId(), 
//							p.getTen(), 
//							p.getMoTa(), 
//							p.getDonGia(), 
//							p.getLoaiPhong(), 
//							soGioSD, 
//							tongTien, 
//							listPhongThue.get(i).getThoiGianDen(), 
//							listPhongThue.get(i).getThoiGianVe(), 
//							khHang);
//					listTKRoom.add(tkPhong);
//					System.out.println(tkPhong);
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		// List phong voi thoi gian va doanh thu
//		return listTKRoom;
//	}
	
	public ArrayList<TKLoaiPhong> getTKLoaiPhong(ArrayList<TKDatPhong> listTKDatPhong, ArrayList<LoaiPhong> listLP) {
		ArrayList<TKLoaiPhong> listTKLoaiPhong = new ArrayList<TKLoaiPhong>();
		for(int i = 0; i< listLP.size(); i++) {
			float totalTime = 0;
			int totalPrice = 0;
			for(int j = 0; j< listTKDatPhong.size(); j++) {
				if(listLP.get(i).getId()==listTKDatPhong.get(j).getPhong().getLoaiPhong().getId()) {
					totalTime += listTKDatPhong.get(j).getTongGioThue();
					totalPrice += listTKDatPhong.get(j).getTongTien();
				}
			}
			LoaiPhong loaiPhong = listLP.get(i);
			TKLoaiPhong tkLoaiPhong = new TKLoaiPhong(loaiPhong.getId(), loaiPhong.getTen(), loaiPhong.getDienTich(), loaiPhong.getMoTa(), totalTime, totalPrice);
			listTKLoaiPhong.add(tkLoaiPhong);
		}
		
		return listTKLoaiPhong;
	}
	
}

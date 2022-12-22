package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.NhanVien;
import model.NhanVienPhucVu;
import model.NhanVienPhucVuPhong;
import model.ThanhVien;

public class NhanVienDAO extends DAO{
	 	public NhanVienDAO(){
	        super();
	    }
	    
	    public NhanVien getNhanVien(ThanhVien tv){
	        String sql = "select `tblThanhVien`.`moTa` from tblThanhVien where id = ?";
	        NhanVien nv = new NhanVien();
	        try{
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, tv.getId());
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                nv.setId(tv.getId());
	                nv.setMoTa(rs.getString("moTa"));
	                nv.setDiaChi(tv.getDiaChi());
	                nv.setEmail(tv.getEmail());
	                nv.setGioiTinh(tv.getGioiTinh());
	                nv.setMatKhau(tv.getMatKhau());
	                nv.setNgaySinh(tv.getNgaySinh());
	                nv.setSdt(tv.getSdt());
	                nv.setTen(tv.getTen());
	                nv.setCmt(tv.getCmt());
	                nv.setTenDangNhap(tv.getTenDangNhap());
	                nv.setVaiTro(tv.getVaiTro());
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return nv;
	    }

	    public ArrayList<NhanVienPhucVuPhong> getAllNVPhucVuPhongByPhongThue(int idPT) {
	    	ArrayList<NhanVienPhucVuPhong> listNVPV = new ArrayList<NhanVienPhucVuPhong>();
	    	String sql = "SELECT `tblnhanvienphucvuphong`.`id` as nvPVPid, `tblthanhvien`.* "
	    			+ "FROM `tblnhanvienphucvuphong` "
	    			+ "INNER JOIN `tblthanhvien` "
	    			+ "ON `tblnhanvienphucvuphong`.`tblNhanVienid` = `tblthanhvien`.`id` "
	    			+ "WHERE `tblnhanvienphucvuphong`.`tblPhongThueid` = ?";
	    	try {
				PreparedStatement ps = con.prepareStatement(sql);
		        ps.setInt(1, idPT);
		        ResultSet rs = ps.executeQuery();
		        while(rs.next()){
		        	NhanVienPhucVu nvpv = new NhanVienPhucVu();
		        	nvpv.setId(rs.getInt("id"));
		        	nvpv.setTen(rs.getString("ten"));
		        	nvpv.setTenDangNhap(rs.getString("tenDangNhap"));
		        	nvpv.setMatKhau(rs.getString("matKhau"));
		        	nvpv.setNgaySinh(rs.getDate("ngaySinh"));
		        	nvpv.setGioiTinh(rs.getString("gioiTinh"));
		        	nvpv.setDiaChi(rs.getString("diaChi"));
		        	nvpv.setEmail(rs.getString("email"));
		        	nvpv.setCmt(rs.getString("cmt"));
		        	nvpv.setSdt(rs.getString("sdt"));
		        	nvpv.setVaiTro(rs.getInt("vaiTro"));
		        	nvpv.setMoTa(rs.getString("moTa"));
		        	
		        	NhanVienPhucVuPhong nv = new NhanVienPhucVuPhong();
		        	nv.setId(rs.getInt("nvPVPid"));
		        	nv.setNhanVienPhucVu(nvpv);
		        	
		        	listNVPV.add(nv);
	            } 
			} catch(Exception e){
	            e.printStackTrace();
	        }
	    	return listNVPV;
	    }

}

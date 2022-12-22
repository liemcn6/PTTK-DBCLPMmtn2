package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class TheThuVien {
	private int maThe;
	private int maDocGia;
	private Date ngayCapThe;
	private Date ngayHetHan;
	private String trangThai;
	private int soSachDuocMuon;
	private int soSachDangMuon;
	
	
	public TheThuVien(int maThe) {
		super();
		this.maThe = maThe;
	}


	public TheThuVien() {
		super();
	}


	public TheThuVien(int maThe, int maDocGia, Date ngayCapThe, Date ngayHetHan, String trangThai, int soSachDuocMuon,
			int soSachDangMuon) {
		super();
		this.maThe = maThe;
		this.maDocGia = maDocGia;
		this.ngayCapThe = ngayCapThe;
		this.ngayHetHan = ngayHetHan;
		this.trangThai = trangThai;
		this.soSachDuocMuon = soSachDuocMuon;
		this.soSachDangMuon = soSachDangMuon;
	}


	public int getMaThe() {
		return maThe;
	}


	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}


	public int getMaDocGia() {
		return maDocGia;
	}


	public void setMaDocGia(int maDocGia) {
		this.maDocGia = maDocGia;
	}


	public Date getNgayCapThe() {
		return ngayCapThe;
	}


	public void setNgayCapThe(Date ngayCapThe) {
		this.ngayCapThe = ngayCapThe;
	}


	public Date getNgayHetHan() {
		return ngayHetHan;
	}


	public void setNgayHetHan(Date ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}


	public String getTrangThai() {
		return trangThai;
	}


	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	public int getSoSachDuocMuon() {
		return soSachDuocMuon;
	}


	public void setSoSachDuocMuon(int soSachDuocMuon) {
		this.soSachDuocMuon = soSachDuocMuon;
	}


	public int getSoSachDangMuon() {
		return soSachDangMuon;
	}


	public void setSoSachDangMuon(int soSachDangMuon) {
		this.soSachDangMuon = soSachDangMuon;
	}
	
	
}

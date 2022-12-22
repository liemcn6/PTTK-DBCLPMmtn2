package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class NhanVien {
	private int maNhanVien;
	private String hoVaTen;
	private String Email;
	private String soDienThoai;
	private Date ngaySinh;
	private int maTaiKhoan;
	
	
	public NhanVien(int maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}


	public NhanVien() {
		super();
	}


	public NhanVien(int maNhanVien, String hoVaTen, String email, String soDienThoai, Date ngaySinh, int maTaiKhoan) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;
		Email = email;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.maTaiKhoan = maTaiKhoan;
	}


	public int getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getHoVaTen() {
		return hoVaTen;
	}


	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getSoDienThoai() {
		return soDienThoai;
	}


	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}


	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}
	
}

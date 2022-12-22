package model;

import java.util.Date;

public class NhanVien extends ThanhVien{
	private String moTa;
	
	
	public NhanVien() {
		super();
	}


	public NhanVien(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String gioiTinh,
			String diaChi, String email, String sdt, String cmt, int vaiTro, String moTa) {
		super(id, ten, tenDangNhap, matKhau, ngaySinh, gioiTinh, diaChi, email, sdt, cmt, vaiTro);
		this.moTa = moTa;
	}


	public NhanVien(String moTa) {
		super();
		this.moTa = moTa;
	}


	public String getMoTa() {
		return moTa;
	}


	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	@Override
	public String toString() {
		return "NhanVien [moTa=" + moTa + ", getId()=" + getId() + ", getTen()=" + getTen() + ", getTenDangNhap()="
				+ getTenDangNhap() + ", getMatKhau()=" + getMatKhau() + ", getNgaySinh()=" + getNgaySinh()
				+ ", getGioiTinh()=" + getGioiTinh() + ", getDiaChi()=" + getDiaChi() + ", getEmail()=" + getEmail()
				+ ", getSdt()=" + getSdt() + ", getCmt()=" + getCmt() + ", getVaiTro()=" + getVaiTro() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	
	
}

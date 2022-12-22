package model;

import java.util.Date;

public class ThanhVien {
	private int id, vaiTro;
    private String ten;
    private String tenDangNhap, matKhau;
    private Date ngaySinh;
    private String gioiTinh, diaChi, email, sdt, cmt;
	public ThanhVien() {
	}
	public ThanhVien(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String gioiTinh,
			String diaChi, String email, String sdt, String cmt, int vaiTro) {
		this.id = id;
		this.ten = ten;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
		this.cmt = cmt;
		this.vaiTro = vaiTro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public int getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(int vaiTro) {
		this.vaiTro = vaiTro;
	}
	@Override
	public String toString() {
		return "ThanhVien [id=" + id + ", vaiTro=" + vaiTro + ", ten=" + ten + ", tenDangNhap=" + tenDangNhap
				+ ", matKhau=" + matKhau + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi
				+ ", email=" + email + ", sdt=" + sdt + ", cmt=" + cmt + "]";
	}
	
    
	
}

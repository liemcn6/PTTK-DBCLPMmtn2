package model;

import java.util.Date;

public class NhanVienPhucVu extends NhanVien {
	public NhanVienPhucVu(){

    }
	
	public NhanVienPhucVu(int id, String ten, String tenDangNhap, String matKhau, Date ngaySinh, String gioiTinh,
			String diaChi, String email, String sdt, String cmt, int vaiTro, String moTa) {
		super(id, ten, tenDangNhap, matKhau, ngaySinh, gioiTinh, diaChi, email, sdt, cmt, vaiTro, moTa);
	}

	@Override
	public String toString() {
		return "NhanVienPhucVu [getMoTa()=" + getMoTa() + ", toString()=" + super.toString() + ", getId()=" + getId()
				+ ", getTen()=" + getTen() + ", getTenDangNhap()=" + getTenDangNhap() + ", getMatKhau()=" + getMatKhau()
				+ ", getNgaySinh()=" + getNgaySinh() + ", getGioiTinh()=" + getGioiTinh() + ", getDiaChi()="
				+ getDiaChi() + ", getEmail()=" + getEmail() + ", getSdt()=" + getSdt() + ", getCmt()=" + getCmt()
				+ ", getVaiTro()=" + getVaiTro() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
}

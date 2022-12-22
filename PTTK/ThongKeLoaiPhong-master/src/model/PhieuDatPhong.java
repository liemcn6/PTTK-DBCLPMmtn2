package model;

public class PhieuDatPhong {
	private int id;
	private PhongThue phongThue;
	private KhachHang khachHang;
	public PhieuDatPhong() {
		super();
	}
	public PhieuDatPhong(int id, PhongThue phongThue, KhachHang khachHang) {
		super();
		this.id = id;
		this.phongThue = phongThue;
		this.khachHang = khachHang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PhongThue getPhongThue() {
		return phongThue;
	}
	public void setPhongThue(PhongThue phongThue) {
		this.phongThue = phongThue;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
}

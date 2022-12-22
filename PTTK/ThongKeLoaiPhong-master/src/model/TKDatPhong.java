package model;

import java.util.ArrayList;

public class TKDatPhong extends PhongThue {
	private float tongGioThue;
	private int tongTien;
	private KhachHang khachHang;
	public TKDatPhong() {
		super();
	}
	public TKDatPhong(int id, String thoiGianDen, String thoiGianVe, Phong phong, ArrayList<DichVuSuDung> listDVSuDung,
			ArrayList<NhanVienPhucVuPhong> listNVPhucVu, float tongGioThue, int tongTien, KhachHang khachHang) {
		super(id, thoiGianDen, thoiGianVe, phong, listDVSuDung, listNVPhucVu);
		this.tongGioThue = tongGioThue;
		this.tongTien = tongTien;
		this.khachHang = khachHang;
	}
	public float getTongGioThue() {
		return tongGioThue;
	}
	public void setTongGioThue(float tongGioThue) {
		this.tongGioThue = tongGioThue;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	
	
}

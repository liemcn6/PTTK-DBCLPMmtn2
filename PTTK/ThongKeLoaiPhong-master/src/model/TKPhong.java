package model;

public class TKPhong extends Phong {
	private float tongGioThue;
	private int tongTien;
	private String thoiGianDen;
	private String thoiGianVe;
	private KhachHang khachHang;
	
	public TKPhong() {
		super();
	}
	

	public TKPhong(float tongGioThue, int tongTien) {
		super();
		this.tongGioThue = tongGioThue;
		this.tongTien = tongTien;
	}
	
	public TKPhong(int id, String ten, String moTa, int donGia, LoaiPhong loaiPhong, float tongGioThue, int tongTien) {
		super(id, ten, moTa, donGia, loaiPhong);
		this.tongGioThue = tongGioThue;
		this.tongTien = tongTien;
	}
	
	
	
	public TKPhong(int id, String ten, String moTa, int donGia, LoaiPhong loaiPhong, float tongGioThue, int tongTien,
			String thoiGianDen, String thoiGianVe, KhachHang khachHang) {
		super(id, ten, moTa, donGia, loaiPhong);
		this.tongGioThue = tongGioThue;
		this.tongTien = tongTien;
		this.thoiGianDen = thoiGianDen;
		this.thoiGianVe = thoiGianVe;
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
	
	
	
	
	public String getThoiGianDen() {
		return thoiGianDen;
	}


	public void setThoiGianDen(String thoiGianDen) {
		this.thoiGianDen = thoiGianDen;
	}


	public String getThoiGianVe() {
		return thoiGianVe;
	}


	public void setThoiGianVe(String thoiGianVe) {
		this.thoiGianVe = thoiGianVe;
	}


	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	@Override
	public String toString() {
		return "TKPhong [tongGioThue=" + tongGioThue + ", tongTien=" + tongTien + ", getId()=" + getId() + ", getTen()="+ getTen();
	}
	
	
	
}

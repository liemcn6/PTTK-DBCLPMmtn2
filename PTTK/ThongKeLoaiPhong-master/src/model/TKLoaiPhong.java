package model;

public class TKLoaiPhong extends LoaiPhong {
	private float tongGioThue;
	private int tongTien;
	public TKLoaiPhong() {
		super();
	}
	public TKLoaiPhong(int id, String ten, int dienTich, String moTa, float tongGioThue, int tongTien) {
		super(id, ten, dienTich, moTa);
		this.tongGioThue = tongGioThue;
		this.tongTien = tongTien;
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
	@Override
	public String toString() {
		return "TKLoaiPhong [tongGioThue=" + tongGioThue + ", tongTien=" + tongTien + "]";
	}
	
	
}

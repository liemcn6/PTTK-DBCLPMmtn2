package model;

import java.util.Date;

public class TKHoaDon extends HoaDon{
	private int tongSoluong;
	private int tongTien;
	private Date ngayXuat;
	
	public TKHoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TKHoaDon(int id, int tongTien, DaiLyCon dlc) {
		super();
		// TODO Auto-generated constructor stub
	}

	public TKHoaDon(int tongSoluong, int tongTien, Date ngayXuat) {
		super();
		this.tongSoluong = tongSoluong;
		this.tongTien = tongTien;
		this.ngayXuat = ngayXuat;
	}

	public int getTongSoluong() {
		return tongSoluong;
	}

	public int getTongTien() {
		return tongTien;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setTongSoluong(int tongSoluong) {
		this.tongSoluong = tongSoluong;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}
	
}

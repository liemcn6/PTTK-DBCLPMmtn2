package model;

import java.sql.Date;

public class DichVuSuDung {
	private int id;
	private int soLuong;
	private DichVu dichVu;
	public DichVuSuDung() {
		super();
	}
	public DichVuSuDung(int id, int soLuong, DichVu dichVu) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.dichVu = dichVu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	
}

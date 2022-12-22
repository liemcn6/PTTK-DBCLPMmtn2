package model;

public class LoaiPhong {
	private int id;
	private String ten;
	private int dienTich;
	private String moTa;
	public LoaiPhong() {
		super();
	}
	public LoaiPhong(int id, String ten, int dienTich, String moTa) {
		super();
		this.id = id;
		this.ten = ten;
		this.dienTich = dienTich;
		this.moTa = moTa;
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
	public int getDienTich() {
		return dienTich;
	}
	public void setDienTich(int dienTich) {
		this.dienTich = dienTich;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	
}

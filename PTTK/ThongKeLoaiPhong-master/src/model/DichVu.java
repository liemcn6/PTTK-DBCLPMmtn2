package model;

public class DichVu {
	private int id;
	private String ten, moTa;
	private int gia;
	public DichVu() {
		super();
	}
	public DichVu(int id, String ten, String moTa, int gia) {
		super();
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.gia = gia;
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
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	
}

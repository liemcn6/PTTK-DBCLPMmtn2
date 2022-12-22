package model;

public class Phong {
	private int id;
	private String ten;
	private String moTa;
	private int donGia;
	private LoaiPhong loaiPhong;
	public Phong() {
		super();
	}
	public Phong(int id, String ten, String moTa, int donGia) {
		super();
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.donGia = donGia;
	}
	
	public Phong(int id, String ten, String moTa, int donGia, LoaiPhong loaiPhong) {
		super();
		this.id = id;
		this.ten = ten;
		this.moTa = moTa;
		this.donGia = donGia;
		this.loaiPhong = loaiPhong;
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
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	
	@Override
	public String toString() {
		return "Phong [ten=" + ten + "]";
	}
	
	
}

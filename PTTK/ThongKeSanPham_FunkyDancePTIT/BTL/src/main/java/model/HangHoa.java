package model;

public class HangHoa {
	private int maHang;
	private String tenHang;
	private int soLuong;
	
	private int giaBan;
	private String moTa;
	private int tongTien;
	public HangHoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HangHoa(int maHang, String tenHang, int soLuong, int giaBan, String moTa, int tongTien) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.moTa = moTa;
		this.tongTien = tongTien;
	}
	public HangHoa(int maHang, String tenHang, int soLuong, int giaBan, int tongTien) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	
		this.tongTien = tongTien;
	}
	public int getMaHang() {
		return maHang;
	}
	public String getTenHang() {
		return tenHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public String getMoTa() {
		return moTa;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return " [" + soLuong + "]";
	}
	
}
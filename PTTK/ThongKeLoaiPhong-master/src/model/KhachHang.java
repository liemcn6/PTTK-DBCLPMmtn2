package model;

public class KhachHang {
	private int id;
	private String ten;
	private int tuoi;
	private String sdt, diaChi;
	public KhachHang() {
		super();
	}
	
	public KhachHang(int id, String ten, int tuoi, String sdt, String diaChi) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.sdt = sdt;
		this.diaChi = diaChi;
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

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
	
}

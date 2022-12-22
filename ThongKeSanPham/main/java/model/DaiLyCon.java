package model;

public class DaiLyCon {
	private int id;
	private String maDL;
	private String tenDL;
	private String diaChi;
	private String sdt;
	private HangHoa hh;
	public DaiLyCon(int id, String maDL, String tenDL, String diaChi, String sdt, HangHoa hh) {
		super();
		this.id = id;
		this.maDL = maDL;
		this.tenDL = tenDL;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.hh = hh;
	}
	public DaiLyCon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMaDL() {
		return maDL;
	}
	public void setMaDL(String maDL) {
		this.maDL = maDL;
	}
	public String getTenDL() {
		return tenDL;
	}
	public void setTenDL(String tenDL) {
		this.tenDL = tenDL;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public HangHoa getHh() {
		return hh;
	}
	public void setHh(HangHoa hh) {
		this.hh = hh;
	}
	@Override
	public String toString() {
		return "[" + tenDL + "]";
	}
	
}
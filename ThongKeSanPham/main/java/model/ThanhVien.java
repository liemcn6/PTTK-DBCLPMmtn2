package model;



public class ThanhVien {
	private int id;
	private String hoTen;
	private String diaChi;
	private String username;
	private String password;
	private String sdt;
	private String vaiTro;
	public ThanhVien(int id, String hoTen, String diaChi, String username, String password, String sdt, String vaiTro) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.username = username;
		this.password = password;
		this.sdt = sdt;
		this.vaiTro = vaiTro;
	}
	public ThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	
}
	
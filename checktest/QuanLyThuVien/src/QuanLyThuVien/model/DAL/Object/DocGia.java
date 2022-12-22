package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class DocGia {
	private int maDocGia;
	private String tenDocGia;
	private String gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private String email;
	private String soDienThoai;
	
	public DocGia(int maDocGia) {
		super();
		this.maDocGia = maDocGia;
	}

	public DocGia() {
		super();
	}

	public DocGia(int maDocGia, String tenDocGia, String gioiTinh, Date ngaySinh, String diaChi, String email,
			String soDienThoai) {
		super();
		this.maDocGia = maDocGia;
		this.tenDocGia = tenDocGia;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	public int getMaDocGia() {
		return maDocGia;
	}

	public void setMaDocGia(int maDocGia) {
		this.maDocGia = maDocGia;
	}

	public String getTenDocGia() {
		return tenDocGia;
	}

	public void setTenDocGia(String tenDocGia) {
		this.tenDocGia = tenDocGia;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	
	

	
	
	
	
	
	
	
	

}

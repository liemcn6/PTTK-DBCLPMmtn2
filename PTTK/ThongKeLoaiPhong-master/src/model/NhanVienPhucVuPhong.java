package model;

public class NhanVienPhucVuPhong {
	private int id;
	private NhanVienPhucVu nhanVienPhucVu;
	public NhanVienPhucVuPhong() {
		super();
	}
	public NhanVienPhucVuPhong(int id, NhanVienPhucVu nhanVienPhucVu) {
		super();
		this.id = id;
		this.nhanVienPhucVu = nhanVienPhucVu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhanVienPhucVu getNhanVienPhucVu() {
		return nhanVienPhucVu;
	}
	public void setNhanVienPhucVu(NhanVienPhucVu nhanVienPhucVu) {
		this.nhanVienPhucVu = nhanVienPhucVu;
	}
	
	
}

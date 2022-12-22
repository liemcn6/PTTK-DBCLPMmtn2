package QuanLyThuVien.model.DAL.Object;

public class Nxb {
	private int maNxb;
	private String tenNxb;
	private String ghiChu;

	public Nxb(int maNxb) {
		super();
		this.maNxb = maNxb;
	}

	public Nxb() {
		super();

	}

	public Nxb(int maNxb, String tenNxb, String ghiChu) {
		super();
		this.maNxb = maNxb;
		this.tenNxb = tenNxb;
		this.ghiChu = ghiChu;
	}

	public int getMaNxb() {
		return maNxb;
	}

	public void setMaNxb(int maNxb) {
		this.maNxb = maNxb;
	}

	public String getTenNxb() {
		return tenNxb;
	}

	public void setTenNxb(String tenNxb) {
		this.tenNxb = tenNxb;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}

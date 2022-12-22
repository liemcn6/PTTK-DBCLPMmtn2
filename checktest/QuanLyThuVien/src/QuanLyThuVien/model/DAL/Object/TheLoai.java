package QuanLyThuVien.model.DAL.Object;

public class TheLoai {
	private int maTheLoai;
	private String tenTheLoai;

	public TheLoai() {
		super();
	}

	public TheLoai(int maTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
	}

	public TheLoai(int maTheLoai, String tenTheLoai) {
		super();
		this.maTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
}

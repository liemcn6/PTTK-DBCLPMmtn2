package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class CuonSach {
	// Làm theo cái mẫu Đầu Sách của anh á nè. tuân thủ các nguyên tắc luôn á nè
	// Tên biến private phải viết chữ đầu tiên thường
	private int maCuonSach;
	private int maDauSach;

	private String viTri;
	private String trangThai;

	public CuonSach(int maCuonSach) {
		super();
		this.maCuonSach = maCuonSach;
	}

	public CuonSach() {
		super();
	}

	public CuonSach(int maCuonSach, int maDauSach, String viTri, String trangThai) {
		super();
		this.maCuonSach = maCuonSach;
		this.maDauSach = maDauSach;
		this.viTri = viTri;
		this.trangThai = trangThai;
	}

	public int getMaCuonSach() {
		return maCuonSach;
	}

	public void setMaCuonSach(int maCuonSach) {
		this.maCuonSach = maCuonSach;
	}

	public int getMaDauSach() {
		return maDauSach;
	}

	public void setMaDauSach(int maDauSach) {
		this.maDauSach = maDauSach;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}

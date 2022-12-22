package QuanLyThuVien.model.DAL.Object;

import java.io.InputStream;
import java.sql.Blob;

public class ThongBao {
	private int idThongBao;
	private String tenThongBao;
	private String noiDung;
	private Blob hinhAnh;
	private InputStream hinhAnhInputStream;
	private int maTaiKhoan;

	public ThongBao(int iDThongBao) {
		super();
		this.idThongBao = iDThongBao;
	}

	public ThongBao() {
		super();
	}

	public ThongBao(int iDThongBao, String tenThongBao, String noiDung, Blob hinhAnh, int maTaiKhoan) {
		super();
		this.idThongBao = iDThongBao;
		this.tenThongBao = tenThongBao;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.maTaiKhoan = maTaiKhoan;
	}

	public ThongBao(int iDThongBao, String tenThongBao, String noiDung, Blob hinhAnh, InputStream hinhAnhInputStream,
			int maTaiKhoan) {
		super();
		this.idThongBao = iDThongBao;
		this.tenThongBao = tenThongBao;
		this.noiDung = noiDung;
		this.hinhAnh = hinhAnh;
		this.hinhAnhInputStream = hinhAnhInputStream;
		this.maTaiKhoan = maTaiKhoan;
	}

	public InputStream getHinhAnhInputStream() {
		return hinhAnhInputStream;
	}

	public void setHinhAnhInputStream(InputStream hinhAnhInputStream) {
		this.hinhAnhInputStream = hinhAnhInputStream;
	}

	public int getIdThongBao() {
		return idThongBao;
	}

	public void setIdThongBao(int idThongBao) {
		this.idThongBao = idThongBao;
	}

	public String getTenThongBao() {
		return tenThongBao;
	}

	public void setTenThongBao(String tenThongBao) {
		this.tenThongBao = tenThongBao;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Blob getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(Blob hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

}

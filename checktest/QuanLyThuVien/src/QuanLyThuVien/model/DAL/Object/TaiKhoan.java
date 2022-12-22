package QuanLyThuVien.model.DAL.Object;

import java.io.InputStream;
import java.sql.Blob;

public class TaiKhoan {
	private int maTaiKhoan;
	private String eMail;
	private String soDienThoai;
	private String matKhau;
	private Blob avartar;
	private InputStream avartarInputStream;
	private int idQuyen;
	private int maThe;

	public TaiKhoan(int maTaiKhoan) {
		super();
		this.maTaiKhoan = maTaiKhoan;
	}

	public TaiKhoan() {
		super();
	}

	public TaiKhoan(int maTaiKhoan, String eMail, String soDienThoai, String matKhau, Blob avartar, int idQuyen,
			int maThe) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.eMail = eMail;
		this.soDienThoai = soDienThoai;
		this.matKhau = matKhau;
		this.avartar = avartar;
		this.idQuyen = idQuyen;
		this.maThe = maThe;
	}

	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Blob getAvartar() {
		return avartar;
	}

	public void setAvartar(Blob avartar) {
		this.avartar = avartar;
	}

	public InputStream getAvartarInputStream() {
		return avartarInputStream;
	}

	public void setAvartarInputStream(InputStream avartarInputStream) {
		this.avartarInputStream = avartarInputStream;
	}

	public int getIdQuyen() {
		return idQuyen;
	}

	public void setIdQuyen(int idQuyen) {
		this.idQuyen = idQuyen;
	}

	public int getMaThe() {
		return maThe;
	}

	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}

}

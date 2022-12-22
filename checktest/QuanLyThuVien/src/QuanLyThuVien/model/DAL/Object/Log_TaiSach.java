package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class Log_TaiSach {
	private int id_LogTaiSach;
	private int maTaiKhoan;
	private Date ngayTaiVe;
	private int maCuonSach;
	
	
	public Log_TaiSach(int id_LogTaiSach) {
		super();
		this.id_LogTaiSach = id_LogTaiSach;
	}


	public Log_TaiSach() {
		super();
	}


	public Log_TaiSach(int id_LogTaiSach, int maTaiKhoan, Date ngayTaiVe, int maCuonSach) {
		super();
		this.id_LogTaiSach = id_LogTaiSach;
		this.maTaiKhoan = maTaiKhoan;
		this.ngayTaiVe = ngayTaiVe;
		this.maCuonSach = maCuonSach;
	}


	public int getId_LogTaiSach() {
		return id_LogTaiSach;
	}


	public void setId_LogTaiSach(int id_LogTaiSach) {
		this.id_LogTaiSach = id_LogTaiSach;
	}


	public int getMaTaiKhoan() {
		return maTaiKhoan;
	}


	public void setMaTaiKhoan(int maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}


	public Date getNgayTaiVe() {
		return ngayTaiVe;
	}


	public void setNgayTaiVe(Date ngayTaiVe) {
		this.ngayTaiVe = ngayTaiVe;
	}


	public int getMaCuonSach() {
		return maCuonSach;
	}


	public void setMaCuonSach(int maCuonSach) {
		this.maCuonSach = maCuonSach;
	}

}

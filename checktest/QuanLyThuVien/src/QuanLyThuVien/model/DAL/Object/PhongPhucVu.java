package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;
import java.sql.Time;

public class PhongPhucVu {
	private int idPhong;
	private String tenPhong;
	private Time gioBatDau;
	private Time gioKetThuc;
	private int maNhanVien;

	public PhongPhucVu(int idPhong) {
		super();
		this.idPhong = idPhong;
	}

	public PhongPhucVu() {
		super();
	}

	public PhongPhucVu(int idPhong, String tenPhong, Time gioBatDau, Time gioKetThuc, int maNhanVien) {
		super();
		this.idPhong = idPhong;
		this.tenPhong = tenPhong;
		this.gioBatDau = gioBatDau;
		this.gioKetThuc = gioKetThuc;
		this.maNhanVien = maNhanVien;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public Time getGioBatDau() {
		return gioBatDau;
	}

	public void setGioBatDau(Time time) {
		this.gioBatDau = time;
	}

	public Time getGioKetThuc() {
		return gioKetThuc;
	}

	public void setGioKetThuc(Time timeStart) {
		this.gioKetThuc = timeStart;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

}

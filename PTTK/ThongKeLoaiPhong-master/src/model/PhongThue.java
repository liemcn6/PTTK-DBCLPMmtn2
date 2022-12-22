package model;

import java.sql.Date;
import java.util.ArrayList;

public class PhongThue {
	private int id;
	private String thoiGianDen;
	private String thoiGianVe;
	private Phong phong;
	private ArrayList<DichVuSuDung> listDVSuDung;
	private ArrayList<NhanVienPhucVuPhong> listNVPhucVu;
	public PhongThue() {
		super();
	}
	public PhongThue(int id, String thoiGianDen, String thoiGianVe, Phong phong, ArrayList<DichVuSuDung> listDVSuDung,
			ArrayList<NhanVienPhucVuPhong> listNVPhucVu) {
		super();
		this.id = id;
		this.thoiGianDen = thoiGianDen;
		this.thoiGianVe = thoiGianVe;
		this.phong = phong;
		this.listDVSuDung = listDVSuDung;
		this.listNVPhucVu = listNVPhucVu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getThoiGianDen() {
		return thoiGianDen;
	}
	public void setThoiGianDen(String thoiGianDen) {
		this.thoiGianDen = thoiGianDen;
	}
	public String getThoiGianVe() {
		return thoiGianVe;
	}
	public void setThoiGianVe(String thoiGianVe) {
		this.thoiGianVe = thoiGianVe;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public ArrayList<DichVuSuDung> getListDVSuDung() {
		return listDVSuDung;
	}
	public void setListDVSuDung(ArrayList<DichVuSuDung> listDVSuDung) {
		this.listDVSuDung = listDVSuDung;
	}
	public ArrayList<NhanVienPhucVuPhong> getListNVPhucVu() {
		return listNVPhucVu;
	}
	public void setListNVPhucVu(ArrayList<NhanVienPhucVuPhong> listNVPhucVu) {
		this.listNVPhucVu = listNVPhucVu;
	}
	
	
}

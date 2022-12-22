package QuanLyThuVien.model.DAL.Object;

import java.sql.Date;

public class MuonTraSach {
	private int maMuonSach;
	private int maThe;
	private Date ngayMuon;
	private Date ngayHenTra;
	private Date ngayTra;
	private String tienDatCoc;
	private String ghiChu;
	
	
	public MuonTraSach(int maMuonSach) {
		super();
		this.maMuonSach = maMuonSach;
	}


	public MuonTraSach() {
		super();
	}


	public MuonTraSach(int maMuonSach, int maThe, Date ngayMuon, Date ngayHenTra, Date ngayTra, String tienDatCoc,
			String ghiChu) {
		super();
		this.maMuonSach = maMuonSach;
		this.maThe = maThe;
		this.ngayMuon = ngayMuon;
		this.ngayHenTra = ngayHenTra;
		this.ngayTra = ngayTra;
		this.tienDatCoc = tienDatCoc;
		this.ghiChu = ghiChu;
	}


	public int getMaMuonSach() {
		return maMuonSach;
	}


	public void setMaMuonSach(int maMuonSach) {
		this.maMuonSach = maMuonSach;
	}


	public int getMaThe() {
		return maThe;
	}


	public void setMaThe(int maThe) {
		this.maThe = maThe;
	}


	public Date getNgayMuon() {
		return ngayMuon;
	}


	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}


	public Date getNgayHenTra() {
		return ngayHenTra;
	}


	public void setNgayHenTra(Date ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}


	public Date getNgayTra() {
		return ngayTra;
	}


	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}


	public String getTienDatCoc() {
		return tienDatCoc;
	}


	public void setTienDatCoc(String tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}

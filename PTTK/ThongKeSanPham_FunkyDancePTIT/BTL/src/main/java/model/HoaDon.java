package model;




public class HoaDon {
	private int id;
	private int tongTien;
	private HangHoa hh;
	private DaiLyCon dlc;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public HoaDon(int id, int tongTien, DaiLyCon dlc) {
		super();
		this.id = id;
		this.tongTien = tongTien;
		this.dlc = dlc;
	}
	
	public int getId() {
		return id;
	}


	public int getTongTien() {
		return tongTien;
	}


	public HangHoa getHh() {
		return hh;
	}


	public DaiLyCon getDlc() {
		return dlc;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}


	public void setHh(HangHoa hh) {
		this.hh = hh;
	}


	public void setDlc(DaiLyCon dlc) {
		this.dlc = dlc;
	}


	@Override
	public String toString() {
		return dlc + "]";
	}
	
}
package model;



public class TKSanPham extends HangHoa{

	private int tongSoluong;
	private int tongtien;
	private HangHoa hh;
	public TKSanPham(int tongSoluong, int tongtien, HangHoa hh) {
		super();
		this.tongSoluong = tongSoluong;
		this.tongtien = tongtien;
		this.hh = hh;
	}
	public TKSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TKSanPham(int maHang, String tenHang, int soLuong, int giaBan, int tongTien) {
		super(maHang, tenHang, soLuong, giaBan, tongTien);
		// TODO Auto-generated constructor stub
	}
	public TKSanPham(int maHang, String tenHang, int soLuong, int giaBan, String moTa, int tongTien) {
		super(maHang, tenHang, soLuong, giaBan, moTa, tongTien);
		// TODO Auto-generated constructor stub
	}
	

	
	public int getTongSoluong() {
		return tongSoluong;
	}
	public int getTongtien() {
		return tongtien;
	}
	public HangHoa getHh() {
		return hh;
	}
	public void setTongSoluong(int tongSoluong) {
		this.tongSoluong = tongSoluong;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public void setHh(HangHoa hh) {
		this.hh = hh;
	}
	
	
}
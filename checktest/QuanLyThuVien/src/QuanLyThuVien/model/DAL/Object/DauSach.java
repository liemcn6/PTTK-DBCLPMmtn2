package QuanLyThuVien.model.DAL.Object;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

/**
 * Object ï¿½?áº§u sÃ¡ch:
 * 
 * @author IT 1006
 * @since 23/11/2018
 */
public class DauSach {
	private int maDauSach;
	private int maNxb;
	private int maTheLoai;
	private String tenSach;
	private String moTa;
	private String tacGia;
	private InputStream anhTacGia;
	private Blob anhTacGiaBlob;
	private Date namXuatBan;
	private String ngonNgu;
	private InputStream anhBia;
	private Blob anhBiaBlob;
	private String trangThai;
	private int gia;
	private InputStream filePDF;
	private Blob filePDFBlob;
	private String loaiSach;

	/**
	 * Phá»¥c vá»¥ cho viá»‡c xÃ³a
	 */
	public DauSach(int madausach) {
		this.setMaDauSach(madausach);
	}

	public DauSach(int manxb, int matheloai, String tensach, String mota, String tacgia, InputStream anhtacgia,
			Date namxuatban, String ngonngu, InputStream anhbia, String trangthai, int gia, InputStream filepdf) {
		this.setMaTheLoai(matheloai);
		this.setMaNxb(manxb);
		this.setTenSach(tensach);
		this.setMoTa(mota);
		this.setTacGia(tacgia);
		this.setAnhTacGia(anhtacgia);
		this.setNamXuatBan(namxuatban);
		this.setNgonNgu(ngonngu);
		this.setAnhBia(anhbia);
		this.setTrangThai(trangthai);
		this.setGia(gia);
		this.setFilePDF(filepdf);
	}

	public DauSach(int madausach, int manxb, int matheloai, String tensach, String mota, String tacgia,
			InputStream anhtacgia, Date namxuatban, String ngonngu, InputStream anhbia, String trangthai, int gia,
			InputStream filepdf) {
		this(manxb, matheloai, tensach, mota, tacgia, anhtacgia, namxuatban, ngonngu, anhbia, trangthai, gia, filepdf);
		this.setMaDauSach(madausach);
	}

	public int getMaDauSach() {
		return maDauSach;
	}

	public void setMaDauSach(int maDauSach) {
		this.maDauSach = maDauSach;
	}

	public int getMaNxb() {
		return maNxb;
	}

	public void setMaNxb(int maNxb) {
		this.maNxb = maNxb;
	}

	public int getMaTheLoai() {
		return maTheLoai;
	}

	public void setMaTheLoai(int maTheLoai) {
		this.maTheLoai = maTheLoai;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public InputStream getAnhTacGia() {
		return anhTacGia;
	}

	public void setAnhTacGia(InputStream anhTacGia) {
		this.anhTacGia = anhTacGia;
	}

	public Date getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(Date namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	/**
	 * Pháº§n xá»­ lÃ½ dá»¯ liá»‡u Ä‘á»�u Ä‘Æ°á»£c
	 * lÃ m á»Ÿ Ä‘Ã¢y
	 */
	public InputStream getAnhBia() {

		return anhBia;
	}

	/**
	 * Pháº§n convert dá»¯ liá»‡u lÃ m á»Ÿ Ä‘Ã¢y
	 */
	public void setAnhBia(InputStream anhBia) {

		this.anhBia = anhBia;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public InputStream getFilePDF() {
		return filePDF;
	}

	public void setFilePDF(InputStream filePDF) {
		this.filePDF = filePDF;
	}

	public Blob getAnhTacGiaBlob() {
		return anhTacGiaBlob;
	}

	public void setAnhTacGiaBlob(Blob anhTacGiaBlob) {
		this.anhTacGiaBlob = anhTacGiaBlob;
	}

	public Blob getAnhBiaBlob() {
		return anhBiaBlob;
	}

	public void setAnhBiaBlob(Blob anhBiaBlob) {
		this.anhBiaBlob = anhBiaBlob;
	}

	public Blob getFilePDFBlob() {
		return filePDFBlob;
	}

	public void setFilePDFBlob(Blob filePDFBlob) {
		this.filePDFBlob = filePDFBlob;
	}

	public DauSach() {
		this.namXuatBan = new Date(0);
	}

	public String getLoaiSach() {
		return loaiSach;
	}

	public void setLoaiSach(String loaiSach) {
		this.loaiSach = loaiSach;
	}
}
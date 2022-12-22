package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.DichVu;
import model.DichVuSuDung;
import model.KhachHang;
import model.LoaiPhong;
import model.NhanVienPhucVu;
import model.NhanVienPhucVuPhong;
import model.Phong;
import model.PhongThue;
import model.TKDatPhong;


public class PhongThueDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private PhongThueDAO createTestSubject() {
		return new PhongThueDAO();
	}
	
	@Test
	public void testGetTKDatPhongByStage() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date timeStart = dateFormat.parse("2021-01-09");
		Date timeEnd = dateFormat.parse("2021-01-11");
		PhongThueDAO ptDao = new PhongThueDAO();
		ArrayList<TKDatPhong> result = ptDao.getTKDatPhongByStage(timeStart, timeEnd);
		ArrayList<TKDatPhong> expResult = new ArrayList<TKDatPhong>();
		
		KhachHang kh = new KhachHang(7, "Đoàn Văn Hậu", 24, "0963335412", "Quỳnh Côi, Thái Bình");
		LoaiPhong lp = new LoaiPhong(4, "XL", 200, "Có thể đáp ứng số lượng khách lớn");
		Phong phong = new Phong(7, "203", "Không có mô tả", 1000000, lp);
		ArrayList<DichVuSuDung> listDVSuDung = new ArrayList<DichVuSuDung>();
		ArrayList<NhanVienPhucVuPhong> listNVPhucVu = new ArrayList<NhanVienPhucVuPhong>();
		DichVuSuDung dvsd = new DichVuSuDung(10, 2, new DichVu(10, "Number 1", "Nước tăng lực", 8000));
		listDVSuDung.add(dvsd);
		NhanVienPhucVuPhong nvpvp1 = new NhanVienPhucVuPhong(18, new NhanVienPhucVu(5, "Đặng Đình Lợi", "loidd98", "loipc98", dateFormat.parse("1998-01-13"), "Nam", "Thanh Liêm, Hà Nam", "loidd98@gmail.com", "0964258789", "035098002569", 1, "Nhân viên phục vụ"));
		NhanVienPhucVuPhong nvpvp2 = new NhanVienPhucVuPhong(19, new NhanVienPhucVu(10, "Phan Thanh Thư", "thupt98", "14121898", dateFormat.parse("1998-10-06"), "Nữ", "Lý Nhân, Hà Nam", "thupt98@gmail.com", "0932654147", "096324562512", 1, "Nhân viên phục vụ"));
		listNVPhucVu.add(nvpvp1);
		listNVPhucVu.add(nvpvp2);
		TKDatPhong tk1 = new TKDatPhong(10, "2021-01-10 13:00:51", "2021-01-10 18:00:51", phong, listDVSuDung, listNVPhucVu, 5, 5016000, kh);
		expResult.add(tk1);
		
		for(int i = 0; i< result.size(); i++) {
			assertEquals(expResult.get(i).getId(), result.get(i).getId());
			assertEquals(expResult.get(i).getThoiGianDen(), result.get(i).getThoiGianDen());
			assertEquals(expResult.get(i).getThoiGianVe(), result.get(i).getThoiGianVe());
			assertEquals(expResult.get(i).getTongGioThue(), result.get(i).getTongGioThue());
			assertEquals(expResult.get(i).getTongTien(), result.get(i).getTongTien());
			
			assertEquals(expResult.get(i).getPhong().getId(), result.get(i).getPhong().getId());
			assertEquals(expResult.get(i).getPhong().getDonGia(), result.get(i).getPhong().getDonGia());
			assertEquals(expResult.get(i).getPhong().getMoTa(), result.get(i).getPhong().getMoTa());
			assertEquals(expResult.get(i).getPhong().getTen(), result.get(i).getPhong().getTen());
			assertEquals(expResult.get(i).getPhong().getLoaiPhong().getId(), result.get(i).getPhong().getLoaiPhong().getId());
			assertEquals(expResult.get(i).getPhong().getLoaiPhong().getTen(), result.get(i).getPhong().getLoaiPhong().getTen());
			assertEquals(expResult.get(i).getPhong().getLoaiPhong().getDienTich(), result.get(i).getPhong().getLoaiPhong().getDienTich());
			assertEquals(expResult.get(i).getPhong().getLoaiPhong().getMoTa(), result.get(i).getPhong().getLoaiPhong().getMoTa());
			
			assertEquals(expResult.get(i).getListDVSuDung().get(0).getSoLuong(), result.get(i).getListDVSuDung().get(0).getSoLuong());
			assertEquals(expResult.get(i).getListDVSuDung().get(0).getDichVu().getId(), result.get(i).getListDVSuDung().get(0).getDichVu().getId());
			assertEquals(expResult.get(i).getListDVSuDung().get(0).getDichVu().getTen(), result.get(i).getListDVSuDung().get(0).getDichVu().getTen());
			assertEquals(expResult.get(i).getListDVSuDung().get(0).getDichVu().getMoTa(), result.get(i).getListDVSuDung().get(0).getDichVu().getMoTa());
			assertEquals(expResult.get(i).getListDVSuDung().get(0).getDichVu().getGia(), result.get(i).getListDVSuDung().get(0).getDichVu().getGia());
			
			assertEquals(expResult.get(i).getListNVPhucVu().get(0).getId(), result.get(i).getListNVPhucVu().get(0).getId());
			assertEquals(expResult.get(i).getListNVPhucVu().get(0).getNhanVienPhucVu().getTen(), result.get(i).getListNVPhucVu().get(0).getNhanVienPhucVu().getTen());
			assertEquals(expResult.get(i).getListNVPhucVu().get(0).getNhanVienPhucVu().getCmt(), result.get(i).getListNVPhucVu().get(0).getNhanVienPhucVu().getCmt());
			assertEquals(expResult.get(i).getListNVPhucVu().get(1).getId(), result.get(i).getListNVPhucVu().get(1).getId());
			assertEquals(expResult.get(i).getListNVPhucVu().get(1).getNhanVienPhucVu().getTen(), result.get(i).getListNVPhucVu().get(1).getNhanVienPhucVu().getTen());
			assertEquals(expResult.get(i).getListNVPhucVu().get(1).getNhanVienPhucVu().getCmt(), result.get(i).getListNVPhucVu().get(1).getNhanVienPhucVu().getCmt());
		}
		
	}
}
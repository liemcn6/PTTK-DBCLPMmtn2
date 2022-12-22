package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.NhanVien;
import model.NhanVienPhucVu;
import model.NhanVienPhucVuPhong;
import model.ThanhVien;
import static org.junit.Assert.*;


public class NhanVienDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private NhanVienDAO createTestSubject() {
		return new NhanVienDAO();
	}


	@Test
	public void testGetNhanVienCaseTrue() throws Exception {
		String username = "admin";
		String password = "admin";
		ThanhVien tv = new ThanhVien();
		tv.setTenDangNhap(username);
		tv.setMatKhau(password);
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		thanhVienDAO.checkLogin(tv);
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		NhanVien result = nhanVienDAO.getNhanVien(tv);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse("1998-12-14");
		NhanVien expResult = new NhanVien(1, "Lê Văn Tuấn", "admin", "admin", date, "Nam", "Hà Nam, Việt Nam", "levantuan1110@gmail.com", "0974947421", "035098451789", 0, "Quản trị hệ thống");
		assertEquals(result.getId(), expResult.getId());
		assertEquals(result.getTen(), expResult.getTen());
		assertEquals(result.getTenDangNhap(), expResult.getTenDangNhap());
		assertEquals(result.getMatKhau(), expResult.getMatKhau());
		assertEquals(result.getNgaySinh(), expResult.getNgaySinh());
		assertEquals(result.getGioiTinh(), expResult.getGioiTinh());
		assertEquals(result.getDiaChi(), expResult.getDiaChi());
		assertEquals(result.getEmail(), expResult.getEmail());
		assertEquals(result.getSdt(), expResult.getSdt());
		assertEquals(result.getCmt(), expResult.getCmt());
		assertEquals(result.getVaiTro(), expResult.getVaiTro());
		assertEquals(result.getMoTa(), expResult.getMoTa());
	}


	@Test
	public void testGetNhanVienCaseFalse() throws Exception {
		String username = "TenDangNhapKhongTonTai";
		String password = "MatKhauKhongTonTai";
		ThanhVien tv = new ThanhVien();
		tv.setTenDangNhap(username);
		tv.setMatKhau(password);
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		thanhVienDAO.checkLogin(tv);
		NhanVienDAO nhanVienDAO = new NhanVienDAO();
		NhanVien result = nhanVienDAO.getNhanVien(tv);
		NhanVien expResult = new NhanVien();

		assertEquals(result.getId(), expResult.getId());
		assertEquals(result.getTen(), expResult.getTen());
		assertEquals(result.getTenDangNhap(), expResult.getTenDangNhap());
		assertEquals(result.getMatKhau(), expResult.getMatKhau());
		assertEquals(result.getNgaySinh(), expResult.getNgaySinh());
		assertEquals(result.getGioiTinh(), expResult.getGioiTinh());
		assertEquals(result.getDiaChi(), expResult.getDiaChi());
		assertEquals(result.getEmail(), expResult.getEmail());
		assertEquals(result.getSdt(), expResult.getSdt());
		assertEquals(result.getCmt(), expResult.getCmt());
		assertEquals(result.getVaiTro(), expResult.getVaiTro());
		assertEquals(result.getMoTa(), expResult.getMoTa());
	}


	@Test
	public void testGetAllNVPhucVuPhongByPhongThue() throws Exception {
		int idPhongThue = 1;
		NhanVienDAO nvDao = new NhanVienDAO();
		ArrayList<NhanVienPhucVuPhong> result = nvDao.getAllNVPhucVuPhongByPhongThue(idPhongThue);
		ArrayList<NhanVienPhucVuPhong> expResult = new ArrayList<NhanVienPhucVuPhong>();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse("1999-01-04");
		NhanVienPhucVu nv1 = new NhanVienPhucVu(2, "Lê Hồng Nhung", "nhunglh99", "14121998", date1, "Nữ", "Hà Đông, Hà Nội", "nhunglh99@gmail.com", "0954632148", "035096547853", 1, "Nhân viên phục vụ");
		NhanVienPhucVuPhong nvpvp1 = new NhanVienPhucVuPhong(1, nv1);
		
		Date date2 = dateFormat.parse("1999-01-13");
		NhanVienPhucVu nv2 = new NhanVienPhucVu(3, "Trần Thu Thủy", "thuytt99", "14121998", date2, "Nữ", "Thanh Xuân, Hà Nội", "thuytt99@gmail.com", "0963541258", "035012345689", 1, "Nhân viên phục vụ");
		NhanVienPhucVuPhong nvpvp2 = new NhanVienPhucVuPhong(2, nv2);
		
		expResult.add(nvpvp1);
		expResult.add(nvpvp2);
		
		for(int i = 0; i< result.size(); i++) {
			assertEquals(expResult.get(i).getId(), result.get(i).getId());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getId(), result.get(i).getNhanVienPhucVu().getId());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getTen(), result.get(i).getNhanVienPhucVu().getTen());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getTenDangNhap(), result.get(i).getNhanVienPhucVu().getTenDangNhap());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getMatKhau(), result.get(i).getNhanVienPhucVu().getMatKhau());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getNgaySinh(), result.get(i).getNhanVienPhucVu().getNgaySinh());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getGioiTinh(), result.get(i).getNhanVienPhucVu().getGioiTinh());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getDiaChi(), result.get(i).getNhanVienPhucVu().getDiaChi());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getEmail(), result.get(i).getNhanVienPhucVu().getEmail());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getSdt(), result.get(i).getNhanVienPhucVu().getSdt());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getCmt(), result.get(i).getNhanVienPhucVu().getCmt());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getVaiTro(), result.get(i).getNhanVienPhucVu().getVaiTro());
			assertEquals(expResult.get(i).getNhanVienPhucVu().getMoTa(), result.get(i).getNhanVienPhucVu().getMoTa());
		}
	}
	
	@Test
	public void testGetAllNVPhucVuPhongByPhongThueCaseEmpty() throws Exception {
		int idPhongThue = -1;
		NhanVienDAO nvDao = new NhanVienDAO();
		ArrayList<NhanVienPhucVuPhong> result = nvDao.getAllNVPhucVuPhongByPhongThue(idPhongThue);
		
		assertEquals(0, result.size());
		
	}
}
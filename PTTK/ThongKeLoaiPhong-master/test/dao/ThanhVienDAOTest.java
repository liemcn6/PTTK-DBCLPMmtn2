package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.ThanhVien;


public class ThanhVienDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private ThanhVienDAO createTestSubject() {
		return new ThanhVienDAO();
	}

	@Test
	public void testCheckLoginCaseTrue() throws Exception {
		String username = "admin";
		String password = "admin";
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		ThanhVien tv = new ThanhVien();
		tv.setTenDangNhap(username);
		tv.setMatKhau(password);
		Boolean result = thanhVienDAO.checkLogin(tv);
		Boolean expectedResult = true;
		assertEquals(result, expectedResult);
	}


	@Test
	public void testCheckLoginCaseFalse() throws Exception {
		String username = "TenDangNhapKhongTonTai";
		String password = "MatKhauKhongTonTai";
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		ThanhVien tv = new ThanhVien();
		tv.setTenDangNhap(username);
		tv.setMatKhau(password);
		Boolean result = thanhVienDAO.checkLogin(tv);
		Boolean expectedResult = false;
		assertEquals(result, expectedResult);
	}
}
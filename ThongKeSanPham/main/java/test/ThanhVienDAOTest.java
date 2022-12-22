package test;


import org.junit.Assert;
import org.junit.Test;

import dao.ThanhVienDAO;
import model.ThanhVien;





public class ThanhVienDAOTest {

	@Test
	public void KiemtraDangNhapTrue() {
		String username = "admin";
		String password = "admin";
		ThanhVienDAO tvDAO = new ThanhVienDAO();
		ThanhVien tv = new ThanhVien();
		tv.setUsername(username);
		tv.setPassword(password);
		Boolean result = tvDAO.kiemtraDangNhap(tv);
		Boolean expectedResult = true;
		Assert.assertEquals(result, expectedResult);
	}


	@Test
	public void  KiemtraDangNhapFalse() {
		String username = "Kevodanh";
		String password = "Kevohinh";
		ThanhVienDAO tvDAO = new ThanhVienDAO();
		ThanhVien tv = new ThanhVien();
		tv.setUsername(username);
		tv.setPassword(password);
		Boolean result = tvDAO.kiemtraDangNhap(tv);
		Boolean expectedResult = false;
		Assert.assertEquals(result, expectedResult) ;
	
	}
}
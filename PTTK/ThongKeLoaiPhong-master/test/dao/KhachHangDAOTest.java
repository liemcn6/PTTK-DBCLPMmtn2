package dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import model.KhachHang;


public class KhachHangDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	private KhachHangDAO createTestSubject() {
		return new KhachHangDAO();
	}

	@Test
	public void testGetKhachHangByPhongThue() throws Exception {
		int idPhongThue = 1;
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHang result = khachHangDAO.getKhachHangByPhongThue(idPhongThue);
		assertNotNull(result);
		KhachHang expResult = new KhachHang(2, "Lê Văn B", 29, "0324689513", "Thanh Xuân, Hà Nội");
		
		assertEquals(result.getId(), expResult.getId());
		assertEquals(result.getTen(), expResult.getTen());
		assertEquals(result.getTuoi(), expResult.getTuoi());
		assertEquals(result.getSdt(), expResult.getSdt());
		assertEquals(result.getDiaChi(), expResult.getDiaChi());
	}


	@Test
	public void testGetKhachHangByPhongThueCaseEmpty() throws Exception {
		int idPhongThue = -1;
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHang result = khachHangDAO.getKhachHangByPhongThue(idPhongThue);
		KhachHang expResult = new KhachHang();
		
		assertEquals(result.getId(), expResult.getId());
		assertEquals(result.getTen(), expResult.getTen());
		assertEquals(result.getTuoi(), expResult.getTuoi());
		assertEquals(result.getSdt(), expResult.getSdt());
		assertEquals(result.getDiaChi(), expResult.getDiaChi());
	}
}
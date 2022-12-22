package dao;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.DichVu;
import model.DichVuSuDung;


public class DichVuDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private DichVuDAO createTestSubject() {
		return new DichVuDAO();
	}

	@Test
	public void testGetAllDVSuDungByPhongThue() throws Exception {
		int idPhongThue = 1;
		DichVuDAO dichVuDAO = new DichVuDAO();
		ArrayList<DichVuSuDung> result = dichVuDAO.getAllDVSuDungByPhongThue(idPhongThue);
		assertNotNull(result);
		ArrayList<DichVuSuDung> expResult = new ArrayList<DichVuSuDung>();
		
		DichVu dv1 = new DichVu(3, "Bia hơi", "Nước uống có cồn 20%", 8000);
		DichVuSuDung dvsd1 = new DichVuSuDung(2, 4, dv1);
		DichVu dv2 = new DichVu(1, "Nước cam", "Nước cam ép", 10000);
		DichVuSuDung dvsd2 = new DichVuSuDung(3, 6, dv2);
		
		
		expResult.add(dvsd1);
		expResult.add(dvsd2);
		
		for(int i = 0; i< result.size(); i++) {
			assertEquals(expResult.get(i).getId(), result.get(i).getId());
			assertEquals(expResult.get(i).getSoLuong(), result.get(i).getSoLuong());
			assertEquals(expResult.get(i).getDichVu().getId(), result.get(i).getDichVu().getId());
			assertEquals(expResult.get(i).getDichVu().getTen(), result.get(i).getDichVu().getTen());
			assertEquals(expResult.get(i).getDichVu().getMoTa(), result.get(i).getDichVu().getMoTa());
			assertEquals(expResult.get(i).getDichVu().getGia(), result.get(i).getDichVu().getGia());
		}
	}

	@Test
	public void testGetAllDVSuDungByPhongThueCaseEmpty() throws Exception {
		int idPhongThue = -1;
		DichVuDAO dichVuDAO = new DichVuDAO();
		ArrayList<DichVuSuDung> result = dichVuDAO.getAllDVSuDungByPhongThue(idPhongThue);
		assertNotNull(result);
		assertEquals(0, result.size());
	}
}
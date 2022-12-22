package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import model.LoaiPhong;
import model.Phong;
import model.TKDatPhong;
import model.TKLoaiPhong;
import model.TKPhong;


public class TKPhongDAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private TKPhongDAO createTestSubject() {
		return new TKPhongDAO();
	}


	@Test
	public void testGetAllLoaiPhong() throws Exception {
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		ArrayList<LoaiPhong> result = tkPhongDAO.getAllLoaiPhong();
		ArrayList<LoaiPhong> expResult = new ArrayList<LoaiPhong>();
		
		LoaiPhong lp1 = new LoaiPhong(1, "S", 50, "Phù hợp với số lượng khách vừa và nhỏ");
		LoaiPhong lp2 = new LoaiPhong(2, "M", 100, "Phù hợp với số lượng khách trung bình");
		LoaiPhong lp3 = new LoaiPhong(3, "L", 150, "Phù hợp với số lượng khách tương đối lớn");
		LoaiPhong lp4 = new LoaiPhong(4, "XL", 200, "Có thể đáp ứng số lượng khách lớn");
		
		expResult.add(lp1);
		expResult.add(lp2);
		expResult.add(lp3);
		expResult.add(lp4);
		
		for(int i = 0; i< result.size(); i++) {
			assertEquals(expResult.get(i).getId(), result.get(i).getId());
			assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
			assertEquals(expResult.get(i).getDienTich(), result.get(i).getDienTich());
			assertEquals(expResult.get(i).getMoTa(), result.get(i).getMoTa());
		}
		
	}


	@Test
	public void testGetLoaiPhongById() throws Exception {
		int idLoaiPhong = 1;
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		LoaiPhong result = tkPhongDAO.getLoaiPhongById(idLoaiPhong);
		LoaiPhong expResult = new LoaiPhong(1, "S", 50, "Phù hợp với số lượng khách vừa và nhỏ");
		
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getTen(), result.getTen());
		assertEquals(expResult.getDienTich(), result.getDienTich());
		assertEquals(expResult.getMoTa(), result.getMoTa());
		
	}
	
	@Test
	public void testGetLoaiPhongByIdCaseFalse() throws Exception {
		int idLoaiPhong = -1;
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		LoaiPhong result = tkPhongDAO.getLoaiPhongById(idLoaiPhong);
		LoaiPhong expResult = new LoaiPhong();
		
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getTen(), result.getTen());
		assertEquals(expResult.getDienTich(), result.getDienTich());
		assertEquals(expResult.getMoTa(), result.getMoTa());
		
	}


	@Test
	public void testGetPhongById() throws Exception {
		int idPhong = 1;
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		Phong result = tkPhongDAO.getPhongById(idPhong);
		Phong expResult = new Phong(1, "101", "Không có mô tả", 200000, new LoaiPhong(1, "S", 50, "Phù hợp với số lượng khách vừa và nhỏ"));
		
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getTen(), result.getTen());
		assertEquals(expResult.getMoTa(), result.getMoTa());
		assertEquals(expResult.getDonGia(), result.getDonGia());
		assertEquals(expResult.getLoaiPhong().getId(), result.getLoaiPhong().getId());
		assertEquals(expResult.getLoaiPhong().getTen(), result.getLoaiPhong().getTen());
		assertEquals(expResult.getLoaiPhong().getDienTich(), result.getLoaiPhong().getDienTich());
		assertEquals(expResult.getLoaiPhong().getMoTa(), result.getLoaiPhong().getMoTa());
		
	}
	
	@Test
	public void testGetPhongByIdCaseFalse() throws Exception {
		int idPhong = -1;
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		Phong result = tkPhongDAO.getPhongById(idPhong);
		Phong expResult = new Phong();
		
		assertEquals(expResult.getId(), result.getId());
		assertEquals(expResult.getTen(), result.getTen());
		assertEquals(expResult.getMoTa(), result.getMoTa());
		assertEquals(expResult.getDonGia(), result.getDonGia());
		assertEquals(expResult.getLoaiPhong(), result.getLoaiPhong());
		
	}


	@Test
	public void testGetTKLoaiPhong() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date thoiGianBD = dateFormat.parse("2021-01-09");
		Date thoiGianKT = dateFormat.parse("2021-01-11");
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		ArrayList<TKDatPhong> listTKDatPhong = new PhongThueDAO().getTKDatPhongByStage(thoiGianBD, thoiGianKT);
		ArrayList<LoaiPhong> listLP = tkPhongDAO.getAllLoaiPhong();
		
		ArrayList<TKLoaiPhong> result = tkPhongDAO.getTKLoaiPhong(listTKDatPhong, listLP);
		
		ArrayList<TKLoaiPhong> expResult = new ArrayList<TKLoaiPhong>();
		TKLoaiPhong tklp1 = new TKLoaiPhong(1, "S", 50, "Phù hợp với số lượng khách vừa và nhỏ", 0, 0);
		TKLoaiPhong tklp2 = new TKLoaiPhong(2, "M", 100, "Phù hợp với số lượng khách trung bình", 0, 0);
		TKLoaiPhong tklp3 = new TKLoaiPhong(3, "L", 150, "Phù hợp với số lượng khách tương đối lớn", 0, 0);
		TKLoaiPhong tklp4 = new TKLoaiPhong(4, "XL", 200, "Có thể đáp ứng số lượng khách lớn", 5, 5016000);
		expResult.add(tklp1);
		expResult.add(tklp2);
		expResult.add(tklp3);
		expResult.add(tklp4);
		
		for(int i = 0; i< result.size(); i++) {
			assertEquals(expResult.get(i).getId(), result.get(i).getId());
			assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
			assertEquals(expResult.get(i).getDienTich(), result.get(i).getDienTich());
			assertEquals(expResult.get(i).getMoTa(), result.get(i).getMoTa());
			assertEquals(expResult.get(i).getTongGioThue(), result.get(i).getTongGioThue(), 0.0);
			assertEquals(expResult.get(i).getTongTien(), result.get(i).getTongTien());
		}
		
	}
	
	@Test
	public void testGetTKLoaiPhongCaseEmpty() throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date thoiGianBD = dateFormat.parse("2019-01-09");
		Date thoiGianKT = dateFormat.parse("2019-01-11");
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		ArrayList<TKDatPhong> listTKDatPhong = new PhongThueDAO().getTKDatPhongByStage(thoiGianBD, thoiGianKT);
		ArrayList<LoaiPhong> listLP = tkPhongDAO.getAllLoaiPhong();
		
		ArrayList<TKLoaiPhong> result = tkPhongDAO.getTKLoaiPhong(listTKDatPhong, listLP);
		
		ArrayList<TKLoaiPhong> expResult = new ArrayList<TKLoaiPhong>();
		TKLoaiPhong tklp1 = new TKLoaiPhong(1, "S", 50, "Phù hợp với số lượng khách vừa và nhỏ", 0, 0);
		TKLoaiPhong tklp2 = new TKLoaiPhong(2, "M", 100, "Phù hợp với số lượng khách trung bình", 0, 0);
		TKLoaiPhong tklp3 = new TKLoaiPhong(3, "L", 150, "Phù hợp với số lượng khách tương đối lớn", 0, 0);
		TKLoaiPhong tklp4 = new TKLoaiPhong(4, "XL", 200, "Có thể đáp ứng số lượng khách lớn", 0, 0);
		expResult.add(tklp1);
		expResult.add(tklp2);
		expResult.add(tklp3);
		expResult.add(tklp4);
		
		for(int i = 0; i< result.size(); i++) {
			
			assertEquals(expResult.get(i).getTen(), result.get(i).getTen());
			assertEquals(expResult.get(i).getDienTich(), result.get(i).getDienTich());
			assertEquals(expResult.get(i).getMoTa(), result.get(i).getMoTa());
			assertEquals(expResult.get(i).getTongGioThue(), result.get(i).getTongGioThue(), 0.0);
			assertEquals(expResult.get(i).getTongTien(), result.get(i).getTongTien());
		}
		
	}
}
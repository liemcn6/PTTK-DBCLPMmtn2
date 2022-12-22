package test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.TKHoaDonDAO;
import model.TKHoaDon;



class HoaDonDAOTest {
	@Test
	public void testGetDanhSachHoaDon() throws Exception {
		
		TKHoaDonDAO hd = new TKHoaDonDAO();
		int idhh = 1;
		ArrayList<TKHoaDon> result = hd.getDanhSachHD(idhh);
		Assert.assertNotNull(result);
	}
@Test
//test xem khong co san pham nao 
	public void testGetDanhSachHoaDon2() throws Exception {
		
		TKHoaDonDAO hd = new TKHoaDonDAO();
		int idhh = 0;
		ArrayList<TKHoaDon> result = hd.getDanhSachHD(idhh);
		Assert.assertNotNull(result);
}


@Test
//test xem nhieu san pham
	public void testGetDanhSachHoaDon3() throws Exception {
		
		TKHoaDonDAO hd = new TKHoaDonDAO();
		int idhh = 1000;
		ArrayList<TKHoaDon> result = hd.getDanhSachHD(idhh);
		Assert.assertNotNull(result);
}
}

package test;



import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import dao.TKSanPhamDAO;

import model.*;


public class TKSanPhamDAOTest {
TKSanPhamDAO tksp = new TKSanPhamDAO();
@Test
public void getDanhSachTKSP1() {
	//test truong hop khong co san pham trong thoi gian nay
	String ngaybatdau = "1000/01/01";
	String ngayketthuc = "1001/12/30";
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	Assert.assertNotNull(listSP);
}

@Test
public void getDanhSachTKSP2() {
	//test truong hop co 8 san pham 
	String ngaybatdau ="1901/01/01";
	String ngayketthuc ="2999/01/02";
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	Assert.assertEquals(8, listSP.size());
}

@Test
public void getDanhSachSP_test3() {
	//test truong hop tong so tien thu duoc lon hon 0
	String ngaybatdau = "2020/01/01";
	String ngayketthuc = "2020/12/30";
	
	boolean check = true;
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	for(TKSanPham tk : listSP) {
		if(tk.getTongtien() <= 0) {
			check = false;
			break;
		}
	}
	Assert.assertTrue(check);
}




@Test
public void getDanhSachSP_testEx1() {
	//test truog hop co nhieu san pham
	String ngaybatdau = "1111/08/09";
	String ngayketthuc = "3333/10/01";
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	Assert.assertNotNull(listSP);
	}

@Test
public void getDanhSachSP_testEx2() {
	//test truong hop thoi gian bat dau = thoi gian ket thuc
	String ngaybatdau = "2000-01-01";
	String ngayketthuc = "2000-01-01";
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	Assert.assertNotNull(listSP);

}
public void getDanhSachSP_testEx6() {
	//test truong hop thoi gian bat dau > thoi gian ket thuc

	String ngaybatdau = "2000-11-01";
	String ngayketthuc = "2000-01-01";
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	Assert.assertNotNull(listSP);

}

@Test

public void getDanhSachSP_testEx3() {
	//test truong hop thoi gian rong
	String ngaybatdau = "2012-12-12";
	String ngayketthuc = "2020-11-11";
	
	ArrayList<TKSanPham> listSP = tksp.getDanhSachSP(ngaybatdau, ngayketthuc);
	TKSanPham list = new TKSanPham(3, "Hermes", 102,3333,339966);
	ArrayList<TKSanPham> tk = new ArrayList<TKSanPham>();
	tk.add(list);
	Assert.assertEquals(tk, listSP);
	
}
public void check() {
	TKSanPhamDAO kq= new TKSanPhamDAO();
	ArrayList<TKSanPham> list = kq.getDanhSachSP("2000-02-02", "2033-02-02");
	System.out.println(list.size());
	for (TKSanPham a: list) {
		System.out.println(a);
		Assert.assertNotNull(a);
	}
}
}

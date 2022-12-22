/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import model.NhanVien;
import model.ThanhVien;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xuan Toog
 */

public class ThanhVienDAOTest {
    
    ThanhVienDAO thanhVienDAO;
    
    public ThanhVienDAOTest() {
        thanhVienDAO = new ThanhVienDAO();
    }

    @Test
    public void testCheckDangNhap_test1() {
        // thành viên không tồn tại (tên đăng nhập, mật khẩu sai)
        ThanhVien tv = new ThanhVien(); tv.setTendangnhap("abc"); tv.setMatkhau("abc");
        boolean check = thanhVienDAO.checkDangNhap(tv);
        assertEquals(false, check);
    }
    
    @Test
    public void testCheckDangNhap_test2() {
        // thành viên tồn tại (tên đăng nhập, mật khẩu đúng)
        ThanhVien tv = new ThanhVien(); tv.setTendangnhap("tung"); tv.setMatkhau("tung");
        boolean check = thanhVienDAO.checkDangNhap(tv);
        assertEquals(true, check);
    }

    @Test
    public void testGetNhanVienByTendangnhap_test1() {
        // tên đăng nhập tồn tại
        NhanVien nv = null;
        nv = thanhVienDAO.getNhanVienByTendangnhap("tung");
        int nhanvienId = nv.getId();
        assertNotNull(nhanvienId);
    }
    
    @Test
    public void testGetNhanVienByTendangnhap_test2() {
        // tên đăng nhập không tồn tại
        NhanVien nv = null;
        nv = thanhVienDAO.getNhanVienByTendangnhap("abc");
        assertNull(nv);  
    }

    @Test
    public void testStringToDate_test1() throws Exception {
        // String đúng format "yyyy-MM-dd"
        String string = "1998-05-14"; 
        Date date = null;
        date = thanhVienDAO.stringToDate(string);
        assertNotNull(date);
    }
    
    @Test
    public void testStringToDate_test2() throws Exception {
        // String không đúng format "yyyy-MM-dd"
        String str1 = "14-05-1998";  String str2 = "1998-05-14";
        Date date1 = thanhVienDAO.stringToDate(str1);
        Date date2 = thanhVienDAO.stringToDate(str2);
        assertNotEquals(date1, date2);
    }
    
}

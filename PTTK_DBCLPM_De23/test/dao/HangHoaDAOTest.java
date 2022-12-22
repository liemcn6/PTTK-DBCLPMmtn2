/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.HangHoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xuan Toog
 */
public class HangHoaDAOTest {
    
    HangHoaDAO hangHoaDAO;
    
    public HangHoaDAOTest() {
        hangHoaDAO = new HangHoaDAO();
    }

    @Test
    public void testCreateHangHoa_test1() {
        // mã hàng hóa đã tồn tại
        HangHoa hh1 = new HangHoa("HH999", "abc", "abc");
        HangHoa hh2 = new HangHoa("HH999", "abc", "abc");
        try {
            DAO.con.setAutoCommit(false);
            int status1 = hangHoaDAO.createHangHoa(hh1);
            assertEquals(1, status1);
            
            int status2 = hangHoaDAO.createHangHoa(hh2);
            assertEquals(-1, status2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Test
    public void testCreateHangHoa_test2() {
        // mã hàng hóa đã tồn tại
        HangHoa hh1 = new HangHoa("HH999", "abc", "abc");
        HangHoa hh2 = new HangHoa("HH998", "abc", "abc");
        try {
            DAO.con.setAutoCommit(false);
            int status1 = hangHoaDAO.createHangHoa(hh1);
            assertEquals(1, status1);
            
            int status2 = hangHoaDAO.createHangHoa(hh2);
            assertEquals(1, status2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DAO.con.rollback();
                DAO.con.setAutoCommit(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testGetHangHoa_test1() {
        // id hàng hóa tồn tại
        HangHoa hh = hangHoaDAO.getHangHoa(1);
        assertEquals(1, hh.getId());
    }
    
    @Test
    public void testGetHangHoa_test2() {
        // id hàng hóa tồn tại
        HangHoa hh = null;
        hh = hangHoaDAO.getHangHoa(1);
        assertEquals(1, hh.getId());
    }

    @Test
    public void testSearchHangHoa_test1() {
        // không có hàng hóa nào có tên chứa từ khóa
        ArrayList<HangHoa> arr = new ArrayList();
        arr = hangHoaDAO.searchHangHoa("abc");
        assertEquals(0, arr.size());
    }
    
    @Test
    public void testSearchHangHoa_test2() {
        // có 1 hàng hóa nào có tên chứa từ khóa
        ArrayList<HangHoa> arr = new ArrayList();
        arr = hangHoaDAO.searchHangHoa("Iphone X");
        assertEquals(1, arr.size());
    }
    
    @Test
    public void testSearchHangHoa_test3() {
        // có > 1 hàng hóa nào có tên chứa từ khóa
        ArrayList<HangHoa> arr = new ArrayList();
        arr = hangHoaDAO.searchHangHoa("Iphone");
        assertNotEquals(0, arr.size());
        assertNotEquals(1, arr.size());
    }
    
}

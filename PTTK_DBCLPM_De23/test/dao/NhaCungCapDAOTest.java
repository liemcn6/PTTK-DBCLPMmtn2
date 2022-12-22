/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.NhaCungCap;
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
public class NhaCungCapDAOTest {
    
    NhaCungCapDAO nhaCungCapDAO;
    
    public NhaCungCapDAOTest() {
        nhaCungCapDAO = new NhaCungCapDAO();
    }
    

    @Test
    public void testCreateNhaCungCap_test1() {
        // mã nhà cung cấp đã tồn tại
        NhaCungCap ncc1 = new NhaCungCap("NCC999", "abc", "abc", "abc");
        NhaCungCap ncc2 = new NhaCungCap("NCC999", "abc", "abc", "abc");
        
        try {
            DAO.con.setAutoCommit(false);
            int status1 = nhaCungCapDAO.createNhaCungCap(ncc1);
            assertEquals(1, status1);
            
            int status2 = nhaCungCapDAO.createNhaCungCap(ncc2);
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
    public void testCreateNhaCungCap_test2() {
        // mã nhà cung cấp chưa tồn tại
        NhaCungCap ncc1 = new NhaCungCap("NCC999", "abc", "abc", "abc");
        NhaCungCap ncc2 = new NhaCungCap("NCC998", "abc", "abc", "abc");
        
        try {
            DAO.con.setAutoCommit(false);
            int status1 = nhaCungCapDAO.createNhaCungCap(ncc1);
            assertEquals(1, status1);
            
            int status2 = nhaCungCapDAO.createNhaCungCap(ncc2);
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
    public void testGetNhaCungCap_test1() {
        // id nhà cung cấp tồn tại
        NhaCungCap ncc = nhaCungCapDAO.getNhaCungCap(1);
        assertEquals(1, ncc.getId());
    }
    
    @Test
    public void testGetNhaCungCap_test2() {
        // id nhà cung cấp không tồn tại
        NhaCungCap ncc = null;
        ncc = nhaCungCapDAO.getNhaCungCap(-1);
        assertNull(ncc);
    }

    @Test
    public void testSearchNhaCungCap_test1() {
        // không có nhà cung cấp nào có tên chứa từ khóa
        ArrayList<NhaCungCap> arr = new ArrayList();
        arr = nhaCungCapDAO.searchNhaCungCap("abc");
        assertEquals(0, arr.size());
    }
    
    @Test
    public void testSearchNhaCungCap_test2() {
        // có 1 nhà cung cấp nào có tên chứa từ khóa
        ArrayList<NhaCungCap> arr = new ArrayList();
        arr = nhaCungCapDAO.searchNhaCungCap("Nha cung cap Ha Noi");
        assertEquals(1, arr.size());
    }
    
    @Test
    public void testSearchNhaCungCap_test3() {
        // có > 1 nhà cung cấp nào có tên chứa từ khóa
        ArrayList<NhaCungCap> arr = new ArrayList();
        arr = nhaCungCapDAO.searchNhaCungCap("Nha cung cap");
        assertNotEquals(0, arr.size());
        assertNotEquals(1, arr.size());
    }
    
}

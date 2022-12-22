/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.DaiLyTrungGian;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xuan Toog
 */
public class DaiLyTrungGianDAOTest {
    
    DaiLyTrungGianDAO daiLyTrungGianDAO;

    public DaiLyTrungGianDAOTest() {
        daiLyTrungGianDAO = new DaiLyTrungGianDAO();
    }
    
    @Test
    public void testGetDaiLyTrungGianByThanhVienId_test1() {
        // thành viên id tồn tại, đại lý trung gian tồn tại
        DaiLyTrungGian daily = daiLyTrungGianDAO.getDaiLyTrungGianByThanhVienId(1);
        assertEquals(1, daily.getId());
    }
    
    @Test
    public void testGetDaiLyTrungGianByThanhVienId_test2() {
        // thành viên id không tồn tại
        DaiLyTrungGian daily = null;
        daily = daiLyTrungGianDAO.getDaiLyTrungGianByThanhVienId(999);
        assertNull(daily);
    }
    
}

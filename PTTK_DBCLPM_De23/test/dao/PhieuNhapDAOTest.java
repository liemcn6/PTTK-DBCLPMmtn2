/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;
import model.*;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xuan Toog
 */
public class PhieuNhapDAOTest {
    
    PhieuNhapDAO phieuNhapDAO;
    HangHoaDAO hangHoaDAO;
    ThanhVienDAO thanhVienDAO;
    DaiLyTrungGianDAO daiLyTrungGianDAO;
    NhaCungCapDAO nhaCungCapDAO;
    
    
    public PhieuNhapDAOTest() {
        phieuNhapDAO = new PhieuNhapDAO();
        hangHoaDAO = new HangHoaDAO();
        thanhVienDAO = new ThanhVienDAO();
        daiLyTrungGianDAO = new DaiLyTrungGianDAO();
        nhaCungCapDAO = new NhaCungCapDAO();
    }

    @Test
    public void testLuuPhieuNhap_test1() throws Exception {
        // danh sách PhieuNhap_HangHoa không rỗng
        ArrayList<PhieuNhap_HangHoa> arr = new ArrayList();
        try {
            DAO.con.setAutoCommit(false);
            HangHoa hh = null; hh = hangHoaDAO.getHangHoa(1);
            assertNotNull(hh);
            
            NhanVien nv = null; nv = thanhVienDAO.getNhanVienByTendangnhap("tung");
            assertNotNull(nv);
            
            DaiLyTrungGian daily = null; daily = daiLyTrungGianDAO.getDaiLyTrungGianByThanhVienId(nv.getId());
            assertNotNull(daily);
            
            NhaCungCap ncc = null; ncc = nhaCungCapDAO.getNhaCungCap(1);
            assertNotNull(ncc);
            
            arr.add(new PhieuNhap_HangHoa(1, 1, hh));
            PhieuNhap phieuNhap = new PhieuNhap(new Date(), "", nv, daily, ncc, arr);
            boolean check = phieuNhapDAO.luuPhieuNhap(phieuNhap);
            assertEquals(true, check);
            
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
    public void testLuuPhieuNhap_test2() throws Exception {
        // danh sách PhieuNhap_HangHoa rỗng
        ArrayList<PhieuNhap_HangHoa> arr = new ArrayList();
        try {
            DAO.con.setAutoCommit(false);
            HangHoa hh = null; hh = hangHoaDAO.getHangHoa(1);
            assertNotNull(hh);
            
            NhanVien nv = null; nv = thanhVienDAO.getNhanVienByTendangnhap("tung");
            assertNotNull(nv);
            
            DaiLyTrungGian daily = null; daily = daiLyTrungGianDAO.getDaiLyTrungGianByThanhVienId(nv.getId());
            assertNotNull(daily);
            
            NhaCungCap ncc = null; ncc = nhaCungCapDAO.getNhaCungCap(1);
            assertNotNull(ncc);
            
//            arr.add(new PhieuNhap_HangHoa(1, 1, hh));
            PhieuNhap phieuNhap = new PhieuNhap(new Date(), "", nv, daily, ncc, arr);
            boolean check = phieuNhapDAO.luuPhieuNhap(phieuNhap);
            assertEquals(false, check);
            
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
    
}

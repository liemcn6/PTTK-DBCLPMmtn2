/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Sachmuon325;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class SachmuonDAOTest {
    
    SachmuonDAO instance = new SachmuonDAO();
    /**
     * Test of getListSachmuon method, of class SachmuonDAO.
     */
    @Test
    public void testGetListSachmuon_testChuan1() {
        // chua tra 1 quyen
       
        String mavachBD = "00022";
        boolean trangthai = false;
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
        assertNotNull( result);
        assertEquals(1, result.size());
        assertEquals(trangthai, result.get(0).isTrangthai());
        
    }
    @Test
    public void testGetListSachmuon_testChuan2() {
        //chua tra > 1 quyen
        
        String mavachBD = "00006";
        boolean trangthai = false;
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
         assertNotNull( result);
        assertEquals(3, result.size());
        for(int i=0; i<result.size();i++){
            assertEquals(trangthai, result.get(i).isTrangthai());
        }
        
    }
    @Test
    public void testGetListSachmuon_testChuan3() {
        // da tra het == k còn muon sach nao
        String mavachBD = "00002";
        boolean trangthai = false;
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
         
        assertEquals(0, result.size());
        
        
    }
    @Test
    public void testGetListSachmuon_testChuan4() {
        // da tra 1
        System.out.println("getListSachmuon");
        String mavachBD = "00015";
        boolean trangthai = true;
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
        assertNotNull( result);
        assertEquals(1, result.size());
        assertEquals(trangthai, !result.get(0).isTrangthai());
        
        
    }
    @Test
    public void testGetListSachmuon_testChuan5() {
        // da tra >1
        String mavachBD = "00003";
        boolean trangthai = true;
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
         assertNotNull( result);
        assertEquals(3, result.size());
        for(int i=0; i<result.size();i++){
            assertEquals(trangthai, !result.get(i).isTrangthai());
        }
    }
    @Test
    public void testGetListSachmuon_testChuan6() {
        // chua tra quyen nao
        System.out.println("getListSachmuon");
        String mavachBD = "00009";
        boolean trangthai = true;
        
        
        List<Sachmuon325> result = instance.getListSachmuon(mavachBD, trangthai);
        assertEquals(0, result.size());
        
    }

    /**
     * Test of updateListSachmuon method, of class SachmuonDAO.
     */
    @Test
    public void testUpdateListSachmuon() {
        System.out.println("updateListSachmuon");
        List<Sachmuon325> dsSachmuon = null;
        
        boolean expResult = false;
        boolean result = instance.updateListSachmuon(dsSachmuon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateIdphatListStm method, of class SachmuonDAO.
     */
    @Test
    public void testUpdateIdphatListStm() {
        System.out.println("updateIdphatListStm");
        List<Sachmuon325> dsSachtramuon = null;
        
        boolean expResult = false;
        boolean result = instance.updateIdphatListStm(dsSachtramuon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

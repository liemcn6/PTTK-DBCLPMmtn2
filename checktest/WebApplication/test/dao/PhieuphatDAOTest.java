/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
public class PhieuphatDAOTest {
    
    
    /**
     * Test of luuPhieuphat method, of class PhieuphatDAO.
     */
    @Test
    public void testLuuPhieuphat() {
        System.out.println("luuPhieuphat");
        int idtbd = 0;
        int idpm = 0;
        int idnv = 0;
        PhieuphatDAO instance = new PhieuphatDAO();
        boolean expResult = false;
        boolean result = instance.luuPhieuphat(idtbd, idpm, idnv);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

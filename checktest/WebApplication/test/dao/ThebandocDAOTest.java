/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Thebandoc325;
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
public class ThebandocDAOTest {
    
     ThebandocDAO dao = new ThebandocDAO();
    
   

    /**
     * Test of getTheBD method, of class ThebandocDAO.
     */
    @Test
    public void testGetTheBDChuan() {
       // mathe ban doc ton tai
        String mavachBD = "00002";
        
        Thebandoc325 result = dao.getTheBD(mavachBD);
        assertNotNull(result);
        assertEquals(mavachBD, result.getMavachBD());
        
    }
    
    @Test
    public void testGetTheBDNgoaile(){
        // ma the ban doc khong ton tai
        String mavachBD = "0039";
        Thebandoc325 result = dao.getTheBD(mavachBD);
        assertNull(result);
    }
    
}

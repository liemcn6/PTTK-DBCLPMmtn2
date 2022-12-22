package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.DAO;

import java.sql.Connection;
import static org.junit.Assert.*;
public class DAOTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	private DAO createTestSubject() {
		return new DAO();
	}


	@Test
    public void testGetConnection() {
        System.out.println("Ket noi thanh cong");
        DAO instance = new DAO();
        Connection result = instance.con;
        assertNotNull(result);
    }
	

	@Test
    public void testGetErrorConnection() {
        System.out.println("Ket noi that bai");
        DAO instance = new DAO();
        Connection result = instance.con;
        assertNull(result);
    }
}
package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        System.out.println("getConnection");
        DAO instance = new DAO();
        Connection result = instance.con;
        assertNotNull(result);
    }
}
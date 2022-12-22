package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
public static Connection con;
	public DAO() {
		if(con == null) {
			String dbUrl = "jdbc:mysql://localhost:3306/dbtn2?autoReconnect=true&useSSL=false";

			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");	
				con = (Connection) DriverManager.getConnection(dbUrl,"root","19091990"); //connect
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

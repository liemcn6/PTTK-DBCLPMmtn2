/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Xuan Toog
 */
public class DAO {
    public static Connection con;
    
    public DAO() {
        if(con==null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pttk_dbclpm_23?allowPublicKeyRetrieval=true&useSSL=false", "root", "Tung@1234");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

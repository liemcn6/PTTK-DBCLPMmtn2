/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DbConnect {
    private final String localhost="localhost";
    private final String dbName="quanlythuvien";
    private final String user ="root";
    private final String password ="";
    String url = "jdbc:mysql://"+localhost+"/"+dbName;
    public Connection getConnection()throws Exception{
       Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }
    public static void main(String[] args) throws Exception {   
            System.out.println(new DbConnect().getConnection());
    }
}

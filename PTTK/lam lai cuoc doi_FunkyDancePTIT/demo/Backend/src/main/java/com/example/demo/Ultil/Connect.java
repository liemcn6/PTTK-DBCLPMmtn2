package com.example.demo.Ultil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
    public static Connection get(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demodb","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

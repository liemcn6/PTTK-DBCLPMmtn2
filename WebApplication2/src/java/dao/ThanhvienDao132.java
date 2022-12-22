/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DbConnect;
import entity.Thanhvien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThanhvienDao132 {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // hàm kiểm tra đăng nhập
    public Thanhvien checkLogin(String tendangnhap, String matkhau) throws SQLException {
        String query = "SELECT * FROM tblthanhvien132 WHERE tendangnhap= ? AND matkhau=?";
        try {
            conn = new DbConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tendangnhap);
            ps.setString(2, matkhau);
            rs = ps.executeQuery();
            while (rs.next()) {
                Thanhvien tv = new Thanhvien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
                if (tv != null) {
                    return tv;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}

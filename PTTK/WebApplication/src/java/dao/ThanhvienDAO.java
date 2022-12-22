/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Thanhvien325;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Hoten325;

public class ThanhvienDAO extends DAO {

    public ThanhvienDAO() {
        super();
    }

    PreparedStatement ps = null;
    ResultSet rs = null;

    // hàm kiểm tra đăng nhập
    public boolean kiemtraDangnhap(Thanhvien325 tv) {
        boolean kq = false;
        if (tv.getUsername().contains("true")
                || tv.getUsername().contains("=")
                || tv.getPassword().contains("true")
                || tv.getPassword().contains("=")) {
            return false;
        }
        String sql = "SELECT * FROM tblthanhvien WHERE username= ? AND password=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tv.getUsername());
            ps.setString(2, tv.getPassword());
            rs = ps.executeQuery();
            if (rs.next()) {
                tv.setId(rs.getInt("id"));
                tv.setVaitro(rs.getString("vaitro"));
                //hoten
                Hoten325 ht = new Hoten325();
                ht.setHodem(rs.getString("hodem"));
                ht.setTen(rs.getString("ten"));
                tv.setHoten(ht);
                kq = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
    public static void main(String[] args) {
        ThebandocDAO t = new ThebandocDAO();
        String a= t.getTheBD("00001").getSdt();
        System.out.println(a);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.DaiLyTrungGian;

/**
 *
 * @author Xuan Toog
 */
public class DaiLyTrungGianDAO extends DAO{
    
    public DaiLyTrungGianDAO() {
        super();
    }
    
    public DaiLyTrungGian getDaiLyTrungGianByThanhVienId(int tvID) {
        DaiLyTrungGian daily = null;
        try {
            PreparedStatement ps = con.prepareStatement("select dailytrunggian.id, dailytrunggian.ma, "
                    + "dailytrunggian.ten, dailytrunggian.diachi, dailytrunggian.sodienthoai from "
                    + "dailytrunggian join thanhvien on dailytrunggian.id = thanhvien.dailytrunggian_id "
                    + "where thanhvien.id = ?");
            ps.setInt(1, tvID);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                daily = new DaiLyTrungGian();
                daily.setId(rs.getInt(1));
                daily.setMa(rs.getString(2));
                daily.setTen(rs.getString(3));
                daily.setDiachi(rs.getString(4));
                daily.setSodienthoai(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return daily;
    }
}

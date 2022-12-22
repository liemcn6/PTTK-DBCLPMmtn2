/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author Xuan Toog
 */
public class HangHoaDAO extends DAO{

    public HangHoaDAO() {
        super();
    }
    
    public int createHangHoa(HangHoa hh) {
        int status = 0;
        try {
            // check mã HangHoa hh đã tồn tại chưa
            PreparedStatement ps1 = con.prepareStatement("select * from hanghoa where ma = ?");
            ps1.setString(1, hh.getMa());
            ArrayList<HangHoa> arr = new ArrayList();
            ResultSet rs = ps1.executeQuery();
            while(rs.next()) {
                HangHoa hanghoa = new HangHoa();
                hanghoa.setId(rs.getInt(1));
                hanghoa.setMa(rs.getString(2));
                hanghoa.setTen(rs.getString(3));
                hanghoa.setMota(rs.getString(4));
                
                arr.add(hanghoa);
            }
            if(arr.size() > 0)
                return -1;
            
            
            PreparedStatement ps = con.prepareStatement("insert into hanghoa(ma, ten, mota) values (?,?,?)");
            ps.setString(1, hh.getMa());
            ps.setString(2, hh.getTen());
            ps.setString(3, hh.getMota());
            
            status = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return status;
    }
    
    public HangHoa getHangHoa(int id) {
        HangHoa hh = new HangHoa();
        try {
            PreparedStatement ps = con.prepareStatement("select * from hanghoa where id = ?");
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                hh.setId(rs.getInt(1));
                hh.setMa(rs.getString(2));
                hh.setTen(rs.getString(3));
                hh.setMota(rs.getString(4));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            hh = null;
        }
        
        return hh;
    }
    
    public ArrayList<HangHoa> searchHangHoa(String tenHH) {
        ArrayList<HangHoa> arr = new ArrayList();
        try {
            String query = "select * from hanghoa where ten like '%"+tenHH+"%'";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                HangHoa hh = new HangHoa();
                hh.setId(rs.getInt(1));
                hh.setMa(rs.getString(2));
                hh.setTen(rs.getString(3));
                hh.setMota(rs.getString(4));
                
                arr.add(hh);
            }
        } catch (Exception e) {
            e.printStackTrace();
            arr = null;
        }
        
        return arr;
    }
    
    public boolean existMaHH(String maHH) {
        boolean check = false;
        try {
            String query = "select * from hanghoa where ma = '"+maHH+"'";
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            
            if(rs.next())
                check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return check;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAO.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Diachi325;
import model.Hoten325;
import model.Thanhvien325;
import model.Thebandoc325;

/**
 *
 * @author DELL
 */
public class ThebandocDAO extends DAO {

    public ThebandocDAO() {
        super();
    }
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    public  Thebandoc325 getTheBD(String mavachBD) {
        
        String sql = "SELECT tblthebandoc.id,tblthebandoc.ma, tblthebandoc.hodem,tblthebandoc.ten,tblthebandoc.ngaysinh,tblthebandoc.sdt,tblthebandoc.mavachBD\n" +
                    ",tbldiachi.sonha,tbldiachi.toanha,tbldiachi.xompho,tbldiachi.phuongxa,tbldiachi.quanhuyen,tbldiachi.tinhthanh\n" +
                    " FROM tblthebandoc, tbldiachi where mavachBD = ? and tbldiachi.id = tblthebandoc.tbldiachiid;";
        Thebandoc325 tbd = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mavachBD);
            rs = ps.executeQuery();
            if (rs.next()) {
                if(tbd==null) tbd = new Thebandoc325();
                tbd.setId(rs.getInt("id"));
                tbd.setMa(rs.getString("ma"));
                Hoten325 ht = new Hoten325();
                ht.setHodem(rs.getString("hodem"));
                ht.setTen(rs.getString("ten"));
                tbd.setTen(ht);
                tbd.setNgaysinh(rs.getDate("ngaysinh"));
                tbd.setSdt(rs.getString("sdt"));
                Diachi325 dc = new Diachi325();
                dc.setSonha(rs.getString("sonha"));
                dc.setToanha(rs.getString("toanha"));
                dc.setXompho(rs.getString("xompho"));
                dc.setPhuongxa(rs.getString("phuongxa"));
                dc.setQuanhuyen(rs.getString("quanhuyen"));
                dc.setTinhthanh(rs.getString("tinhthanh"));
                tbd.setDiachi(dc);
                tbd.setMavachBD(mavachBD);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            return tbd;
        }
        
    }
    
}

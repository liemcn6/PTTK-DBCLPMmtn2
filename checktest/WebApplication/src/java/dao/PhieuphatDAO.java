/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class PhieuphatDAO extends DAO{
    public PhieuphatDAO() {
        super();
    }
    PreparedStatement ps = null;
    ResultSet rs = null;
    public boolean luuPhieuphat(int idtbd, int idpm,int idnv) {
        
        boolean kq = false;
        String sql = "INSERT INTO `tblphieuphat` (`tblThebandocid`, `tblPhieumuonid`, `tblNhanvienid`) VALUES (?, ?, ?);";
        try {
           
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idtbd);
                ps.setInt(2, idpm);
                ps.setInt(3, idnv);
                ps.executeUpdate();
            kq = true;
        } catch (Exception e) {
            try {
               // this.con.rollback();//cmt dong nay ney chay che do JUnit test

            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
               // this.con.setAutoCommit(true);//cmt dong nay neu chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }
        return kq;
    }
}

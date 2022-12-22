/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Dausach325;
import model.Phieumuon325;
import model.Phieuphat325;
import model.Sach325;
import model.Sachmuon325;

/**
 *
 * @author DELL
 */
public class SachmuonDAO extends DAO {

    public SachmuonDAO() {
        super();
    }
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Sachmuon325> getListSachmuon(String mavachBD, boolean trangthai) {
        String sql = "SELECT tbldausach.ma,tbldausach.ten,tbldausach.tacgia,tbldausach.giabia,tblsach.mavach,tblsach.id,tblphieumuon.mavachPhieumuon,tblsachmuon.tblPhieumuonid,tblsachmuon.ngaymuon,tblsachmuon.ngayphaitra,tblsachmuon.ngaytra\n"
                + "FROM ((((tblsachmuon inner join tblsach on tblsachmuon.tblSachid=tblsach.id) inner join tbldausach on tblsach.tblDausachid=tbldausach.id)\n"
                + "inner join tblphieumuon on tblphieumuon.id = tblsachmuon.tblPhieumuonid) inner join tblthebandoc on tblthebandoc.id=tblphieumuon.tblThebandocid) \n"
                + "where tblthebandoc.mavachBD = ? and tblsachmuon.trangthai = ?;";
        List<Sachmuon325> list = new ArrayList<>();
        int tt = 0;
        if (trangthai) {
            tt = 1;
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mavachBD);
            ps.setInt(2, tt);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sachmuon325 sm = new Sachmuon325();
                sm.setNgaymuon(rs.getDate("ngaymuon"));
                sm.setNgayphaitra(rs.getDate("ngayphaitra"));
                sm.setNgaytra(rs.getDate("ngaytra"));
                Phieumuon325 pm = new Phieumuon325();
                pm.setId(rs.getInt("tblPhieumuonid"));
                pm.setMavachPhieumuon(rs.getString("mavachPhieumuon"));
                sm.setPhieumuon(pm);
                Dausach325 ds = new Dausach325();
                ds.setMa(rs.getString("ma"));
                ds.setTen(rs.getString("ten"));
                ds.setTacgia(rs.getString("tacgia"));
                ds.setGiabia(Double.parseDouble(rs.getString("giabia")));
                Sach325 s = new Sach325();
                s.setMavach(rs.getString("mavach"));
                s.setId(rs.getInt("id"));
                s.setDausach(ds);
                sm.setSach(s);

                list.add(sm);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public boolean updateListSachmuon(List<Sachmuon325> list) {
        if ((list == null) || (list.size() == 0)) {
            return false;
        }
        boolean kq = false;
        String sql = "UPDATE `tblsachmuon` SET `trangthai` = '1', `ngaytra` = ? WHERE (`tblSachid` = ?);";
        try {
            for (Sachmuon325 i : list) {
                ps = con.prepareStatement(sql);
                ps.setDate(1, (Date) i.getNgaytra());
                ps.setInt(2, i.getSach().getId());
                ps.executeUpdate();
            }

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
    public boolean updateIdphatListStm(List<Sachmuon325> list) {
        if ((list == null) || (list.size() == 0)) {
            return false;
        }
       
        boolean kq = false;
        String sql = "UPDATE `tblsachmuon` SET `tblPhieuphatid` = ? WHERE (`tblSachid` = ?);";
        String sqlTakeId = "SELECT id FROM tblphieuphat ORDER BY id DESC LIMIT 1;";
        
        try {
            ps = con.prepareStatement(sqlTakeId);
            rs=ps.executeQuery();
            
            int id= 0;
            if(rs.next()){
                id=rs.getInt("id");
            }
            
            for (Sachmuon325 i : list) {
                PreparedStatement pss = con.prepareStatement(sql);
                pss.setInt(1, id);
                pss.setInt(2, i.getSach().getId());
                pss.executeUpdate();
            }

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Sachmuon325 {
    private int id;
    private Date ngaymuon,ngayphaitra;
    private boolean trangthai;
    private Date ngaytra;
    private String mota;
    private Sach325 sach;
    private Phieumuon325 phieumuon;

    public Sachmuon325() {
    }

    public Sachmuon325(Date ngaymuon, Date ngayphaitra, boolean trangthai, Date ngaytra, String mota, Sach325 sach) {
        this.ngaymuon = ngaymuon;
        this.ngayphaitra = ngayphaitra;
        this.trangthai = trangthai;
        this.ngaytra = ngaytra;
        this.mota = mota;
        this.sach = sach;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgayphaitra() {
        return ngayphaitra;
    }

    public void setNgayphaitra(Date ngayphaitra) {
        this.ngayphaitra = ngayphaitra;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Sach325 getSach() {
        return sach;
    }

    public void setSach(Sach325 sach) {
        this.sach = sach;
    }

    public Phieumuon325 getPhieumuon() {
        return phieumuon;
    }

    public void setPhieumuon(Phieumuon325 phieumuon) {
        this.phieumuon = phieumuon;
    }
    
    
}

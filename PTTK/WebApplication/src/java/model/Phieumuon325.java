/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Phieumuon325 {
    private int id;
    private String mavachPhieumuon;
    private int tongSachmuon;
    private String mota;
    private Thebandoc325 bandoc;
    private List<Sachmuon325> dsSachmuon;
    private Nhanvien325 nv;

    public Phieumuon325() {
    }

    public Phieumuon325(int id, String mavachPhieumuon, int tongSachmuon, String mota, Thebandoc325 bandoc, List<Sachmuon325> dsSachmuon, Nhanvien325 nv) {
        this.id = id;
        this.mavachPhieumuon = mavachPhieumuon;
        this.tongSachmuon = tongSachmuon;
        this.mota = mota;
        this.bandoc = bandoc;
        this.dsSachmuon = dsSachmuon;
        this.nv = nv;
    }

    public Phieumuon325(String mavachPhieumuon, int tongSachmuon, String mota, Thebandoc325 bandoc, List<Sachmuon325> dsSachmuon) {
        this.mavachPhieumuon = mavachPhieumuon;
        this.tongSachmuon = tongSachmuon;
        this.mota = mota;
        this.bandoc = bandoc;
        this.dsSachmuon = dsSachmuon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMavachPhieumuon() {
        return mavachPhieumuon;
    }

    public void setMavachPhieumuon(String mavachPhieumuon) {
        this.mavachPhieumuon = mavachPhieumuon;
    }

    public int getTongSachmuon() {
        return tongSachmuon;
    }

    public void setTongSachmuon(int tongSachmuon) {
        this.tongSachmuon = tongSachmuon;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Thebandoc325 getBandoc() {
        return bandoc;
    }

    public void setBandoc(Thebandoc325 bandoc) {
        this.bandoc = bandoc;
    }

    public List<Sachmuon325> getDsSachmuon() {
        return dsSachmuon;
    }

    public void setDsSachmuon(List<Sachmuon325> dsSachmuon) {
        this.dsSachmuon = dsSachmuon;
    }

    public Nhanvien325 getNv() {
        return nv;
    }

    public void setNv(Nhanvien325 nv) {
        this.nv = nv;
    }
    
    
}

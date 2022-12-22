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
public class Phieuphat325 {
   private int id;
   private double tongtienphat;
   private String mota;
   private List<Sachmuon325> dsSachtramuon;
   private Thebandoc325 bandoc;
   private Phieumuon325 phieumuon;
   private Nhanvien325 nv;

    public Phieuphat325() {
    }

    public Phieuphat325(double tongtienphat, String mota, List<Sachmuon325> dsSachtramuon, Thebandoc325 bandoc, Phieumuon325 phieumuon, Nhanvien325 nv) {
        this.tongtienphat = tongtienphat;
        this.mota = mota;
        this.dsSachtramuon = dsSachtramuon;
        this.bandoc = bandoc;
        this.phieumuon = phieumuon;
        this.nv = nv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTongtienphat() {
        return tongtienphat;
    }

    public void setTongtienphat(double tongtienphat) {
        this.tongtienphat = tongtienphat;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<Sachmuon325> getDsSachtramuon() {
        return dsSachtramuon;
    }

    public void setDsSachtramuon(List<Sachmuon325> dsSachtramuon) {
        this.dsSachtramuon = dsSachtramuon;
    }

    public Thebandoc325 getBandoc() {
        return bandoc;
    }

    public void setBandoc(Thebandoc325 bandoc) {
        this.bandoc = bandoc;
    }

    public Phieumuon325 getPhieumuon() {
        return phieumuon;
    }

    public void setPhieumuon(Phieumuon325 phieumuon) {
        this.phieumuon = phieumuon;
    }

    public Nhanvien325 getNv() {
        return nv;
    }

    public void setNv(Nhanvien325 nv) {
        this.nv = nv;
    }
   
   
}

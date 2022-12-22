package com.example.demo.Model;

public class TuanLV {
    private int id;
    private String ten;
    private String mota;
    private Nam nam;
    private Thang thang;
    private Tuan tuan;

    public TuanLV(int id) {
        this.id = id;
    }

    public TuanLV(int id, String ten, String mota, Nam nam, Thang thang, Tuan tuan) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
        this.nam = nam;
        this.thang = thang;
        this.tuan = tuan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

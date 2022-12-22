package com.example.demo.Model;

public class ChuoiNH {
    private int id;
    private String ten;
    private String mota;

    public ChuoiNH(int id) {
        this.id = id;
    }

    public ChuoiNH(int id, String ten, String mota) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

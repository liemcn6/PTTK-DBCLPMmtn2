package com.example.demo.Model;

public class Nam {
    private int id;
    private String ten;
    private String mota;

    public Nam(int id, String ten, String mota) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
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

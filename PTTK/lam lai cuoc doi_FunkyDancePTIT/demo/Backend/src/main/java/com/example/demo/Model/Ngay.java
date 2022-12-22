package com.example.demo.Model;

public class Ngay {
    private String ten;
    private String mota;

    public Ngay(String ten){
        this.ten = ten;
    }

    public Ngay(String ten, String mota) {
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

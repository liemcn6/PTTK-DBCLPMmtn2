package com.example.demo.Model;

public class LichDK {
    private int id;
    private String ten;
    private String mota;
    private int min;
    private NVPT nvpt;
    private TuanLV tuanLV;
    private NgayTrongLich[] ngay;

    public LichDK() {
    }

    public LichDK(int id, String ten, String mota) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
    }

    public LichDK(int id, String ten, String mota, int min, NVPT nvpt, TuanLV tuanLV, NgayTrongLich[] ngay) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
        this.min = min;
        this.nvpt = nvpt;
        this.tuanLV = tuanLV;
        this.ngay = ngay;
    }

    public NVPT getNvpt() {
        return nvpt;
    }

    public void setNvpt(NVPT nvpt) {
        this.nvpt = nvpt;
    }

    public NgayTrongLich[] getNgay() {
        return ngay;
    }

    public void setNgay(NgayTrongLich[] ngay) {
        this.ngay = ngay;
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

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public TuanLV getTuanLV() {
        return tuanLV;
    }

    public void setTuanLV(TuanLV tuanLV) {
        this.tuanLV = tuanLV;
    }
}

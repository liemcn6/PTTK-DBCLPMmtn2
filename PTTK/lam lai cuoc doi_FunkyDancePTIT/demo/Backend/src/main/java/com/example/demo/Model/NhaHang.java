package com.example.demo.Model;

public class NhaHang {
    private int id;
    private ChuoiNH chuoiNH;
    private String ten;
    private String diaChi;
    private String mota;

    public NhaHang(int id) {
        this.id = id;
    }

    public NhaHang( String ten, String diaChi){
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public NhaHang(int id, ChuoiNH chuoiNH, String ten, String diaChi, String mota) {
        this.id = id;
        this.chuoiNH = chuoiNH;
        this.ten = ten;
        this.diaChi = diaChi;
        this.mota = mota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChuoiNH getChuoiNH() {
        return chuoiNH;
    }

    public void setChuoiNH(ChuoiNH chuoiNH) {
        this.chuoiNH = chuoiNH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

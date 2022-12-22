package com.example.demo.Model;

public class NgayTrongLich {
    private  int id;
    private CaLV caLV;
    private Ngay ngay;

    public NgayTrongLich(int id) {
        this.id = id;
    }

    public NgayTrongLich(CaLV caLV, Ngay ngay) {
        this.caLV = caLV;
        this.ngay = ngay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CaLV getCaLV() {
        return caLV;
    }

    public void setCaLV(CaLV caLV) {
        this.caLV = caLV;
    }

    public Ngay getNgay() {
        return ngay;
    }

    public void setNgay(Ngay ngay) {
        this.ngay = ngay;
    }
}

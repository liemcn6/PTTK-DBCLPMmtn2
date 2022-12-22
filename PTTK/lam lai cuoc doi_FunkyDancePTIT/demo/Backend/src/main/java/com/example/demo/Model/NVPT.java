package com.example.demo.Model;

import java.util.Date;

public class NVPT extends NhanVien {
    private String phongBan;
    private String chucVu;

    public NVPT(String phongBan, String chucVu){
        this.chucVu = phongBan;
        this.chucVu = chucVu;
    }

    public NVPT(int id, String phongBan, String chucVu) {
        super(id);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
    }

    public NVPT(NhaHang nhaHang, String ten, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String ngayThoiLam, String email, String phongBan, String chucVu) {
        super(nhaHang, ten, sdt, diaChi, ngaySinh, ngayVaoLam, ngayThoiLam, email);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
    }

    public NVPT(int id, String ten, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String email, String phongBan, String chucVu) {
        super(id, ten, sdt, diaChi, ngaySinh, ngayVaoLam, email);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}

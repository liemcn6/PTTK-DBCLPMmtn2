package com.example.demo.Model;

import java.util.Date;

public class NhanVien {
    private int id;
    private NhaHang nhaHang;
    private String ten;
    private String sdt;
    private String diaChi;
    private Date ngaySinh;
    private Date ngayVaoLam;
    private String ngayThoiLam;
    private String email;
    private boolean admin;

    public NhanVien(){

    }

    public NhanVien(int id) {
        this.id = id;
    }


    public NhanVien(NhaHang nhaHang ,String ten, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String ngayThoiLam, String email, boolean admin) {
        this.nhaHang = nhaHang;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.ngayThoiLam = ngayThoiLam;
        this.email = email;
        this.admin = admin;
    }

    public NhanVien(int id, String ten, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String email) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.email = email;
    }

    public NhanVien(NhaHang nhaHang , String ten, String sdt, String diaChi, Date ngaySinh , Date ngayVaoLam, String ngayThoiLam, String email) {
        this.nhaHang = nhaHang;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.ngayThoiLam = ngayThoiLam;
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NhaHang getNhaHang() {
        return nhaHang;
    }

    public void setNhaHang(NhaHang nhaHang) {
        this.nhaHang = nhaHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getNgayThoiLam() {
        return ngayThoiLam;
    }

    public void setNgayThoiLam(String ngayThoiLam) {
        this.ngayThoiLam = ngayThoiLam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}

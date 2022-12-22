/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Xuan Toog
 */
public class ThanhVien {
    private int id;
    private String tendangnhap, matkhau, hoten, diachi;
    private Date ngaysinh;
    private String email, sodienthoai;

    public ThanhVien() {
    }

    public ThanhVien(String tendangnhap, String matkhau, String hoten, String diachi, Date ngaysinh, String email, String sodienthoai) {
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.hoten = hoten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sodienthoai = sodienthoai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Thebandoc325 {
    private int id;
    private String ma;
    private Hoten325 ten;
    private Date ngaysinh;
    private Diachi325 diachi;
    private String sdt, mavachBD;

    public Thebandoc325(int id, String ma, Hoten325 ten, Date ngaysinh, Diachi325 diachi, String sdt, String mavachBD) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.mavachBD = mavachBD;
    }

   

    public Thebandoc325() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    

    public Hoten325 getTen() {
        return ten;
    }

    public void setTen(Hoten325 ten) {
        this.ten = ten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Diachi325 getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi325 diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMavachBD() {
        return mavachBD;
    }

    public void setMavachBD(String mavachBD) {
        this.mavachBD = mavachBD;
    }
    
}

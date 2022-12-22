/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;



/**
 *
 * @author Admin
 */
public class Thanhvien325 {
    private int id;
    private String username,password;
    private Hoten325 hoten;
    private Diachi325 diachi;
    private Date ngaysinh;
    private String email,sdt,vaitro;

    public Thanhvien325() {
    }

    public Thanhvien325(int id, String username, String password, Hoten325 hoten, Diachi325 diachi, Date ngaysinh, String email, String sdt, String vaitro) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.hoten = hoten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.sdt = sdt;
        this.vaitro = vaitro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Hoten325 getHoten() {
        return hoten;
    }

    public void setHoten(Hoten325 hoten) {
        this.hoten = hoten;
    }

    public Diachi325 getDiachi() {
        return diachi;
    }

    public void setDiachi(Diachi325 diachi) {
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getVaitro() {
        return vaitro;
    }

    public void setVaitro(String vaitro) {
        this.vaitro = vaitro;
    }

   

  
}

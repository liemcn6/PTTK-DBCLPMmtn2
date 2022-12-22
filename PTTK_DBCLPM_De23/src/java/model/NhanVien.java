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
public class NhanVien extends ThanhVien{
    private String vitricongviec;

    public NhanVien() {
    }

    public NhanVien(String tendangnhap, String matkhau, String hoten, String diachi, Date ngaysinh, String email, String sodienthoai, String vitricongviec) {
        super(tendangnhap, matkhau, hoten, diachi, ngaysinh, email, sodienthoai);
        this.vitricongviec = vitricongviec;
    }

    public String getVitricongviec() {
        return vitricongviec;
    }

    public void setVitricongviec(String vitricongviec) {
        this.vitricongviec = vitricongviec;
    }
    
    
}

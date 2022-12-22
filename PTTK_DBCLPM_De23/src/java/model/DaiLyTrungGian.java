/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Xuan Toog
 */
public class DaiLyTrungGian {
    private int id;
    private String ma, ten, diachi, sodienthoai;
    private ArrayList<ThanhVien> listThanhVien;

    public DaiLyTrungGian() {
    }

    public DaiLyTrungGian(String ma, String ten, String diachi, String sodienthoai) {
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public ArrayList<ThanhVien> getListThanhVien() {
        return listThanhVien;
    }

    public void setListThanhVien(ArrayList<ThanhVien> listThanhVien) {
        this.listThanhVien = listThanhVien;
    }
    
    
}

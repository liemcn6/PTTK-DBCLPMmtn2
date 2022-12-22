/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Dausach325 {
    private int id;
    private String ma;
    private String ten, tacgia,namxb;
    private double giabia;
    private int soluong;
    private String mota;
    private List<Sach325> dsSach;

    public Dausach325(int id, String ma, String ten, String tacgia, String namxb, double giabia, int soluong, String mota) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tacgia = tacgia;
        this.namxb = namxb;
        this.giabia = giabia;
        this.soluong = soluong;
        this.mota = mota;
    }

    

    public Dausach325() {
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

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNamxb() {
        return namxb;
    }

    public void setNamxb(String namxb) {
        this.namxb = namxb;
    }

    public double getGiabia() {
        return giabia;
    }

    public void setGiabia(double giabia) {
        this.giabia = giabia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public List<Sach325> getDsSach() {
        return dsSach;
    }

    public void setDsSach(List<Sach325> dsSach) {
        this.dsSach = dsSach;
    }

   
    
    
}

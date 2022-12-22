/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Xuan Toog
 */
public class PhieuNhap_HangHoa {
    private int id;
    private float dongia;
    private int soluong;
    private HangHoa hangHoa;

    public PhieuNhap_HangHoa() {
    }

    public PhieuNhap_HangHoa(float dongia, int soluong, HangHoa hangHoa) {
        this.dongia = dongia;
        this.soluong = soluong;
        this.hangHoa = hangHoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author DELL
 */
public class Diachi325 {
    private int id;
    private String sonha,toanha,xompho,phuongxa,quanhuyen,tinhthanh;

    public Diachi325() {
    }

    public Diachi325(int id, String sonha, String toanha, String xompho, String phuongxa, String quanhuyen, String tinhthanh) {
        this.id = id;
        this.sonha = sonha;
        this.toanha = toanha;
        this.xompho = xompho;
        this.phuongxa = phuongxa;
        this.quanhuyen = quanhuyen;
        this.tinhthanh = tinhthanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSonha() {
        return sonha;
    }

    public void setSonha(String sonha) {
        this.sonha = sonha;
    }

    public String getToanha() {
        return toanha;
    }

    public void setToanha(String toanha) {
        this.toanha = toanha;
    }

    public String getXompho() {
        return xompho;
    }

    public void setXompho(String xompho) {
        this.xompho = xompho;
    }

    public String getPhuongxa() {
        return phuongxa;
    }

    public void setPhuongxa(String phuongxa) {
        this.phuongxa = phuongxa;
    }

    public String getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(String quanhuyen) {
        this.quanhuyen = quanhuyen;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }
    
}

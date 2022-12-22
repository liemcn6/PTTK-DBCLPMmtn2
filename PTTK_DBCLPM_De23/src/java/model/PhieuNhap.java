/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Xuan Toog
 */
public class PhieuNhap {
    private int id;
    private Date thoigiannhaphang;
    private String ghichu;
    private NhanVien nhanVienKho;
    private DaiLyTrungGian daiLyTrungGian;
    private NhaCungCap nhaCungCap;
    private ArrayList<PhieuNhap_HangHoa> listPhieuNhap_HangHoa;

    public PhieuNhap() {
    }

    public PhieuNhap(Date thoigiannhaphang, String ghichu, NhanVien nhanVienKho, DaiLyTrungGian daiLyTrungGian, NhaCungCap nhaCungCap, ArrayList<PhieuNhap_HangHoa> listPhieuNhap_HangHoa) {
        this.thoigiannhaphang = thoigiannhaphang;
        this.ghichu = ghichu;
        this.nhanVienKho = nhanVienKho;
        this.daiLyTrungGian = daiLyTrungGian;
        this.nhaCungCap = nhaCungCap;
        this.listPhieuNhap_HangHoa = listPhieuNhap_HangHoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoigiannhaphang() {
        return thoigiannhaphang;
    }

    public void setThoigiannhaphang(Date thoigiannhaphang) {
        this.thoigiannhaphang = thoigiannhaphang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public NhanVien getNhanVienKho() {
        return nhanVienKho;
    }

    public void setNhanVienKho(NhanVien nhanVienKho) {
        this.nhanVienKho = nhanVienKho;
    }

    public DaiLyTrungGian getDaiLyTrungGian() {
        return daiLyTrungGian;
    }

    public void setDaiLyTrungGian(DaiLyTrungGian daiLyTrungGian) {
        this.daiLyTrungGian = daiLyTrungGian;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public ArrayList<PhieuNhap_HangHoa> getListPhieuNhap_HangHoa() {
        return listPhieuNhap_HangHoa;
    }

    public void setListPhieuNhap_HangHoa(ArrayList<PhieuNhap_HangHoa> listPhieuNhap_HangHoa) {
        this.listPhieuNhap_HangHoa = listPhieuNhap_HangHoa;
    }
    
    
}

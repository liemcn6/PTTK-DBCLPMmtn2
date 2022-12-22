package com.example.demo.Model;

import java.util.Date;

public class NVQL extends NhanVien {
    private String username;
    private String password;

    public NVQL(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public NVQL(int id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public NVQL(NhaHang nhaHang, String ten, String sdt, String diaChi, Date ngaySinh, Date ngayVaoLam, String ngayThoiLam, String email, boolean admin, String username, String password) {
        super(nhaHang, ten, sdt, diaChi, ngaySinh, ngayVaoLam, ngayThoiLam, email, admin);
        this.username = username;
        this.password = password;
    }
}

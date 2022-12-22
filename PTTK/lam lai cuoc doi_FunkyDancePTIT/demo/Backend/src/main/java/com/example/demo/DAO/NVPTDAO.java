package com.example.demo.DAO;

import com.example.demo.Model.CaLV;
import com.example.demo.Model.NVPT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NVPTDAO implements DAO {
    public NVPTDAO(){

    }
    public List<NVPT> getListByName(String keyword){
        List<NVPT> res = new ArrayList<NVPT>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tblnhanvien nhanvien" +
                    " left join tblnvpt nvpt" +
                    " on nhanvien.id = nvpt.nvId" +
                    " where match(ten) against ('"+keyword+"')");
            while (rs.next()){
                if(rs.getString("ngayThoiLam").equals("0000-00-00"))
                res.add(new NVPT(rs.getInt("id"),
                        rs.getString("ten"), rs.getString("sdt"), rs.getString("diaChi"),
                        rs.getDate("ngaySinh"), rs.getDate(("ngayVaoLam")),
                        rs.getString("email"), rs.getString("phongBan"),
                        rs.getString("chucVu")) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}

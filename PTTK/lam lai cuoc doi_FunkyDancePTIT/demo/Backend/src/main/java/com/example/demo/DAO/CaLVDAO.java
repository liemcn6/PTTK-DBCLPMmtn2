package com.example.demo.DAO;


import com.example.demo.Model.CaLV;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaLVDAO implements DAO{
    public CaLVDAO() {
    }
    public List<CaLV> getAllCaLV(){
        List<CaLV> res = new ArrayList<CaLV>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblcalv");
            while (rs.next()){
                res.add(new CaLV(rs.getInt(1), rs.getString(2), rs.getString(3)) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}

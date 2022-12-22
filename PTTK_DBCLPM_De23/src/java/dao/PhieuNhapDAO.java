/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.*;

/**
 *
 * @author Xuan Toog
 */
public class PhieuNhapDAO extends DAO{
    
    public PhieuNhapDAO() {
        super();
    }
    
    public boolean luuPhieuNhap(PhieuNhap phieunhap) throws SQLException {
        if(phieunhap.getListPhieuNhap_HangHoa().isEmpty())
            return false;
        
        boolean status = false;
        Connection con = DAO.con;
        try {
            
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement("insert into phieunhap (thoigiannhaphang, ghichu,"
                    + " dailytrunggian_id, nhacungcap_id, thanhvien_id) values (?,?,?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            ps1.setString(1, datetimeToString(phieunhap.getThoigiannhaphang()));
            ps1.setString(2, phieunhap.getGhichu());
            ps1.setInt(3, phieunhap.getDaiLyTrungGian().getId());
            ps1.setInt(4, phieunhap.getNhaCungCap().getId());
            ps1.setInt(5, phieunhap.getNhanVienKho().getId());

            int rowAffected = ps1.executeUpdate();

            // lấy id của hóa đơn vào tạo
            ResultSet rs = ps1.getGeneratedKeys();
            int phieunhap_id = 0;
            if (rs.next()) {
                phieunhap_id = rs.getInt(1);
            }

            if (rowAffected == 1) { // nếu thêm được phiếu nhập
                ArrayList<PhieuNhap_HangHoa> list_hanghoanhap = phieunhap.getListPhieuNhap_HangHoa();
                for (int i = 0; i < list_hanghoanhap.size(); i++) {
                    String sql = "insert into phieunhap_hanghoa (dongia, soluong, hanghoa_id, phieunhap_id) "
                            + "values (" + list_hanghoanhap.get(i).getDongia()+ ", "
                            + list_hanghoanhap.get(i).getSoluong() + ", "
                            + list_hanghoanhap.get(i).getHangHoa().getId() + ", "
                            + phieunhap_id + ");";
                    Statement st = con.createStatement();
                    st.execute(sql);
                }
            }
            
            con.commit();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            con.rollback();
        }
        return status;
    }

    public String datetimeToString(java.util.Date datetime) {
        String res = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        res = format.format(datetime);
        return res;
    }
    
    public java.util.Date stringToDatetime(String datetime_str) throws Exception{
        java.util.Date datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetime_str);
        return datetime;
    }
}

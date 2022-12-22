package QuanLyThuVien.model.DAL;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.*;

public class DALDauSach extends ConnectDatabase implements I_DAL<DauSach> {

	public DALDauSach(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	public List<DauSach> getAll(String loaiSach) throws SQLException, ClassNotFoundException {
		openConnection();
		List<DauSach> DauSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayDauSach ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setString(1, loaiSach);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			DauSach dauSach = new DauSach();

			dauSach.setMaDauSach(res.getInt(1));
			dauSach.setMaNxb(res.getInt(2));
			dauSach.setMaTheLoai(res.getInt(3));
			dauSach.setTenSach(res.getString(4));
			dauSach.setMoTa(res.getString(5));
			dauSach.setTacGia(res.getString(6));
			dauSach.setAnhTacGiaBlob(res.getBlob(7));// AnhTacGia
			dauSach.setNamXuatBan(res.getDate(8));
			dauSach.setNgonNgu(res.getString(9));
			dauSach.setAnhBiaBlob(res.getBlob(10));// AnhBia
			dauSach.setTrangThai(res.getString(11));
			dauSach.setGia(res.getInt(12));
			dauSach.setFilePDFBlob(res.getBlob(13));// filePDF
			dauSach.setLoaiSach(res.getString(14));
			DauSachs.add(dauSach);
		}

		closeConnection();
		return DauSachs;
	}

	public List<DauSach> getAllPhanTrang(String loaiSach, int minRes, int maxRes, int maTheLoai, String sort,
			String search) throws SQLException, ClassNotFoundException {

		openConnection();
		List<DauSach> DauSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayDauSachPhanTrang ?,?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);

		statement.setString(1, loaiSach);
		statement.setInt(2, minRes);
		statement.setInt(3, maxRes);
		statement.setInt(4, maTheLoai);
		statement.setString(5, sort);
		statement.setString(6, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			DauSach dauSach = new DauSach();

			dauSach.setMaDauSach(res.getInt(1));
			dauSach.setMaNxb(res.getInt(2));
			dauSach.setMaTheLoai(res.getInt(3));
			dauSach.setTenSach(res.getString(4));
			dauSach.setMoTa(res.getString(5));
			dauSach.setTacGia(res.getString(6));
			dauSach.setAnhTacGiaBlob(res.getBlob(7));// AnhTacGia
			dauSach.setNamXuatBan(res.getDate(8));
			dauSach.setNgonNgu(res.getString(9));
			dauSach.setAnhBiaBlob(res.getBlob(10));// AnhBia
			dauSach.setTrangThai(res.getString(11));
			dauSach.setGia(res.getInt(12));
			dauSach.setFilePDFBlob(res.getBlob(13));// filePDF DauSachs.add(dauSach); }
			dauSach.setLoaiSach(res.getString(14));

			DauSachs.add(dauSach);
		}
//		closeConnection();
		return DauSachs;
	}

	/**
	 * record là dòng truy�?n vào. Chung cho tất cả
	 * 
	 * @author IT 1006
	 */
	@Override
	public int Add(DauSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spDauSach ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?";// 15 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaDauSach());
		statement.setInt(2, record.getMaNxb());
		statement.setInt(3, record.getMaTheLoai());
		statement.setString(4, record.getTenSach());
		statement.setString(5, record.getMoTa());
		statement.setString(6, record.getTacGia());
		statement.setBlob(7, record.getAnhTacGia());
		statement.setDate(8, record.getNamXuatBan());
		statement.setString(9, record.getNgonNgu());
		statement.setBlob(10, record.getAnhBia());
		statement.setString(11, record.getTrangThai());
		statement.setFloat(12, record.getGia());
		statement.setBlob(13, record.getFilePDF());
		statement.setString(14, record.getLoaiSach());

		statement.setString(15, "INSERT");

		int rowInsert = statement.executeUpdate();

		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaDauSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		int rowDelete = statement.executeUpdate();

		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(DauSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spDauSach ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?";// 15 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaDauSach());
		statement.setInt(2, record.getMaNxb());
		statement.setInt(3, record.getMaTheLoai());
		statement.setString(4, record.getTenSach());
		statement.setString(5, record.getMoTa());
		statement.setString(6, record.getTacGia());
		statement.setBlob(7, record.getAnhTacGia());
		statement.setDate(8, record.getNamXuatBan());
		statement.setString(9, record.getNgonNgu());
		statement.setBlob(10, record.getAnhBia());
		statement.setString(11, record.getTrangThai());
		statement.setFloat(12, record.getGia());
		statement.setBlob(13, record.getFilePDF());
		statement.setString(14, record.getLoaiSach());

		statement.setString(15, "UPDATE");

		int rowUpdate = statement.executeUpdate();

		closeConnection();
		return rowUpdate;
	}

	@Override
	public DauSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotDauSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		DauSach dauSach = new DauSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			dauSach.setMaDauSach(res.getInt(1));
			dauSach.setMaNxb(res.getInt(2));
			dauSach.setMaTheLoai(res.getInt(3));
			dauSach.setTenSach(res.getString(4));
			dauSach.setMoTa(res.getString(5));
			dauSach.setTacGia(res.getString(6));
			dauSach.setAnhTacGiaBlob(res.getBlob(7));
			dauSach.setNamXuatBan(res.getDate(8));
			dauSach.setNgonNgu(res.getString(9));
			dauSach.setAnhBiaBlob(res.getBlob(10));
			dauSach.setTrangThai(res.getString(11));
			dauSach.setGia(res.getInt(12));
			dauSach.setFilePDFBlob(res.getBlob(13));
			dauSach.setLoaiSach(res.getString(14));

		}
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return dauSach;
	}

	public Nxb getMaNxb(String tenNxb) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMaNxbTheoTen ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, tenNxb);

		Nxb nxb = new Nxb();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			nxb.setMaNxb(res.getInt(1));
			nxb.setTenNxb(res.getString(2));
			nxb.setGhiChu(res.getString(3));

		}
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return nxb;
	}

	public TheLoai getMaTheLoai(String tenTheLoai) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMaTheLoaiTheoTen ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, tenTheLoai);

		TheLoai theLoai = new TheLoai();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			theLoai.setMaTheLoai(res.getInt(1));
			theLoai.setTenTheLoai(res.getString(2));

		}
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return theLoai;
	}

	public int getSoLuongPhanTu(String loaiSach, int maTheLoai, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayDauSachPhanTrangCount ?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, loaiSach);
		statement.setInt(2, maTheLoai);
		statement.setString(3, search);

		int kq = 0;
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			kq = res.getInt(1);
		}
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return kq;
	}

	@Override
	public int maxCode(String tenBang) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spMaxCode ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, tenBang);

		int kq = 0;
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			kq = res.getInt(1);
		}
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return kq;
	}

	@Override
	public List<DauSach> getAll() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

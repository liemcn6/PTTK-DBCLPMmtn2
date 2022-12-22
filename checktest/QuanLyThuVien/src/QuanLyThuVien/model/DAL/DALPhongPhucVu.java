package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.PhongPhucVu;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.PhongPhucVu;

public class DALPhongPhucVu extends ConnectDatabase implements I_DAL<PhongPhucVu> {

	public DALPhongPhucVu(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<PhongPhucVu> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<PhongPhucVu> PhongPhucVus = new ArrayList<>();
		String sqlExec = "EXEC spLayPhongPhucVu";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			PhongPhucVu phongPhucVu = new PhongPhucVu();
			phongPhucVu.setIdPhong(res.getInt(1));
			phongPhucVu.setTenPhong(res.getString(2));
			phongPhucVu.setGioBatDau(res.getTime(3));
			phongPhucVu.setGioKetThuc(res.getTime(4));
			phongPhucVu.setMaNhanVien(res.getInt(5));
			PhongPhucVus.add(phongPhucVu);
		}

		closeConnection();
		return PhongPhucVus;
	}

	@Override
	public int Add(PhongPhucVu record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spPhongPhucVu ?,?,?,?,?, ?";// 6 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getIdPhong());
		statement.setString(2, record.getTenPhong());
		statement.setTime(3, record.getGioBatDau());
		statement.setTime(4, record.getGioKetThuc());
		statement.setInt(5, record.getMaNhanVien());
		statement.setString(6, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaPhongPhucVu ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(PhongPhucVu record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spPhongPhucVu ?,?,?,?,?, ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getIdPhong());
		statement.setString(2, record.getTenPhong());
		statement.setTime(3, record.getGioBatDau());
		statement.setTime(4, record.getGioKetThuc());
		statement.setInt(5, record.getMaNhanVien());
		statement.setString(6, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public PhongPhucVu GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotPhongPhucVu ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		PhongPhucVu phongPhucVu = new PhongPhucVu();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			phongPhucVu.setIdPhong(res.getInt(1));
			phongPhucVu.setTenPhong(res.getString(2));
			phongPhucVu.setGioBatDau(res.getTime(3));
			phongPhucVu.setGioKetThuc(res.getTime(4));
			phongPhucVu.setMaNhanVien(res.getInt(5));
		}
		closeConnection();
		return phongPhucVu;
	}

	public List<PhongPhucVu> getAllPhanTrang(int minRes, int maxRes, int maNhanVien, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<PhongPhucVu> PhongPhucVus = new ArrayList<>();
		String sqlExec = "EXEC spLayPhongPhucVuPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maNhanVien);
		statement.setString(4, sort);
		statement.setString(5, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			PhongPhucVu phongPhucVu = new PhongPhucVu();
			phongPhucVu.setIdPhong(res.getInt(1));
			phongPhucVu.setTenPhong(res.getString(2));
			phongPhucVu.setGioBatDau(res.getTime(3));
			phongPhucVu.setGioKetThuc(res.getTime(4));
			phongPhucVu.setMaNhanVien(res.getInt(5));
			PhongPhucVus.add(phongPhucVu);
		}
		closeConnection();
		return PhongPhucVus;
	}

	public int getSoLuongPhanTu(int maNhanVien, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayPhongPhucVuPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maNhanVien);
		statement.setString(2, search);

		int kq = 0;
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			kq = res.getInt(1);
		}
		closeConnection();
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
		closeConnection();
		return kq;

	}

}

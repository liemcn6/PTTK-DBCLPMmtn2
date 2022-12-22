package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.NhanVien;
import QuanLyThuVien.model.DAL.Object.NhanVien;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALNhanVien extends ConnectDatabase implements I_DAL<NhanVien> {

	public DALNhanVien(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<NhanVien> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<NhanVien> NhanViens = new ArrayList<>();
		String sqlExec = "EXEC spLayNhanVien";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			NhanVien nhanVien = new NhanVien();
			nhanVien.setMaNhanVien(res.getInt(1));
			nhanVien.setHoVaTen(res.getString(2));
			nhanVien.setEmail(res.getString(3));
			nhanVien.setSoDienThoai(res.getString(4));
			nhanVien.setNgaySinh(res.getDate(5));
			nhanVien.setMaTaiKhoan(res.getInt(6));
			NhanViens.add(nhanVien);
		}
		closeConnection();
		return NhanViens;
	}

	@Override
	public int Add(NhanVien record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spNhanVien ?,?,?,?,?, ?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaNhanVien());
		statement.setString(2, record.getHoVaTen());
		statement.setString(3, record.getEmail());
		statement.setString(4, record.getSoDienThoai());
		statement.setDate(5, record.getNgaySinh());
		statement.setInt(6, record.getMaTaiKhoan());
		statement.setString(7, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaNhanVien ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(NhanVien record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spNhanVien ?,?,?,?,?, ?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaNhanVien());
		statement.setString(2, record.getHoVaTen());
		statement.setString(3, record.getEmail());
		statement.setString(4, record.getSoDienThoai());
		statement.setDate(5, record.getNgaySinh());
		statement.setInt(6, record.getMaTaiKhoan());
		statement.setString(7, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public NhanVien GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotNhanVien ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		NhanVien nhanVien = new NhanVien();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			nhanVien.setMaNhanVien(res.getInt(1));
			nhanVien.setHoVaTen(res.getString(2));
			nhanVien.setEmail(res.getString(3));
			nhanVien.setSoDienThoai(res.getString(4));
			nhanVien.setNgaySinh(res.getDate(5));
			nhanVien.setMaTaiKhoan(res.getInt(6));
		}
		closeConnection();
		return nhanVien;
	}

	public List<NhanVien> getAllPhanTrang(int minRes, int maxRes, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<NhanVien> NhanViens = new ArrayList<>();

		String sqlExec = "EXEC spLayNhanVienPhanTrang ?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setString(3, sort);
		statement.setString(4, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		ResultSet res = statement.executeQuery();

		while (res.next()) {
			NhanVien nhanVien = new NhanVien();

			nhanVien.setMaNhanVien(res.getInt(1));
			nhanVien.setHoVaTen(res.getString(2));
			nhanVien.setEmail(res.getString(3));
			nhanVien.setSoDienThoai(res.getString(4));
			nhanVien.setNgaySinh(res.getDate(5));
			nhanVien.setMaTaiKhoan(res.getInt(6));

			NhanViens.add(nhanVien);
		}
		closeConnection();
		return NhanViens;
	}

	public int getSoLuongPhanTu(String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayNhanVienPhanTrangCount ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, search);

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
		// Because load image very time-consuming --> Don't close connect to DB
		// closeConnection();
		return kq;

	}

}

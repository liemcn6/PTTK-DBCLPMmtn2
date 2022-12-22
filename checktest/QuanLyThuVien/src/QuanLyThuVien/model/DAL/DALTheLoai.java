package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.TheLoai;

public class DALTheLoai extends ConnectDatabase implements I_DAL<TheLoai> {

	public DALTheLoai(String jdbcURL) throws SQLException {
		super(jdbcURL);

	}

	@Override
	public List<TheLoai> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<TheLoai> TheLoais = new ArrayList<>();
		String sqlExec = "EXEC spLayTheLoai";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			TheLoai theLoai = new TheLoai();

			theLoai.setMaTheLoai(res.getInt(1));
			theLoai.setTenTheLoai(res.getString(2));

			TheLoais.add(theLoai);
		}

		// closeConnection();
		return TheLoais;
	}

	@Override
	public int Add(TheLoai record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spTheLoai ?,?,?";// 3
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaTheLoai());
		statement.setString(2, record.getTenTheLoai());
		statement.setString(3, "INSERT");

		int rowInsert = statement.executeUpdate();

		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaTheLoai ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		int rowDelete = statement.executeUpdate();

		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(TheLoai record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spTheLoai ?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaTheLoai());
		statement.setString(2, record.getTenTheLoai());
		statement.setString(3, "UPDATE");

		int rowUpdate = statement.executeUpdate();

		closeConnection();
		return rowUpdate;
	}

	@Override
	public TheLoai GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotTheLoai ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		TheLoai theLoai = new TheLoai();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			theLoai.setMaTheLoai(res.getInt(1));
			theLoai.setTenTheLoai(res.getString(2));

		}
		closeConnection();
		return theLoai;
	}

	public List<TheLoai> getAllPhanTrang(int minRes, int maxRes, String sort, String search)
			throws SQLException, ClassNotFoundException {

		openConnection();

		List<TheLoai> TheLoais = new ArrayList<>();

		String sqlExec = "EXEC spLayTheLoaiPhanTrang ?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setString(3, sort);
		statement.setString(4, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			TheLoai TheLoai = new TheLoai();

			TheLoai.setMaTheLoai(res.getInt(1));
			TheLoai.setTenTheLoai(res.getString(2));

			TheLoais.add(TheLoai);
		}
		closeConnection();
		return TheLoais;
	}

	public int getSoLuongPhanTu(String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayTheLoaiPhanTrangCount ?";

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
		closeConnection();
		return kq;
	}

}

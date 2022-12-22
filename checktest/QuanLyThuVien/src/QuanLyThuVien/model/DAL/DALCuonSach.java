package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.CuonSach;

public class DALCuonSach extends ConnectDatabase implements I_DAL<CuonSach> {

	public DALCuonSach(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<CuonSach> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<CuonSach> CuonSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayCuonSach";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {

			CuonSach cuonSach = new CuonSach();

			cuonSach.setMaCuonSach(res.getInt(1));
			cuonSach.setMaDauSach(res.getInt(2));
			cuonSach.setViTri(res.getString(3));
			cuonSach.setTrangThai(res.getString(4));

			CuonSachs.add(cuonSach);
		}

		closeConnection();
		return CuonSachs;
	}

	public List<CuonSach> getAllPhanTrang(int minRes, int maxRes, int maCuonSach, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<CuonSach> CuonSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayCuonSachPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maCuonSach);
		statement.setString(4, sort);
		statement.setString(5, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			CuonSach cuonSach = new CuonSach();
			cuonSach.setMaCuonSach(res.getInt(1));
			cuonSach.setMaDauSach(res.getInt(2));
			cuonSach.setViTri(res.getString(3));
			cuonSach.setTrangThai(res.getString(4));
			CuonSachs.add(cuonSach);
		}
		closeConnection();
		return CuonSachs;
	}

	public int getSoLuongPhanTu(int maCuonSach, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayCuonSachPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maCuonSach);
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
	public int Add(CuonSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spCuonSach ?,?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaCuonSach());
		statement.setInt(2, record.getMaDauSach());
		statement.setString(3, record.getViTri());
		statement.setString(4, record.getTrangThai());
		statement.setString(5, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaCuonSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(CuonSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spCuonSach ?,?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setInt(1, record.getMaCuonSach());
		statement.setInt(2, record.getMaDauSach());
		statement.setString(3, record.getViTri());
		statement.setString(4, record.getTrangThai());
		statement.setString(5, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public CuonSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotCuonSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		CuonSach cuonSach = new CuonSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			cuonSach.setMaCuonSach(res.getInt(1));
			cuonSach.setMaDauSach(res.getInt(2));
			cuonSach.setViTri(res.getString(3));
			cuonSach.setTrangThai(res.getString(4));
		}
		closeConnection();
		return cuonSach;

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

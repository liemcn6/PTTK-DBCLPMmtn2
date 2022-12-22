package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.Nxb;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALNxb extends ConnectDatabase implements I_DAL<Nxb> {

	public DALNxb(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<Nxb> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<Nxb> Nxbs = new ArrayList<>();
		String sqlExec = "EXEC spLayNxb";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			Nxb Nxb = new Nxb();
			Nxb.setMaNxb(res.getInt(1));
			Nxb.setTenNxb(res.getString(2));
			Nxb.setGhiChu(res.getString(3));
			Nxbs.add(Nxb);
		}

		closeConnection();
		return Nxbs;
	}

	@Override
	public int Add(Nxb record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spNxb ?,?,?,?";// 4 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaNxb());
		statement.setString(2, record.getTenNxb());
		statement.setString(3, record.getGhiChu());
		statement.setString(4, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaNxb ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(Nxb record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spNxb ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setInt(1, record.getMaNxb());
		statement.setString(2, record.getTenNxb());
		statement.setString(3, record.getGhiChu());
		statement.setString(4, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public Nxb GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotNxb ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		Nxb Nxb = new Nxb();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			Nxb.setMaNxb(res.getInt(1));
			Nxb.setTenNxb(res.getString(2));
			Nxb.setGhiChu(res.getString(3));
		}
		closeConnection();
		return Nxb;
	}

	public List<Nxb> getAllPhanTrang(int minRes, int maxRes, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<Nxb> Nxbs = new ArrayList<>();
		String sqlExec = "EXEC spLayNxbPhanTrang ?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setString(3, sort);
		statement.setString(4, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			Nxb Nxb = new Nxb();

			Nxb.setMaNxb(res.getInt(1));
			Nxb.setTenNxb(res.getString(2));
			Nxb.setGhiChu(res.getString(3));

			Nxbs.add(Nxb);
		}
		closeConnection();
		return Nxbs;
	}

	public int getSoLuongPhanTu(String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayNxbPhanTrangCount ?";

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

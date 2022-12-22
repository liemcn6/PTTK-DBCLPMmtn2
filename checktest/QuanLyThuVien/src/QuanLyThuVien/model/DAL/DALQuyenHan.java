package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.QuyenHan;

public class DALQuyenHan extends ConnectDatabase implements I_DAL<QuyenHan> {

	public DALQuyenHan(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<QuyenHan> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<QuyenHan> QuyenHans = new ArrayList<>();
		String sqlExec = "EXEC spLayQuyenHan";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			QuyenHan quyenHan = new QuyenHan();
			quyenHan.setIdQuyen(res.getInt(1));
			quyenHan.setTenQuyen(res.getString(2));
			QuyenHans.add(quyenHan);
		}

		closeConnection();
		return QuyenHans;
	}

	@Override
	public int Add(QuyenHan record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spQuyenHan ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getIdQuyen());
		statement.setString(2, record.getTenQuyen());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaQuyenHan ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(QuyenHan record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spQuyenHan ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getIdQuyen());
		statement.setString(2, record.getTenQuyen());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public QuyenHan GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotQuyenHan?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		QuyenHan quyenHan = new QuyenHan();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			quyenHan.setIdQuyen(res.getInt(1));
			quyenHan.setTenQuyen(res.getString(2));
		}
		closeConnection();
		return quyenHan;
	}

	@Override
	public int maxCode(String tenBang) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}

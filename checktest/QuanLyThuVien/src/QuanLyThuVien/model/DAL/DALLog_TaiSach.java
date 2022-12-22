package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.Log_TaiSach;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALLog_TaiSach extends ConnectDatabase implements I_DAL<Log_TaiSach>{

	public DALLog_TaiSach(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<Log_TaiSach> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<Log_TaiSach> Log_TaiSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayLog_TaiSach";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			Log_TaiSach log_TaiSach = new Log_TaiSach();
			log_TaiSach.setId_LogTaiSach(res.getInt(1));
			log_TaiSach.setMaTaiKhoan(res.getInt(2));
			log_TaiSach.setNgayTaiVe(res.getDate(3));
			log_TaiSach.setMaCuonSach(res.getInt(4));
			Log_TaiSachs.add(log_TaiSach);
		}

		closeConnection();
		return Log_TaiSachs;
	}

	@Override
	public int Add(Log_TaiSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spLog_TaiSach ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getId_LogTaiSach());
		statement.setInt(2, record.getMaTaiKhoan());
		statement.setDate(3, record.getNgayTaiVe());
		statement.setInt(4, record.getMaCuonSach());
		statement.setString(14, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaPhieuPhat ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(Log_TaiSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLog_TaiSach ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getId_LogTaiSach());
		statement.setInt(2, record.getMaTaiKhoan());
		statement.setDate(3, record.getNgayTaiVe());
		statement.setInt(4, record.getMaCuonSach());
		statement.setString(14, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public Log_TaiSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotPhieuPhat ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		Log_TaiSach log_TaiSach = new Log_TaiSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			log_TaiSach.setId_LogTaiSach(res.getInt(1));
			log_TaiSach.setMaTaiKhoan(res.getInt(2));
			log_TaiSach.setNgayTaiVe(res.getDate(3));
			log_TaiSach.setMaCuonSach(res.getInt(4));
		}
		closeConnection();
		return log_TaiSach;
	}

	@Override
	public int maxCode(String tenBang) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}

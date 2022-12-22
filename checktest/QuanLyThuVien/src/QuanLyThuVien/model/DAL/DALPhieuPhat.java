package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.DauSach;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALPhieuPhat extends ConnectDatabase implements I_DAL<PhieuPhat> {

	public DALPhieuPhat(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<PhieuPhat> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<PhieuPhat> PhieuPhats = new ArrayList<>();
		String sqlExec = "EXEC spLayPhieuPhat";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			PhieuPhat phieuPhat = new PhieuPhat();

			phieuPhat.setIdPhieuPhat(res.getInt(1));
			phieuPhat.setMaNhanVien(res.getInt(2));
			phieuPhat.setMaThe(res.getInt(3));
			phieuPhat.setNgayLap(res.getDate(4));
			phieuPhat.setTienPhat(res.getInt(5));
			PhieuPhats.add(phieuPhat);
		}

		closeConnection();
		return PhieuPhats;
	}

	@Override
	public int Add(PhieuPhat record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spPhieuPhat ?,?,?,?,?, ?";// 14 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getIdPhieuPhat());
		statement.setInt(2, record.getMaNhanVien());
		statement.setInt(3, record.getMaThe());
		statement.setDate(4, record.getNgayLap());
		statement.setInt(5, record.getTienPhat());
		statement.setString(6, "INSERT");
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
	public int Update(PhieuPhat record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spPhieuPhat ?,?,?,?,?, ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getIdPhieuPhat());
		statement.setInt(2, record.getMaNhanVien());
		statement.setInt(3, record.getMaThe());
		statement.setDate(4, record.getNgayLap());
		statement.setInt(5, record.getTienPhat());
		statement.setString(6, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public PhieuPhat GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotPhieuPhat ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		PhieuPhat phieuPhat = new PhieuPhat();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			phieuPhat.setIdPhieuPhat(res.getInt(1));
			phieuPhat.setMaNhanVien(res.getInt(2));
			phieuPhat.setMaThe(res.getInt(3));
			phieuPhat.setNgayLap(res.getDate(4));
			phieuPhat.setTienPhat(res.getInt(5));
		}
		closeConnection();
		return phieuPhat;
	}

	public List<PhieuPhat> getAllPhanTrang(int minRes, int maxRes, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<PhieuPhat> PhieuPhats = new ArrayList<>();
		String sqlExec = "EXEC spLayPhieuPhatPhanTrang ?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setString(3, sort);
		statement.setString(4, search);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			PhieuPhat phieuPhat = new PhieuPhat();

			phieuPhat.setIdPhieuPhat(res.getInt(1));
			phieuPhat.setMaNhanVien(res.getInt(2));
			phieuPhat.setMaThe(res.getInt(3));
			phieuPhat.setNgayLap(res.getDate(4));
			phieuPhat.setTienPhat(res.getInt(5));

			PhieuPhats.add(phieuPhat);
		}

		closeConnection();
		return PhieuPhats;
	}

	public int getSoLuongPhanTu(String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayPhieuPhatPhanTrangCount ?";

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

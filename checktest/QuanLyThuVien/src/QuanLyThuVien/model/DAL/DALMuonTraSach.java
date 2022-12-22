package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALMuonTraSach extends ConnectDatabase implements I_DAL<MuonTraSach> {

	public DALMuonTraSach(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<MuonTraSach> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<MuonTraSach> MuonTraSachs = new ArrayList<>();
		String sqlExec = "EXEC spLayMuonTraSach";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			MuonTraSach muonTraSach = new MuonTraSach();
			muonTraSach.setMaMuonSach(res.getInt(1));
			muonTraSach.setMaThe(res.getInt(2));
			muonTraSach.setTienDatCoc(res.getString(3));
			muonTraSach.setGhiChu(res.getString(4));
			MuonTraSachs.add(muonTraSach);
		}

		closeConnection();
		return MuonTraSachs;
	}

	public List<MuonTraSach> getAllPhanTrang(int minRes, int maxRes, int maThe, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();

		List<MuonTraSach> MuonTraSachs = new ArrayList<>();

		String sqlExec = "EXEC spLayMuonTraSachPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maThe);
		statement.setString(4, sort);
		statement.setString(5, search);

		ResultSet res = statement.executeQuery();

		while (res.next()) {
			MuonTraSach muonTraSach = new MuonTraSach();

			muonTraSach.setMaMuonSach(res.getInt(1));
			muonTraSach.setMaThe(res.getInt(2));
			muonTraSach.setTienDatCoc(res.getString(3));
			muonTraSach.setGhiChu(res.getString(4));

			MuonTraSachs.add(muonTraSach);
		}

		closeConnection();
		return MuonTraSachs;
	}

	@Override
	public int Add(MuonTraSach record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spMuonTraSach ?,?,?,?,?";// 5 @param

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaThe());
		statement.setString(3, record.getTienDatCoc());
		statement.setString(4, record.getGhiChu());
		statement.setString(5, "INSERT");

		int rowInsert = statement.executeUpdate();

		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaMuonTraSach ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		int rowDelete = statement.executeUpdate();

		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(MuonTraSach record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spMuonTraSach ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaThe());
		statement.setString(3, record.getTienDatCoc());
		statement.setString(4, record.getGhiChu());
		statement.setString(5, "UPDATE");

		int rowUpdate = statement.executeUpdate();

		closeConnection();
		return rowUpdate;
	}

	@Override
	public MuonTraSach GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotMuonTraSach ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		MuonTraSach muonTraSach = new MuonTraSach();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			muonTraSach.setMaMuonSach(res.getInt(1));
			muonTraSach.setMaThe(res.getInt(2));
			muonTraSach.setTienDatCoc(res.getString(3));
			muonTraSach.setGhiChu(res.getString(4));
		}

		closeConnection();

		return muonTraSach;
	}

	public int getSoLuongPhanTu(int maThe, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMuonTraSachPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maThe);
		statement.setString(2, search);

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

}

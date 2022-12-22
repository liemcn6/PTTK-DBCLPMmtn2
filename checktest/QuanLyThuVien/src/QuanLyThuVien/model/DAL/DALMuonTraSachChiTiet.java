package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.MuonTraSach;
import QuanLyThuVien.model.DAL.Object.MuonTraSachChiTiet;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;

public class DALMuonTraSachChiTiet extends ConnectDatabase implements I_DAL<MuonTraSachChiTiet> {

	public DALMuonTraSachChiTiet(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<MuonTraSachChiTiet> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<MuonTraSachChiTiet> MuonTraSachChiTiets = new ArrayList<>();
		String sqlExec = "EXEC spLayMuonTraSachChiTiet";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
			muonTraSachChiTiet.setMaMuonSach(res.getInt(1));
			muonTraSachChiTiet.setMaCuonSach(res.getInt(2));
			muonTraSachChiTiet.setNgayMuon(res.getDate(3));
			muonTraSachChiTiet.setNgayHenTra(res.getDate(4));
			muonTraSachChiTiet.setNgayTra(res.getDate(5));
			muonTraSachChiTiet.setTrangThai(res.getString(6));
			muonTraSachChiTiet.setSoLuong(res.getInt(7));
			MuonTraSachChiTiets.add(muonTraSachChiTiet);
		}
		closeConnection();
		return MuonTraSachChiTiets;
	}

	public List<MuonTraSachChiTiet> getAllPhanTrang(int minRes, int maxRes, int maCuonSach, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<MuonTraSachChiTiet> MuonTraSachChiTiets = new ArrayList<>();
		String sqlExec = "EXEC spLayMuonTraSachChiTietPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maCuonSach);
		statement.setString(4, sort);
		statement.setString(5, search);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
			muonTraSachChiTiet.setMaMuonSach(res.getInt(1));
			muonTraSachChiTiet.setMaCuonSach(res.getInt(2));
			muonTraSachChiTiet.setNgayMuon(res.getDate(3));
			muonTraSachChiTiet.setNgayHenTra(res.getDate(4));
			muonTraSachChiTiet.setNgayTra(res.getDate(5));
			muonTraSachChiTiet.setTrangThai(res.getString(6));
			muonTraSachChiTiet.setSoLuong(res.getInt(7));
			MuonTraSachChiTiets.add(muonTraSachChiTiet);
		}

		closeConnection();
		return MuonTraSachChiTiets;
	}

	@Override
	public int Add(MuonTraSachChiTiet record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spMuonTraSachChiTiet ?,?,?,?,?, ?,?,?";// 8 @param

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaCuonSach());
		statement.setDate(3, record.getNgayMuon());
		statement.setDate(4, record.getNgayHenTra());
		statement.setDate(5, record.getNgayTra());
		statement.setString(6, record.getTrangThai());
		statement.setInt(7, record.getSoLuong());
		statement.setString(8, "INSERT");

		int rowInsert = statement.executeUpdate();

		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaMuonTraSachChiTiet ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(MuonTraSachChiTiet record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spMuonTraSachChiTiet ?,?,?,?,?, ?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaMuonSach());
		statement.setInt(2, record.getMaCuonSach());
		statement.setDate(3, record.getNgayMuon());
		statement.setDate(4, record.getNgayHenTra());
		statement.setDate(5, record.getNgayTra());
		statement.setString(6, record.getTrangThai());
		statement.setInt(7, record.getSoLuong());
		statement.setString(8, "UPDATE");

		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public MuonTraSachChiTiet GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotMuonTraSachChiTiet ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		MuonTraSachChiTiet muonTraSachChiTiet = new MuonTraSachChiTiet();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			muonTraSachChiTiet.setMaMuonSach(res.getInt(1));
			muonTraSachChiTiet.setMaCuonSach(res.getInt(2));
			muonTraSachChiTiet.setNgayMuon(res.getDate(3));
			muonTraSachChiTiet.setNgayHenTra(res.getDate(4));
			muonTraSachChiTiet.setNgayTra(res.getDate(5));
			muonTraSachChiTiet.setTrangThai(res.getString(6));
			muonTraSachChiTiet.setSoLuong(res.getInt(7));
		}
		closeConnection();
		return muonTraSachChiTiet;
	}

	public int getSoLuongPhanTu(int maCuonSach, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMuonTraSachChiTietPhanTrangCount ?,?";

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

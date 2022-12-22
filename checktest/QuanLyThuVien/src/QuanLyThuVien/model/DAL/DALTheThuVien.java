package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.TheThuVien;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.TheThuVien;

public class DALTheThuVien extends ConnectDatabase implements I_DAL<TheThuVien> {

	public DALTheThuVien(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<TheThuVien> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<TheThuVien> TheThuViens = new ArrayList<>();
		String sqlExec = "EXEC spLayTheThuVien";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			TheThuVien theThuVien = new TheThuVien();
			theThuVien.setMaThe(res.getInt(1));
			theThuVien.setMaDocGia(res.getInt(2));
			theThuVien.setNgayCapThe(res.getDate(3));
			theThuVien.setNgayHetHan(res.getDate(4));
			theThuVien.setTrangThai(res.getString(5));
			theThuVien.setSoSachDuocMuon(res.getInt(6));
			theThuVien.setSoSachDangMuon(res.getInt(7));
			TheThuViens.add(theThuVien);
		}

		closeConnection();
		return TheThuViens;
	}

	@Override
	public int Add(TheThuVien record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spTheThuVien ?,?,?,?,?, ?,?,?";// 8 @param

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaThe());
		statement.setInt(2, record.getMaDocGia());
		statement.setDate(3, record.getNgayCapThe());
		statement.setDate(4, record.getNgayHetHan());
		statement.setString(5, record.getTrangThai());
		statement.setInt(6, record.getSoSachDuocMuon());
		statement.setInt(7, record.getSoSachDangMuon());
		statement.setString(8, "INSERT");

		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {

		openConnection();
		String sqlExec = "EXEC spXoaTheThuVien ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();

		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(TheThuVien record) throws SQLException, ClassNotFoundException {

		openConnection();

		String sqlExec = "EXEC spTheThuVien ?,?,?,?,?, ?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getMaThe());
		statement.setInt(2, record.getMaDocGia());
		statement.setDate(3, record.getNgayCapThe());
		statement.setDate(4, record.getNgayHetHan());
		statement.setString(5, record.getTrangThai());
		statement.setInt(6, record.getSoSachDuocMuon());
		statement.setInt(7, record.getSoSachDangMuon());
		statement.setString(8, "UPDATE");

		int rowUpdate = statement.executeUpdate();

		closeConnection();
		return rowUpdate;
	}

	public List<TheThuVien> getAllPhanTrang(int minRes, int maxRes, int maDocGia, String sort, String search)
			throws SQLException, ClassNotFoundException {

		openConnection();

		List<TheThuVien> TheThuViens = new ArrayList<>();

		String sqlExec = "EXEC spLayTheThuVienPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maDocGia);
		statement.setString(4, sort);
		statement.setString(5, search);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			TheThuVien theThuVien = new TheThuVien();

			theThuVien.setMaThe(res.getInt(1));
			theThuVien.setMaDocGia(res.getInt(2));
			theThuVien.setNgayCapThe(res.getDate(3));
			theThuVien.setNgayHetHan(res.getDate(4));
			theThuVien.setTrangThai(res.getString(5));
			theThuVien.setSoSachDuocMuon(res.getInt(6));
			theThuVien.setSoSachDangMuon(res.getInt(7));

			TheThuViens.add(theThuVien);
		}

		closeConnection();
		return TheThuViens;
	}

	public int getSoLuongPhanTu(int maDocGia, String search) throws SQLException, ClassNotFoundException {

		openConnection();
		String sqlExec = "EXEC spLayTheThuVienPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maDocGia);
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
	public TheThuVien GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotTheThuVien ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		TheThuVien theThuVien = new TheThuVien();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			theThuVien.setMaThe(res.getInt(1));
			theThuVien.setMaDocGia(res.getInt(2));
			theThuVien.setNgayCapThe(res.getDate(3));
			theThuVien.setNgayHetHan(res.getDate(4));
			theThuVien.setTrangThai(res.getString(5));
			theThuVien.setSoSachDuocMuon(res.getInt(6));
			theThuVien.setSoSachDangMuon(res.getInt(7));
		}
		closeConnection();
		return theThuVien;
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

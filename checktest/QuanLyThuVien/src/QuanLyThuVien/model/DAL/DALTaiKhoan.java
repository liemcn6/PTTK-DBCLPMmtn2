package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.QuyenHan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;
import QuanLyThuVien.model.DAL.Object.TaiKhoan;

public class DALTaiKhoan extends ConnectDatabase implements I_DAL<TaiKhoan> {

	public DALTaiKhoan(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	public int changePassword(String mk, int id) throws ClassNotFoundException, SQLException {
		openConnection();
		String sql = "Update TaiKhoan Set MatKhau=? Where MaTaiKhoan=?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setString(1, mk);
		statement.setInt(2, id);
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	public TaiKhoan getTaiKhoanTheoEmail(String email) throws ClassNotFoundException, SQLException {
		openConnection();
		String sql = "Select * From TaiKhoan Where Email=?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setString(1, email);
		ResultSet res = statement.executeQuery();
		TaiKhoan taiKhoan = null;
		if (res.next()) {
			taiKhoan = new TaiKhoan();
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getString(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getBlob(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
		}
		return taiKhoan;
	}

	@Override
	public List<TaiKhoan> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<TaiKhoan> TaiKhoans = new ArrayList<>();
		String sqlExec = "EXEC spLayTaiKhoan";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getString(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getBlob(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
			TaiKhoans.add(taiKhoan);
		}

		closeConnection();
		return TaiKhoans;
	}

	@Override
	public int Add(TaiKhoan record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spTaiKhoan ?,?,?,?,?, ?,?,?";// 8 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaTaiKhoan());
		statement.setString(2, record.geteMail());
		statement.setString(3, record.getSoDienThoai());
		statement.setString(4, record.getMatKhau());
		statement.setBlob(5, record.getAvartarInputStream());
		statement.setInt(6, record.getIdQuyen());
		statement.setInt(7, record.getMaThe());
		statement.setString(8, "INSERT");
		int rowInsert = statement.executeUpdate();
		closeConnection();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaTaiKhoan ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(TaiKhoan record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spTaiKhoan ?,?,?,?,?, ?,?,?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, record.getMaTaiKhoan());
		statement.setString(2, record.geteMail());
		statement.setString(3, record.getSoDienThoai());
		statement.setString(4, record.getMatKhau());
		statement.setBlob(5, record.getAvartarInputStream());
		statement.setInt(6, record.getIdQuyen());
		statement.setInt(7, record.getMaThe());
		statement.setString(8, "UPDATE");
		int rowUpdate = statement.executeUpdate();
		closeConnection();
		return rowUpdate;
	}

	@Override
	public TaiKhoan GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotTaiKhoan ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		TaiKhoan taiKhoan = new TaiKhoan();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getString(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getBlob(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
		}
		closeConnection();
		return taiKhoan;
	}

	public List<TaiKhoan> getAllPhanTrang(int minRes, int maxRes, int maTaiKhoan, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<TaiKhoan> TaiKhoans = new ArrayList<>();
		String sqlExec = "EXEC spLayTaiKhoanPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maTaiKhoan);
		statement.setString(4, sort);
		statement.setString(5, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			TaiKhoan taiKhoan = new TaiKhoan();
			taiKhoan.setMaTaiKhoan(res.getInt(1));
			taiKhoan.seteMail(res.getString(2));
			taiKhoan.setSoDienThoai(res.getString(3));
			taiKhoan.setMatKhau(res.getString(4));
			taiKhoan.setAvartar(res.getBlob(5));
			taiKhoan.setIdQuyen(res.getInt(6));
			taiKhoan.setMaThe(res.getInt(7));
			TaiKhoans.add(taiKhoan);
		}
//		closeConnection();
		return TaiKhoans;
	}

	public int getSoLuongPhanTu(int maTaiKhoan, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayTaiKhoanPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maTaiKhoan);
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

	public QuyenHan getIDQuyen(String tenQuyen) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayIDQuyenTheoTen ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setString(1, tenQuyen);

		QuyenHan quyenHan = new QuyenHan();
		ResultSet res = statement.executeQuery();
		if (res.next()) {

			quyenHan.setIdQuyen(res.getInt(1));
			quyenHan.setTenQuyen(res.getString(2));

		}
		closeConnection();
		return quyenHan;
	}
}

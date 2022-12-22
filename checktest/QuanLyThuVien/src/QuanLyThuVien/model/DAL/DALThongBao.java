package QuanLyThuVien.model.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import QuanLyThuVien.model.DAL.Object.ThongBao;
import QuanLyThuVien.model.DAL.Object.PhieuPhat;
import QuanLyThuVien.model.DAL.Object.ThongBao;

public class DALThongBao extends ConnectDatabase implements I_DAL<ThongBao> {

	public DALThongBao(String jdbcURL) throws SQLException {
		super(jdbcURL);
	}

	@Override
	public List<ThongBao> getAll() throws SQLException, ClassNotFoundException {
		openConnection();
		List<ThongBao> ThongBaos = new ArrayList<>();
		String sqlExec = "EXEC spLayThongBao";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		ResultSet res = statement.executeQuery();
		while (res.next()) {
			ThongBao thongBao = new ThongBao();

			thongBao.setIdThongBao(res.getInt(1));
			thongBao.setTenThongBao(res.getString(2));
			thongBao.setNoiDung(res.getString(3));
			thongBao.setHinhAnh(res.getBlob(4));
			thongBao.setMaTaiKhoan(res.getInt(5));

			ThongBaos.add(thongBao);
		}

		return ThongBaos;
	}

	@Override
	public int Add(ThongBao record) throws SQLException, ClassNotFoundException {
		if (record == null)
			return 0;

		openConnection();
		String sqlExec = "EXEC spThongBao ?,?,?,?,?, ?";// 6 @param
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getIdThongBao());
		statement.setString(2, record.getTenThongBao());
		statement.setString(3, record.getNoiDung());
		statement.setBlob(4, record.getHinhAnhInputStream());
		statement.setInt(5, record.getMaTaiKhoan());

		statement.setString(6, "INSERT");

		int rowInsert = statement.executeUpdate();
		return rowInsert;
	}

	@Override
	public int Delete(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spXoaThongBao ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		statement.setInt(1, (int) code[0]);
		int rowDelete = statement.executeUpdate();
		closeConnection();
		return rowDelete;
	}

	@Override
	public int Update(ThongBao record) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spThongBao ?,?,?,?,?, ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, record.getIdThongBao());
		statement.setString(2, record.getTenThongBao());
		statement.setString(3, record.getNoiDung());
		statement.setBlob(4, record.getHinhAnhInputStream());
		statement.setInt(5, record.getMaTaiKhoan());
		statement.setString(6, "UPDATE");

		int rowUpdate = statement.executeUpdate();
		return rowUpdate;
	}

	@Override
	public ThongBao GetOne(Object... code) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayMotThongBao ?";
		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, (int) code[0]);

		ThongBao thongBao = new ThongBao();
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			thongBao.setIdThongBao(res.getInt(1));
			thongBao.setTenThongBao(res.getString(2));
			thongBao.setNoiDung(res.getString(3));
			thongBao.setHinhAnh(res.getBlob(4));
			thongBao.setMaTaiKhoan(res.getInt(5));
		}
		return thongBao;
	}

	public List<ThongBao> getAllPhanTrang(int minRes, int maxRes, int maThongBao, String sort, String search)
			throws SQLException, ClassNotFoundException {
		openConnection();
		List<ThongBao> ThongBaos = new ArrayList<>();
		String sqlExec = "EXEC spLayThongBaoPhanTrang ?,?,?,?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setInt(1, minRes);
		statement.setInt(2, maxRes);
		statement.setInt(3, maThongBao);
		statement.setString(4, sort);
		statement.setString(5, search);

		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);
		ResultSet res = statement.executeQuery();

		while (res.next()) {
			ThongBao thongBao = new ThongBao();
			thongBao.setIdThongBao(res.getInt(1));
			thongBao.setTenThongBao(res.getString(2));
			thongBao.setNoiDung(res.getString(3));
			thongBao.setHinhAnh(res.getBlob(4));
			thongBao.setMaTaiKhoan(res.getInt(5));
			ThongBaos.add(thongBao);
		}
		return ThongBaos;
	}

	public int getSoLuongPhanTu(int maThongBao, String search) throws SQLException, ClassNotFoundException {
		openConnection();
		String sqlExec = "EXEC spLayThongBaoPhanTrangCount ?,?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sqlExec);
		statement.setEscapeProcessing(true);
		statement.setQueryTimeout(15);

		statement.setInt(1, maThongBao);
		statement.setString(2, search);

		int kq = 0;
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			kq = res.getInt(1);
		}
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

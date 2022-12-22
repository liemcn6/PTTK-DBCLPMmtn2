package QuanLyThuVien.model.DAL.Object;

public class QuyenHan {
  private int idQuyen;
  private String tenQuyen;
  
public int getIdQuyen() {
	return idQuyen;
}

public void setIdQuyen(int idQuyen) {
	this.idQuyen = idQuyen;
}

public String getTenQuyen() {
	return tenQuyen;
}

public void setTenQuyen(String tenQuyen) {
	this.tenQuyen = tenQuyen;
}

public QuyenHan() {
	super();
}

public QuyenHan(int idQuyen, String tenQuyen) {
	super();
	this.idQuyen = idQuyen;
	this.tenQuyen = tenQuyen;
}
  
}

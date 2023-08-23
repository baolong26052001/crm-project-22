package crm_project_22.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

public class CongViec {
	private int id;
	private String ten;
	private String mota;
	private String nguoidung;
	private Timestamp ngaybatdau;
	private Timestamp ngayketthuc;
	private String trangthai;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getNguoidung() {
		return nguoidung;
	}
	public void setNguoidung(String nguoidung) {
		this.nguoidung = nguoidung;
	}
	public Timestamp getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(Timestamp ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public Timestamp getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(Timestamp ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	
	
	
	
	
	
}

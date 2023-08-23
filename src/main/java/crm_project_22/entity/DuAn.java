package crm_project_22.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

public class DuAn {
	private int id;
	private String ten;
	private String mota;
	private Timestamp ngaybatdau;
	private Timestamp ngayketthuc;
	
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
	
	
}

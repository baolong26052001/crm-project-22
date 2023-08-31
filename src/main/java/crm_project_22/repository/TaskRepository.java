package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.CongViec;
import crm_project_22.entity.DuAn;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.entity.NguoiDung;
import crm_project_22.entity.TrangThai;

public class TaskRepository {
	public List<CongViec> getAllCongViec() {
		List<CongViec> list = new ArrayList<CongViec>();
		
		String query = "select cv.id, cv.ten, da.ten as tenduan, nd.fullname, cv.ngaybatdau, cv.ngayketthuc, tt.ten as tentrangthai\r\n"
				+ "from CongViec cv, NguoiDung nd, TrangThai tt, DuAn da  \r\n"
				+ "where cv.id_nguoidung = nd.id and da.id = cv.id_duan and tt.id = cv.id_trangthai;";
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CongViec congViec = new CongViec();
				congViec.setId(resultSet.getInt("id"));
				congViec.setTen(resultSet.getString("ten"));
				congViec.setMota(resultSet.getString("tenduan"));
				congViec.setNguoidung(resultSet.getString("fullname"));
				
//				NguoiDung nguoiDung = new NguoiDung();
//				nguoiDung.setId(resultSet.getInt("id"));
//				congViec.setNguoiDung(nguoiDung);
				
				congViec.setNgaybatdau(resultSet.getTimestamp("ngaybatdau"));
				congViec.setNgayketthuc(resultSet.getTimestamp("ngayketthuc"));
				congViec.setTrangthai(resultSet.getString("tentrangthai"));
				
//				TrangThai trangThai = new TrangThai();
//				trangThai.setId(resultSet.getInt("id"));
//				congViec.setTrangThai(trangThai);
				
				list.add(congViec);
			}
		} catch (Exception e) {
			System.out.println("Lỗi thực thi câu query" + e.getLocalizedMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					System.out.println("Lỗi đóng kết nối " + e.getLocalizedMessage());
				}
			}
		}
		
		return list;
	}
	public int deleteById(int id) {
		int count = 0;
		String query = "delete from CongViec where id = ?";
		Connection connection = MysqlConfig.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}

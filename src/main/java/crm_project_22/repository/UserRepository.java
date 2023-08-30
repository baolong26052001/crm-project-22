package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.DuAn;
import crm_project_22.entity.NguoiDung;

public class UserRepository {
	public List<NguoiDung> getAllNguoiDung() {
		List<NguoiDung> list = new ArrayList<NguoiDung>();
		
		String query = "select nd.id, nd.fullname, nd.email, ltv.ten as role\r\n"
				+ "from NguoiDung nd, LoaiThanhVien ltv \r\n"
				+ "where nd.id_loaithanhvien = ltv.id;";
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NguoiDung nguoiDung = new NguoiDung();
				nguoiDung.setId(resultSet.getInt("id"));
				nguoiDung.setFullname(resultSet.getString("fullname"));
				nguoiDung.setEmail(resultSet.getString("email"));
				nguoiDung.setRole(resultSet.getString("role"));
				
				list.add(nguoiDung);
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
		String query = "delete from NguoiDung where id = ?";
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
	public boolean addUser(String fullname, String email, String password, String phone, String address) {
		String query = "insert into NguoiDung (fullname, email, matkhau, soDienThoai, diachi, id_loaithanhvien) values (?, ?, ?, ?, ?, 1);";
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (fullname != null && email != null && password != null && phone != null && address != null)
			{
				statement.setString(1, fullname);
				statement.setString(2, email);
				statement.setString(3, password);
				statement.setString(4, phone);
				statement.setString(5, address);
			}
			
			
			int resultSet = statement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println("Lỗi thực thi câu query" + e.getLocalizedMessage());
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					System.out.println("Lỗi đóng kết nối " + e.getLocalizedMessage());
				}
			}
		}
		return true;
	}
}

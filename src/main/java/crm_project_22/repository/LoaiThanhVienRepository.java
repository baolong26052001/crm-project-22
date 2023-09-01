package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleResult;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.entity.NguoiDung;

public class LoaiThanhVienRepository {
	public boolean AddRole(String ten, String mota) {
		String query = "insert into LoaiThanhVien (ten, mota) values (?, ?);";
		
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (ten != null && mota != null)
			{
				statement.setString(1, ten);
				
				statement.setString(2, mota);
			}
			
			
			int resultSet = statement.executeUpdate();
		} catch (SQLException e) {
			
			System.out.println("Lỗi thực thi câu query " + e.getLocalizedMessage());
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
	
	public List<LoaiThanhVien> getAllLoaiThanhVien() {
		List<LoaiThanhVien> list = new ArrayList<LoaiThanhVien>();
		
		String query = "select * from LoaiThanhVien";
		Connection connection = MysqlConfig.getConnection();
		
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				LoaiThanhVien loaiThanhVien = new LoaiThanhVien();
				loaiThanhVien.setId(resultSet.getInt("id"));
				loaiThanhVien.setTen(resultSet.getString("ten"));
				loaiThanhVien.setMota(resultSet.getString("mota"));
				
				list.add(loaiThanhVien);
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
		String query = "delete from LoaiThanhVien where id = ?";
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

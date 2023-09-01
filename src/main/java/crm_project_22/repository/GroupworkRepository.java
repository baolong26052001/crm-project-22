package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.DuAn;
import crm_project_22.entity.LoaiThanhVien;

public class GroupworkRepository {
	public List<DuAn> getAllDuAn() {
		List<DuAn> list = new ArrayList<DuAn>();
		
		String query = "select * from DuAn";
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				DuAn duAn = new DuAn();
				duAn.setId(resultSet.getInt("id"));
				duAn.setTen(resultSet.getString("ten"));
				duAn.setMota(resultSet.getString("mota"));
				duAn.setNgaybatdau(resultSet.getTimestamp("ngaybatdau"));
				duAn.setNgayketthuc(resultSet.getTimestamp("ngayketthuc"));
				
				list.add(duAn);
			}
		} catch (Exception e) {
			System.out.println("Lỗi thực thi câu query " + e.getLocalizedMessage());
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
		String query = "delete from DuAn where id = ?";
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
	public boolean AddGroupwork(String ten, String ngaybatdau, String ngayketthuc) {
		String query = "insert into DuAn (ten, ngaybatdau, ngayketthuc) values (?, ?, ?);";
		
		Connection connection = MysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if (ten != null && ngaybatdau != null && ngayketthuc != null)
			{
				statement.setString(1, ten);
				
				statement.setString(2, ngaybatdau);
				statement.setString(3, ngayketthuc);
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

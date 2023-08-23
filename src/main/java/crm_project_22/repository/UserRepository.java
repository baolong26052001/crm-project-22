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
}

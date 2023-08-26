package crm_project_22.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_22.config.MysqlConfig;
import crm_project_22.entity.LoaiThanhVien;
import crm_project_22.entity.NguoiDung;

/*
 * tên class của repository sẽ tạo theo tên bảng, để quản lý tất cả các câu query liên quan đến bảng đó
 * findBy: dành cho câu select có điều kiện where
 * */

public class NguoiDungRepository {
	
	public List<NguoiDung> findByEmailAndPassword(String email, String matkhau) {
		String query = "select *\r\n"
				+ "from NguoiDung nd\r\n"
				+ "JOIN LoaiThanhVien ltv ON ltv.id = nd.id_loaithanhvien\n"
				+ "where nd.email = ? and nd.matkhau = ?"; //?:là giá trị của tham số sẽ được truyền vào sau
		
		Connection connection = MysqlConfig.getConnection();
		List<NguoiDung> listNguoiDung = new ArrayList<NguoiDung>();
		
		try {
			// truyền câu query vào connection
			PreparedStatement statement = connection.prepareStatement(query);
			// truyền giá trị tham số vào câu query nếu có
			statement.setString(1, email); //lưu ý: setString, setInt... phải tùy vào kiểu dữ liệu của cột đang so sánh của tham số
			statement.setString(2, matkhau);
			
			// thực thi câu query
			/*
			 * executeQuery: khi câu truy vấn là câu lấy dữ liệu SELECT
			 * executeUpdate: không phải là câu lấy dữ liệu. INSERT, DELETE, UPDATE...
			 * */
			ResultSet resultSet = statement.executeQuery();
			// duyệt dữ liệu từ resultSet
			while(resultSet.next()) {
				NguoiDung nguoiDung = new NguoiDung();
				//int id = resultSet.getInt("id"); //lấy giá trị của cột id trong CSDL khi duyệt qua từng dòng
				
				nguoiDung.setId(resultSet.getInt("id"));
				nguoiDung.setFullname(resultSet.getString("fullname"));
				nguoiDung.setEmail(resultSet.getString("email"));
				
				LoaiThanhVien loaiThanhVien = new LoaiThanhVien();
				loaiThanhVien.setTen(resultSet.getString("ten"));
				
				nguoiDung.setLoaiThanhVien(loaiThanhVien);
				
				listNguoiDung.add(nguoiDung);
			}
			
			if (listNguoiDung.size() > 0) {
				System.out.println("đăng nhập thành công");
			}
			else {
				System.out.println("đăng nhập thất bại");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi thực thi câu query" + e.getLocalizedMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Lỗi đóng kết nối " + e.getLocalizedMessage());
				}
			}
		}
		return listNguoiDung;
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
}

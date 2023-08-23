package crm_project_22.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfig 
{
	// tạo kết nối tới csdl
	public static Connection getConnection()
	{
		Connection connection = null;
		//khai báo driver sử dụng dành cho csdl tương ứng
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/crm", "root", "admin123");
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Lỗi kết nối CSDL " + e.getLocalizedMessage());
		}
		return connection;
	}
	
	
}
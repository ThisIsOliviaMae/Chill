package Manager;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/hackercup";
	private static final String username = "root";
	private static final String password = "cutiepie96";

	public DBConnection() {

	}

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username,
					password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

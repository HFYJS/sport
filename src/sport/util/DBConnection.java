package sport.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private DBConnection() {

	}

	public static Connection getConnection() {
		final Properties prop = new Properties();
		try {
			prop.load(DBConnection.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		final String DBDriver = prop.getProperty("DBDriver");
		final String DBURL = prop.getProperty("DBURL");
		final String DBName = prop.getProperty("DBName");
		final String DBPwd = prop.getProperty("DBPwd");
		Connection conn = null;
		try {
			Class.forName(DBDriver);
			conn = DriverManager.getConnection(DBURL, DBName, DBPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

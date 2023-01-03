package roomtype.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	public static Connection createMSSQLConnection() {
		Properties props = new Properties();
		Connection conn = null;
		FileInputStream fis = null;
		HikariDataSource ds = null;
			try {
				fis = new FileInputStream("C:\\_SpringBoot\\workspaceA\\jspExercise\\src\\main\\resources\\db.properties");
				props.load(fis);
				HikariConfig config = new HikariConfig(props);
				ds = new HikariDataSource(config);
				conn = ds.getConnection();
			} catch (IOException | SQLException e) {
				System.out.println("連線出問題!!");
				e.printStackTrace();
			} 
		return conn;
	}
}

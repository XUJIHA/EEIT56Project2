package roomtype.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory2 {
	public static Connection createMSSQLConnection() {
		DataSource ds = null;
		Connection conn = null;
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Team3DB");
			conn = ds.getConnection();
			boolean status = !conn.isClosed();
			System.out.println(status);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * Servlet implementation class TestConnection
 */
@WebServlet("/TestConnection2")
public class TestHikariConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("C:\\_SpringBoot\\workspaceA\\jspExercise\\src\\main\\resources\\db.properties");
		props.load(fis);
		HikariConfig config = new HikariConfig(props);
		HikariDataSource ds = new HikariDataSource(config);
		try {
			Connection conn = ds.getConnection();
			System.out.println("status:" + !conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

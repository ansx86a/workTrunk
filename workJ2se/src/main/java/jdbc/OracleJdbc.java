package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJdbc {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		try {
			// DriverManager.getConnection("jdbc:oracle:thin:@ip:port:sid", "name", "password");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@172.24.17.9:1805:fccglebt", "ebdevusr", "ebdevusr");
			conn.setAutoCommit(false);
			System.out.println("getconnection ok");
			Statement st = conn.createStatement();
			String sql = " select 1  from dual";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getObject(1));
			}
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			conn.rollback();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("done");
	}
}

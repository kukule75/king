package king.other;

import org.junit.Test;

import java.sql.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author YuXiaodan
 * @ClassName JdbcTest
 * @Description
 * @date 2018年05月21日 2018/5/21
 */
public class JdbcTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException, InterruptedException {

		Connection conn;
		Statement stmt;
		ResultSet rs;
		String url = "jdbc:mysql://127.0.0.1:3306/my";
		String user = "root";
		String password = "123456";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
		String sql = "show session variables like '%timeout%'";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out
					.println(rs.getString(1)+":  "+rs.getString(2));
		}
		TimeUnit.SECONDS.sleep(11);
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out
					.println(rs.getString(1)+":  "+rs.getString(2));
		}
	}

	@Test
	public void testA() throws ClassNotFoundException, SQLException, InterruptedException{

		Connection conn;
		Statement stmt;
		ResultSet rs;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://127.0.0.1:3306/my";
		String user = "root";
		String password = "123456";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);
		stmt = conn.createStatement();
//		String sql = "show session variables like '%timeout%'";
		String sql = "insert into account (acc_no, acc_code, user_id, `status`, status_code, acc_type, dc_flag, minus_flag) VALUES(?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, "abc");
		ps.setInt(2, 1001);
		ps.setLong(3, 111111);
		ps.setString(4, "1111");
		ps.setLong(5, 100L);
		ps.setString(6, "E");
		ps.setString(7, "D");
		ps.setString(8, "1");
		for (int i = 0; i < 10; i++) {
			ps.execute();
			TimeUnit.SECONDS.sleep(3);
		}

	}}

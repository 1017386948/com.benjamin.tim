import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/goods?useSSL=false&serverTimezone=GMT",
				"root", "root");
		String sql = "SELECT * FROM tbl_goods;";
		Statement st = conn.createStatement();
		ResultSet result = st.executeQuery(sql);
		String goodName = null;
		while (result.next()) {
			goodName = result.getString(3);
		}
		result.close();
		st.close();
		conn.close();
		System.out.println(goodName);
	}

}

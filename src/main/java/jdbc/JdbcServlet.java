package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcServlet
 */
@WebServlet("/JdbcServlet")
public class JdbcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JdbcServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
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
			response.getWriter().write(goodName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

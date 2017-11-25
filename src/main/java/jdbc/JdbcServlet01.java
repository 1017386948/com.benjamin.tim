package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/JdbcServlet01")
public class JdbcServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JdbcServlet01() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.126:3306/dp_ordm2_t", "root",
					"admin");
			String sql = "SELECT * FROM core_authuser;";
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery(sql);
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			while (result.next()) {
				writer.write(result.getString(2) + "\n");
			}
			result.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package hehe.study;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo4
 */
@WebServlet("/ServletDemo4")
public class ServletDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		test1(response);
	}

	private void test1(HttpServletResponse response) throws IOException {

		System.out.println("INNN");

		response.setDateHeader("expires",
				System.currentTimeMillis() + 24 * 60 * 1000);
		ClassLoader loader = ServletDemo4.class.getClassLoader();
		InputStream in = loader.getResourceAsStream("/../db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("drive");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("用类装载器读取src目录下的db1.properties配置文件：");
		response.getWriter()
				.println(MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", driver,
						url, username, password));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package hehe.study;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemo3
 */
@WebServlet("/ServletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		readSrcDirPropCfgFile(response);
		response.getWriter().println("<hr/>");
	}

	private void readSrcDirPropCfgFile(HttpServletResponse response)
			throws IOException {
		InputStream in = this.getServletContext()
				.getResourceAsStream("/WEB-INF/db.properties");
		Properties prop = new Properties();
		prop.load(in);
		String drive = prop.getProperty("drive");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取src目录下的db1.properties配置文件：");
		response.getWriter()
				.println(MessageFormat.format(
						"driver={0},url={1},username={2},password={3}", drive,
						url, username, password));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

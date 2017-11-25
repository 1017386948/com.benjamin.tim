package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo1
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDemo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		downloadFileByOutputStream(response);
	}

	private void downloadFileByOutputStream(HttpServletResponse response) throws IOException {
		String realPath = this.getServletContext().getRealPath("/img/javaweb.png");
		String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		InputStream in = new FileInputStream(realPath);
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = in.read(buffer)) >= 0) {
			out.write(buffer, 0, length);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

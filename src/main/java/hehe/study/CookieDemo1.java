package hehe.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieDemo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			out.write("您上次访问的时间是：");
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				Long lastAccessTime = Long.parseLong(cookie.getValue());
				Date date = new Date(lastAccessTime);
				out.write(date.toString());
			}
		} else {
			out.write("这是您第一次访问本站！");
		}
		Cookie cookie = new Cookie("lastAccessTime",
				System.currentTimeMillis() + "");
		cookie.setMaxAge(60);
		response.addCookie(cookie);

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

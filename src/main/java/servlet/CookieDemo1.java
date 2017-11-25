package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo1
 */
@WebServlet(name = "CookieDemo1", urlPatterns = { "/cookiedemo1", "/CookieDemo1" }, initParams = {
		@WebInitParam(name = "admin", value = "Harry"), @WebInitParam(name = "password", value = "123456") })
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieDemo1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				Long lastAccessTime = Long.parseLong(cookie.getValue());
				Date date = new Date(lastAccessTime);
				out.write(date.toString());
			}
		} else {
		}
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		@SuppressWarnings("unchecked")
		Enumeration<String> e = this.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			out.write(name);
			out.write(this.getInitParameter(name));
		}

		this.getServletContext();
		getServletConfig();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

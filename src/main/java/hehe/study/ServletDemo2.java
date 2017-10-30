package hehe.study;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hohohoho")
public class ServletDemo2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1574477677467598122L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-type", "text/html");
		ServletContext context = this.getServletContext();
		String data = (String) context.getAttribute("data");
		response.getWriter().print("servletDemo2");
		response.getWriter().print(data);

		@SuppressWarnings("unchecked")
		Enumeration<String> e = getServletConfig().getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = getServletConfig().getInitParameter(name);
			response.getWriter().print(name + "=" + value + "<br/>");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}

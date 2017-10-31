package hehe.study;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo2
 */
@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestDemo2() {
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
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Enumeration<String> reqHeadInfos = request.getHeaderNames();// 获取所有的请求头
		out.write("获取到的客户端所有的请求头信息如下：");
		out.write("<hr/>");
		while (reqHeadInfos.hasMoreElements()) {
			String headName = (String) reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);// 根据请求头的名字获取对应的请求头的值
			out.write(headName + ":" + headValue);
			out.write("<br/>");
		}
		out.write("<br/>");
		out.write("获取到的客户端Accept-Encoding请求头的值：");
		out.write("<hr/>");
		String value = request.getHeader("Accept-Encoding");// 获取Accept-Encoding请求头对应的值
		out.write(value);

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

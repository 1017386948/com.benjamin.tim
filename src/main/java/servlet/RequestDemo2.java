package servlet;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unchecked")
		Enumeration<String> reqHeadInfos = request.getHeaderNames();// ��ȡ���е�����ͷ
		out.write("<hr/>");
		while (reqHeadInfos.hasMoreElements()) {
			String headName = (String) reqHeadInfos.nextElement();
			String headValue = request.getHeader(headName);// ��������ͷ�����ֻ�ȡ��Ӧ������ͷ��ֵ
			out.write(headName + ":" + headValue);
			out.write("<br/>");
		}
		out.write("<br/>");
		out.write("��ȡ���Ŀͻ���Accept-Encoding����ͷ��ֵ��");
		out.write("<hr/>");
		String value = request.getHeader("Accept-Encoding");// ��ȡAccept-Encoding����ͷ��Ӧ��ֵ
		out.write(value);

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

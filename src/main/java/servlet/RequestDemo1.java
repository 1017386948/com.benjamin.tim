package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo1
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RequestDemo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String queryString = request.getQueryString();
		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		int remotePort = request.getRemotePort();
		String remoteUser = request.getRemoteUser();
		String method = request.getMethod();// �õ�����URL��ַʱʹ�õķ���
		String pathInfo = request.getPathInfo();
		String localAddr = request.getLocalAddr();// ��ȡWEB��������IP��ַ
		String localName = request.getLocalName();// ��ȡWEB��������������
		response.setCharacterEncoding("UTF-8");// ���ý��ַ���"UTF-8"����������ͻ��������
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("");
		out.write("<hr/>");
		out.write("requestUrl" + requestUrl);
		out.write("<br/>");
		out.write("requestUri" + requestUri);
		out.write("<br/>");
		out.write("queryString" + queryString);
		out.write("<br/>");
		out.write("remoteAddr" + remoteAddr);
		out.write("<br/>");
		out.write("remoteHost" + remoteHost);
		out.write("<br/>");
		out.write("remotePort" + remotePort);
		out.write("<br/>");
		out.write("remoteUser" + remoteUser);
		out.write("<br/>");
		out.write("method" + method);
		out.write("<br/>");
		out.write("pathInfo" + pathInfo);
		out.write("<br/>");
		out.write("localAddr" + localAddr);
		out.write("<br/>");
		out.write("localName��" + localName);
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

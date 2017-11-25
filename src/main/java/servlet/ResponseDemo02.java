package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseDemo02
 */
@WebServlet("/ResponseDemo02")
public class ResponseDemo02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseDemo02() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("refresh", "5");
		BufferedImage image = new BufferedImage(80, 20,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 20);
		g.setColor(Color.BLUE);// ����ͼƬ���������ɫ
		g.setFont(new Font(null, Font.BOLD, 20));
		g.drawString(makeNum(), 0, 20);
		response.setContentType("image/jpeg");// ��ͬ��response.setHeader("Content-Type",
												// "image/jpeg");
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 6.��ͼƬд�������
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private String makeNum() {
		Random random = new Random();
		String num = random.nextInt(9999999) + "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 7 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
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

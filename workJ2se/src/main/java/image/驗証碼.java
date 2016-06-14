package image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class 驗証碼 {

	public static void main(String[] args) throws IOException {
		驗証碼 p = new 驗証碼();
		p.$1();
		p.$2();
	}

	public void $1() throws IOException {
		BufferedImage image = renderWord("ApzO", 100, 50);
		ImageIO.write(image, "jpg", new File("z:/001驗証碼.jpg"));
		ImageIO.write(image, "png", new File("z:/001驗証碼.png"));
	}

	// 參照KaptchaExtend 做出來的東西，不過出來的東西就有點不好看，也還沒有畫上干擾線
	// 這一頁有簡單的範例，容易使用https://github.com/axet/kaptcha
	public BufferedImage renderWord(String word, int width, int height) {
		int fontSize = 24;
		Font[] fonts = new Font[] { new Font("Arial", Font.BOLD, fontSize), new Font("Courier", Font.BOLD, fontSize) };
		Color color = Color.BLACK;
		int charSpace = 5;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2D = image.createGraphics();
		g2D.setColor(color);

		RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		hints.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
		g2D.setRenderingHints(hints);

		FontRenderContext frc = g2D.getFontRenderContext();
		Random random = new Random();

		int startPosY = (height - fontSize) / 5 + fontSize;

		char[] wordChars = word.toCharArray();
		Font[] chosenFonts = new Font[wordChars.length];
		int[] charWidths = new int[wordChars.length];
		int widthNeeded = 0;
		for (int i = 0; i < wordChars.length; i++) {
			chosenFonts[i] = fonts[random.nextInt(fonts.length)];
			char[] charToDraw = new char[] { wordChars[i] };
			GlyphVector gv = chosenFonts[i].createGlyphVector(frc, charToDraw);
			charWidths[i] = (int) gv.getVisualBounds().getWidth();
			if (i > 0) {
				widthNeeded = widthNeeded + 2;
			}
			widthNeeded = widthNeeded + charWidths[i];
		}
		int startPosX = (width - widthNeeded) / 2;
		for (int i = 0; i < wordChars.length; i++) {
			g2D.setFont(chosenFonts[i]);
			char[] charToDraw = new char[] { wordChars[i] };
			g2D.drawChars(charToDraw, 0, charToDraw.length, startPosX, startPosY);
			startPosX = startPosX + (int) charWidths[i] + charSpace;
		}
		return image;
	}

	public void $1_2sample() {
		// 參考這個網站和樣式
		// http://pclevin.blogspot.tw/2012/06/java.html

		jsp: {

			// <body>
			// <table>
			// <tr>
			// <td><img src="Kaptcha.jpg"></td>
			// <td valign="top">
			// <form method="POST">
			// <br>請輸入驗證碼：<input type="text" name="kaptchafield"><br />
			// <input type="submit" name="submit">
			// </form>
			// </td>
			// </tr>
			// </table>
			//
			//
			// <%
			// String c = (String)session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			// String parm = (String) request.getParameter("kaptchafield");
			//
			// out.println("Parameter: " + parm + " ? Session Key: " + c + " : ");
			//
			// if (c != null && parm != null) {
			// if (c.equals(parm)) {
			// out.println("<b>true</b>");
			// } else {
			// out.println("<b>false</b>");
			// }
			// }
			// %>
			//
			// </body>

		}

		web點xml: {

			//
			// <servlet>
			// <servlet-name>Kaptcha</servlet-name>
			// <servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
			// <!-- 是否要有邊框 -->
			// <init-param>
			// <param-name>kaptcha.border</param-name>
			// <param-value>yes</param-value>
			// </init-param>
			//
			// <!-- 字體顏色 -->
			// <init-param>
			// <param-name>kaptcha.textproducer.font.color</param-name>
			// <param-value>black</param-value>
			// </init-param>
			// <!-- 驗證碼與驗證碼的間隙 -->
			// <init-param>
			// <param-name>kaptcha.textproducer.char.space</param-name>
			// <param-value>5</param-value>
			// </init-param>
			//
			// <!-- 背景顏色開始點 -->
			// <init-param>
			// <param-name>kaptcha.background.clear.from</param-name>
			// <param-value>100,150,250</param-value>
			// </init-param>
			//
			// <!-- 背景顏色結束點 -->
			// <init-param>
			// <param-name>kaptcha.background.clear.to</param-name>
			// <param-value>250,150,100</param-value>
			// </init-param>
			//
			// </servlet>
			//
			// <servlet-mapping>
			// <servlet-name>Kaptcha</servlet-name>
			// <url-pattern>/Kaptcha.jpg</url-pattern>
			// </servlet-mapping>
			//
			// <welcome-file-list>
			// <welcome-file>KaptchaExample.jsp</welcome-file>
			// </welcome-file-list>
			//

		}

	}

	public void $2() throws IOException {
		String captcha = "09875";

		int width = 55;
		int height = 20;
		Color fontColor = new Color(36, 85, 92); /* 文字顏色 */
		Color lineColor = new Color(65, 161, 175); /* 線條顏色 */
		Color bgColor = new Color(208, 226, 229); /* 底色 */

		Random random = new Random();
		random.setSeed(System.currentTimeMillis());

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();

		/* 底色 */
		g.setColor(bgColor);
		g.fillRect(0, 0, width, height);

		/* 畫線 */
		g.setColor(lineColor);
		for (int i = 0; i < 20; i++) {
			g.drawLine(random.nextInt(width), 0, random.nextInt(width), height);
		}

		/* 畫出文字 */
		g.setFont(new Font("Atlantic Inline", Font.BOLD, 20));
		g.setColor(fontColor);
		g.drawString(captcha, 0, 18);

		/* 畫線 */
		g.setColor(lineColor);
		for (int i = 0; i < 4; i++) {
			g.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		}

		g.dispose();

		ImageIO.write(image, "png", new File("z:/002captcha_image.png"));

	}

}

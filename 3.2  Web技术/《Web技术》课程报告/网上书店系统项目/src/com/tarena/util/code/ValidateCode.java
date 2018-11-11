package com.tarena.util.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.tarena.web.action.BaseAction;

public class ValidateCode extends BaseAction{

	// 图片宽
	private static int WIDTH = 100;

	// 图片高
	private static int HEIGHT = 30;

	// 验证码数量
	private static int NUM = 4;

	// 干扰线数量
	private static int line = 4;

	private static char[] seq = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9' };

	/**
	 * 生成随机的验证码
	 * 
	 * @return
	 * @throws Exception
	 */
	private byte[] generator(Map<String, Object> session) throws Exception {
		Random r = new Random();

		// 图片的内存映像
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);

		// 获得画笔对象
		Graphics g = image.getGraphics();
		g.setColor(new Color(255,255,255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);

		// 用于存储随机生成的验证码
		StringBuffer number = new StringBuffer();

		// 绘制验证码
		for (int i = 0; i < NUM; i++) {
			g.setColor(randomColor(r));
			int h = (int) ((HEIGHT * 70 / 100) * r.nextDouble() + (HEIGHT * 40 / 100));
			g.setFont(new Font(null, Font.BOLD, h));
			String ch = String.valueOf(seq[r.nextInt(seq.length)]);
			number.append(ch);
			g.drawString(ch, i * WIDTH / NUM * 90 / 100, h);
		}
		session.put("validate_code_session", number.toString());
		// 绘制干扰线
		for (int i = 0; i <= line; i++) {
			g.setColor(randomColor(r));
			g.drawLine(r.nextInt(WIDTH), r.nextInt(HEIGHT), r.nextInt(WIDTH), r
					.nextInt(HEIGHT));

		}

		// 压缩成jpeg格式
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);

		// 把BufferedImage对象中的图像信息编码后
		// 向创建该对象(encoder)时指定的输出流输出
		encoder.encode(image);
		session.put("imageCode", number.toString());
		return os.toByteArray();
	}

	private Color randomColor(Random r) {
		return new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));

	}

	// 获取验证码
	public InputStream getCode(Map<String, Object> session) throws Exception {
		return new ByteArrayInputStream(generator(session));
	}

}

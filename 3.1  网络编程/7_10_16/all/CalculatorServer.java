/**
 * 单客户单服务器（SCSS）程序之服务器端。
 * 客户端发出请求来后，接收并转换成整形，然后服务器运算后返回结果给客户端。
 * 
 * @author (htc) 
 * @version (2013-10-14)
 */

import java.io.*;
import java.net.*;

public class CalculatorServer {
	public static void main(String[] args) {
		try {
			ServerSocket socket = new ServerSocket(10005);
			Socket server = socket.accept();
			DataInputStream in = new DataInputStream(server.getInputStream());
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			while (true) {
				int num1 = in.readInt();  //读取四个输入字节并返回一个 int 值。
				int num2 = in.readInt();
				char op = in.readChar();  //读取两个输入字节并返回一个 char 值。
				int result = calculator(num1, num2, op);
				out.writeInt(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int calculator(int num1, int num2, char op) {
		switch (op) 
		{
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default:
			break;
		}
		return 0;
	}

}
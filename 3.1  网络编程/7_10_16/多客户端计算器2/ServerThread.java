
/**
 * 一个线程类，为一个套接字提供通信工作
 * 
 * @author (htc) 
 * @version (2013-10-15)
 */
import java.net.*;
import java.io.*;
import java.awt.*;  //抽象窗口工具包
import javax.swing.*;  //Swing包

public class ServerThread extends Thread   
{
    private Socket toClient;       //该参数需要由构造函数初始化，并在run方法中调用（关键该socket），因此必须定义为全局属性
    private JTextArea msgArea = new JTextArea(15, 50);
    private DataInputStream in;  //定义输入输出流，在本例中，在构造函数中初始化，在run方法中调用，需要定义为属性
    private DataOutputStream out;  //若不定义为属性，则只能在run方法中定义、初始化并调用

    /**
     * 构造函数，参数为一个socket，初始化与该socket关联的输入输出流，当然也可以在run方法中处理
     */
    public ServerThread(Socket socket) throws IOException  //初始化输入输出流可能会产生IO异常
    {
        toClient = socket;
        in = new DataInputStream(toClient.getInputStream());  //初始化输入输出流，用于数据收发
        out = new DataOutputStream(toClient.getOutputStream());
    }

    /**
     * 重写run方法，在其中完成服务器针对一个客户端的收发工作，因为没有数据共享的问题，不需要考虑同步问题
     */
    public void run()
    {
        try
        {
            System.out.println("连接请求来自：" + toClient.getInetAddress());  //显示连接的客户信息
            
            while (true) {
				int num1 = in.readInt();  //读取四个输入字节并返回一个 int 值。
				int num2 = in.readInt();
				char op = in.readChar();  //读取两个输入字节并返回一个 char 值。
				int result = calculator(num1, num2, op);
				out.writeInt(result);
				System.out.println("IP为" + toClient.getInetAddress() + "的客户端请求运算：" + num1+  op + num2);  //显示记录处理过的任务。
                System.out.println("服务器返回运算结果为：" + result);
                msgArea.append("IP为" + toClient.getInetAddress() + "的客户端请求运算：" + num1+  op + num2 + "\n");  //显示本方发送的信息
            
			}
        }
        catch(Exception e)
        {
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

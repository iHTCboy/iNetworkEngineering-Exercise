/**
 * 单客户单服务器（SCSS）程序之客户端。
 * 在客户端输入2个操作数，然后选择一个命令（+、-、*、/），在请求服务器端，再接收服务器运算后返回的结果，并显示。
 * 
 * @author (htc) 
 * @version (2013-10-14)
 */

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorClient extends JFrame 
{
	public static void main(String[] args) 
	{
		new CalculatorClient();
	}

	private JTextField inputField1 = new JTextField(6);  //JTextField(int columns)构造一个具有指定列数的新的空 TextField。
	private JTextField inputField2 = new JTextField(6);
	private JTextField resultField = new JTextField(6);

	private DataInputStream in;//接收数据流
	private DataOutputStream out; //发送数据流

	public CalculatorClient() 
	{
		setTitle("Calculator of Client");
	    this.setSize(420, 250);
		JPanel panel = new JPanel();  //使用默认的布局管理器创建新面板。所有面板的默认布局管理器都是 FlowLayout 类。流布局用于安排有向流中的组件，这非常类似于段落中的文本行。流的方向取决于容器的 componentOrientation 属性， 
		panel.add(new JLabel("num1"));
		panel.add(inputField1);
		panel.add(new JLabel("num2"));
		panel.add(inputField2);
		panel.add(new JLabel("result"));
		panel.add(resultField);
		this.add(panel);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 2));  //GridLayout类是一个布局处理器，它以矩形网格形式对容器的组件进行布置。容器被分成大小相等的矩形，一个矩形中放置一个组件。
		panel2.add(createButton('+'));
		panel2.add(createButton('-'));
		panel2.add(createButton('*'));
		panel2.add(createButton('/'));
		this.add(panel2, BorderLayout.SOUTH);  //这是一个布置容器的边框布局，它可以对容器组件进行安排，并调整其大小，使其符合下列五个区域：北、南、东、西、中。每个区域最多只能包含一个组件，并通过相应的常量进行标识：NORTH、SOUTH、EAST、WEST、CENTER。
	    this.setVisible(true);
	    
		try {
            int port = 10005;  //端口号，由服务端决定
            Socket client = new Socket("localhost",port);  //创建套接字，端口号必须与服务器端一致；创建成功后，会自动与服务器端进行连接
            
            //创建输入输出流，用于发送与接收数据
            in = new DataInputStream(client.getInputStream()); //接收数据流
            out = new DataOutputStream(client.getOutputStream()); //发送数据流
        }
        catch(Exception e1)   //在网络通信过程中可能会产生很多异常，这里简单化了异常处理，在真正的应用软件中是不合适的。
        {
            e1.printStackTrace();
        }
	}

	private JButton createButton(char c)    //JButton "push" 按钮的实现。 通过 Action 可配置按钮，并进行一定程度的控制。将 Action 用于按钮具有许多直接配置按钮所不及的优点。
	{
		JButton button = new JButton(String.valueOf(c));    //创建一个带文本（+、-、*、/）的按钮。  valueOf(char c) 返回char参数的字符串表示形式。
		button.addActionListener(new ActionListener()      //实现ActionListener接口,实现actionPerformed方法, 给按钮添加事件监听 addActionListener(this); 或者 addActionListener(new ActionListener(){ public void actionPerformed(ActionEvent e) { } });
		{
			public void actionPerformed(ActionEvent e)     // 发生操作时调用。
			{
				int num1 = Integer.parseInt(inputField1.getText());//  Integer.parseInt(String s) 将字符串参数作为有符号的十进制整数进行解析。
				int num2 = Integer.parseInt(inputField2.getText());
				char op = e.getActionCommand().charAt(0);     //返回的是当前动作指向对象的名称
				try {
					out.writeInt(num1);   //将一个 int 值写入输出流，该值由四个字节组成。
					out.writeInt(num2);
					out.writeChar(op);    //将一个 char 值写入输出流，该值由两个字节组成。
					int result = in.readInt();//读取两个输入字节并返回一个 char 值。
					resultField.setText(String.valueOf(result));//setText(String t)将此文本组件显示的文本设置为指定文本。valueOf(char c)返回char参数的字符串表示形式
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		return button;
	}

}
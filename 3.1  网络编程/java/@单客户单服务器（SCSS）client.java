
/**
 * 单客户单服务器（SCSS）且收发有序示例程序之客户端。
 * 客户端主动请求服务器端，接收到欢迎信息后，发送radius值，再接收服务器发回的面积值，显示后中断通信，关闭程序。
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //端口号，由服务端决定
            
            Socket client = new Socket("localhost",port);  //创建套接字，端口号必须与服务器端一致；创建成功后，会自动与服务器端进行连接
            
            //创建输入输出流，用于发送与接收数据
            DataInputStream in = new DataInputStream(client.getInputStream()); //接收数据流
            DataOutputStream out = new DataOutputStream(client.getOutputStream()); //发送数据流
            
            String str = in.readUTF(); //等待接收信息，在接收到信息前，实际上处理阻塞状态
            System.out.println(str);  //显示该信息
            
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入半径（实数）： ");
            double radius = scan.nextDouble();  //读取输入值
            out.writeUTF("" + radius);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
            out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。
            
            str = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
            System.out.println("半径为" + radius + "的圆的面积为：" + str);
            
            in.close();  //关闭输入输出流，应在关闭socket之前
            out.close();
            
            client.close();  //关闭连接
            System.out.println("程序终止");
        }
        catch(Exception e)   //在网络通信过程中可能会产生很多异常，这里简单化了异常处理，在真正的应用软件中是不合适的。
        {
            e.printStackTrace();
        }
    }
}

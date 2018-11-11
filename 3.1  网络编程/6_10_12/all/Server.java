
/**
 * Write a description of class Server here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //端口号，客户与服务器端要一致，其值要求在1025－65535之间，且要求本机没有在该端口运行的程序
            
            ServerSocket serverSocket = new ServerSocket(port);  //创建服务器套接字
            System.out.println("等待连接...");
            
            while (true)  //理论上服务器端不会终止，可通过强行关闭程序的方式终止程序
            {
                Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求; 程序将在此之后阻塞，直到有客户连接上来           
                System.out.println("连接请求来自：" + toClient.getInetAddress());  //显示连接的客户信息
            
                //创建输入输出流，用于发送与接收数据
                DataInputStream in = new DataInputStream(toClient.getInputStream()); //接收数据流
                DataOutputStream out = new DataOutputStream(toClient.getOutputStream()); //发送数据流
                String number1 ="";
                String number2 ="";
                String mark ="";
            
                String str = "欢迎" + toClient.getInetAddress().getHostAddress();  //准备欢迎信息                
                out.writeUTF(number1);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
                out.writeUTF(number2);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
                out.writeUTF(mark);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
                out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。
            
                
               number1 = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
                double numberA = Double.parseDouble(number1);  //将字符串转换成实数，要求该字符串实际上代表一个实数
               number2 = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
                double numberB = Double.parseDouble(number2);  //将字符串转换成实数，要求该字符串实际上代表一个实数
               mark = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
                double markALL = Double.parseDouble(mark);  //将字符串转换成实数，要求该字符串实际上代表一个实数
                //double area = Math.PI * radius * radius;  //计算圆的面积
                out.writeUTF("" + numberA);
                out.flush();
            
            
                in.close();  //关闭输入输出流，应在关闭socket之前
                out.close();
            
                toClient.close();  //关闭连接Socket，必须在关闭serverSocket之前调用
            }
            
            //serverSocket.close();   //关连serverSocket
            //System.out.println("程序终止");
        }
        catch(Exception e)   //在网络通信过程中可能会产生很多异常，这里简单化了异常处理，在真正的应用软件中是不合适的。
        {
            e.printStackTrace();
        }
    }
}

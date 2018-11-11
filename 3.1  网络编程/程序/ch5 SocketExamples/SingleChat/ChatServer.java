
/**
 * 运行客户与服务器一对一聊天的示例程序之服务器端。没有提供GUI界面。
 * 服务器端必须先运行
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatServer
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //端口号，客户与服务器端要一致，其值要求在1025－65535之间，且要求本机没有在该端口运行的程序
            
            final ServerSocket serverSocket = new ServerSocket(port);  //创建服务器套接字
            System.out.println("等待连接...");
            
            final Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求; 程序将在此之后阻塞，直到有客户连接上来           
            System.out.println("连接请求来自：" + toClient.getInetAddress());  //显示连接的客户信息
            
            //创建输入输出流，用于发送与接收数据
            final DataInputStream in = new DataInputStream(toClient.getInputStream()); //接收数据流，定义为final，便于在内部类中使用
            final DataOutputStream out = new DataOutputStream(toClient.getOutputStream()); //发送数据流
            Scanner scan = new Scanner(System.in);
                       
            String str = "欢迎" + toClient.getInetAddress().getHostAddress() + "，请发言。";  //准备欢迎信息
            out.writeUTF(str);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
            out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。
           
            //用内部类的方式定义一个线程，用于接收并显示消息
            Thread t = new Thread(new Runnable()  //使用了内部类的方式，也不是必须的：可以将类本身作为一个线程，或者定义一个新的线程类。
            {
                public void run()
                {
                    try
                    {
                        while (true)
                        {
                            String str1 = in.readUTF();  //接收并显示数据
                            System.out.println("对方说： " + str1);                           
                            Thread.sleep(500);   //休息0.5S，给发送信息留下时间；实际上影响不大，因为不可能连续不断的接收数据的，中间本身就会有间隔
                            
                            if (str1.toLowerCase().contains("bye"))  //发送包含bye的信息后中断聊天
                            {
                                in.close();  //关闭输入输出流，应在关闭socket之前
                                out.close();
                                
                                toClient.close();  //关闭连接Socket，必须在关闭serverSocket之前调用
                                serverSocket.close();   //关连serverSocket
                                System.out.println("聊天结束，程序终止");
                                System.exit(0);                             
                            }
                        }

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            
            //处理消息发送
            while (true)
            {
                str = scan.next(); //接收用户从键盘输入的信息
                out.writeUTF(str);  //发送信息
                out.flush();
            }
           
        }
        catch(Exception e)   //在网络通信过程中可能会产生很多异常，这里简单化了异常处理，在真正的应用软件中是不合适的。
        {
            e.printStackTrace();
        }
    }
}

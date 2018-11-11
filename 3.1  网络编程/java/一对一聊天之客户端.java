
/**
 * 运行客户与服务器一对一聊天的示例程序之客户端。没有提供GUI界面。
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //端口号，由服务端决定
            
            final Socket client = new Socket("localhost",port);  //创建套接字，端口号必须与服务器端一致；创建成功后，会自动与服务器端进行连接
            System.out.println("发起连接...");   //因为Scanner在输入之前必须有输出信息
            
            //创建输入输出流，用于发送与接收数据
            final DataInputStream in = new DataInputStream(client.getInputStream()); //接收数据流
            final DataOutputStream out = new DataOutputStream(client.getOutputStream()); //发送数据流
            Scanner scan = new Scanner(System.in);
            
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
                                
                                client.close();  //关闭连接Socket
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
                String str = scan.next(); //接收用户从键盘输入的信息
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


/**
 * 单客户单服务器（SCSS）程序之服务器端。
 * 客户端发出请求来后，接收并转换成整形，然后服务器运算后返回结果给客户端。
 * 服务器端必须先运行
 * 服务器调用了线程类ServerThread，为每一个客户连接提供通信支持
 * 
 * @author (htc) 
 * @version (2013-10-15)
 */

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MultiServer  extends MultiServerGUI
{
   
        
            int port = 5500;  //端口号，客户与服务器端要一致，其值要求在1025－65535之间，且要求本机没有在该端口运行的程序
            
            ServerSocket serverSocket = new ServerSocket(port);  //创建服务器套接字
            //System.out.println("等待连接...");
            msgArea.append("等待连接...");  //显示本方发送的信息
            
            while (true)  //理论上服务器端不会终止，可通过强行关闭程序的方式终止程序
            {
                Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求; 程序将在此之后阻塞，直到有客户连接上来           
                
                Thread t = new ServerThread(toClient);  //为该连接创建一个线程；若有多个连接，则有多个线程运行
                t.start();   //启动线程

            }
            
            //serverSocket.close();   //关连serverSocket
            //System.out.println("程序终止");
      
  
}

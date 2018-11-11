import java.net.*;
import java.io.*;
public class MultiServerTest
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(5500);  //创建服务器套接字 
        while (true)  
        {
                final Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求           
                
                Thread t = new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            DataInputStream in = new DataInputStream(toClient.getInputStream()); 
                            DataOutputStream out = new DataOutputStream(toClient.getOutputStream());
                            System.out.println("连接请求来自：" + toClient.getInetAddress());  //显示连接的客户信息
                            String str = "欢迎" + toClient.getInetAddress().getHostAddress();  //准备欢迎信息
                            out.writeUTF(str);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
                            out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。 
                            str = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
                            double radius = Double.parseDouble(str);  //将字符串转换成实数，要求该字符串实际上代表一个实数
                            double area = Math.PI * radius * radius;  //计算圆的面积
                            out.writeUTF("" + area);
                            out.flush();
                            
                            in.close();  //关闭输入输出流，应在关闭socket之前
                            out.close();
                            toClient.close();  //关闭连接Socket，必须在关闭serverSocket之前调用
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                });  
                t.start();   //启动线程
        }
    }
}
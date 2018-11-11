
/**
 * 用NIO方式编写的一对一聊天功能的客户商。
 * 
 * @author (yhz) 
 * @version (2013-6-28)
 */
import java.nio.*;  //ByteBuffer在该包中
import java.nio.channels.*;  //SocketChannel, Selector
import java.io.*; //IOException在该包中
import java.net.*;  //Socket在该包中
import java.util.*;  //Iterator, Scanner在该包中

public class NIOClient
{
    private static final int BUF_LENGTH = 1024;
    private static final int PORT = 5500;   //服务器开放的端口号
    private static final String IP = "127.0.0.1";  //服务器的IP地址
    
    public NIOClient() throws IOException 
    {
        Selector selector = null;  //Selector负责监控接收连接就绪、读就绪、写就绪等事件
        if (selector == null) 
        {
            selector = Selector.open();  //打开通道选择器
        }
        
        SocketChannel sc = SocketChannel.open();  //打开客户端套接字通道
        sc.configureBlocking(false);  //将客户端套接字通道连接方式调整为非阻塞模式
        Socket clientSocket = sc.socket();  //获取与通道关联的套接字，各种事件本身要通过Socket来完成
        clientSocket.bind(null);   //绑定本地端口；不指定时由系统自动生成
        
        sc.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);  //向sel注册写就绪、读就绪、连接就绪事件
        
        while (true)
        {
            int nKeys = selector.select();  //返回就绪事件的数量
           
            if (nKeys > 0)  //有就绪事件
            {
                Iterator it = selector.selectedKeys().iterator();
                while (it.hasNext())   //扫描就绪事件
                {
                    SelectionKey key = (SelectionKey) it.next();  //提取就绪事件key值
                   
                    if (key.isConnectable() && !sc.isConnected())  //如果连接就绪且当前没有连接；一旦连接，在关闭之前会保持连接状态
                    {  
                        InetAddress addr = InetAddress.getByName(IP); 
                        //客户端套接字通道向服务端发起非阻塞连接 
                        boolean success = sc.connect(new InetSocketAddress(addr, PORT)); 
                        //如果客户端没有立即连接到服务端，则客户端完成非立即连接操作   
                        if (!success) 
                        {
                            sc.finishConnect(); 
                        }
                    }

                    if (key.isReadable())  //读就绪状态，进行读操作
                    {
                        readDataFromSocket(key);
                    }
                    
                    if (key.isWritable())  //写就绪状态，进行写操作
                    {
                        Scanner scan = new Scanner(System.in);
                        System.out.println("输入你想发送的信息：");
                        String str = scan.next();
                        writeDataFromSocket(key, str);
                    }

                    it.remove();  //移去该key值。在对Iterator进行循环操作的过程中，如果要删除其中的某个值，只能通过remove方法
                }
            }
        }

    }

    private ByteBuffer readDataFromSocket(SelectionKey key) throws IOException 
    {
        ByteBuffer buf = ByteBuffer.allocate(BUF_LENGTH);  //分配缓冲区
        SocketChannel sc = (SocketChannel) key.channel();  //获取Socket通道

        int readBytes = 0;
        int ret;

        while ((ret = sc.read(buf)) > 0) 
        {
            readBytes += ret;  //记录读取的字节数，在此函数中无实用
        }
       
        buf.flip(); //重围通道
        
        return buf;  //返回读取的内容
    }

    private void writeDataFromSocket(SelectionKey key, String str) throws IOException 
    {
        SocketChannel sc = (SocketChannel) key.channel();  //获取Socket通道
        
        ByteBuffer buf = ByteBuffer.wrap(str.getBytes());
        
        sc.write(buf);
    }
}


/**
 * 支持UDP的在后台接收数据的线程
 * 
 * @author (yhz) 
 * @version (2013-6-27)
 */

import java.io.*;   //文件操作包
import java.net.*;  //网络操作包
import javax.swing.*;  //Swing包

public class UDPReceiveThread extends Thread
{
    private JTextArea msgArea;  //用于显示接收的信息的区域
    private DatagramPacket receivePkt;  //用于接收的Packet
    private DatagramSocket receiveSocket;  //用于接收的Socket
    private static final int BUFSIZE = 1024;  //每次能够发送或接收的包的大小。UDP不会拆分包，所以发送包的大小的值不能太大（不宜超过1500字节）

    public UDPReceiveThread(JTextArea msgArea, int receivePort) //receivePort为需要监听的端口，即源端口
    {
        this.msgArea = msgArea;
        byte[] inBuf = new byte[BUFSIZE];
        receivePkt = new DatagramPacket(inBuf, inBuf.length);
        
        try
        {
            receiveSocket = new DatagramSocket(receivePort);
            setPriority(Thread.MIN_PRIORITY);  //设置线程的优先级为最低优先级
            start();  //启动线程
        }
        catch(SocketException e)
        {
            msgArea.append("无法连接到指定端口");
        }
    }
    
    public void run()
    {
        while (true)
        {
            try
            {
                receiveSocket.receive(receivePkt);  //接收包并放到receivePkt中
                //取出数据。receivePkt.getData()得到的是字节数组，需要转换成字符串
                String msg = new String(receivePkt.getData(), 0, receivePkt.getLength());
                msgArea.append("对方说：" + msg + "\n"); //显示数据
            }
            catch (IOException e)
            {
                msgArea.append("接收数据错误\n");
            }
        }
    }
}

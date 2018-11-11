
/**
 * 简单的基于UDP的一对一聊天程序，支持GUI。本类提供客户端端功能。
 * 
 * @author (YHZ) 
 * @version (2013-6-27)
 */

import java.io.*;   //文件操作包
import java.net.*;  //网络操作包
import java.awt.*;  //抽象窗口工具包
import java.awt.event.*;  //GUI事件处理包
import javax.swing.*;  //Swing包

public class UDPChatClient extends JFrame implements ActionListener  //继承JFrame，并实现ActionListener
{
    //以下是GUI相关的一些控件定义
    private JTextField rcvPortField = new JTextField("   5050   ");   //接收端口文本框
    private JTextField sendPortField = new JTextField("   6060   ");   //发送端口文本框
    private JTextField desIPField = new JTextField("         127.0.0.1        ");   //目的IP地址，字符串形式表示
    private JButton beginBtn = new JButton("开始");    //当点击此Button后，自动在后台接收数据，并可发送数据
    private JTextArea msgArea = new JTextArea(15, 50);  //用于显示消息的文本区域
    private JTextField sendField = new JTextField(50);   //用于填写要发送的信息的文本框
    private JButton sendBtn = new JButton("发送");    //点击后，发送出sendField中指定的文本
    
    //以下是一些相关属性的定义
    private int rcvPort;  //接收端口
    private int sendPort;  //发送端口
    private InetAddress IPAddress;   //IP地址
    private DatagramSocket sendSocket;  //用于发送的Socket，在启动“开始”按钮后初始化
    
    private static final int BUFSIZE = 1024;  //每次能够发送或接收的包的大小。UDP不会拆分包，所以发送包的大小的值不能太大（不宜超过1500字节）
    
    public UDPChatClient()
    {
        makeFrame();
    }
    
    //创建GUI窗口
    private void makeFrame()
    {
        setTitle("UDP Chat服务器端");
        
        //整体采用BorderLayout而布局，使用其中的North, Center及South
        JPanel northPanel = new JPanel(new FlowLayout());  //上方的Panel，设置为FlowLayout方式，包含端口、IP及beginBtn
        JScrollPane centerPane = new JScrollPane(msgArea);  //中间为一个支持滚动的文本区域
        JPanel southPanel = new JPanel(new FlowLayout());   //下方的Panel，设置为FlowLayout方式，包含sendField及sendBtn
        
        Container con = getContentPane();  //获取窗口内容区
        con.setLayout(new BorderLayout());  
        con.add(northPanel, BorderLayout.NORTH);
        con.add(centerPane, BorderLayout.CENTER);
        con.add(southPanel, BorderLayout.SOUTH);
        
        //处理northPanel
        northPanel.add(new JLabel("源端口号："));
        northPanel.add(rcvPortField);
        northPanel.add(new JLabel("目的端口号："));
        northPanel.add(sendPortField);    
        northPanel.add(new JLabel("目标IP："));
        northPanel.add(desIPField);
        northPanel.add(beginBtn);
        
        //处理southPanel
        southPanel.add(sendField);
        southPanel.add(sendBtn);
        
        //处理相关控件的特殊状态
        msgArea.setEditable(false);  //文本区域只能用于显示，不允许编辑
        msgArea.setLineWrap(true); //允许自动换行
        sendBtn.setEnabled(false);  //在beginBtn点击之前，不允许点击sendBtn
        
        //添加监听事件
        beginBtn.addActionListener(this);
        sendBtn.addActionListener(this);
        sendField.addActionListener(this);  //回车事件
        
        pack();   //使窗口紧凑排布
        setLocationRelativeTo(null);  //使窗口居中
        setVisible(true);  //使窗口可见
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == beginBtn)  //点击了"开始"按钮
        {            
            //获取指定的端口与IP地址信息
            rcvPort = Integer.parseInt(rcvPortField.getText().trim());
            sendPort = Integer.parseInt(sendPortField.getText().trim());
            try
            {
                IPAddress = InetAddress.getByName(desIPField.getText().trim());
            }
            catch (UnknownHostException exception)
            {
                msgArea.append("指定地址的主机不存在");
                return;  //不允许往后做，即不允许收发数据
            }

            try
            {
                sendSocket = new DatagramSocket();  //初始化，好处是只需要创建该对象一次；在点击“发送”后再创建也是可以的。
            }
            catch(SocketException exception)
            {
                msgArea.append("无法创建Socket");
                return;  //不允许往后做，即不允许收发数据
            }
            
            //启动接收并显示消息的线程
            new UDPReceiveThread(msgArea, rcvPort);
            
            //设置控制状态变化：不允许修改端口号及IP地址，不能再次“开始”，可以“发送”数据
            rcvPortField.setEditable(false);
            sendPortField.setEditable(false);
            desIPField.setEditable(false);
            beginBtn.setEnabled(false);
            sendBtn.setEnabled(true);                
            
        }
        if (e.getSource() == sendBtn || e.getSource() == sendField)   //点击了"发送"按钮
        {
            //发送数据
            sendMsg();
        }
    }
    
    private void sendMsg()
    {
        byte[] outBuf = sendField.getText().trim().getBytes();  //获取要发送的内容
        DatagramPacket sendPkt = new DatagramPacket(outBuf, outBuf.length, IPAddress, sendPort);  //准备要发送的包，每次都要指定目的IP地址及端口号
        try
        {
            sendSocket.send(sendPkt);  //发送数据
        }
        catch(IOException e)
        {
            msgArea.append("发送数据失败");
            return;
        }
        
        msgArea.append("我说：" + sendField.getText().trim() + "\n");  //显示本方发送的信息
        sendField.setText(null);  //将发送框置空
        
    }
}

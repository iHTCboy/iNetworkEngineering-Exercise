import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date; 
import java.text.SimpleDateFormat;

public class ChatServerGUI extends JFrame implements ActionListener
{
    private JTextArea infoArea = new JTextArea(10, 60);
    private JTextField msgField = new JTextField(50);
    private JButton sendBtn = new JButton("发送");
    private JButton connectBtn = new JButton("启动服务器");
    private DataInputStream in;
    private DataOutputStream out;
   
    public ChatServerGUI()
    {
        makeFrame();
    }
    
    public void makeFrame()
    {
        setTitle("服务器");
        
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        
        JScrollPane scrollPane = new JScrollPane(infoArea);
        JPanel bottomPanel = new JPanel(new FlowLayout());
        con.add(topPanel, BorderLayout.NORTH);
        con.add(scrollPane, BorderLayout.CENTER);
        con.add(bottomPanel, BorderLayout.SOUTH);
        
        topPanel.add(connectBtn);
        
        bottomPanel.add(msgField);
        bottomPanel.add(sendBtn);
        
        connectBtn.addActionListener(this);
        sendBtn.addActionListener(this);
        
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            if (e.getSource() == connectBtn) //连接
            {
            int port = 5500;  //端口号，客户与服务器端要一致，其值要求在1025－65535之间，且要求本机没有在该端口运行的程序
            final ServerSocket serverSocket = new ServerSocket(port);  //创建服务器套接字
            final Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求; 程序将在此之后阻塞，直到有客户连接上来           
            infoArea.append("连接请求来自：" + toClient.getInetAddress() +"\n");  //显示连接的客户信息
            
            //创建输入输出流，用于发送与接收数据
            in = new DataInputStream(toClient.getInputStream()); //接收数据流，定义为final，便于在内部类中使用
            out = new DataOutputStream(toClient.getOutputStream()); //发送数据流
            //Scanner scan = new Scanner(System.in);
                       
            String str = "欢迎" + toClient.getInetAddress().getHostAddress() + "，请发言。";  //准备欢迎信息
            out.writeUTF(str);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
            out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。
                
                Thread t = new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            while(true)
                            {
                             String str1 = in.readUTF();  //接收并显示数据
                             infoArea.append("对方说： " + str1+"\n");                           
                             Thread.sleep(500);   //休息0.5S，给发送信息留下时间；实际上影响不大，因为不可能连续不断的接收数据的，中间本身就会有间隔
                            }
                        }
                        catch(Exception ex)
                        {
                            System.out.println(ex);
                        }
                    }
                });
                t.start();
            }
            if (e.getSource() == sendBtn) //发送
            {
                String info = msgField.getText().trim();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//);//设置日期格式
                out.writeUTF("“"+info+ "”"+"   "+df.format(new Date()));
				infoArea.append(df.format(new Date())+ "\n");
                infoArea.append("我说：“"+ info +"”"+ "\n");
                out.flush();
            }
        }
        catch(Exception exce)
        {
            System.out.println(exce);
        }
        }
    }
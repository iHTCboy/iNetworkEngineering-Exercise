import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIChatClient extends JFrame implements ActionListener
{
    private JTextArea infoArea = new JTextArea(10, 60);
    private JTextField ipField = new JTextField("   127.0.0.1   ");
    private JTextField portField = new JTextField(" 5500 ");
    private JTextField msgField = new JTextField(50);
    private JButton sendBtn = new JButton("发送");
    private JButton connectBtn = new JButton("连接");
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    
    public GUIChatClient()
    {
        makeFrame();
    }
    
    public void makeFrame()
    {
        setTitle("客户端");
        
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new FlowLayout());
        
        JScrollPane scrollPane = new JScrollPane(infoArea);
        JPanel bottomPanel = new JPanel(new FlowLayout());
        con.add(topPanel, BorderLayout.NORTH);
        con.add(scrollPane, BorderLayout.CENTER);
        con.add(bottomPanel, BorderLayout.SOUTH);
        
        topPanel.add(new JLabel("IP地址:"));        
        topPanel.add(ipField);
        topPanel.add(new JLabel("端口号："));       
        topPanel.add(portField);
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
                int port = Integer.parseInt(portField.getText().trim());
                socket = new Socket(ipField.getText().trim(), port);
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                
                Thread t = new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            while(true)
                            {
                                String data = in.readUTF();
                                infoArea.append("对方说：" + data + "\n");
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
                out.writeUTF(info);
                infoArea.append(info + "\n");
                
            }
        }
        catch(Exception exce)
        {
            System.out.println(exce);
        }
    }
}

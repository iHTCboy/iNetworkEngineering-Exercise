import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiServerGUI extends JFrame 
{
   public JTextArea msgArea = new JTextArea(15, 50);  //用于显示消息的文本区域
  //  private MultiServer multiServer;
        public MultiServerGUI()
    {
        setTitle("云计算器服务器端");
        
        makeFrame();
        
        multiServer =new  MultiServer();
       
    }
    
    private void makeFrame()
    {
       
        
        //整体采用BorderLayout而布局，使用其中的North, Center及South
        JPanel northPanel = new JPanel(new FlowLayout());  //上方的Panel，设置为FlowLayout方式，包含端口、IP及beginBtn
        JScrollPane centerPane = new JScrollPane(msgArea);  //中间为一个支持滚动的文本区域
       
        Container con = getContentPane();  //获取窗口内容区
        con.setLayout(new BorderLayout());  
        con.add(northPanel, BorderLayout.NORTH);
        con.add(centerPane, BorderLayout.CENTER);
  
        
        //处理northPanel
        northPanel.add(new JLabel("云记录"));

        
       //处理相关控件的特殊状态
        msgArea.setEditable(false);  //文本区域只能用于显示，不允许编辑
        msgArea.setLineWrap(true); //允许自动换行

                
        pack();   //使窗口紧凑排布
        setLocationRelativeTo(null);  //使窗口居中
        setVisible(true);  //使窗口可见
        
     }
 }

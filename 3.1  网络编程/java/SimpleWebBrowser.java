/*
*利用URL类和JEditorPane类实现的一个非常简单的浏览器，支持超链接
*
* @author (yhz) 
* @version (2013-8-5)
*/
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;  //类HyperlinkListener用到
import java.io.*; 
import java.net.*; 
import java.util.*; 

//实现HyperlinkListener接口，用于响应用户点击超链接事件
public class SimpleWebBrowser extends JFrame implements HyperlinkListener, ActionListener
{ 
    private JTextField urlField = new JTextField(50); //地址栏
    private JEditorPane contentEditor = new JEditorPane();//网页框
  
    /**
    **构造函数
    **初始化图形用户界面
    */
    public SimpleWebBrowser()
    {
        
        setTitle("简单的网页浏览器");  //设置标题
        Container con = getContentPane();  //获取窗口区域
        con.setLayout(new BorderLayout());  //设置窗口的布局为BorderLayout，取上方及中间。     
       
        JPanel topPanel = new JPanel(new FlowLayout());  //窗口上方，用于放提示信息及地址栏，采用FlowLayout布局
        topPanel.add(new JLabel("输入URL地址"));
        topPanel.add(urlField);
        
        JScrollPane scrollPane = new JScrollPane (contentEditor); //为JEditorPanel加上滚动条
        contentEditor.setEditable(false);  //contentEditor不可编辑
        
        urlField.setText("http://202.193.80.32/Git/Index.asp");  //为方便测试
        
        con.add(topPanel, BorderLayout.NORTH);
        con.add (scrollPane, BorderLayout.CENTER);
                
        contentEditor.addHyperlinkListener(this); //为contentEditor添加事件侦听
        urlField.addActionListener(this);  //响应当焦点在urlField时按下回车键事件

        Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();  //获取窗口大小　
        setSize(scrSize); //设置窗口大小，占满整个屏幕
        setVisible(true);

    }
    
    /**
    **实现监听器接口的actionPerformed函数，当焦点在urlField时按下回车键后，调用此方法
    */
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            URL url = new URL(urlField.getText().trim()); //根据用户输入的地址构造URL对象
            contentEditor.setPage(url);  //获取并显示网页内容，相关工作由setPage方法自动完成
        }
        catch (MalformedURLException ex)
        {
            System.out.println(ex);
        }
        catch (IOException ex1)
        {
            System.out.println(ex1);
        }        
    }
      
    /**
    **实现监听器接口的hyperlinkUpdate函数,当用户点击网页上的链接时，调用些方法
    */
    public void hyperlinkUpdate (HyperlinkEvent e) 
    { 
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)  //用户点击超链接事件
        {
            try
            {
                URL url = e.getURL();  //获取用户点击的URL
                contentEditor.setPage(url);  //打开新页面
                urlField.setText(url.toString());  //更新地址栏
            }
            catch (MalformedURLException ex)
            {
                System.out.println(ex);
            }
            catch (IOException ex1)
            {
                System.out.println(ex1);
            }
        }

    } 

}
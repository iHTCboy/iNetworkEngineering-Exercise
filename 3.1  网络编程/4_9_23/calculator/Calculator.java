import java.awt.*;       
import java.awt.event.*;
import javax.swing.*;    //引入所需要的包
class MyFrame extends JFrame implements ActionListener{   
 private JButton b1,b2,b3,b4,b5,b6;
 private TextField t1,t2,t3;     //定义六个按钮和三个文本域
 public MyFrame(String s){
  super(s);
  b1=new JButton("加");
  b2=new JButton("减");
  b3=new JButton("乘");
  b4=new JButton("除");
       //对按钮加文字标签
 Panel p=new Panel();    //生成一个面板
  p.setLayout(new FlowLayout());  //以FlowLayout来规划面板中的组件
  t1=new TextField ("",4);
  t2=new TextField("",4);
  t3=new TextField("",4);    //生成文本域并设置长度
 p.add(new JLabel("Num1"));p.add(t1);
 p.add(new JLabel("Num2"));p.add(t2); 
 p.add(new JLabel("Res"));p.add(t3);//顺次在面板中加入按钮和文本域
 t3.setEditable(false);   //设置t3不可编辑
 Panel button=new Panel();
 button.setLayout(new GridLayout(2,2));//以两行2列来布局button面板中的各组件
 button.add(b1);button.add(b2);button.add(b3);
 button.add(b4);  
   getContentPane().add(button,BorderLayout.SOUTH);
   getContentPane().add(p,BorderLayout.NORTH);
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this); 
  //注册事件监听器
} 

   public void  actionPerformed(ActionEvent e){   //实现接口方法
    double number1=Double.parseDouble(t1.getText());
    double number2=Double.parseDouble(t2.getText());//得到文本域中的数字字符串调用parseDouble（）函数转化为数值型数字
    if(e.getSource()==b1)
    {
     double result=number1+number2;
     t3.setText(String.valueOf(result));//实现+
        }
    if(e.getSource()==b2)
    {
     double result=number1-number2;
     t3.setText(String.valueOf(result));//实现-
    }
    if(e.getSource()==b3)
    {
     double result=number1*number2;    //实现*
     t3.setText(String.valueOf(result));
    }
    if(e.getSource()==b4)                 //实现/
    {
     double result=number1/number2;
     t3.setText(String.valueOf(result));
    }
   
   }
   }
public class Calculator{   
    public static void main(String[] args){ 
        MyFrame frm=new MyFrame("Welcome to my calculator");    //设置标题    
  frm.setSize(320,240);      //设置大小
    frm. setVisible(true);//可见
}
 }  

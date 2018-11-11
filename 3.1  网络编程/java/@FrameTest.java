import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class FrameTest extends JFrame implements ActionListener
{
    private JButton colorBtn = new JButton("¸Ä±äÑÕÉ«");
    private int hitTimes = 0;
    public FrameTest()
    {
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(colorBtn);
        colorBtn.addActionListener(this);
        setSize(150,160);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (hitTimes == 1)
        {
            getContentPane().setBackground(Color.RED);
            hitTimes = 0;
        }
        else if (hitTimes == 0)
        {
            getContentPane().setBackground(Color.GRAY);
            hitTimes = 1;
        }
    }    
}

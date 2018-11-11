
/**
 * a GUI for a small guess data game.
 * 
 * @author (yhz) 
 * @version (2009-01-11)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuessGameGUI extends JFrame implements ActionListener
{
    private String[] btnStrings = {"1","2","3","4","5","6","7","8","9","0","RESET","Quit"};
    private JButton[] btns = new JButton[btnStrings.length];
    private GuessData guessGame;
    private int[] hasGuessData = new int[4];
    private int hasGuessNum = 0;

    /**
     * Constructor 
     */
    public GuessGameGUI()
    {
        setTitle("Guess data game");
        
        makeFrame();
        
        guessGame = new GuessData();
        
        pack();
        setVisible(true);
    }
    
    private void makeFrame()
    {
        Container ctn = getContentPane();
        ctn.setLayout(new GridLayout(4,3));
        
        for (int i = 0; i < btnStrings.length; i++)
        {
            btns[i] = new JButton(btnStrings[i]);
            ctn.add(btns[i]);
            btns[i].addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btns[10]) // reset button
        {
            hasGuessNum = 0;
            guessGame = new GuessData();  //renew the initialData
        }
        else if (e.getSource() == btns[11]) // quit button
        {
            System.exit(0);
        }
        else 
        {
            JButton tempBtn = (JButton) (e.getSource());
            int tempInt = Integer.parseInt(tempBtn.getText().trim());
            hasGuessData[hasGuessNum ++] = tempInt;
            if (hasGuessNum == 4)
            {
                guessGame.setGuessData(hasGuessData);
                String result =  guessGame.compare();
                
                JOptionPane.showMessageDialog(this, result);
                if (result.length() != 4)  //guess right
                {
                    System.exit(0);
                }
                else 
                {
                    hasGuessNum = 0;
                }                   
            }
        }
    }
    
}

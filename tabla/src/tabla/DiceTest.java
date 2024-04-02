/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author ratch
 */
public class DiceTest implements ActionListener
{
    JButton button;
    Dice zar;
    Dice zar2;
    int index;
    
    public DiceTest () throws IOException
    {
        JFrame frame = new JFrame();
        
        frame = new JFrame("dice");
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        zar = new Dice();
        zar.setLocation(50, 50);
        zar.changeImage(2);
        
        zar2 = new Dice();
        zar2.setLocation(250, 50);
        zar2.changeImage(2);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setLocation(0, 0);
        panel.setSize(500, 500);
        
        
        panel.add(zar);
        panel.add(zar2);
        
        
         button = new  JButton();
         button.setSize(50, 20);
         button.setLocation(100, 300);
         button.addActionListener(this);
         panel.add(button);
         
        
        //panel.add(obj.label2);
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
    
    public static void main(String[] args) throws IOException
    {
         new DiceTest();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Random rand = new Random();
        if (e.getSource() == button)
        {
            System.out.println("OPA");
            try {
                zar.Roll();
                //zar2.Roll();
            } catch (InterruptedException ex) {
                Logger.getLogger(DiceTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DiceTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

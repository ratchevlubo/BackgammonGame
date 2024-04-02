
package tabla;

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
        
public class Frame extends JFrame
{
    //private int width = 800 - 150;
    //private int height = 1200 - 300;
    
    private int width;
    private int height;
    
    private String title = "Tabla";
    
    private ImageIcon icon = new ImageIcon("src\\ball_sorter\\icon.png");
            
    public Frame()
    {
        setTitle(title);
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.CYAN);
        //setLocationRelativeTo(null);
        setSize(800, 1200);
        
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        

        setVisible(true);
        
        width = getWidth();
        height = getHeight();
        
        MainPanel g = new MainPanel(0, 0, width, height);
        add(g);
        
        revalidate();
        repaint();
        
        System.out.println(getWidth() + ", " + getHeight());

    }
}
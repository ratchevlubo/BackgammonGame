package tabla;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel implements ActionListener
{
    private int width;
    private int height;
    
    private Color background = new Color(128, 28, 28);
    
    private JButton btnExit;
    
    public MainPanel (int x, int y, int width, int height)
    {
        this.width = width;
        this.height = height;
        

        setLayout(null);
        setLocation(x, y);
        setSize(width, height);
        setBackground(background);
        System.out.println(width + ", " + height);
        
        initComponents();
    }
    
    private void initComponents ()
    {
        int bwidth = width*4/5;
        int bheight = height*4/5;
        Board b = new Board(width/2 - bwidth/2, height/2 - bheight/2, bwidth, bheight);
        add(b);
        
        btnExit = new JButton("EXIT");
        btnExit.setSize(100, 50);
        btnExit.setLocation(80, 80);
        btnExit.addActionListener(this);
        add(btnExit);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnExit)
        {
            System.exit(0);
        }
    }
}

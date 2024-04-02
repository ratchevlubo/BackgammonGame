package tabla;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener, MouseListener
{
    private int x;
    private int y;
    private int width;
    private int height;
    
    private Color background = new Color(28, 28, 255);
    
    private JLabel board = new JLabel();
    
    private Pole selected;
    
    private Pole poleta[];
    
    public Board (int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        setLayout(null);
        setLocation(x, y);
        setSize(width, height);
        setBackground(background);
        
        board.setLocation(width/2 - 800/2, height/2 - 800/2);
        board.setSize(800, 800);
        board.setIcon(new ImageIcon("C:\\Users\\ratch\\Desktop\\tabla_daska.png"));
        add(board);

        
        startGame();
       
    }
    
    public void startGame ()
    {
        poleta = new Pole[24];
        for (int i = 0; i < 6; i++) {
            poleta[5-i] = new Pole(800/2 - 50 - 50 + 22 - 61*(i), 0, 60, 400, false);
            board.add(poleta[5-i]);
            poleta[5-i].addMouseListener(this);
        }
        
        for (int i = 6; i < 12; i++) {
            poleta[i] = new Pole(800/2 + 48 - 30 + 61*(i-6), 0, 60, 400, false);
            board.add(poleta[i]);
            poleta[i].addMouseListener(this);
        }
        
        for (int i = 12; i < 18; i++) {
            poleta[29-i] = new Pole(800/2 - 50 - 50 + 22 - 61*(i-12), 400, 60, 400, true);
            board.add(poleta[29-i]);
            poleta[29-i].addMouseListener(this);
        }
        
        for (int i = 18; i < 24; i++) {
            poleta[i] = new Pole(800/2 + 48 - 30 + 61*(i-18), 400, 60, 400, true);
            board.add(poleta[i]);
            poleta[i].addMouseListener(this);
        }
        
        Pull pull[] = new Pull[30];
        for (int i = 0; i < 5; i++)
        {
            pull[i] = new Pull(0);
            poleta[0].addPull(pull[i]);
        }
        
        for (int i = 5; i < 7; i++)
        {
            pull[i] = new Pull(0);
            poleta[11].addPull(pull[i]);
        }
        
        for (int i = 7; i < 10; i++)
        {
            pull[i] = new Pull(0);
            poleta[16].addPull(pull[i]);
        }
        
        for (int i = 10; i < 15; i++)
        {
            pull[i] = new Pull(0);
            poleta[18].addPull(pull[i]);
        }
        
        
        for (int i = 15; i < 20; i++)
        {
            pull[i] = new Pull(1);
            poleta[12].addPull(pull[i]);
        }
        
        for (int i = 20; i < 22; i++)
        {
            pull[i] = new Pull(1);
            poleta[23].addPull(pull[i]);
        }
        
        for (int i = 22; i < 25; i++)
        {
            pull[i] = new Pull(1);
            poleta[4].addPull(pull[i]);
        }
        
        for (int i = 25; i < 30; i++)
        {
            pull[i] = new Pull(1);
            poleta[6].addPull(pull[i]);
        }
    }
    
    @Override
    public void paintComponent(Graphics g)  
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setPaint(new Color(49, 16, 0, 20));
        //g2d.drawRect(100, 100, 300, 300);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (selected == null)
        {
            selected = (Pole)e.getSource();
            selected.select();
        }
        else
        {
            if (selected == (Pole)e.getSource())
            {
                selected.unselect();
                selected = null;
            }
            else
            {
                System.out.println("MOVE");
                selected.move((Pole)e.getSource());
                selected.unselect();
                selected = null;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }

}

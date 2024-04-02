package tabla;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Pole extends JLabel
{
    private ArrayList<Pull> pullove;
    private int x;
    private int y;
    private int width;
    private int height;
    private int pullSize;
    private boolean flipped;
    private boolean selected = false;
    private JLabel lblStatus = new JLabel();
    private ImageIcon stateSelected = new ImageIcon("C:\\Users\\ratch\\Desktop\\selected.png");
    private ImageIcon stateUnselected = new ImageIcon("C:\\Users\\ratch\\Desktop\\unselected.png");
    
    public Pole (int x, int y, int width, int height, boolean flipped)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.flipped = flipped;
        
        setSize(width, height);
        setLocation(x, y);
        setLayout(null);
        //setIcon(new ImageIcon("C:\\Users\\ratch\\Desktop\\60x800.png"));
        
        lblStatus.setSize(12, 12);
        if (flipped)
        {
            lblStatus.setLocation(width/2 - 6, height - 3 - 12);
        }
        else
        {
            lblStatus.setLocation(width/2 - 6, y + 3);
        }
        lblStatus.setIcon(stateUnselected);
        add(lblStatus);
        
        pullove = new ArrayList<>();
        pullSize = 55;
    }
    
    public void addPull (Pull pull)
    {
        add(pull);
        pullove.add(pull);
        if (flipped)
        {
            pull.setLocation(0 + (width-pullSize)/2, 0 + height - (pullove.size()-1) * pullSize - 17 - pullSize);
        }
        else
        {
            pull.setLocation(0 + (width-pullSize)/2, 0 + (pullove.size()-1) * pullSize + 17);
        }
    }
    
    public Pull removePull ()
    {
        if (pullove.size() > 0)
        {
            remove(pullove.get(pullove.size()-1));
            return pullove.remove(pullove.size()-1);
        }
        else
        {
            return null;
        }
    }
    
    public void show (Graphics2D g2d)
    {
        g2d.drawLine(x, y, x, y+height);
    }
    
    public void select ()
    {
        selected = true;
        lblStatus.setIcon(stateSelected);
    }
    
    public void unselect ()
    {
        selected = false;
        lblStatus.setIcon(stateUnselected);
    }
    
    public boolean isSelected ()
    {
        return selected;
    }
    
    public void move (Pole pole)
    {
        pole.add(removePull());
    }
    

    
}

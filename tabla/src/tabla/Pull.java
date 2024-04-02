package tabla;

import java.awt.*;
import javax.swing.*;

public class Pull extends JLabel
{
    private ImageIcon pullW = new ImageIcon("C:\\Users\\ratch\\Desktop\\pullW.png");
    private ImageIcon pullB = new ImageIcon("C:\\Users\\ratch\\Desktop\\pullB.png");
    
    public Pull (int type)
    {
        setSize(55, 55);
        if (type == 0)
        {
            setIcon(pullW);
        }
        else
        {
            setIcon(pullB);
        }
    }
}

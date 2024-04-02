package tabla;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dice extends JLabel
{
    private BufferedImage img;
    private int imgSize = 136;
    Timer timer;
    Timer timerEnd;
    Random rand = new Random();

    public Dice()
    {
        setSize(200, 200);

    }

    private BufferedImage grabImage(int index) throws IOException
    {
        BufferedImage image = ImageIO.read(new File("C:\\Users\\ratch\\Desktop\\zar.png"));
        BufferedImage img = image.getSubimage(index * imgSize, 0, imgSize, imgSize);     
        return img;
    }
    
    public void changeImage (int index) throws IOException
    {
        setIcon(new ImageIcon(grabImage(index)));
    }
    
    public void Roll() throws InterruptedException, IOException
    {
        System.out.println("Start");
        timer = new Timer();
        timer.schedule(new rolling(), 50);
        timerEnd = new Timer();
        timerEnd.schedule(new endRolling(), 2000);
        
    }

    class rolling extends TimerTask {
        public void run() {
            try {
                changeImage(rand.nextInt(6));
            } catch (IOException ex) {
                Logger.getLogger(Dice.class.getName()).log(Level.SEVERE, null, ex);
            }
            timer.cancel(); //Terminate the timer threa
            timer = new Timer();
            timer.schedule(new rolling(), 50);
        }
    }
    
    
    class endRolling extends TimerTask {
        public void run() {
            System.out.println("END");
            timer.cancel();
            timer.purge();
            timerEnd.cancel();
            timerEnd.purge();
        }
    }
}
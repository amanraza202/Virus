import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.AWTException;

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
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        virus v =  new virus();

        // while (true) 
        for (int i = 0; i < 10; i++)
        {
            v.popup();
            v.blockAll();

        }
        
    }
}
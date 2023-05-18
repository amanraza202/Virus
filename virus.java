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
    public void image(){
        JWindow window = new JWindow();
        String images[] = {"one.jpg","two.avif","three.jpg","VIRUS.jpg"};
        int n = (int)(Math.random()*3);
        String image = images[n]; 
        ImageIcon iconLogo = new ImageIcon(image);
        JLabel l = new JLabel(iconLogo,JLabel.CENTER);
        window.add(l);
        window.setSize(300,200);
        window.setLocation(Random.nextInt(width), Random.nextInt(height));
        window.setVisible(true);
    }
    public void popup(){
        JWindow window = new JWindow();
        JLabel l = new JLabel("You are Infected with Virus",JLabel.CENTER);
        window.add(l);
        window.setSize(300,200);
        window.setLocation(Random.nextInt(width), Random.nextInt(height));
        window.setVisible(true);
    }
    // public void close(){
    //     Runtime runtime = Runtime.getRuntime();
    //   try
    //   {
    //      System.out.println("Shutting down the PC after 20 seconds.");
    //      runtime.exec("shutdown -s -t 20");
    //   }
    //   catch(IOException e)
    //   {
    //      System.out.println("Exception: " +e);
    //   }
    // }
    public static void main(String[] args) throws AWTException, InterruptedException 
    {
        virus v =  new virus();
        Frame f = new Frame();
        f.setSize(500, 500);
        f.setTitle("Virus Warning");
        f.setVisible(true);
        f.setLayout(null);
        Button b = new Button("Close");
        b.setBounds(200, 200, 100, 30);
        f.add(b);

        Label l = new Label("Close this Application or your windows will be infected with virus");
        l.setBounds(100, 100, 400, 30);
        f.add(l);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                for (int i = 0; i < 10; i++)
                {
                    try {
                        v.blockAll();
                    } catch (AWTException e1) {
                        e1.printStackTrace();
                    }
                    v.popup();
                    v.image();
                }
                // v.close();
            }
        });
        
    }
}
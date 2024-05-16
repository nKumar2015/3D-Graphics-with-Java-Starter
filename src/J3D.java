import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class J3D extends JPanel{

    private static final int WIDTH = 1024;
    private static final int HEIGHT = 1024;
    private static final double ASPECT_RATIO = ((double) WIDTH)/HEIGHT;
    private static final int FOV = 90;

    private BufferedImage image;
    private Graphics g;
    private Timer timer;


    public J3D() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();


        timer = new Timer(10, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            clearScreen(g, Color.BLACK);
            
            repaint();
        }
    }

    public void clearScreen(Graphics g, Color c){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void drawTriangle(Graphics g, triangle t, boolean isWireframe){
        
    }

    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("3D");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new J3D());
        frame.setVisible(true);
    }

}



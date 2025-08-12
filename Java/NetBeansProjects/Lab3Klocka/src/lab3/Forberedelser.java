/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.awt.*;
import javax.swing.*;

public class Forberedelser {
    
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("An empty grey frame"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel myPanel = new MyPanel();
        myPanel.setPreferredSize(new Dimension(400,400));
        myPanel.setBackground(Color.RED);
        myPanel.setLayout(new BorderLayout());
        myPanel.add(new JLabel ("Alexander"),BorderLayout.CENTER);
        
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawLine(0,0,200,200);
        g.drawLine(400,400,0,0);
        g.drawLine(400,0,200,200);
        g.drawLine(0,400,200,200);
        g.drawOval(100,200,100,100);
        g.drawOval(300,100,50,50);
        g.setColor(Color.YELLOW);
        g.drawOval(200,300,70,70);
        g.setColor(Color.BLUE);
        g.fillOval(50,50, 100, 100);
    }
}

    
   /*public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();                
        panel.setBackground(Color.RED);     //Röda färgen försvinner
        frame.add(panel);
        
        JComponent component = new ChartComponent();
        frame.add(component);
        
        final int FRAME_WIDTH = 400;
        final int FRAME_HEIGHT = 400;
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame.pack();             Vad gör den här ens? Det funkar inte när den är med
        frame.setVisible(true);
    }
}

class ChartComponent extends JComponent{
    
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        //g.drawLine(100,100,200,200);
        
        /*g.drawLine(0,0,200,200);            //När man ritar strecken verkar det inte som om framen verkligen är 400x400 för strecken går inte till hörnen.
        g.drawLine(0,400,200,200);
        g.drawLine(400,0,200,200);
        g.drawLine(400,400,200,200);
        g.setColor(Color.green);
        g.fillOval(100,50,50,50);
        g.setColor(Color.blue);
        g.fillOval(200,150,120,120);
        g.setColor(Color.magenta);
        g.fillOval(150,250,80,80);
        g.setColor(Color.black);
        g.drawString("Alexander Sundquist", 250,350);
    }
}*/
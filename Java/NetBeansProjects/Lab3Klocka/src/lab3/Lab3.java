/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Calendar;
        
/**
 *
 * @author alexs
 */
public class Lab3 
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Klocka"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel myPanel = new MyPanel();
        myPanel.setPreferredSize(new Dimension(400,400));
        myPanel.setBackground(Color.red);
        
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);

        Timer t = new Timer(1000, myPanel);
        t.start();
    }
}

class MyPanel extends JPanel implements ActionListener
{
    int RADIUS = 160;
    int CENTER_COORDINATE = 200;
    int CLOCK_LINE_LENGTH = 30;
    int HAND_WIDTH = 8;
    int MINUT_HAND_LENGTH = 110;
    int HOUR_HAND_LENGTH = 60;
    int SECOND_HAND_WIDTH = 4;
    int SECOND_HAND_LENGTH = 110;
    double ANGLE_CHANGE = (Math.PI)/6; 
    
    @Override
    public void paintComponent(Graphics g)
    {
        String[] ArrayNumbers = new String[]{"6","5","4","3","2","1","12","11","10","9","8","7"}; 
        double angle = 0;
        for (int i =0; i<12; i++)
        {
            String number = ArrayNumbers[i];
            clockLine(g, angle, number);
            angle = angle + ANGLE_CHANGE;
        }
                
                
        /*for (double angle = 0; angle < 2*Math.PI; angle = angle + ANGLE_CHANGE)
        {
            clockLine(g, angle, number);   
        }*/
        
        g.setColor(Color.GREEN);
        g.drawOval(45,45,310,310);
      
        g.fillOval(190,190,20,20);
        
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(calendar.HOUR);
        int minute = calendar.get(calendar.MINUTE);
        int second = calendar.get(calendar.SECOND);
        
        double hourHandAngle = Math.PI - (2*(Math.PI)/12)*hour - ((2*(Math.PI)/60)*minute)/12 - ((2*(Math.PI)/60)*second)/(60*12);
        double minutHandAngle = Math.PI - (2*(Math.PI)/60)*minute - ((2*(Math.PI)/60)*second)/60;
        double secondHandAngle = Math.PI - (2*(Math.PI)/60)*second;
        
        g.setColor(Color.BLUE);
        clockHand(g, HAND_WIDTH, MINUT_HAND_LENGTH, minutHandAngle);
        g.setColor(Color.YELLOW);
        clockHand(g, HAND_WIDTH, HOUR_HAND_LENGTH, hourHandAngle);
        g.setColor(Color.ORANGE);
        clockHand(g, SECOND_HAND_WIDTH, SECOND_HAND_LENGTH, secondHandAngle);
    }
    
    void clockLine(Graphics g, double angle, String number)
    {
        double xEndCoordinate = Math.sin(angle)*RADIUS;
        double yEndCoordinate = Math.cos(angle)*RADIUS;     //Slutpunkter av linjen
            
        double xClockLineDifference = Math.sin(angle)*CLOCK_LINE_LENGTH;
        double yClockLineDifference = Math.cos(angle)*CLOCK_LINE_LENGTH;   //Skillnaden i x och y kordinater för start och slutpunkt
            
        double xStartCoordinate = xEndCoordinate - xClockLineDifference ;
        double yStartCoordinate = yEndCoordinate - yClockLineDifference ;
        
        
        g.drawString(number, CENTER_COORDINATE + (int) xStartCoordinate, CENTER_COORDINATE + (int) yStartCoordinate);
        
        
        /*Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(6f));
        Line2D line = new Line2D.Double(CENTER_COORDINATE + xStartCoordinate, CENTER_COORDINATE + yStartCoordinate, CENTER_COORDINATE +xEndCoordinate, CENTER_COORDINATE + yEndCoordinate);
        g2.draw(line);*/
    }
    
    void clockHand (Graphics g, int handWidth, int handLength, double handAngle)
    {
        double xEndCoordinate = Math.sin(handAngle)*handLength;
        double yEndCoordinate = Math.cos(handAngle)*handLength; 
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(handWidth));
        Line2D line = new Line2D.Double(CENTER_COORDINATE, CENTER_COORDINATE, CENTER_COORDINATE + xEndCoordinate, CENTER_COORDINATE + yEndCoordinate);
        g2.draw(line);
    } 
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        repaint();
    }
}



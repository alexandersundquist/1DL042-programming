/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
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
public class VerasKod {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("Klocka"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyPanel myPanel = new MyPanel();
        myPanel.setPreferredSize(new Dimension(400,400));
        myPanel.setBackground(Color.LIGHT_GRAY);
        
        frame.add(myPanel);
        frame.pack();
        frame.setVisible(true);
        
        Timer t = new Timer(1000, myPanel);
        t.start();
    }
}

class MyPanel extends JPanel implements ActionListener
{
    int RADIE = 200;
    int CLOCKLINE_LENGTH = 40;
    int CENTER_COORDINATES = 200;
    int CLOCKLINE_VISARE_MARGINAL = 18;
    double ANGLE_CHANGE = Math.PI/6;
    double TIM_VISARE_LENGTH = 100;
    double MINUT_VISARE_LENGTH = 160;
    double SEKUND_VISARE_LENGTH = 180;
    int TIM_VISARE_WIDTH = 9;
    int MINUT_VISARE_WIDTH = 6;
    int SEKUND_VISARE_WIDTH = 4;
    
    @Override
    public void paintComponent(Graphics g)
    {
        for (double angle = 0; angle < 2* Math.PI; angle = angle + ANGLE_CHANGE)
        {
            clockLine(g, angle);
        }
        
        Calendar calendar = Calendar.getInstance();
        int TIMME = calendar.get(Calendar.HOUR);
        int MINUT = calendar.get(Calendar.MINUTE);
        int SEKUND = calendar.get(Calendar.SECOND);
        
        System.out.println(TIMME);
        System.out.println(MINUT);
        System.out.println(SEKUND);
       
        double tim_visare_angle = Math.PI - ((Math.PI)/6)*TIMME - (((Math.PI)/30)*MINUT)/12 - ((Math.PI)/30)*SEKUND/60/12;
        double minut_visare_angle = Math.PI - ((Math.PI)/30)*MINUT - ((Math.PI)/30)*SEKUND/60;
        double sekund_visare_angle = Math.PI - ((Math.PI)/30)*SEKUND;
        
        clockVisare(g, TIM_VISARE_LENGTH, TIM_VISARE_WIDTH, tim_visare_angle);
        clockVisare(g, MINUT_VISARE_LENGTH, MINUT_VISARE_WIDTH, minut_visare_angle);
        clockVisare(g, SEKUND_VISARE_LENGTH, SEKUND_VISARE_WIDTH, sekund_visare_angle);
    }
    
    public void clockLine(Graphics g, double angle)
    {
            
        double xEndCoordinate = Math.sin(angle) * RADIE;
        double yEndCoordinate = Math.cos(angle) * RADIE;
                    
        double xCLockLineDifference = Math.sin(angle) * CLOCKLINE_LENGTH;
        double yCLockLineDifference = Math.cos(angle) * CLOCKLINE_LENGTH;
            
        double xStartCoordinate = xEndCoordinate - xCLockLineDifference;
        double yStartCoordinate = yEndCoordinate - yCLockLineDifference; 
        
         System.out.println("xkordinate" + xStartCoordinate + "ykordinat" + yStartCoordinate);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4f));
        Line2D line = new Line2D.Double(CENTER_COORDINATES + xStartCoordinate, CENTER_COORDINATES + yStartCoordinate,CENTER_COORDINATES + xEndCoordinate, CENTER_COORDINATES + yEndCoordinate);
        g2.draw(line);
    }
    
    public void clockVisare(Graphics g, double visare_length, int visare_width, double visare_angle)
    {
        double xEndCoordinate = Math.sin(visare_angle) * visare_length;
        double yEndCoordinate = Math.cos(visare_angle) * visare_length;
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(visare_width));
        Line2D line = new Line2D.Double(CENTER_COORDINATES,CENTER_COORDINATES, CENTER_COORDINATES + xEndCoordinate,CENTER_COORDINATES + yEndCoordinate);
        g2.draw(line);
    }
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        repaint();
    }
}






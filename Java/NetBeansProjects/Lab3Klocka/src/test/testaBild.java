/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author alexs
 */
public class testaBild {

    public static void main(String args[]) {
    JFrame frame = new JFrame();
    frame.setPreferredSize(new Dimension(400,400));
    ImageIcon icon = new ImageIcon("blomma.jpg");
    JLabel label = new JLabel(icon);
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

 }
}

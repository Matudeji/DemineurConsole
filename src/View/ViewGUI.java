/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Map;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class ViewGUI implements View {

    Map map;

    public ViewGUI(Map map) {
        this.map = map;
    }

    public void print() {
        JFrame frame = new JFrame("My first Frame in Java");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(map.getHeight(), map.getWidth(), 5, 5));

        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                JButton button = new JButton();
                try {
                  Image img = ImageIO.read(getClass().getResource("images/gaetane.jpg"));
                  button.setIcon(new ImageIcon(img));
                } catch (Exception ex) {
                  System.out.println(ex);
                }
                frame.add(button);
            }
        }

        frame.setSize(map.getWidth()*50, map.getHeight()*50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

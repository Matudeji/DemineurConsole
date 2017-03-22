/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Map;
import java.awt.GridLayout;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class GraphicalGridView extends JPanel {
    Map map;
    JFrame frame;
    GridLayout grid;
    
    GraphicalGridView(Map map, JFrame mainFrame) {
        this.map = map;
        this.frame = mainFrame;
        grid = new GridLayout(map.getHeight(), map.getWidth(), 5, 5);
        frame.setLayout(grid);
    }
    
    public void print() {
        
        //frame.removeAll();
        frame.setLayout(grid);
        
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                JButton button = new JButton();
                try {
                  Image img = ImageIO.read(getClass().getResource("images/gaetane.jpg"));
                  button.setIcon(new ImageIcon(img));
                  button.addActionListener(new ClickListener());
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

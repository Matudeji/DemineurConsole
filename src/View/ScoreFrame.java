/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class ScoreFrame extends JFrame{
    GridLayout gridLayout;
    JPanel panel;
    
    ScoreFrame() {
        super("Score");
        gridLayout = new GridLayout(5, 1);
        panel.setLayout(gridLayout);
        panel = new JPanel();
        this.add(panel);
        // exemple d'utilisation
        panel.add(new JLabel("le 16*16 en 17 sec!"));
    }
    
}

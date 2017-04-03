/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class CustomGameFrame extends JFrame{
        CustomGamePanel customGamePanel;

    public CustomGameFrame() {
        this.customGamePanel = new CustomGamePanel();
        this.add(customGamePanel);
        
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
        
    
}

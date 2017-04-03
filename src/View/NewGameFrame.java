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
public class NewGameFrame extends JFrame {
    NewGamePanel newGamePanel;
    
    NewGameFrame() {
        this.newGamePanel = new NewGamePanel();
        this.add(newGamePanel);
    }

    
}

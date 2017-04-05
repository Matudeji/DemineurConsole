/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import javax.swing.JFrame;

/**
 *
 * @author arthur
 */
public class NewGameFrame extends JFrame {
    NewGamePanel newGamePanel;
    
    NewGameFrame(Game game) {
        this.newGamePanel = new NewGamePanel(game);
        this.add(newGamePanel);
    }

    
}

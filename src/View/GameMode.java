/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author arthur
 */
public class GameMode extends JRadioButton implements ActionListener {
    
    private final String label;
    private final String id;
    private final Game game;
    
    GameMode(String label, String id, Game game) {
        super(label);
        this.label = label;
        this.id = id;
        this.game = game;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(id);
    }
    
}

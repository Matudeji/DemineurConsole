/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Cell;
import Model.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author arthur
 */
public class GraphicalCellView extends JButton implements ActionListener{
    private Cell cell;
    private boolean enabled;
    private Game game;
    
    GraphicalCellView(Cell cell, boolean enabled, Game game) {
        super(""+cell.getType());
        this.game = game;
        this.cell = cell;
        this.enabled = enabled;

        this.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("bouton: " + cell.getPosition().getX() + " " + cell.getPosition().getY());
        
        System.out.println(game.getMap().getWidth() * cell.getPosition().getY() + cell.getPosition().getX());
        //map.getWidth() * i + j
        Controller.clic(cell.getPosition(), game);
    }
    
    /**
     * @return the enabled
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public void updateText() {
        this.setText(""+cell.getType());
    }
    
    
}

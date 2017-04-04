/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import Controller.Controller;
import Model.Game;
import Model.Point;


/**
 *
 * @author arthur
 */
public class ClickManager extends MouseAdapter {
    
    Point position;
    Game game;

    ClickManager(Point position, Game game) {
        this.position = position;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            Controller.clic(position, game);
        }else if(SwingUtilities.isRightMouseButton(e)){
            Controller.rightClic(position, game);
        }
    }

}

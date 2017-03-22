/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
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
    Game game;
    Map map;
    GraphicalGridView grid;
    JFrame mainFrame;
    

    public ViewGUI(Game game) {
        this.game = game;
        this.map = game.getMap();
        mainFrame = new JFrame("Déminouille");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.grid = new GraphicalGridView(game, mainFrame); 
    }
    
    @Override
    public void print() {
        grid.print();
    }
}

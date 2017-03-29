/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import Model.Map;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class ViewGUI extends JFrame implements View, Observer {

    Game game;
    Map map;
    Observable gameModel;
    GraphicalGridView grid;

    public ViewGUI(Game game, Observable gameModel) {
        super("Déminouille");
        /*this.game = game;
        this.map = game.getMap();
        this.gameModel = gameModel;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.grid = new GraphicalGridView(game, this);
        this.add(grid);
        this.print();
        this.setVisible(true);
         */
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.grid = new GraphicalGridView(game, this);
        this.add(grid);

    }

    @Override
    public void print() {
        this.grid.print();
    }

    @Override
    public void update(Observable o, Object o1) {
        // loop through each cell

        if (gameModel == o) {
            System.out.println("update de la vue");
            for (int i = 0; i < this.game.getMap().getHeight(); i++) {
                for (int j = 0; j < this.game.getMap().getWidth(); j++) {
                    this.grid.getButton(i, j);
                }
            }
        }
    }
}

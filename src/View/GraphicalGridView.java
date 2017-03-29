/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import Model.Map;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class GraphicalGridView extends JPanel {

    Game game;
    Map map;
    JFrame frame;
    GridLayout grid;

    GraphicalGridView(Game game, JFrame mainFrame) {
        super();
        this.game = game;
        this.map = game.getMap();
        this.frame = mainFrame;
        grid = new GridLayout(map.getHeight(), map.getWidth(), 5, 5);
        this.setLayout(grid);
        this.map = game.getMap();

        this.print();
    }

    public void print() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                GraphicalCellView cellView = new GraphicalCellView(map.map[j][i], true, game);
                this.add(cellView);
            }
        }
        frame.setSize(map.getWidth() * 50, map.getHeight() * 50);
        this.setVisible(true);
    }

    public GraphicalCellView getButton(int j, int i) {
        System.out.println(i + " " + j);
        System.out.println(map.getWidth() * i + j);
        System.out.println("getCompo " + this.grid.getRows() * i + j);
        System.out.println(this.getComponents().length);
        return (GraphicalCellView) this.getComponent(map.getWidth() * i + j);
    }

}

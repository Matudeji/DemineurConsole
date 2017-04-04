/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import Model.Map;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
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
    StatusBar statusBar;
    MenuBar menuBar;
    SubMenu subMenu;
    
    NewGamePanel newGamePanel;
    

    public ViewGUI(Game game, Observable gameModel) {
        super("Déminouille");
        this.game = game;
        this.map = game.getMap();
        this.gameModel = gameModel;
        
        this.setSize(300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout(5, 5));
        
        this.grid = new GraphicalGridView(game, this);
        this.add(grid, BorderLayout.CENTER);
        
        this.statusBar = new StatusBar(game.getMap().getStayingMine());
        this.add(statusBar, BorderLayout.SOUTH);
        
        this.menuBar = new MenuBar();
        this.setJMenuBar(menuBar);
        
        this.newGamePanel = new NewGamePanel(game);
        this.add(newGamePanel, BorderLayout.EAST);
        
        this.setSize(map.getWidth() * 50 + 400, map.getHeight() * 50 + 100);

    }

    @Override
    public void print() {
        this.grid.print();
    } 

    @Override
    public void update(Observable o, Object o1) {
        // loop through each cell
        if (gameModel == o) {
            for (int i = 0; i < this.game.getMap().getHeight(); i++) {
                for (int j = 0; j < this.game.getMap().getWidth(); j++) {
                    this.grid.getButton(j, i).updateText();
                }
            }
            this.statusBar.setRemainingMines(game.getMap().getStayingMine());
        }
    }
}

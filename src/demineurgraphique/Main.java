/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurgraphique;

import Controller.Controller;
import Model.Game;
import Model.Point;
import View.ViewGUI;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.createMap(10, 10, 10, game);
        ViewGUI viewG = new ViewGUI(game, game);
        game.addObserver(viewG);
        game.addView(viewG);        

        game.initMines(new Point(2, 2));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurgraphique;

import Model.Game;
import Model.Point;
import View.CustomGameFrame;
import View.ViewGUI;

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

    }
}

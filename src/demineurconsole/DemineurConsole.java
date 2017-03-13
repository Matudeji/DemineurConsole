/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurconsole;

import Model.*;
import Controller.*;
import java.util.Scanner;

/**
 *
 * @author alan
 */
public class DemineurConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game game = new Game();
        Controller controller = new Controller();
        Scanner scan = new Scanner(System.in);

        //initialisation
        game.createMap(9, 5, 10, game);
        game.printMap();

        String s = scan.nextLine();
        Point clic = controller.parseString(s);
        game.initMines(clic);
        game.revail(clic.getX(), clic.getY());
        game.printMap();
        
        // jeu
        do {
            s = scan.nextLine();
            clic = controller.parseString(s);
        } while (game.clic(clic));
    }

}

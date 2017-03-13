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

        game.createMap(14, 7, 10, game);
        game.printMap();
        
        String s = scan.nextLine();
        Point firstClic = controller.parseString(s);
        
        game.initMines(firstClic);
        game.revail(firstClic.getX(), firstClic.getY());
        game.printMap();
        String c = scan.nextLine();
        Point clic = controller.parseString(c);
        game.revail(clic.getX(),clic.getY());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurconsole;
import Model.*;
import Controller.*;
import java.io.IOException;
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

        game.createMap(7, 7, 5, game);
        game.printMap();
        
        String s = scan.nextLine();
        try{
        String[] parts = s.split(" ");
        Point clic = new Point(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        game.initMines(clic);
        controller.parseString(s,game);
        game.printMap();
        }
        catch(NumberFormatException e){
            System.out.println("erreur d'initialisation du demineur!");
        }
        
        // jeu
        do {
            s = scan.nextLine();
        } while (controller.parseString(s,game));
    }
    
}

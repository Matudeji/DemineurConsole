/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demineurconsole;

import Model.*;
import Controller.*;
import View.*;
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
        //Controller controller = new Controller();
        Scanner scan = new Scanner(System.in);
        String s = "";
        boolean init = true;
        int width = 0;
        int hight = 0;
        int nombMine = 0;
        
        while (init) {
            try {
                System.out.println("veuillez saisir la largeur du Démineur: ");
                s = scan.nextLine();
                width = Integer.parseInt(s);
                System.out.println("veuillez saisir la longueur du Démineur: ");
                s = scan.nextLine();
                hight = Integer.parseInt(s);
                System.out.println("veuillez saisir le pourcentage de mine: ");
                s = scan.nextLine();
                nombMine = Integer.parseInt(s);
                init = false;
            } catch (NumberFormatException e) {
                System.out.println("Erreur de saisi, recommencé l'initialisation. ");
            }

        }

        game.createMap(width, hight, nombMine, game);
        
        ViewGUI viewGUI = new ViewGUI(game);
        game.addView(viewGUI);
        
        ViewConsole viewConsole = new ViewConsole(game.getMap());
        game.addView(viewConsole);
        
        game.getView(0).print();
        game.getView(1).print();

        init = true;
        while (init) {
            try {
                s = scan.nextLine();
                String[] parts = s.split(" ");
                Point clic = new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                game.initMines(clic);
                init = false;
            } catch (ArrayIndexOutOfBoundsException d) {
                System.out.println("erreur d'initialisation du demineur!");
            }
        }
        Controller.parseString(s, game);

        // jeu
        do {
            s = scan.nextLine();
        } while (Controller.parseString(s, game));

    }

}

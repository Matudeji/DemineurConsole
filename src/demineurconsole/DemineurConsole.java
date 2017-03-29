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
import java.lang.RuntimeException;
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

        int nombMine =0;
        while(init){
            try{
                System.out.println("veuillez saisir la largeur du Démineur: ");
                s = scan.nextLine();
                width=Integer.parseInt(s);
                System.out.println("veuillez saisir la longueur du Démineur: ");
                s = scan.nextLine();
                hight=Integer.parseInt(s);
                System.out.println("veuillez saisir le pourcentage de mine: ");
                s = scan.nextLine();
                nombMine=Integer.parseInt(s);

                if(width*hight>3){
                    game.createMap(width, hight, nombMine, game);
                    ViewConsole viewC = new ViewConsole(game.getMap());
                    //ViewGUI viewG = new ViewGUI(game);
                    
                    game.addView(viewC);
                    //game.addView(viewG);
                    game.getView(0).print();
                    //game.getView(1).print();
                    init=false;
                }

                else{
                    System.out.println("Vous devez mettre minimum une superficie de 4 cases!");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Erreur de saisi, recommencé l'initialisation. ");
            }
            catch( RuntimeException b){
                System.out.println("Erreur de saisi, recommencé l'initialisation. ");
            } 
            
        }

        
        init=true;
        while(init){
            try{
                s = scan.nextLine();
                String[] parts = s.split(" ");
                Point clic = new Point(Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
                game.initMines(clic);
                System.out.println("blabla");
                init=false;
            }
            catch(ArrayIndexOutOfBoundsException d){
                System.out.println("erreur d'initialisation du demineur!");
            }
        }
        Controller.parseString(s,game);
        game.getView(0).print();        
        int GameState=0;
        // jeu
        do {
            System.out.println("taper votre commande:");
            s = scan.nextLine();
            GameState=Controller.parseString(s, game);
        } while (GameState==0);
        
        switch(GameState){
            case -1: System.out.println("Booom! You loose !");
                break;
            case -2:
                    System.out.println("GoodBye");
                    break;
            case 1:
                    System.out.println("Yeaaah! You win !");
            default:
                break;
        }

    }

}

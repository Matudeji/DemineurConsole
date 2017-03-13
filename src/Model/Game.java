/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author arthur
 */
public class Game implements Observer {

    private Map map;

    public Game() {

    }

    
    public void createMap(int width, int height, int mineProportion, Game gg) {
        map = new Map(width, height, mineProportion,gg);

    }

    public void printMap() {
        map.print();
    }

    public void initMines(Point firstClic) {
        map.initMines(firstClic);
    }

    public void mark(int x, int y,char mon){
        if(map.map[x][y].getHidden()){
            map.map[x][y].setType(mon);
        }
        else{
            System.out.println("La case est deja dévoilé");
        }
    }

      public boolean clic(Point clic) {
        if(map.map[clic.getX()][clic.getY()].getMine()) {
            return false;
        }
        revail(clic.getX(), clic.getY());
        return true;
    }

    private void revailNeighborhood(int x, int y) {
        // On va dévoiler les cellules voisines vide
        if (map.map[x][y].getNumberOfMine() == 0 && x != 0) {
            if (map.map[x - 1][y].getHidden()) {
                revail(x - 1, y);
            }
        }
        //haut
        if (map.map[x][y].getNumberOfMine() == 0 && y != 0) {
            if (map.map[x][y - 1].getHidden()) {
                revail(x, y - 1);
            }
        }
        //droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1) {
            if (map.map[x + 1][y].getHidden()) {
                //System.out.println("lol");
                revail(x + 1, y);
            }
        }
        //bas
        if (map.map[x][y].getNumberOfMine() == 0 && y != map.getHeight() - 1) {
            if (map.map[x][y + 1].getHidden()) {
                revail(x, y + 1);
            }
        }
        //haut-gauche
        if (map.map[x][y].getNumberOfMine() == 0 && x != 0 && y != 0) {
            if (map.map[x - 1][y - 1].getHidden()) {
                System.out.println("diagonaaaale");
                revail(x - 1, y - 1);
            }
        }
        //haut-droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1 && y != 0) {
            if (map.map[x + 1][y - 1].getHidden()) {
                System.out.println("diagonaaaale");
                revail(x + 1, y - 1);
            }
        }
        //bas-gauche
        if (map.map[x][y].getNumberOfMine() == 0 && x != 0 && y != map.getHeight() - 1) {
            if (map.map[x - 1][y + 1].getHidden()) {
                System.out.println("diagonaaaale");
                revail(x - 1, y + 1);
            }
        }
        //bas-droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1 && y != map.getHeight() - 1) {
            if (map.map[x + 1][y + 1].getHidden()) {
                System.out.println("diagonaaaale");
                revail(x + 1, y + 1);
            }
        }
    }

    public void revail(int x, int y) {

        if (map.map[x][y].getNumberOfMine() != 0 && map.map[x][y].getHidden()) {
            map.map[x][y].setHidden(false);
            String convertedNumberOfMine = Integer.toString(map.map[x][y].getNumberOfMine());

            map.map[x][y].setType(convertedNumberOfMine.charAt(0));
            revailNeighborhood(x, y);
        } else if (map.map[x][y].getNumberOfMine() == 0 && map.map[x][y].getHidden()) {
            map.map[x][y].setHidden(false);
            map.map[x][y].setType('.');
            revailNeighborhood(x, y);
        }
    }

    
    public final static void clearConsole(){
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final IOException e)
    {
        //  Handle any exceptions.
    }
}

    @Override
    public void update(Observable o, Object o1) {
        clearConsole();
        printMap();
        System.out.println("==========================");

    }

}

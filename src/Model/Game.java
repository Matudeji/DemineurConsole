/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        map = new Map(width, height, mineProportion, gg);

    }

    public void printMap() {
        map.print();
    }

    public void initMines(Point firstClic) {
        map.initMines(firstClic);
    }

    private void revailNeighborhood(int x, int y) {
        // On va dévoiler les cellules voisines vide
        if (map.map[x][y].getNumberOfMine() == 0) {
            if (x != 0) {
                if (map.map[x - 1][y].getHidden()) {
                    revail(x - 1, y);
                }
            }
            //haut
            if (y != 0) {
                if (map.map[x][y - 1].getHidden()) {
                    revail(x, y - 1);
                }
            }
            //droit
            if (x != map.getWidth() - 1) {
                if (map.map[x + 1][y].getHidden()) {
                    //System.out.println("lol");
                    revail(x + 1, y);
                }
            }
            //bas
            if (y != map.getHeight() - 1) {
                if (map.map[x][y + 1].getHidden()) {
                    revail(x, y + 1);
                }
            }
            //haut-gauche
            if (x != 0 && y != 0) {
                if (map.map[x - 1][y - 1].getMine()) {
                    System.out.println("diagonaaaale");
                    revail(x - 1, y - 1);
                }
            }
            //haut-droit
            if (x != map.getWidth() - 1 && y != 0) {
                if (map.map[x + 1][y - 1].getMine()) {
                    System.out.println("diagonaaaale");
                    revail(x + 1, y - 1);
                }
            }
            //bas-gauche
            if (x != 0 && y != map.getHeight() - 1) {
                if (map.map[x - 1][y + 1].getMine()) {
                    System.out.println("diagonaaaale");
                    revail(x - 1, y + 1);
                }
            }
            //bas-droit
            if (x != map.getWidth() - 1 && y != map.getHeight() - 1) {
                if (map.map[x + 1][y + 1].getMine()) {
                    System.out.println("diagonaaaale");
                    revail(x + 1, y + 1);
                }
            }
        }
    }

    public void revail(int x, int y) {
        // On dévoile la cellule du clic
        // if (!map.map[x][y].getMine() && map.map[x][y].getHidden()) {
        //     map.map[x][y].setHidden(false);
        //     if (map.map[x][y].getNumberOfMine() == 0) {
        //         map.map[x][y].setType('.');
        //         revailNeighborhood(x, y);
        //     } else if (map.map[x][y].getNumberOfMine() > 0) {
        //         map.map[x][y].setHidden(false);
        //         String convertedNumberOfMine = Integer.toString(map.map[x][y].getNumberOfMine());
        //         map.map[x][y].setType(convertedNumberOfMine.charAt(0));
        //     }
        // }
        if (map.map[x][y].getNumberOfMine() != 0 && map.map[x][y].getHidden()) {
            map.map[x][y].setHidden(false);
            String convertedNumberOfMine = Integer.toString(map.map[x][y].getNumberOfMine());
            map.map[x][y].setType(convertedNumberOfMine.charAt(0));
        } else if (map.map[x][y].getNumberOfMine() == 0 && map.map[x][y].getHidden()) {
            map.map[x][y].setHidden(false);
            map.map[x][y].setType('.');
            revailNeighborhood(x, y);
        }
    }

    @Override
    public void update(Observable o, Object o1) {
        printMap();

    }

}

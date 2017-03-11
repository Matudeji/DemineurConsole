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

    public void createMap(int width, int height, int mineProportion) {
        map = new Map(width, height, mineProportion);
    }

    public void printMap() {
        map.print();
    }

    public void initMines(Point firstClic) {
        map.initMines(firstClic);
    }

    private void revailRecursive(int x, int y) {

    }

    public void revail(int x, int y) {
        if(map.map[x][y].getMine()) {
            System.out.println("T'as tout fait péter ehehehe");
        }
        // On dévoile la cellule du clic
        if (!map.map[x][y].getMine() && map.map[x][y].getHidden()) {
            map.map[x][y].setHidden(false);
            if(map.map[x][y].getNumberOfMine() == 0) {
                map.map[x][y].setType('.');
            }else{
                map.map[x][y].setType((char) map.map[x][y].getNumberOfMine());
            }
        }
        // On va dévoiler les cellules voisines vide
        if (x != 0) {
            if (map.map[x - 1][y].getNumberOfMine() == 0 && map.map[x - 1][y].getHidden()) {
                revail(x-1, y);
            }
        }
        //haut
        if (y != 0) {
            if (map.map[x][y - 1].getNumberOfMine() == 0 && map.map[x][y-1].getHidden()) {
                revail(x, y-1);
            }
        }
        //droit
        if (x != map.getWidth() - 1) {
            if (map.map[x + 1][y].getNumberOfMine() == 0 && map.map[x + 1][y].getHidden()) {
                revail(x+1, y);
            }
        }
        //bas
        if (y != map.getHeight() - 1 ) {
            if (map.map[x][y + 1].getNumberOfMine() == 0 && map.map[x][y+1].getHidden()) {
                revail(x, y+1);
            }
        }
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}

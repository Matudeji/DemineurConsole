/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private void revailRecursive(int x, int y) {
        
    }
    
    public void revail(Point clic) {
        
        if(!map.getCell(clic).getMine() && map.getCell(clic).getHidden()) {
            map.getCell(clic).setHidden(false);
            map.getCell(clic).setType('.');
        }
        // On dévoile les cellules voisines vide
        
    }

    @Override
    public void update(Observable o, Object o1) {
        printMap();
    }
    
}

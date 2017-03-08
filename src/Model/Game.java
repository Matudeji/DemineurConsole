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

    @Override
    public void update(Observable o, Object o1) {
        
    }
    
}

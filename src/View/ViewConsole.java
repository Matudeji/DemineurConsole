/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Map;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author arthur
 */
public class ViewConsole implements View, Observer {
    
    Map map;
    
    public ViewConsole(Map map) {
        this.map = map;
    }

    @Override
    public void print() {
        System.out.print(" ");
        for(int j=0; j<map.getWidth(); j++) {
            System.out.print(j);
        }
        System.out.println("");
        for(int i=0; i<map.getHeight(); i++) {
            for(int j=0; j<map.getWidth(); j++) {
                if(j == 0) {
                    System.out.print(i);
                }
                System.out.print(map.map[j][i].getType());
            }
            System.out.println("");
        }
        System.out.println("----------------------------------");
    }
    
    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

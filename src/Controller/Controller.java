/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;
import Model.*;

/**
 *
 * @author arthur
 */
public class Controller {
    
    private static final char revail = 'd';
    private static final char mark = 'm';
    private static final char quit = 'q';
    
    private static final char mine = 'x';
    private static final char undecide = '?';
    private static final char unmark = '#';
        
    public Controller() {
        
    }
    
    public void readInput() {

    }
    
    public Point parseString(String s) {
        String[] parts = s.split(" ");
        System.out.println(s);
        if(parts[0].charAt(0) == revail) {
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            return new Point(x, y);
        }
        return new Point(0, 0);
    }
    
}

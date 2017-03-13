/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;
import Model.*;
import java.io.IOException;

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
    
    public boolean parseString(String s,Game o) {
        try {
            String[] parts = s.split(" ");
            System.out.println(s);
            if(parts[0].charAt(0) == revail) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                return o.clic(new Point(x,y));
            }
            if(parts[0].charAt(0) == mark) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                if(parts[3].charAt(0) == mine){
                    o.mark(x,y,'!');
                }
                if(parts[3].charAt(0) == undecide){
                    o.mark(x,y,undecide);
                }
                if(parts[3].charAt(0) == unmark){
                    o.mark(x,y,unmark);
                }

                return true;
            }
            if(parts[0].charAt(0) == quit){
                    return false;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("mauvaise commande tapée");
        }
        return true;
    }
    
}

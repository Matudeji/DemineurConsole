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
    
    public int parseString(String s,Game o) {
        try {
            String[] parts = s.split(" ");
            System.out.println(s);
            if(parts[0].charAt(0) == revail) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                
                if(o.clic(new Point(x,y))){
                    return o.Victory();
                }
                else{
                    return -1;
                }
            }
            if(parts[0].charAt(0) == mark) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                if(parts[3].charAt(0) == mine){
                    o.mark(x,y,'!');    // on marque la case
                    o.testifmine(x,y,true);
                    System.out.println("marche");
                    return o.Victory();// on decrement peut etre le nbr de mine restante
                }
                if(parts[3].charAt(0) == undecide){
                    o.mark(x,y,undecide);
                }
                if(parts[3].charAt(0) == unmark){
                    o.mark(x,y,unmark);
                    o.testifmine(x,y,false);
                }

                return 0;
            }
            if(parts[0].charAt(0) == quit){
                    return -2;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("mauvaise commande tapée");
        }
        return 0;
    }
    
}

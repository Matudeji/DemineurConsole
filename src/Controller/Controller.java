/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

    public static int parseString(String s, Game o) {
        try {
            String[] parts = s.split(" ");
            System.out.println(s);
            if (parts[0].charAt(0) == revail) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                if (o.clic(new Point(x, y))) {
                    return o.Victory();
                } else {
                    return -1;
                }
            }
            if (parts[0].charAt(0) == mark) {
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                if (parts[3].charAt(0) == mine) {
                    o.mark(x, y, '!');    // on marque la case
                    o.testifmine(x, y, true);
                    System.out.println("marche");
                    return o.Victory();// on decrement peut etre le nbr de mine restante
                }
                if (parts[3].charAt(0) == undecide) {
                    o.mark(x, y, undecide);
                }
                if (parts[3].charAt(0) == unmark) {
                    o.mark(x, y, unmark);
                    o.testifmine(x, y, false);
                }

                return 0;
            }
            if (parts[0].charAt(0) == quit) {
                return -2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("mauvaise commande tapée");
        }
        return 0;
    }

    public static int clic(Point pt, Game o) {
        System.out.println("controller");
        if(o.isInitialize()==false){
            o.initMines(pt);
            o.clic(pt);
            o.setInitialize(true);
            return 0;
        }
        else{
            if (o.clic(pt)) {
                return o.Victory();
            } else {
                return o.defeat();
            }
        }
    }
    
    public static int rebuildMap(int width, int height, int nbmines, Game o){
        o.createMap(width,height,nbmines,o);
        System.out.println(nbmines);
        return 0;
    }

    public static void rightClic(Point pt, Game o) {
        o.mark(pt.getX(), pt.getY());
    }
    
    
    


}

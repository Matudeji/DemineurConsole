
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.View;
import View.ViewConsole;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author arthur
 */
public class Game extends Observable implements Observer {

    private Map map;
    private boolean initialize;
    private ArrayList<View> views;
    
    private static final char mine = 'x';
    private static final char undecide = '?';
    private static final char unmark = '#';
    private static final char mark = '!';

    public Game() {
        views = new ArrayList();
        initialize=false;
    }
    
     public boolean isInitialize() {
        return initialize;
    }

    public void setInitialize(boolean initialize) {
        this.initialize = initialize;
    }

    public Map getMap() {
        return map;
    }

    public View getView(int i) {
        return views.get(i);
    }

    public void addView(View view) {
        System.out.println(view);
        try {
            this.views.add(view);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void createMap(int width, int height, int mineProportion, Game gg) {
        map = new Map(width, height, mineProportion, gg);
        setChanged();
        notifyObservers("restart");

    }

    public void printMap() {
        map.print();
    }

    public void initMines(Point firstClic) {
        map.initMines(firstClic);
        System.out.println("initMines");
        setChanged();
        notifyObservers();
    }
    
    public void mark(int x, int y) {
        if(map.map[x][y].getType() == unmark) {
           map.map[x][y].setType(mine) ;
           map.setStayingMine(map.getStayingMine() - 1);
        }else if(map.map[x][y].getType() == mine) {
            map.map[x][y].setType(undecide) ;
            map.setStayingMine(map.getStayingMine() + 1);
        }else if(map.map[x][y].getType() == undecide) {
           map.map[x][y].setType(unmark) ;
        }
        setChanged();
        notifyObservers();
    }

    public void mark(int x, int y, char mon) {
        if (map.map[x][y].getHidden()) {
            map.map[x][y].setType(mon);
        } else {
            System.out.println("La case est deja dévoilé");
        }
        setChanged();
        notifyObservers();
    }

    public boolean clic(Point clic) {
        System.out.println("game clic");
        if (map.map[clic.getX()][clic.getY()].getMine()) {
            return false;
        }
        revail(clic.getX(), clic.getY());
        setChanged();
        notifyObservers();
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
                revail(x - 1, y - 1);
            }
        }
        //haut-droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1 && y != 0) {
            if (map.map[x + 1][y - 1].getHidden()) {
                revail(x + 1, y - 1);
            }
        }
        //bas-gauche
        if (map.map[x][y].getNumberOfMine() == 0 && x != 0 && y != map.getHeight() - 1) {
            if (map.map[x - 1][y + 1].getHidden()) {
                revail(x - 1, y + 1);
            }
        }
        //bas-droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1 && y != map.getHeight() - 1) {
            if (map.map[x + 1][y + 1].getHidden()) {
                revail(x + 1, y + 1);
            }
        }
        //bas-gauche
        if (map.map[x][y].getNumberOfMine() == 0 && x != 0 && y != map.getHeight() - 1) {
            if (map.map[x - 1][y + 1].getHidden()) {
                revail(x - 1, y + 1);
            }
        }
        //bas-droit
        if (map.map[x][y].getNumberOfMine() == 0 && x != map.getWidth() - 1 && y != map.getHeight() - 1) {
            if (map.map[x + 1][y + 1].getHidden()) {
                revail(x + 1, y + 1);
            }
        }
    }

    public int Victory() {
        if (map.getStayingMine() == 0) {
            if (map.mapAllViewed() == true) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    public int VictoryFrame(){
        if (map.getStayingMine() == 0) {
            if (map.mapAllViewed() == true) {
                setChanged();
                notifyObservers("victory");
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public boolean notStart(){
        if(map.getMineProportion()==map.getStayingMine()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean testifmine(int x, int y, boolean marque) {
        return map.testIfMine(x, y, marque);
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

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final IOException e) {
            //  Handle any exceptions.
        }
    }
    public int defeat(){
        this.initialize=false;
        createMap(map.getWidth(),map.getHeight(),(map.getMineProportion()*100)/(map.getHeight()*map.getWidth()),this);
        setChanged();
        notifyObservers("defeat");
        return -1;
    }

    @Override
    public void update(Observable o, Object o1) {
        clearConsole();
        for (int i = 0; i < views.size(); i++) {
            if (views.get(i) instanceof ViewConsole) {
                views.get(i).print();
            }
        }
    }

}

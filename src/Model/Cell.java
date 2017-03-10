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
public class Cell extends Observable {
    private Point position;
    private boolean hidden;
    private char type;
    private boolean mine;
    private int numberOfMine;

    public Cell(Point position, boolean hidden, char type, boolean mine,Game o) {
        this.position = position;
        this.hidden = hidden;
        this.type = type;
        this.mine = mine;
        this.addObserver(o);
    }
    
    

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * @return the hidden
     */
    public boolean getHidden() {
        return hidden;
    }

    /**
     * @param hidden the hidden to set
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return the type
     */
    public char getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(char type) {
        this.type = type;
        setChanged();
	notifyObservers(this.type);
    }

    /**
     * @return the mine
     */
    public boolean getMine() {
        return mine;
    }

    /**
     * @param mine the mine to set
     */
    public void setMine(boolean mine) {
        this.mine = mine;
    }

    /**
     * @return the numberOfMine
     */
    public int getNumberOfMine() {
        return numberOfMine;
    }

    /**
     * @param numberOfMine the numberOfMine to set
     */
    public void setNumberOfMine(int numberOfMine) {
        this.numberOfMine = numberOfMine;
    }
    
    
}

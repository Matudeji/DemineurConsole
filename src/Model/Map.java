/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Observable;

/**
 *
 * @author arthur
 */
public class Map extends Observable {
    private int width;
    private int height;
    private int mineProportion;
    private static int mineProportionMax = 85;
    private Cell[][] map;

    public Map(int width, int height, int mineProportion, Game o) throws RuntimeException {
        if(width <= 0 || height <= 0) {
            throw new RuntimeException("Les dimensions doivent être positives");
        }
        this.width = width;
        this.height = height;
        this.mineProportion = mineProportion;
        map = new Cell[width][height];
        initEmptyMap(o);
    }
    
    
    public void initEmptyMap(Game o) {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                map[j][i] = new Cell(new Point(i, j), true, '#', false,o);
            }
        }
    }
    
    public void print() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                System.out.print(map[j][i].getType());
            }
            System.out.println("");
        }
    }
    
    public void initMines(Point firstClic) {
        int mineToAdd = mineProportion;
        while (mineToAdd != 0) {
            int x = (int) (Math.random() * width );
            int y = (int) (Math.random() * height );
            
            if(!map[x][y].getMine() && x != firstClic.getX() && y != firstClic.getY()) {
                map[x][y].setMine(true);   
                map[x][y].setType('x'); 
                mineToAdd--;
            }
        }
        initNumberOfMines();
    }
    
    private void initNumberOfMines() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                int numberOfMine=0;
                //gauche
                if(j != 0) {
                    if(map[j-1][i].getMine()) {
                        numberOfMine++;
                    }
                }
                //haut
                if(i != 0) {
                    if(map[j][i-1].getMine()) {
                        numberOfMine++;
                    }
                }
                //droit
                if(j != width-1) {
                    if(map[j+1][i].getMine()) {
                        numberOfMine++;
                    }
                }
                //bas
                if(i != height-1) {
                    if(map[j][i+1].getMine()) {
                        numberOfMine++;
                    }
                }
                map[j][i].setNumberOfMine(numberOfMine);
            }
        }
    }
    
    public Cell getCell(Point p) {
        return map[p.getX()][p.getY()];
    }
    
    public Cell getCell(int x, int y) {
        return map[x][y];
    }
    
    

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the mineProportion
     */
    public int getMineProportion() {
        return mineProportion;
    }

    /**
     * @param mineProportion the mineProportion to set
     */
    public void setMineProportion(int mineProportion) {
        this.mineProportion = mineProportion;
    }

    /**
     * @return the mineProportionMax
     */
    public static int getMineProportionMax() {
        return mineProportionMax;
    }

    /**
     * @param aMineProportionMax the mineProportionMax to set
     */
    public static void setMineProportionMax(int aMineProportionMax) {
        mineProportionMax = aMineProportionMax;
    }
    
}

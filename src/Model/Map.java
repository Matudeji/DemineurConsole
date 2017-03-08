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

    public Map(int width, int height, int mineProportion) throws RuntimeException {
        if(width <= 0 || height <= 0) {
            throw new RuntimeException("Les dimensions doivent être positives");
        }
        this.width = width;
        this.height = height;
        this.mineProportion = mineProportion;
        map = new Cell[width][height];
        initMap();
    }
    
    
    public void initMap() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                map[i][j] = new Cell(new Point(i, j), true, '#', false);
            }
        }
    }
    
    public void print() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                System.out.print(map[i][j].getType());
            }
            System.out.println(i);
        }
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

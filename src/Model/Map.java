/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author arthur
 */
public class Map {
    private int width;
    private int height;
    private int mineProportion;
    private static int mineProportionMax = 85;
    //ArrayList< map
    private Cell[][] tab;

    public Map(int width, int height, int mineProportion) {
        this.width = width;
        this.height = height;
        this.mineProportion = mineProportion;
        tab = new Cell[width][height];
    }
    
    
    public void initMap() {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                map[i][j] = new SafeCell()
            }
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

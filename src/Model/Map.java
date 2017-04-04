/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Math.random;
import java.util.Observable;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author arthur
 */
public class Map extends Observable {
    private int width;
    private int height;
    private int mineProportion;
    private int stayingMine;
    private static int mineProportionMax = 85;
    public Cell[][] map;

    public Map(int width, int height, int mineProportion, Game o) throws RuntimeException {
        if(width <= 0 || height <= 0) {
            throw new RuntimeException("Les dimensions doivent être positives");
        }
        this.width = width;
        this.height = height;
        if(mineProportion<0 || mineProportion>100){
            this.mineProportion = (width*height)/2;
            this.stayingMine=this.mineProportion;
        }
        else{
            if(mineProportion>= 85){
                this.mineProportion = (int) ((width*height)* (85.0/100.0));
                this.stayingMine=this.mineProportion;
            }
            else{
                this.mineProportion = (int) ( ( (float) width* (float) height)* ( (float) mineProportion/100.0) );
                this.stayingMine=this.mineProportion;
            }
        }
        map = new Cell[width][height];
        initEmptyMap(o);
    }
    
    
    public void initEmptyMap(Game o) {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                 Cell uneCell = new Cell(new Point(j, i), true, '#', false,o);
                 map[j][i]=uneCell;
            }
        }
    }
    
    public void print() {
        System.out.print(" ");
        for(int j=0; j<width; j++) {
            System.out.print(j);
        }
        System.out.println("");
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(j == 0) {
                    System.out.print(i);
                }
                System.out.print(map[j][i].getType());
            }
            System.out.println("");
        }
        System.out.println("----------------------------------");
    }
    
    public void initMines(Point firstClic) {
        int mineToAdd=1;
        if(mineProportion==0){
            mineToAdd =1;
        }
        else{
            mineToAdd = mineProportion;
        }
        int a=firstClic.getX();
        int b=firstClic.getY();
        ArrayList<Cell> al = new ArrayList<Cell>();
         for(int i=0; i<height; i++) {
                for(int j=0; j<width; j++) {
                    if(i!=b || j!=a){
                        al.add(map[j][i]);
                    }
                }
            }
        while (mineToAdd != 0) {
            Random random = new Random();
            int x = random.nextInt(al.size());
            System.out.println("nbrmine restante:"+al.size()+mineToAdd +x);
                al.get(x).setMine(true);  
                al.get(x).setType('#'); 
                al.remove(x);
                mineToAdd--;
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
                //haut-gauche
                if(j != 0 && i != 0) {
                    if(map[j-1][i-1].getMine()) {
                        numberOfMine++;
                    }
                }
                //haut-droit
                if(j != width-1 && i != 0) {
                    if(map[j+1][i-1].getMine()) {
                        numberOfMine++;
                    }
                }
                //bas-gauche
                if(j != 0 && i != height-1) {
                    if(map[j-1][i+1].getMine()) {
                        numberOfMine++;
                    }
                }
                //bas-droit
                if(j != width-1 && i != height-1) {
                    if(map[j+1][i+1].getMine()) {
                        numberOfMine++;
                    }
                }
                map[j][i].setNumberOfMine(numberOfMine);
                
                if(!map[j][i].getMine() && numberOfMine != 0) {
                    String convertedNumberOfMine = Integer.toString(numberOfMine);
                }
            }
        }
    }
    
    public Cell getCell(Point p) {
        return map[p.getX()][p.getY()];
    }
    
    public Cell getCell(int x, int y) {
        return map[x][y];
    }
    
    public boolean testIfMine(int x, int y,boolean mark){
        if(mark){   // on marque
            if(map[x][y].getMine()==true){ // si il y a une mine
            this.stayingMine-=1;
            return true;
            }
            else{
                return false;
            }
        }
        else{   // on demarque
            if(map[x][y].getMine()==true){ // si il y a une mine sur la cellule
                this.stayingMine+=1;
                return true;
            }
            else{
                return false;
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
    
    public boolean mapAllViewed(){
        for(int i=0; i<height;i++){
            for(int j=0;j<width;j++){
                if(map[j][i].getMine()==false){
                    if(map[j][i].getHidden()==true){
                        return false;
                    }
                }
            }
        }
        return true;
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
     public void setStayingMine(int stayingMine) {
        this.stayingMine = stayingMine;
    }

    public int getStayingMine() {
        return stayingMine;
    }
}

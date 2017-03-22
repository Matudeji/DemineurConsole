/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author arthur
 */
public class GraphicalCellView extends JButton {
    private int x;
    private int y;
    private boolean enabled;
    private String text;
    private Image img;

    public GraphicalCellView(int x, int y, boolean enabled, String text, String img) {
        this.x = x;
        this.y = y;
        this.enabled = enabled;
        this.text = text;
        try {
            this.img = ImageIO.read(getClass().getResource("images/gaetane.jpg"));
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the enabled
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    @Override
    public void setEnabled(boolean enabled) {
        //
        this.enabled = enabled;
    }
    
}

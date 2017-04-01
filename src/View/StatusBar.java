/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class StatusBar extends JPanel{
    private int remainingMines;
    private JLabel text;
    
    StatusBar(int remainingMines) {
        this.text = new JLabel();
        this.setRemainingMines(remainingMines);
        this.add(this.text);
    }

    private void updateText() {
        this.text.setText("Remaining mines: " + Integer.toString(remainingMines));
    }

    public void setRemainingMines(int remainingMines) {
        if(this.remainingMines != remainingMines) {
            this.remainingMines = remainingMines;
           this.updateText();
        }
    }
    
}

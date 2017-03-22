/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author arthur
 */
public class ClickListener implements ActionListener{
    
    public ClickListener() {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("something happened");
    }
}

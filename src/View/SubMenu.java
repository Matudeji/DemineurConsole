/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author arthur
 */
public class SubMenu extends JMenu {
    JMenuItem beginner, intermediate, expert, custom;
    
    SubMenu() {
        super("New");
        beginner = new JMenuItem("Beginner");
        intermediate = new JMenuItem("Intermediate");
        expert = new JMenuItem("Expert");
        custom = new JMenuItem("Custom");
        
        this.add(beginner);
        this.add(intermediate);
        this.add(expert);
        this.add(custom);
    }
}

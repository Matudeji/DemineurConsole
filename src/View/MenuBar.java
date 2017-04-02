/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author arthur
 */
public class MenuBar extends JMenuBar {
    JMenu menu;
    SubMenu subMenu;
    
    MenuBar() {
        super();
        
        menu = new JMenu("Game");
        this.add(menu);
        
        subMenu = new SubMenu();
        menu.add(subMenu);
        System.out.println("submenu");
    }
    
}

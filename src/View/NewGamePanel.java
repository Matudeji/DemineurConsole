/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Game;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author arthur
 */
public class NewGamePanel extends JPanel {
        
    private final CustomGamePanel customGamePanel;
    private final JPanel creationGamePanel;
    
    private final JLabel select;
    private final ButtonGroup group;
   
    /*
    private final JRadioButton beginner;
    private final JRadioButton intermediate;
    private final JRadioButton expert;
    private final JRadioButton custom;
    */
    
    
    private final GameMode beginner;
    private final GameMode intermediate;
    private final GameMode expert;
    private final GameMode custom;

    NewGamePanel(Game game) {
        customGamePanel = new CustomGamePanel();
        
        creationGamePanel = new JPanel();
        select = new JLabel("Select Level : ");
        group = new ButtonGroup();
        /*
        beginner = new JRadioButton("Beginner : 10 mines in a 9x9 field");
        intermediate = new JRadioButton("Intermediate : 40 mines in a 16x16 field");
        expert = new JRadioButton("Expert : 99 mines in a 16x30 field");
        custom = new JRadioButton("Custom : ");
        */
        
        beginner = new GameMode("Beginner : 10 mines in a 9x9 field", "beginner", game);
        intermediate = new GameMode("Intermediate : 40 mines in a 16x16 field", "intermediate", game);
        expert = new GameMode("Expert : 99 mines in a 16x30 field", "expert", game);
        custom = new GameMode("Custom : ", "custom", game);
        
        creationGamePanel.setLayout(new GridLayout(5,1));
        
        group.add(beginner);
        group.add(intermediate);
        group.add(expert);
        group.add(custom);
        creationGamePanel.add(select);
        creationGamePanel.add(beginner);
        creationGamePanel.add(intermediate);
        creationGamePanel.add(expert);
        creationGamePanel.add(custom);
        
        this.setLayout(new GridLayout(2,1));
        this.add(creationGamePanel);
        this.add(customGamePanel);
    }
    
    
}

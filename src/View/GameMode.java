/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import Model.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

/**
 *
 * @author arthur
 */
public class GameMode extends JRadioButton implements ActionListener {

    private final String label;
    private final String id;
    private final Game game;

    private static final String beginner = "beginner";
    private static final String intermediate = "intermediate";
    private static final String expert = "expert";
    private static final String custom = "custom";

    GameMode(String label, String id, Game game) {
        super(label);
        this.label = label;
        this.id = id;
        this.game = game;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (id) {
            case beginner:
                Controller.rebuildMap(9, 9, 10, game);
                break;
            case intermediate:
                Controller.rebuildMap(16, 16, 40, game);
                break;
            case expert:
                Controller.rebuildMap(16, 30, 99, game);
                break;
            case custom:
                Controller.rebuildMap(9, 9, 10, game);
                break;
        }
        System.out.println(id);
    }

}

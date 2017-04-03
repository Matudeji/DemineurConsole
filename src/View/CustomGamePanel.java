/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author arthur
 */
public class CustomGamePanel extends JPanel {

    Parameter rows, columns, mines;

    private int rowsDefault = 9;
    private int columnsDefault = 19;
    private int minesDefault = 76;



    public CustomGamePanel() {
        this.setLayout(new GridLayout(3, 3));

        rows = new Parameter("rows", 9, 24, rowsDefault);
        columns = new Parameter("columns", 9, 30, columnsDefault);
        mines = new Parameter("rows", 10, (int) (0.85 * rowsDefault * columnsDefault), minesDefault);


        rows.slider.setPaintTicks(true);
        rows.slider.setPaintLabels(true);
        rows.slider.setMinorTickSpacing(1);
        rows.slider.setMajorTickSpacing(2);

        columns.slider.setPaintTicks(true);
        columns.slider.setPaintLabels(true);
        columns.slider.setMinorTickSpacing(2);
        columns.slider.setMajorTickSpacing(4);

        mines.slider.setPaintTicks(true);
        mines.slider.setPaintLabels(true);
        mines.slider.setMinorTickSpacing(13);
        mines.slider.setMajorTickSpacing(26);

        rows.panel.add(rows.label);
        rows.panel.add(rows.slider);
        rows.panel.add(rows.text);

        columns.panel.add(columns.label);
        columns.panel.add(columns.slider);
        columns.panel.add(columns.text);

        mines.panel.add(mines.label);
        mines.panel.add(mines.slider);
        mines.panel.add(mines.text);

        this.add(rows.panel);
        this.add(columns.panel);
        this.add(mines.panel);
    }

}

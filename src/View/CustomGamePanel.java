/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author arthur
 */
public class CustomGamePanel extends JPanel {

    private int rows = 9;
    private int columns = 19;
    private int mines = 76;

    public JPanel rowsPanel = new JPanel();
    public JLabel rowsLabel = new JLabel("rows");
    public JSlider rowsSlide = new JSlider(9, 24, rows);
    public JTextField rowsText = new JTextField(String.valueOf(rows), 2);

    public JPanel columnsPanel = new JPanel();
    public JLabel columnsLabel = new JLabel("columns");
    public JSlider columnsSlide = new JSlider(9, 30, columns);
    public JTextField columnsText = new JTextField(String.valueOf(columns), 2);

    public JPanel minesPanel = new JPanel();
    public JLabel minesLabel = new JLabel("mines");
    public JSlider minesSlide = new JSlider(10, (int) (0.85 * rows * columns), mines);
    public JTextField minesText = new JTextField(String.valueOf(mines), 2);

    public CustomGamePanel() {
        this.setLayout(new GridLayout(3, 3));

        rowsSlide.setPaintTicks(true);
        rowsSlide.setPaintLabels(true);
        rowsSlide.setMinorTickSpacing(1);
        rowsSlide.setMajorTickSpacing(2);

        columnsSlide.setPaintTicks(true);
        columnsSlide.setPaintLabels(true);
        columnsSlide.setMinorTickSpacing(2);
        columnsSlide.setMajorTickSpacing(4);

        minesSlide.setPaintTicks(true);
        minesSlide.setPaintLabels(true);
        minesSlide.setMinorTickSpacing(13);
        minesSlide.setMajorTickSpacing(26);

        rowsPanel.add(rowsLabel);
        rowsPanel.add(rowsSlide);
        rowsPanel.add(rowsText);

        columnsPanel.add(columnsLabel);
        columnsPanel.add(columnsSlide);
        columnsPanel.add(columnsText);

        minesPanel.add(minesLabel);
        minesPanel.add(minesSlide);
        minesPanel.add(minesText);

        this.add(rowsPanel);
        this.add(columnsPanel);
        this.add(minesPanel);
    }

}

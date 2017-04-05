/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author arthur
 */
public class Parameter implements ChangeListener {

    public JPanel panel;
    public JLabel label;
    public JSlider slider;
    public JTextField text;

    Parameter(String label, int sliderMin, int sliderMax, int sliderDefault) {
        panel = new JPanel();
        this.label = new JLabel(label);
        slider = new JSlider(sliderMin, sliderMax, sliderDefault);
        text = new JTextField(String.valueOf(sliderDefault), 2);
        slider.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        //System.out.println(source.getValueIsAdjusting());
        System.out.println(source.getValue());
    }

}

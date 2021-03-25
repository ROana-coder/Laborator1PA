package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JComboBox colorCombo; // the color of the shape

    public JLabel getSidesLabel() {
        return sidesLabel;
    }

    public void setSidesLabel(JLabel sidesLabel) {
        this.sidesLabel = sidesLabel;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    //create the label and the spinner
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); // This is the default number of sides


        //create the colorCombo, containing the values: Random and Black
        Random rand = new Random();
        float r = (float) (rand.nextFloat() / 2f + 0.5);
        float g = (float) (rand.nextFloat() / 2f + 0.5);
        float b = (float) (rand.nextFloat() / 2f + 0.5);

        Color color = new Color(r, g, b);
        Color blackColor = Color.BLACK;
        Color[] colors = {color, blackColor};
        colorCombo=new JComboBox<>(colors);


        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
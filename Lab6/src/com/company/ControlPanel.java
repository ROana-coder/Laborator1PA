package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
 //...TODO

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //add all buttons
 //...TODO
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
 //...TODO
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG",
                    new FileOutputStream("d:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
 //...TODO
}


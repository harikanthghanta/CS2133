package com.kylealanr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by kyle on 3/15/15.
 */
public class BrowserPanel extends JPanel {
    BrowserPanel(){
        JTextField textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("event");
            }
        });
        setLayout(new BorderLayout());
        add(textField);
    }

}

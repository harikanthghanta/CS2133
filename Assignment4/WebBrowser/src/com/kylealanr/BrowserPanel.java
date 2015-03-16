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
        final JTextField textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BrowserRender().setEnteredURL(textField.getText());
            }
        });
        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
    }

}

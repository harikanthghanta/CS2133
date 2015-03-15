package com.kylealanr;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 3/15/15.
 */
public class BrowserPanel extends JPanel {
    BrowserPanel(){
        JTextField textField = new JTextField();
        setLayout(new BorderLayout());
        add(textField);
    }

}

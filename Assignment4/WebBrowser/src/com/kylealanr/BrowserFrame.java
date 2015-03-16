package com.kylealanr;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 3/15/15.
 */
public class BrowserFrame extends JFrame {
    public final String TITLE = "Simple Browser";
    public final int HEIGHT = 800;
    public final int WIDTH = 600;
    public String enteredURL = "";


    Container container;


    BrowserFrame(){
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(new BrowserPanel(), BorderLayout.NORTH);

        setVisible(true);
    }
}

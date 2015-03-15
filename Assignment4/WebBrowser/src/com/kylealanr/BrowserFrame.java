package com.kylealanr;

import javax.swing.*;

/**
 * Created by kyle on 3/15/15.
 */
public class BrowserFrame extends JFrame {
    public final String TITLE = "Simple Browser";
    public final int HEIGHT = 800;
    public final int WIDTH = 600;

    BrowserFrame(){
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }
}

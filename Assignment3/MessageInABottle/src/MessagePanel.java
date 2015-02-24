import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class MessagePanel extends JPanel {

    /**
     * Overridden paintComponent that draws a fixed size bottle with a message inside
     *
     * @param g graphics object used to draw the bottle and message
     */
    @Override
    public void paintComponent(Graphics g){
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        super.paintComponent(g);

        g.drawString("This is a message", 200, 550);

        //bottle opening
        g.drawOval(200, 200, 100, 50);

        //bottle neck
        g.drawLine(200, 230, 200, 350); //left side
        g.drawLine(300, 230, 300, 350); //right side

        //bottle angle
        g.drawLine(200, 350, 125, 400); //left side
        g.drawLine(300, 350, 375, 400); //right side

        //bottle sides
        g.drawLine(125, 400, 125, 675); //left side
        g.drawLine(375, 400, 375, 675); //right side

        //bottle bottom curve
        g.drawArc(125, 650, 250, 50, 0, -180);
    }
}

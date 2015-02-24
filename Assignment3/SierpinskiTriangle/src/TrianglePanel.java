import javax.swing.*;
import java.awt.*;

/**
 * Created by kyle on 2/23/15.
 */
public class TrianglePanel extends JPanel {

    /**
     * Overridden paintComponent method that starts the recursive calls to drawTriangle
     *
     * @param g the graphics object to be passed into drawTriangle
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        int side = (height < width) ? height : width;
        drawTriangle(g, 0, 0, side);
    }

    /**
     * Method that calculates the inner triangle and recursively calls itself with the calculated points
     *
     * @param g graphics object that will draw a 1 x 1 rectangle in the base case
     * @param x the x coordinate of the pixel passed in
     * @param y the y coordinate of the pixel passed in
     * @param side the side of the triangle
     */
    public void drawTriangle(Graphics g, int x, int y, int side){
        if(side == 1){
            g.drawRect(x, y, 1, 1);
        } else {
            //calculate the middle tip of the inside triangle
            int xMid = x + (side / 4);
            int yMid = y;

            //calculate the left tip of the inside triangle
            int xLeft = x;
            int yLeft = y + (side / 2);

            //calculate the right tip of the inside triangle
            int xRight = x + (side / 2);
            int yRight = y + (side / 2);

            //call drawTriangle on the calculated points
            drawTriangle(g, xMid, yMid, side / 2);
            drawTriangle(g, xLeft, yLeft, side / 2);
            drawTriangle(g, xRight, yRight, side / 2);
        }
    }
}

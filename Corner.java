import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
/**
 * Write a description of class Corner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Corner extends Space
{
    // instance variables - replace the example below with your own
    //private int x;
    //private int y, height, width;
    private Color color;
    /**
     * Constructor for objects of class Corner
     */
    public Corner(Color col)
    {
        // initialise instance variables
        color = col;
    }

   /**
     * Draws the appropriate cornwe space on the board
     * @x x position on frame
     * @y y position on frame
     */
    public void draw(Graphics window, int x, int y, int width, int height) {
        super.draw(window,x,y,width,height);
        // fill color
        window.setColor(color);
        window.fillRect(x,y,width,height);
    }
}

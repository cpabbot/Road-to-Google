import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Abstract class Space - write a description of the class here
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public abstract class Space
{
    private String name;
    private int x,y;
    
    public Space() {
        //this(null, null);
    }
    
    public Space(String theName)
    {
        name = theName;
        x = 0;
        y = 0;
    }
    
    /**
     * Draws the appropriate space on the board
     * Should be overriden by Property and other subclass objects
     */
    public void draw(Graphics window, int x, int y, int w, int h, int side) {
        // outline
        window.setColor(Color.BLACK);
        Graphics2D g2D = (Graphics2D) window;
        g2D.setStroke(new BasicStroke(5F));
        window.drawRect(x,y,w,h);
    }
    
    public void setXY(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }
    
    public void setX(int xPos) {
        x = xPos;
    }
    
    public void setY(int yPos) {
        y = yPos;
    }
    
   
    
    
    public Color getColor() { return Color.BLACK; }
    public String getName() { return name; }
    public int getX() { return x; }
    public int getY() { return y; }
}

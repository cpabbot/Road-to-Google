import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Write a description of class Property here.
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Property extends Space
{
    private double price;
    private double rent;
    private Color color;
    private Player ownership;
    private int houses;
    private boolean colorSet;
    //////////////////////////////////hey
    
    public Property() {
        this(0, 0, Color.WHITE, null, "name");
        //lol
    }
    
    public Property(double thePrice, double theRent, Color theColor, Player theOwnership, String theName) {
        super(theName);
        price = thePrice;
        rent = theRent;
        color = theColor;
        ownership = theOwnership;
        houses = 0;
         colorSet = false;
    }
    
    /**
     * Draws the appropriate property space on the board
     * @x x position on frame
     * @y y position on frame
     */
    public void draw(Graphics window, int x, int y, int width, int height, int side) {
        // fill color
        window.setColor(color);
        ////////////////window.fillRect(x,y,width,height);
        if(side == 0) { // top
            window.fillRect(x,y+(int)(0.75*height),width,(int)(0.25*height));
        } else if(side == 1) { // right
            window.fillRect(x,y,(int)(0.25*width),height);
        } else if(side == 2) { // bottom
            window.fillRect(x,y+(int)(0.75*height),width,(int)(0.25*height));
        } else if(side == 3) { // left
            window.fillRect(x,y+(int)(0.75*height),width,(int)(0.25*height));
        }
        // full space outline
        super.draw(window,x,y,width,height,side);
        // outline owner color
        if(ownership != null)
        {
            window.setColor(ownership.getColor());
            Graphics2D g2D = (Graphics2D) window;
            g2D.setStroke(new BasicStroke(5F));
            window.drawRect(x,y,width,height);
        }
    }
    
     /**
     * Based off number of houses calculates what rent for Property will be
     */
    public double calculateRent()
    {
        if(houses == 0)
        {
            if(colorSet)
            {
               return rent * 2;
            }
        }
        else if(houses == 1) { return rent * 5; }
        else if(houses == 2) { return rent * 15; }
        else if(houses == 3) { return rent * 35; }
        else if(houses == 4) { return rent * 55; }
        return rent;
    }

     /**
     * increment number of houses by amount
     * @amount num to incrememnt houses by
     */
    public void changeHouses(int amount)
    {
        houses = houses + amount;
    }
    
    /**
     * Set the player that owns this property
     */
    public void setOwnership(Player p) {
        ownership = p;
    }
    
    public boolean isProperty() { return true; }
    public double getPrice() { return price; }
    public Player getOwnership() { return ownership; }
    public Color getColor() { return color; }
}

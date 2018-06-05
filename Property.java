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
    private int stocks;
    private boolean colorSet;
    
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
        stocks = 0;
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
        if(side == 0) { // top
            window.fillRect(x,y+(int)(0.75*height),width,(int)(0.25*height));
        } else if(side == 1) { // right
            window.fillRect(x,y,(int)(0.25*width),height);
        } else if(side == 2) { // bottom
            window.fillRect(x,y,width,(int)(0.25*height));
        } else if(side == 3) { // left
            window.fillRect(x+(int)(0.75*width),y,(int)(0.25*width),height);
        }
        // full space outline
        super.draw(window,x,y,width,height,side);
        // outline owner color
        if(ownership != null)
        {
            window.setColor(ownership.getColor());
            Graphics2D g2D = (Graphics2D) window;
            g2D.setStroke(new BasicStroke(5F));
            window.drawRect(x+5,y+5,width-10,height-10);
        }
        // draw stocks
        window.setColor(Color.BLACK);
        for(int i=0; i<stocks; i++) {
            if(side == 0) { // top
                window.fillRect(x+12*i,y+(int)(0.75*height),10,10);
            } else if(side == 1) { // right
                window.fillRect(x,y,10,10);
            } else if(side == 2) { // bottom
                window.fillRect(x,y,10,10);
            } else if(side == 3) { // left
                window.fillRect(x+(int)(0.75*width),y,10,10);
            }
        }
    }
    
     /**
     * Based off number of stocks calculates what rent for Property will be
     */
    public double calculateRent()
    {
        if(stocks == 0)
        {
            if(colorSet)
            {
               return rent * 2;
            }
        }
        else if(stocks == 1) { return rent * 5; }
        else if(stocks == 2) { return rent * 15; }
        else if(stocks == 3) { return rent * 35; }
        else if(stocks == 4) { return rent * 55; }
        return rent;
    }

     /**
     * increment number of stocks by amount
     * @amount num to incrememnt stocks by
     */
    public void changeStocks(int amount)
    {
        stocks = stocks + amount;
    }
    
    public int getStockPrice() {
        return (int)(price/4);
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

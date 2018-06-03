import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Player here.
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Player
{
    private String name;
    private double money;
    private Color color;
    private int location;
    private ArrayList<Space> ownes;  // @review is this really necessary though???
    
    /**
     * Constructor for objects of class Player
     */
    public Player(String theName, double theMoney, Color theColor)
    {
       name = theName;
       money = theMoney;
       color = theColor;
       ownes = new ArrayList<Space>();
    }
    
    public void moveLocation(int numMoves) {
        location += numMoves;
        if(location >= 36) {
            location -= 36; // reset to 0 when fully around board / passing go
        }
    }
    
    /**
     * returns value of int money of player
     */
    public double getMoney()
    {
       return money;
    }
    
    /**
     * sets value of int money of player to plus/minus(if negative) amount
     */
    public double changeMoney(double amount)
    {
       return money = money + amount;
    }
    
    /**
     * adds prop to list ownes of Player
     * @prop property to change ownership
     * 
     */
    public void buyProperty(Property prop)
    {
       ownes.add(prop);
       prop.setOwnership(this);
    }
    
    /**
     * subtracts rent from Property prop from Player money
     *  maybe we should do this form Property Class????
     */
    public void payRent(Property prop)
    {
       money = money - prop.calculateRent();
    }
    
    public String getName() { return name; }
    public int getLocation() { return location; }
    public Color getColor() { return color; }
}

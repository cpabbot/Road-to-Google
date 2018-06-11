import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
/**
 * Corner draws corner spaces and implements their functions
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Corner extends Space
{
    private Color color;
    private String iAm;
    
    /**
     * Constructor for objects of class Corner
     */
    public Corner(Color col, String str)
    {
        // initialise instance variables
        color = col;
        iAm = str;
    }

   /**
     * Draws the appropriate cornwe space on the board
     * @x x position on frame
     * @y y position on frame
     */
    public void draw(Graphics window, int x, int y, int width, int height, int side) {
        super.draw(window,x,y,width,height, side);
        // fill color
        window.setColor(color);
        window.fillRect(x,y,width,height);
    }
   
    /**
     * Based on the String variable iAm the space will cause its proper effect to the player
     * If properlu implemented:
     * if iAm equals Jail the player will lose a 3 of their next turns
     * if iAm equals Free parking the player will recieve the money accumulated at Free Parking
     * if iAm equal Go to Jail the players position will change to be at jail
     *
     */
   public void act(Player p1)
   {
       if(iAm.equals("Start"))
       {
           p1.changeMoney(200.0);
        }
        else if(iAm.equals("Jail"))
        {
            //waste turn
        }
        else if(iAm.equals("Free Parking"))
        {
            //changeMoney by money in free parking
        }
        else if(iAm.equals("Go to jail"))
        {
            //moves player to jail
        }
       
    }
}

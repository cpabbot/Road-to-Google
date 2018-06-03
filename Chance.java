import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Chance here.
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Chance extends Space
{   
    private Color color;
    private ArrayList<String> cards;
    private Player player;
    private int numCards;
    public Chance(Color col)
    {
        color = col;
        cards = new ArrayList<String>();
        generateCards();
    }
    
    /**
     * Draws the appropriate property space on the board
     * @x x position on frame
     * @y y position on frame
     */
    public void draw(Graphics window, int x, int y, int width, int height) {
        super.draw(window,x,y,width,height);
        // fill color
        window.setColor(color);
        window.fillRect(x,y,width,height);
    }
    
    /**
     * Is called when player lands on chance 
     * picks card parallel with action
     */
    public String chooseCard(Player p1)
    {
        player = p1;
        //pick random number 0-num of cards-1
        //number correlates with parallel actions and string reply
        int num = (int)Math.random()*numCards + 1;
        applyAction(num, player);
        return sayAction(num);
    }
    
    /**
     * Fills list of String cards 
     */
    public void generateCards()
    {
        
    }
    
    public void applyAction(int ran, Player p1)
    {
        
    }
    
    public String sayAction(int ran)
    {
        return "";
    }
}

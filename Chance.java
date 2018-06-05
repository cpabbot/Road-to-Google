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
   // private int numCards;
   public Chance()
    {
        //color = col;
        cards = new ArrayList<String>();
        generateCards();
    }
    
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
    public void draw(Graphics window, int x, int y, int width, int height, int side) {
        super.draw(window,x,y,width,height, side);
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
        int num = (int)(Math.random()*cards.size());
        applyAction(num, p1);
        return sayAction(num);
    }
    
    /**
     * Fills list of String cards 
     */
    public void generateCards()
    {
        //cards.add("Your buisness looks like it needs a restart, go to start and try again!");
        //cards.add("Your making really bad buisness moves man, go back 3 spaces.");
        cards.add("A good CEO knows theres no way to avoid taxes, got to pay $150");
        cards.add("Promotion! Promotion! Promotion! Nice job, heres a $150 Bonus!");
        cards.add("The ceilings are leaking in your buildings, it's gonna be $100 in repairs. Sorry");
        cards.add("You won CEO of the year! It came with a $200 cash prize");
        cards.add("Um, there was some banking errors and you some how lost $200...sorry.");
        cards.add("We are gonna have to fix that smile for the meeting today, pay $50 for the dentist");
        cards.add("Investing stocks into your own company was a good idea, you earned $50");
        cards.add("Every buisness man needs a night out to a concert, but you got to pay for good seats. It's gonna be $150 for the front row.");
        cards.add("The employees liked you enough to give you a $150 christmas card. Nice job boss!");
        cards.add("The wife popped a tire driving to come see you, thats gonna be a $50 replacement.");
        cards.add("Happy Birthday Boss! Heres $50");
        cards.add("Someone got hurt on the job, your gonna have to pay $100 for the hospital bill.");
        cards.add("Dang sending your kids to buisnss classes is expensive, like $150 expensive.");
        cards.add("That consultancy fee you have just earned you $100!");
        cards.add("Your co-workers entered you in a beauty contentest. You came in second! Cash prize was $50");
        cards.add("Man isnt it nice to be rich? you just found $100 in your pocket!");
    }
    
    public void applyAction(int ran, Player p1)
    {
        if( ran == 0)
        {
            p1.moveLocation(0);
        }
        else if(ran == 1)
        {
             p1.moveLocation(p1.getLocation() - 3);
        }
        else if(ran == 2)
        {
            p1.changeMoney(-150.0);
        }
        else if(ran == 3)
        {
            p1.changeMoney(150.0);
        }
        else if(ran == 4)
        {
             p1.changeMoney(-100.0);
        }
        else if(ran == 5)
        {
             p1.changeMoney(200.0);
        }
        else if(ran == 6)
        {
            p1.changeMoney(-200.0);
        }
        else if(ran == 7)
        {
            p1.changeMoney(-50.0);
        }
        else if(ran == 8)
        {
            p1.changeMoney(50.0);
        }
        else if(ran == 9)
        {
            p1.changeMoney(-150.0);
        }
        else if(ran == 10)
        {
            p1.changeMoney(150.0);
        }
        else if(ran == 11)
        {
             p1.changeMoney(-50.0);
        }
        else if(ran == 12)
        {
             p1.changeMoney(50.0);
        }
        else if(ran == 13)
        {
            p1.changeMoney(-100.0);
        }
        else if(ran == 14)
        {
            p1.changeMoney(-150.0);
        }
        else if(ran == 15)
        {
            p1.changeMoney(100.0);
        }
        /*else if(ran == 16)
        {
            p1.changeMoney(50.0);
        }
        else if(ran == 17)
        {
            p1.changeMoney(100.0);
        } */
        
    }
    
    public String sayAction(int ran)
    {
        return cards.get(ran);
    }
}

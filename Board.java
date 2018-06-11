import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel; 

import java.util.List;
import java.util.ArrayList;

import java.awt.Dimension;

/**
 * JPanel that contains all the GUI for the board
 * the board contains a list of spaces
 * 
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Board extends JPanel
{
    private ArrayList<Space> spaces = new ArrayList<Space>();
    private int x,y;
    private int size;
    private ArrayList<Player> players;
    
    private static Color purple = new Color(160,32,240);
    private static Color lightBlue = new Color(102,178,255);
    private static Color orange = new Color(255,127,80);
    private static Color green = new Color(0,205,0);
    private static Color red = new Color(205,0,0);
    private static Color yellow = new Color(255,255,0);
    private static Color blue = new Color(0,0,205);
    private static Color grey = new Color(128,128,128);
    private static Color pink = new Color(255,0,255);
    private static Color cyan = new Color(64,244,208);
    private static Color silver = new Color(192,192,192);
    
    public Board() {
        this(300, null);
    }
    
    /**
     * Constructs a board
     * @param theSize the width and height of the board (which is a square)
     * @param thePlayers the list of players
     */
    public Board(int theSize, ArrayList<Player> thePlayers) {
        super();
        players = thePlayers;
        setPreferredSize(new Dimension(theSize,theSize));
        size = theSize;
        fillSpaces(); // fills arrayList spaces
    }
    
    /**
     * Paints the GUI
     * -- draws each space on the board
     * -- draws each player on the board
     */
    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        
        window.setColor(Color.WHITE);
        window.fillRect(0,0,getWidth(),getHeight());
        drawSpaces(window);
        drawPlayers(window);
    }
    
    /**
     * Draws the players on the board based on the players' locations and the x and y coords of each space
     * @param window the Graphics object to draw on
     */
    public void drawPlayers(Graphics window) {
        int spaceX, spaceY;
        for(Player p : players) {
            window.setColor(p.getColor());
            spaceX = spaces.get(p.getLocation()).getX();
            spaceY = spaces.get(p.getLocation()).getY();
            window.fillRect(spaceX,spaceY,70,70);
            
            // outline
            window.setColor(Color.BLACK);
            window.drawRect(spaceX,spaceY,70,70);
        }
    }
    
    /**
     * Draws a board
     * Draws each space on the board
     */
    public void drawSpaces(Graphics window) {
        int propSize = size/12;
        int cornerSize = propSize*2;
        int spaceX, spaceY;
        
        //----drawCorner 0 top left----//
        spaces.get(0).draw(window,0,0,cornerSize,cornerSize,0);
       
        //-------top row--------//
        for(int i = 1; i < 9; i++) {
            spaceX = propSize*(i-1)+cornerSize;
            spaceY = y;
            spaces.get(i).draw(window,spaceX,spaceY,propSize,propSize*2,0);
            spaces.get(i).setXY(spaceX,spaceY);
        }
        
        ///----draw corner 1 top right------//
        spaceX = propSize*(8)+cornerSize;
        spaceY = 0;
         spaces.get(9).draw(window,spaceX,spaceY,cornerSize,cornerSize,1);
         spaces.get(9).setXY(spaceX,spaceY);
         
        //------right column-----//
        for(int i = 10; i < 18; i++) {
            spaceX = propSize*(8)+cornerSize;
            spaceY = propSize*(i%10)+cornerSize;
            spaces.get(i).draw(window,spaceX,spaceY,propSize*2,propSize,1);
            spaces.get(i).setXY(spaceX,spaceY);
        }
        
        ///----draw corner 2 bottom right------//
        spaceX = propSize*(8)+cornerSize;
        spaceY = propSize*(8)+cornerSize;
        spaces.get(18).draw(window,spaceX,spaceY,cornerSize,cornerSize,2);
        spaces.get(18).setXY(spaceX,spaceY);
        
        //------bottom row----//
        for(int i = 20; i < 28; i++) {
            spaceX = propSize*(7)+cornerSize-propSize*(i%10);
            spaceY = y+cornerSize+propSize*8;
            spaces.get(i-1).draw(window,spaceX,spaceY,propSize,propSize*2,2);
            spaces.get(i-1).setXY(spaceX,spaceY);
        }
        
         ///----draw corner 3 bottom left------//
         spaceX = 0;
         spaceY = propSize*(8)+cornerSize;
         spaces.get(27).draw(window,spaceX,spaceY,cornerSize,cornerSize,3);
         spaces.get(27).setXY(spaceX,spaceY);
         
        //-------left column-----//
         for(int i = 30; i < 38; i++) {
            spaceX = x;
            spaceY = y+cornerSize+propSize*7-propSize*(i%10);
            spaces.get(i-2).draw(window,spaceX,spaceY,propSize*2,propSize,3);
            spaces.get(i-2).setXY(spaceX,spaceY);
        }
    }
    
    /**
     * Accessor
     * return Space object from ArrayList at given index
     * @index get corresponding Space object to this index in List
     */
    public Space getSpaceAt(int index) {
        return spaces.get(index);
    }
    
    /**
     * Adds a Space object into spaces list to correspond with board
     */
    public void fillSpaces()
    {
        spaces.add(new Corner(silver, "Start")); //0
        spaces.add(new Property(60, 2, purple, null, "Yahoo")); //1
        spaces.add(new Chance(cyan)); //2
        spaces.add(new Property(80, 4, purple, null, "Uber")); //3
        spaces.add(new Property(200, 50, grey, null, "Pay Pal")); //4
        spaces.add(new Property(100, 6, lightBlue, null, "Acquie")); //5
        spaces.add(new Chance(cyan)); //6
        spaces.add(new Property(100, 6, lightBlue, null, "RED")); //7
        spaces.add(new Property(120, 8, lightBlue, null, "Texas Instruments")); //8
        spaces.add(new Corner(silver, "Jail")); //9
        spaces.add(new Property(140, 10, pink, null, "eBay"));
        spaces.add(new Property(140, 10, pink, null, "Qualcomm"));
        spaces.add(new Property(160, 12, pink, null, "Cisco Systems"));
        spaces.add(new Property(200, 50, grey, null, "Tesla"));
        spaces.add(new Property(180, 14, orange, null, "HP Company"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(180, 14, orange, null, "Broadcom"));
        spaces.add(new Property(200, 16, orange, null, "Oracle"));
        spaces.add(new Corner(silver, "Free Parking"));
        spaces.add(new Property(220, 18, red, null, "Adobe"));
         spaces.add(new Property(220, 18, red, null, "IBM"));
        spaces.add(new Property(240, 20, red, null, "Intel"));
        spaces.add(new Property(200, 50, grey, null, "Space X"));
        spaces.add(new Property(260, 22, yellow, null, "Alphabet"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(260, 22, yellow, null, "Samsung"));
        spaces.add(new Property(280, 24, yellow, null, ""));
        spaces.add(new Corner(silver, "Go to jail"));
        spaces.add(new Property(300, 26, green, null, "Facebook"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(300, 26, green, null, "Amazon"));
        spaces.add(new Property(320, 28, green, null, "Microsoft"));
        spaces.add(new Property(200, 50, grey, null, "The Boring Company"));
        spaces.add(new Property(350, 35, blue, null, "Apple"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(400, 50, blue, null, "Google"));
        
        
    }
    
    /**
     * @return the ArrayList of Space objects
     */
    public ArrayList<Space> getSpaces()
    {
        return spaces;
    }
    
    public Color getPurple() { return purple; }
    public Color getGrey() { return grey; }
    public Color getBlue() { return blue; }
}

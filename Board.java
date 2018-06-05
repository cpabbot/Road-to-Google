import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel; 

import java.util.List;
import java.util.ArrayList;

import java.awt.Dimension;

/**
 * Write a description of class Board here.
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
    
    public Board(int theSize, ArrayList<Player> thePlayers) {
        super();
        players = thePlayers;
        setPreferredSize(new Dimension(theSize,theSize));
        //setSize(theSize, theSize);
        size = theSize;
        fillSpaces(); //fills arrayList spaces
    }
    
    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        
        window.setColor(Color.WHITE);
        window.fillRect(0,0,getWidth(),getHeight());
        drawSpaces(window);
        drawPlayers(window);
    }
    
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
        spaces.add(new Property(60, 2, purple, null, "stuff1")); //1
        spaces.add(new Chance(cyan)); //2
        spaces.add(new Property(80, 4, purple, null, "stuff2")); //3
        spaces.add(new Property(200, 50, grey, null, "railroad1")); //4
        spaces.add(new Property(100, 6, lightBlue, null, "stuff3")); //5
        spaces.add(new Chance(cyan)); //6
        spaces.add(new Property(100, 6, lightBlue, null, "stuff4")); //7
        spaces.add(new Property(120, 8, lightBlue, null, "stuff5")); //8
        spaces.add(new Corner(silver, "Jail")); //9
        spaces.add(new Property(140, 10, pink, null, "stuff9"));
        spaces.add(new Property(140, 10, pink, null, "stuff10"));
        spaces.add(new Property(160, 12, pink, null, "stuff11"));
        spaces.add(new Property(200, 50, grey, null, "railroad2"));
        spaces.add(new Property(180, 14, orange, null, "stuff6"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(180, 14, orange, null, "stuff7"));
        spaces.add(new Property(200, 16, orange, null, "stuff8"));
        spaces.add(new Corner(silver, "Free Parking"));
        spaces.add(new Property(220, 18, red, null, "stuff13"));
         spaces.add(new Property(220, 18, red, null, "stuff12"));
        spaces.add(new Property(240, 20, red, null, "stuff14"));
        spaces.add(new Property(200, 50, grey, null, "railroad3"));
        spaces.add(new Property(260, 22, yellow, null, "stuff15"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(260, 22, yellow, null, "stuff16"));
        spaces.add(new Property(280, 24, yellow, null, "Tesla"));
        spaces.add(new Corner(silver, "Go to jail"));
        spaces.add(new Property(300, 26, green, null, "Facebook"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(300, 26, green, null, "Amazon"));
        spaces.add(new Property(320, 28, green, null, "Microsoft"));
        spaces.add(new Property(200, 50, grey, null, "railroad4"));
        spaces.add(new Property(350, 35, blue, null, "Apple"));
        spaces.add(new Chance(cyan));
        spaces.add(new Property(400, 50, blue, null, "Google"));
        
        
    }
    
    public ArrayList<Space> getSpaces()
    {
        return spaces;
    }
    
    public Color getPurple() { return purple; }
    public Color getGrey() { return grey; }
    public Color getBlue() { return blue; }
}

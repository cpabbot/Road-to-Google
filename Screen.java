import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.List;

/**
 * Adds frame for graphics
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Screen extends JFrame implements ActionListener
{
    private static final int WIDTH = 1240;
    private static final int HEIGHT = 800;
    
    private static Board board;
    private static Menu menu;
    private static Chance chance;
    
    private static Color grey = new Color(128,128,128);
    
    // these 3 fields are used in the main method and must be instiated before constructor
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE};
    private static String[] colorStrings = {"BLACK", "BLUE", "RED", "GREEN", "ORANGE"};
    
    private static String pName;
    private static JButton roll, buy, pay, stocks, end;
    private static int cpi; // current player index
    private static Player currentPlayer;
    private static Space currentSpace;
    private static Property currentProperty;
    
    public Screen()
    {
        super("Road to Google");
        setSize(WIDTH,HEIGHT+40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //getContentPane().add(new Frame(WIDTH, HEIGHT));
        //main.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        JPanel main = new JPanel();
        
        //players = new ArrayList<Player>();
        cpi = 0;
        
        board = new Board(HEIGHT, players);
        menu = new Menu(400, HEIGHT);
        chance = new Chance();
        main.add(board);
        main.add(menu);
        
        getContentPane().add(main);
        
        setResizable(false);
        setVisible(true);
        
        addButtonListeners();
    }
    
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to our game!!!\n");
        
        System.out.print("Enter number of players, minimum of 2: ");
        int numPlayers = s.nextInt();
        
        for(int i = 0; i < numPlayers; i++) {
            System.out.print("Enter Player " + (i+1) + " Name: ");
            pName = s.next();
            System.out.print("Pick a Color: ");
            for(String c : colorStrings) {
                System.out.print(c + " ");
            }
            Color chosenCol = getColor(s.next().toUpperCase());
            players.add(new Player(pName, 1500, chosenCol));
        }
        
        String welcomeText = "Welcome " + players.get(0).getName();
        for(int i = 1; i < numPlayers; i++) {
            welcomeText += " and " + players.get(i).getName();
        }
        System.out.println("\n" + welcomeText + "\n");
        
        System.out.print("Type anything to begin: "); // @extension add colors
        String doesntmatter = s.next();
        
        Screen screen = new Screen();
        
        start();
    }
    
    /**
     * Displays Roll, Buy, Pay, and End Buttons on screen
     * When clicked will do proper function
     */
    public void addButtonListeners() {
        roll = menu.getRollBtn();
        roll.addActionListener(this);
        roll.setActionCommand("roll");
        
        buy = menu.getBuyBtn();
        buy.addActionListener(this);
        buy.setActionCommand("buy");
        
        pay = menu.getPayBtn();
        pay.addActionListener(this);
        pay.setActionCommand("pay");
        
        end = menu.getEndBtn();
        end.addActionListener(this);
        end.setActionCommand("end");
        
        stocks = menu.getStocksBtn();
        stocks.addActionListener(this);
        stocks.setActionCommand("end");
    }
    
    /**
     * Called at the beginning of Players turn
     * Enbales Roll button and Disables others
     * Makes it so a Player can not do anything before they roll
     */
    public static void start() {
        menu.addOutputText(players.get(cpi).getName() + "'s turn!\nRoll to move");
        roll.setEnabled(true);
        buy.setEnabled(false);
        pay.setEnabled(false);
        end.setEnabled(false);
    }
    
    /**
     * Controls what happens when a menu button is pressed:
     * ROLL -- random number 1-12 and player moves that many spaces on board
     * BUY -- 
     * PAY RENT -- 
     * END TURN -- 
     */
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();
        //menu.addOutputText("Command entered: " + buttonPressed); // for testing purposes
        if(buttonPressed.equals("roll")) { roll(); }
        else if(buttonPressed.equals("buy")) { buy(); }
        else if(buttonPressed.equals("pay")) { pay(); }
        else if(buttonPressed.equals("end")) { end(); }
    }
    
    /**
     * Rolls a random number 1-12 inclusive and moves current player
     * sets the player info text to current property's info
     */
    public void roll() {
        currentPlayer = players.get(cpi);
        // move the player a random number of spaces 1-12 inclusive
        int rollNum = (int)(Math.random()*12)+1;
        menu.addOutputText(players.get(cpi).getName() + " rolled a " + rollNum);
        roll.setEnabled(false);
        currentPlayer.moveLocation(rollNum);
        board.repaint();
        
        // set the details of the space the player has landed on
        int currentLocation = players.get(cpi).getLocation();
        currentSpace = board.getSpaceAt(currentLocation);
        if(currentPlayer.getPassedGo() == true)
        {
            currentPlayer.changeMoney(200.0);
            currentPlayer.setPassedGo(false);
            menu.addOutputText(players.get(cpi).getName() + " gets $200 for passing go!");
        }
        // if  I land on a property
        if(currentSpace.getClass().getName().equals("Property"))
        {
            currentProperty = (Property)currentSpace;
            if( currentProperty.getOwnership() == currentPlayer) { // if I own this
                end.setEnabled(true);
            }
            else if( currentProperty.getOwnership() == null) { // if no one owns it
                buy.setEnabled(true);
                end.setEnabled(true);
            }
            else { // they own it, aw man
                pay.setEnabled(true);
            }
        }
         else if(currentSpace.getClass().getName().equals("Chance"))
        {
            //info += chance.chooseCard(currentPlayer);
            menu.addOutputText(((Chance)currentSpace).chooseCard(currentPlayer));
            board.repaint();
            end.setEnabled(true);
        }
        else 
        {
            end.setEnabled(true);
        }
        
        menu.setPlayerInfoText(getInfo(), currentSpace.getColor());
    }
    
    public String getInfo() {
        String info = currentPlayer.getName() + " ~ $" + currentPlayer.getMoney();
        info += "\n" + currentSpace.getName() + " (" + currentSpace.getClass().getName() + ")";
        
        // if  I land on a property
        if(currentSpace.getClass().getName().equals("Property"))
        {
            currentProperty = (Property)currentSpace;
            if( currentProperty.getOwnership() == currentPlayer) { // if I own this
                info += "\nProperty owned by " + currentPlayer.getName();
            }
            else if( currentProperty.getOwnership() == null) { // if no one owns it
                info += "\nProperty not owned, can be bought!";
                info += "\nPurchase Price: $" + currentProperty.getPrice();
            }
            else { // they own it, aw man
                info += "\nProperty owned by " + currentProperty.getOwnership().getName();
                info += "\nRent Cost: $" + currentProperty.calculateRent();
            }
        }
        else if(currentSpace.getClass().getName().equals("Chance"))
        {
            //info += chance.chooseCard(currentPlayer);
            //menu.addOutputText(chance.chooseCard(currentPlayer));
        }
        
        
        
        return info;
    }
    
    /**
     * When buy button is clicked this method will be called
     * sets 
     */
    public void buy() {
        ((Property)currentSpace).setOwnership(currentPlayer); //changes ownership of property
        currentPlayer.changeMoney(-((Property)currentSpace).getPrice()); //subtracts value of property from Player money
        menu.addOutputText(currentPlayer.getName() + " bought " + currentSpace.getName() + " for $" + ((Property)currentSpace).getPrice()); //says it in chat
        menu.setPlayerInfoText(getInfo(), currentSpace.getColor());
        currentPlayer.buyProperty((Property)currentSpace);
        
        buy.setEnabled(false);
        end.setEnabled(true);
    }
    
    /**
     * subtract rent cost of property
     */
    public void pay() {
        Player otherPlayer = ((Property)currentSpace).getOwnership();
        if(((Property)currentSpace).getColor() == board.getGrey()) //grey color for railroads
        {
             int count = 0;
             for(int i = 0; i<otherPlayer.getOwnes().size(); i++)
             {
                
                if((otherPlayer.getOwnes().get(i).getColor() == board.getGrey())) //gry color for railroads
                {
                    count++;
                }
                
             }
             
             currentPlayer.changeMoney(-((Property)currentSpace).calculateRent()*count); //subtract my money
             otherPlayer.changeMoney(((Property)currentSpace).calculateRent()*count); // add their money
             menu.addOutputText(currentPlayer.getName() + " just payed " + ((Property)currentSpace).calculateRent()*count + " in rent to " + otherPlayer.getName());//says in chat money lost
            }
        else if(currentSpace.getClass().getName().equals("Property"))
        {
           currentPlayer.changeMoney(-((Property)currentSpace).calculateRent()); //subtract my money
           otherPlayer.changeMoney(((Property)currentSpace).calculateRent()); // add their money
           menu.addOutputText(currentPlayer.getName() + " just payed $" + ((Property)currentSpace).calculateRent() + " in rent to " + otherPlayer.getName());//says in chat money lost
        }
        
        menu.setPlayerInfoText(getInfo(), currentSpace.getColor());
        
        pay.setEnabled(false);
        end.setEnabled(true);
    }
    
    /**
     * Changes whos
     * sets 
     */
    public void end() {
        cpi++;
        if(cpi >= players.size()) {
            cpi = 0; // reset after last player in list ends turn
        }
        start();
    }
    
    public static Color getColor(String colStr) {
        Color col = Color.BLACK;
        for(int i = 0; i < colorStrings.length; i++) {
            if(colorStrings[i].equals(colStr)) {
                col = colors[i];
            }
        }
        return col;
    }
    
    public boolean canBuyStocks()
    {
        int count = 0;
        /*for(int i = 0; i<board.getSpaces().size(); i++)
        {
            if(board.getSpaces().get(i).getClass().getName().equals("Property"))
            {
                Property space = (Property)board.getSpaces().get(i);
                if(space.getOwnership() == currentPlayer)
                {
                    
                }
            }
        } */
        for(int i = 0; i<currentPlayer.getOwnes().size(); i++)
        {
            for(int j = i+1; i<currentPlayer.getOwnes().size(); j++)
            {
                if(currentPlayer.getOwnes().get(i).getColor()
                             == currentPlayer.getOwnes().get(j).getColor())
                {
                    count++;
                }
                if(currentPlayer.getOwnes().get(i).getColor() == board.getPurple() && count == 1) //color purple
                {
                    return true;
                }
                if(currentPlayer.getOwnes().get(i).getColor() == board.getBlue() && count == 1) //color blue
                {
                    return true;
                }
                if(count == 2)
                {
                    return true;
                }
                
            }
            count = 0;
        }
        return false;
    }
    
    public int getScreenWidth() { return WIDTH; }
    public int getScreenHeight() { return HEIGHT; }
}

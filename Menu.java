import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description of class Menu here.
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Menu extends JPanel implements ActionListener
{
    private int width;
    private int height;
    private JButton roll, buy, pay, stocks, end;
    private JLabel h1;
    private JTextArea output, playerInfo;
    private String text;
    
    public Menu() {
        this(0,0);
    }
    
    public Menu(int w, int h) {
        super();
        setPreferredSize(new Dimension(w,h));
        width = w;
        height = h;
        
        // Title
        h1 = new JLabel("Menu");
        h1.setFont(new Font("Sans-Serif", Font.BOLD, 30));
        this.add(h1);
        
        addTextArea();
        addButtons();
        
        // Player Info
        playerInfo = new JTextArea();
        playerInfo.setBackground(Color.WHITE);
        playerInfo.setEditable(false);
        playerInfo.setColumns(30);
        playerInfo.setRows(10);
        //playerInfo.setFont(new Font("Castellar", Font.BOLD, 20));
        this.add(playerInfo);
    }
    
    /**
     * Paints the background
     */
    public void paintComponent(Graphics window) {
        super.paintComponent(window);
        
        window.setColor(Color.LIGHT_GRAY);
        window.fillRect(0,0,getWidth(),getHeight());
    }
    
    /**
     * Adds a text box to output text onto the screen
     */
    public void addTextArea() {
        text = "Road to Google!!!";
        output = new JTextArea("");
        output.setEditable(false);
        output.setColumns(30);
        output.setRows(30);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        addOutputText("");
    }
    
    /**
     * Adds the 4 buttons that allow the user to interact with the game
     * ROLL, BUY, PAY RENT, and END TURN
     */
    public void addButtons() {
        roll = new JButton("ROLL");
        this.add(roll);
        //roll.addActionListener(this);
        //roll.setActionCommand("roll");
        
        buy = new JButton("BUY");
        this.add(buy);
        //buy.addActionListener(this);
        //buy.setActionCommand("buy");
        
        pay = new JButton("PAY RENT");
        this.add(pay);
        //pay.addActionListener(this);
        //pay.setActionCommand("pay");
        
        end = new JButton("END TURN");
        this.add(end);
        //end.addActionListener(this);
        //end.setActionCommand("end");
        
        stocks = new JButton("Buy Stocks");
        this.add(stocks);
    }
    
    /**
     * Controls what happens when a menu button is pressed:
     * ROLL -- 
     * BUY -- 
     * PAY RENT -- 
     * END TURN -- 
     */
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();
        addOutputText(buttonPressed);
    }
    
    /**
     * Adds a line of text to the output text box
     * @txt the String line to add
     */
    public void addOutputText(String txt) {
        text += txt + "\n";
        output.setText(text);
    }
    
    /**
     * Sets the text for the player info text box
     * @txt the String to set the text box to
     */
    public void setPlayerInfoText(String txt, Color color) {
        playerInfo.setBackground(color);
        if(color.equals(Color.BLACK)) {
            playerInfo.setForeground(Color.WHITE);
        }
        playerInfo.setText(txt);
    }
    
    public JButton getRollBtn() { return roll; }
    public JButton getBuyBtn() { return buy; }
    public JButton getPayBtn() { return pay; }
    public JButton getEndBtn() { return end; }
    public JButton getStocksBtn() { return stocks; }
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.*;
import java.awt.*;

/**
 * Contains all graphics components
 *
 * Marquis and Cameron's super cool project
 * v0.1 pre-Alpha unreleased
 * Spring 2018
 * AP Computer Science A final project
 */
public class Frame extends JPanel implements Runnable, ActionListener
{
    private Board board;
    private Menu menu;
    private int width, height;
    
    public Frame(int w, int h) {
        width = w;
        height = h;
        
        //JPanel main = new JPanel();
        //this.setSize(w,h);
        //this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        //board = new Board(height);
        //menu = new Menu(500,height); // JPanel menu sidebar
        
        //JButton testButton = new JButton("Test12");
        //this.add(testButton);
        
        //this.add(board);
        //this.add(menu);
        //this.add(menu, BorderLayout.EAST);
        
        //JButton b = new JButton("button");
        //b.addActionListener(this);
        
        setVisible(true);
        
        //new Thread(this).start();
    }
    
    public void update(Graphics window)
    {
        paint(window);
    }
    
    public void paint(Graphics window)
    {
        //window.setColor(Color.GRAY);
        //window.fillRect(0,0,getWidth(),getHeight());
        
        //board.draw(window);
        //menu.draw(window);
    }
    
    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                Thread.currentThread().sleep(2);
                repaint();
            }
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
    }
}

package Test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;


public class Char extends JFrame implements KeyListener{
    Image   img;
    Image   back;
    int     x= 100, y= 80, dir= 0, num=0;

    // Main
    public static void main(String args[])
    {   new Char();
    }

    // Constructor
    Char()
    {   super("Character");
        img = getToolkit().getImage("src/sample/chr47.gif");
        back = getToolkit().getImage("src/sample/map.gif");
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.gray);
        setSize(280, 250);
        //System.out.println(new File(".").getAbsoluteFile().getParent());
        setVisible(true);
    }

    // Paint
    @Override
    public void paint(Graphics g)
    {
        int yoff;
        g.drawImage(back,0,40,this);
        if (img!=null)
        {   yoff= (dir*2+num)*32;
            g.drawImage(img,x,y,x+32,y+32,0,yoff,32,yoff+32,this);
        }
    }

    /*@Override
    public void paint(Graphics g)
    {   int yoff;
        g.drawImage(back,0,40,this);
        if (img!=null)
        {   yoff= (dir+num)*32;
            g.drawImage(img,x,y,x+32,y+32,0,yoff,32,yoff+32,this);
        }
    }*/

    // KeyEvent Listener
    @Override
    public void keyPressed(KeyEvent e)
    {   switch(e.getKeyCode( ))
    {   case KeyEvent.VK_UP : if(isTure(y-10,x)){y=y-10; dir=0; break;}break;
        case KeyEvent.VK_RIGHT : if(isTure(y,x+10)){x=x+10; dir=1; break;}break;
        case KeyEvent.VK_DOWN :
            if(y+10<=210) {
                y = y + 10;
                dir = 2;
            }break;
        case KeyEvent.VK_LEFT : if(isTure(y,x-10)){x=x-10; dir=3; break;}break;
    }
        num ^= 1;
        repaint();
    }

    public boolean isTure(int i,int j){
        if(0<=i&&210>=i&&0<=j&&280>=j){
            return true;
        }
        return false;
    }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { }
}

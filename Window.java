import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
//Jade Chen
class Window extends JFrame
{
    private final int WIDTH = 820;
    private final int HEIGHT = 640;




    public Window()
    {
        super("game");

        setSize(WIDTH,HEIGHT);
        getContentPane().add( new game());

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Window run = new Window();
    }
}
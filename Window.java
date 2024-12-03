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
        super("BreakOut");

        setSize(WIDTH,HEIGHT);

        //use the ClassTester to test your classes
        //before you start to write the full game
        getContentPane().add( new game());

        //uncomment this to make the game
        // getContentPane().add( new BreakOut() );

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main( String args[] )
    {
        Window run = new Window();
    }
}
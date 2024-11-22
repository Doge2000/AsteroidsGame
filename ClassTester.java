import java.awt.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class ClassTester extends JPanel
{
    //Jade Chen
    //instance variables
    int x;
    int y;
    int w;
    int h;

    //define a Brick
    Brick brick;

    //define a Paddle
    Paddle pad;

    //define a Ball


    public ClassTester() // create all instance in here
    {
        setBackground(Color.WHITE);
        x = 100;
        y = 110;
        w = 100;
        h = 20;


        //make a new Brick
        brick = new Brick(x,y,w,h);

        //make a new Paddle
        pad = new Paddle(200, 300, 100, 10, 1);


        //make a new Ball



        setFocusable( true );		// Do NOT DELETE these three lines
    }

    public void paint( Graphics window )// all other paint methods and game logic goes in here.
    {
        window.setColor(Color.WHITE); window.fillRect( 0,0, 800, 600); // makes the background white
        window.setColor(Color.BLACK); window.drawRect( 0,0, 800, 600); // draws a black box around the outside

        window.setColor(Color.BLUE); // to change fonts, color, etc: go to the Graphics Intro Folder

        window.drawString("Class Tester ", 50, 30 );

        //draw a Brick
        brick.paint(window);

        //draw a Paddle
        pad.paint(window);

        //draw a Ball



    }
}
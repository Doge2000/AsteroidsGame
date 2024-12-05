import java.awt.*;

Class Asteroid extends SpaceObject(){
  private int xspeed;
  private int yspeed;
  private int size;

  public Asteroid(int ex, int wy, int wd, int ht, int xsp, int ysp, int sz){
    super(ex, wy, wd*sz, ht*sz);
    xspeed = xsp;
    yspeed = ysp;
    size = sz;
  }
  
  public int getAsteroidSize(){
    return size;
  }
  public void keepInBounds(){
    if(getX() > 840){
      setX(-50);
    }
    else{
      setX(870);
    }
    if(getY() > 650){
      setY(-50)
    }
    else{
      setY(690);
    }
  }
  
  public void paint( Graphics window )
    {
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("Asteroid.png"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, getX(), getY(), getW(), getH(), this);
    }



}

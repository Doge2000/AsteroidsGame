import java.awt.*;

class Asteroid extends SpaceObject {
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
  public void goLeftRight()
  {
    setX(getnX() + xspeed);
  }

  public void goUpDown(){
    setY(getnY()+yspeed);

  }
  public void keepInBounds(int w, int h){
    if(getnX()>w){
      setX(-getW());


    }
    else if(getnX()<-getW()){
      setX(w);


    }
    if(getnY()>h){
      setY(-getH());

    }

    else if(getnY()<-getH()){
      setY(h);

    }
  }
  
  public void paint( Graphics window )
    {
        Graphics2D g2 = (Graphics2D) window;
        Image img1 = Toolkit.getDefaultToolkit().getImage("Asteroid.png"); //use .gif or .png, you can choose the image
        g2.drawImage(img1, (int) getnX(), (int) getnY(), getW(), getH(), this);
    }



}

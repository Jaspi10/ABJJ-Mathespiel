import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Gegner extends Actor
{
    private static final String ORDNER_GEGNER = "images\\gegner";
    private static final ImagePool POOL_GEGNER = new ImagePool(ORDNER_GEGNER);
    
    int leben;
    boolean moving;
    public Gegner()
    {
        setImage(POOL_GEGNER.getImage());
        leben = 1;
    }
    public void act() 
    {
        if (moving)
        {
            move();
            moving = false;
        }
    }
    public void move()
    {
        int r = Greenfoot.getRandomNumber(5);
        if(r == 1)
        {
            moveLeft();
        }
        else if(r == 2)
        {
            moveRight();
        }
        else if(r == 3)
        {
            moveUp();
        }
        else if(r == 4)
        {
            moveDown();
        }
    }
    public void moveLeft()
    {
        Spieler s = (Spieler) getOneObjectAtOffset(-1, 0, Spieler.class);
        if (s != null)
        {
            s.kampf(this);
            return;
        }
        
        if (getOneObjectAtOffset(-1, 0, Hindernis.class) == null)
        {
            setLocation(getX()-1,getY());
        }
    }
    public void moveRight()
    {
        Spieler s = (Spieler) getOneObjectAtOffset(1, 0, Spieler.class);
        if (s != null)
        {
            s.kampf(this);
            return;
        }
        
        if (getOneObjectAtOffset(1, 0, Hindernis.class) == null)
        {
            setLocation(getX()+1,getY());
        }
    }
    public void moveUp()
    {
        Spieler s = (Spieler) getOneObjectAtOffset(0, -1, Spieler.class);
        if (s != null)
        {
            s.kampf(this);
            return;
        }
        
        if (getOneObjectAtOffset(0, -1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()-1);
        }
    }
    public void moveDown()
    {
        Spieler s = (Spieler) getOneObjectAtOffset(0, 1, Spieler.class);
        if (s != null)
        {
            s.kampf(this);
            return;
        }
        
        if (getOneObjectAtOffset(0, 1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()+1);
        }
    }
    public void setMoving(boolean m)
    {
        moving = m;
    }
    public void niederlage() 
    {
        leben--;
        if (leben <= 0) {
            getWorld().removeObject(this);
        }
    }
}

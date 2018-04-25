import greenfoot.*;
public class Spieler extends Actor
{    
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") == true)
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("d") == true)
        {
            moveRight();
        }
        if(Greenfoot.isKeyDown("w") == true)
        {
            moveUp();
        }
        if(Greenfoot.isKeyDown("s") == true)
        {
            moveDown();
        }
    }
    public void moveLeft()
    {
        if (getOneObjectAtOffset(-1, 0, Hindernis.class) == null)
        {
            setLocation(getX()-1,getY());
        }
    }
    public void moveRight()
    {
        if (getOneObjectAtOffset(1, 0, Hindernis.class) == null)
        {
            setLocation(getX()+1,getY());
        }
    }
    public void moveUp()
    {
        if (getOneObjectAtOffset(0, -1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()-1);
        }
    }
    public void moveDown()
    {
        if (getOneObjectAtOffset(0, 1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()+1);
        }
    }
}

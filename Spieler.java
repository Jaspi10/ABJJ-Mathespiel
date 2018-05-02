import greenfoot.*;
public class Spieler extends Actor
{   
    private int leben;
    public Spieler()
    {
        leben = 3;
        getImage().scale(50, 50);
    }
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") == true)
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("d") == true)
        {
            if (getX() == 9)
            {
                Greenfoot.setWorld(new Raum2());
            }
            else
            {
                moveRight();
            }           
        }
        if(Greenfoot.isKeyDown("w") == true)
        {
            moveUp();
        }
        if(Greenfoot.isKeyDown("s") == true)
        {
            moveDown();
        }
        /*if(isTouching(Gegner.class) == true)
        {
            Aufgabe();
        }*/
    }
    public void setLeben(int l)
    {
        leben = l;
    }
    public int getLeben()
    {
        return leben;
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

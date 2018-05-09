import greenfoot.*;
import java.util.List;

public class Spieler extends Actor
{   
    private int leben;
    private boolean moved;
    public Spieler()
    {
        leben = 3;
        getImage().scale(50, 50);
    }
    public void act() 
    {
        move();       
        if (moved) 
        {
            List<Gegner> gegner = getWorld().getObjects(Gegner.class);
            for (Gegner g : gegner) 
            {
                g.setMoving(true);
            }
            moved = false;
        }
        
    }
    public void setLeben(int l)
    {
        leben = l;
    }
    public int getLeben()
    {
        return leben;
    }
    public void move()
    {
        if(Greenfoot.isKeyDown("a") == true)
        {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("d") == true)
        {
            if (getX() == 9)
            {
                //Greenfoot.setWorld(new Raum2());
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
    }
    public void moveLeft()
    {
        if (getOneObjectAtOffset(-1, 0, Hindernis.class) == null)
        {
            setLocation(getX()-1,getY());
            moved = true;
        }
    }
    public void moveRight()
    {
        if (getOneObjectAtOffset(1, 0, Hindernis.class) == null)
        {
            setLocation(getX()+1,getY());
            moved = true;
        }
    }
    public void moveUp()
    {
        if (getOneObjectAtOffset(0, -1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()-1);
            moved = true;
        }
    }
    public void moveDown()
    {
        if (getOneObjectAtOffset(0, 1, Hindernis.class) == null)
        {
            setLocation(getX(),getY()+1);
            moved = true;
        }
    }
}

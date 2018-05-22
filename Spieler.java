import greenfoot.*;
import java.util.List;

public class Spieler extends Actor
{   
    private int leben;
    private boolean moved;
    private Ebene1 ebene;
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
    public void setEbene(Ebene1 e)
    {
        ebene = e;
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
        System.out.println(ebene);
        if(Greenfoot.isKeyDown("a") == true)
        {
            if (getX() == 0)
            {
                ebene.raumwechsel(this, -1, 0);
            }
            else
            {
                moveLeft();
            }            
        }
        if(Greenfoot.isKeyDown("d") == true)
        {
            if (getX() == 9)
            {
                ebene.raumwechsel(this, 1, 0);
            }
            else
            {
                moveRight();
            }
        }
        if(Greenfoot.isKeyDown("w") == true)
        {
            if (getY() == 0)
            {
                ebene.raumwechsel(this, 0, -1);
            }
            else
            {
                moveUp();
            }          
        }
        if(Greenfoot.isKeyDown("s") == true)
        {
            if (getY() == 9)
            {
                ebene.raumwechsel(this, 0, 1);
            }
            else
            {
                moveDown();
            }           
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

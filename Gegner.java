import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Gegner extends Actor
{
    int leben;
    public Gegner()
    {
        leben = 1;
        getImage().scale(50, 50);
    }
    public void act() 
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

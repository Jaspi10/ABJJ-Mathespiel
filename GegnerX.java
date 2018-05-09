import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class GegnerX extends Gegner
{    
    public void move()
    {
        int r = Greenfoot.getRandomNumber(3);
        if(r == 1)
        {
            moveLeft();
        }
        else if(r == 2)
        {
            moveRight();
        }
    }
}

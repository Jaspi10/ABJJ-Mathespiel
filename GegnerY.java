import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class GegnerY extends Gegner
{
    public void move() 
    {
        int r = Greenfoot.getRandomNumber(3);
        if(r == 1)
        {
            moveUp();
        }
        else if(r == 2)
        {
            moveDown();
        }
    }    
}

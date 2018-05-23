import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tuer extends Hindernis
{
    boolean rechts;
    
    public Tuer (boolean rechts)
    {
        if (rechts)
        {
            getImage().mirrorHorizontally();
        }
        
        this.rechts = rechts;
    }
    
    public void oeffne()
    {
        int offset = rechts ? -1 : 1;
        Tuer tuer2 = (Tuer) getOneObjectAtOffset(offset, 0, Tuer.class);
        
        getWorld().removeObject(tuer2);
        getWorld().removeObject(this);
    }
}

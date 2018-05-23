import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Raum extends World
{
    public Raum(boolean tuerOben, boolean tuerUnten, boolean tuerLinks, boolean tuerRechts)
    {
        super(10, 10, 50);
        
        for (int i = 0; i < 10; i++)
        {
            if (!(tuerOben && (i == 4 || i == 5)))
            {
                addObject(new Wand(), i, 0);
            }
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (!(tuerUnten && (i == 4 || i == 5)))
            {
                addObject(new Wand(), i, 9);
            }
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (!(tuerLinks && (i == 4 || i == 5)))
            {
                addObject(new Wand(), 0, i);
            }
        }
        
        for (int i = 0; i < 10; i++)
        {
            if (!(tuerRechts && (i == 4 || i == 5)))
            {
                addObject(new Wand(), 9, i);
            }
        }
    }
    
    //Random
    public void addGegner(Gegner gegner)
    {
        while (true) 
        {
            int x = Greenfoot.getRandomNumber(8);
            int y = Greenfoot.getRandomNumber(8);
            
            if (getObjectsAt(x, y, null).isEmpty())
            {
                addObject(gegner, x, y);
                break;
            }
        }
    }
    
    public void addGegner(Gegner gegner, int x, int y)
    {
        addObject(gegner, x, y);
    }
    
    public void addBossTuer()
    {
        addObject(new Tuer(false), 4, 0);
        addObject(new Tuer(true), 5, 0);
    }
    
}

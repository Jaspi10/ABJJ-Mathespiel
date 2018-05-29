import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Schluesselanzeige extends Actor
{
    private static final String PFAD_KEY = "images\\key.png";
    private static final GreenfootImage BILD_KEY = new GreenfootImage(PFAD_KEY);
    
    public Schluesselanzeige() 
    {
        update(false);
    }
    
    public void update(boolean b)
    {
        if (b)
        {
            setImage(BILD_KEY);
        } else 
        {
            setImage(new GreenfootImage(50, 50));
        }
    }
}
